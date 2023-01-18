package com.divya.checkoutservice.service;

import com.divya.checkoutservice.dto.GroupItemsDTO;
import com.divya.checkoutservice.dto.GroupItemsWithOrdersDTO;
import com.divya.checkoutservice.dto.OrderDTO;
import com.divya.checkoutservice.dto.OrdersInfoDTO;
import com.divya.checkoutservice.dtotoentitymapper.OrderDTOToEntityMapper;
import com.divya.checkoutservice.entity.ItemEntity;
import com.divya.checkoutservice.entity.OrderEntity;
import com.divya.checkoutservice.entitytodtomapper.OrderEntityToDTOMapper;
import com.divya.checkoutservice.exception.NoDataFoundException;
import com.divya.checkoutservice.repository.OrderRepo;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

//    private OrderDTOToEntityMapper orderDTOToEntityMapper;
//
//    private OrderEntityToDTOMapper orderEntityToDTOMapper;
//
//    private OrderRepo orderRepo;
//
//    @Autowired
//    public OrderServiceImpl(OrderDTOToEntityMapper orderDTOToEntityMapper,
//                            OrderEntityToDTOMapper orderEntityToDTOMapper,
//                            OrderRepo orderRepo) {
//        this.orderDTOToEntityMapper = orderDTOToEntityMapper;
//        this.orderEntityToDTOMapper = orderEntityToDTOMapper;
//        this.orderRepo = orderRepo;
//    }

    private final OrderDTOToEntityMapper orderDTOToEntityMapper;

    private final OrderEntityToDTOMapper orderEntityToDTOMapper;

    private final OrderRepo orderRepo;

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    private final RetryRegistry retryRegistry;

    @Value("${url}")
    private String url;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderEntity orderEntity = orderDTOToEntityMapper.map(orderDTO);
//        List<Integer> collect = orderEntity.getItems()
//                .stream()
//                .map(itemEntity -> itemEntity.getQuantity()).collect(Collectors.toList());
//        orderEntity.setTotalQuantity(collect.stream().mapToInt(value -> value).sum());
        orderRepo.save(orderEntity);
        return orderEntityToDTOMapper.map(orderEntity);
    }

    @Override
    public OrderDTO getOrder(int id) throws Exception {
        Optional<OrderEntity> order = orderRepo.findById(id);
        return order.map(orderEntity -> orderEntityToDTOMapper.map(orderEntity))
                .orElseThrow(() -> new NoDataFoundException("order not found for the id" + id));
    }

    int count = 1;

    @Override
//    @io.github.resilience4j.retry.annotation.Retry(name = "order-management-service")
//    @RateLimiter(name = "order-management-service")
    public OrderDTO fullFillOrder(int id) {
        log.info("fullFillOrder:: count:{}, time:{}", count++, LocalDateTime.now());
        Optional<OrderEntity> OrderById = orderRepo.findById(id);

        //entity to DTO
        OrderDTO orderDTO = OrderById.map(orderEntity -> orderEntityToDTOMapper.map(orderEntity))
                .orElseThrow(() -> new NoDataFoundException("order not found for teh id" + id));

        //timeouts
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectionRequestTimeout(10000);
//        httpRequestFactory.setConnectTimeout(10000);
//        httpRequestFactory.setReadTimeout(10000);
//        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

//        use Rest templet to call order-management-service
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("order-management-service");
        Retry retry = retryRegistry.retry("order-management-service");

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8082/orderFullFill";
        HttpEntity<OrderDTO> orderDTOHttpEntity = new HttpEntity<>(orderDTO);
        ResponseEntity<OrderDTO> response =
                retry.executeSupplier(() -> {
//                        circuitBreaker.executeSupplier(() -> {
                            log.info("fullFillOrder:: count:{}, time:{}", count++, LocalDateTime.now());
                            return restTemplate.exchange(resourceUrl, HttpMethod.POST, orderDTOHttpEntity, OrderDTO.class);
                        });

////webclient steps
//        //1 create and configure Webclient
//        WebClient webClient = WebClient.create(url);
//
//        //2 sending request
//        OrderDTO rep = webClient.post()
//                // .uri("")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .body(Mono.just(orderDTO), OrderDTO.class)
//                .retrieve()
//                .bodyToMono(OrderDTO.class)
//                //.transformDeferred(CircuitBreaker)
//                .block();

        //3 handling response

        //save
//        orderRepo.save(orderDTOToEntityMapper.map(response.getBody()));
        return response.getBody();

//        return rep;
    }

//    @Override
//    public OrderDTO getOrderByItems() {
//
//        return null;
//    }

    @Override
    public List<GroupItemsDTO> getGroupByItems() {
        List<OrderEntity> orderEntities = orderRepo.findAll();
        Map<String, List<Integer>> listOfItems = new HashMap<>(); //key: itemName, value : order ids
        Map<String, Integer> quantity = new HashMap<>();
        for (OrderEntity orderEntity : orderEntities) {
            for (ItemEntity itemEntity : orderEntity.getItems()) {
                String key = itemEntity.getName();
                int value = orderEntity.getId();
                if (!listOfItems.containsKey(key)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(value);
                    listOfItems.put(key, list);
                    quantity.put(key, itemEntity.getQuantity());
                } else {
                    listOfItems.get(key).add(value);
//                    listOfItems.put(key, listOfItems.get(key) + 6);  //example  to to sum ::: Map<String, integer>
                    quantity.put(key, quantity.get(key) + itemEntity.getQuantity());
                }
            }
        }


        List<GroupItemsDTO> groupItemsDTOS = new ArrayList<>();

        //TV, Fridge, Chair
        for (Map.Entry<String, List<Integer>> entry : listOfItems.entrySet()) {
            GroupItemsDTO groupItemsDTO = new GroupItemsDTO();
            groupItemsDTO.setItemName(entry.getKey());
            groupItemsDTO.setOrderId(entry.getValue());
            groupItemsDTO.setCount(entry.getValue().size());
            groupItemsDTO.setQuantity(quantity.get(entry.getKey()));
            groupItemsDTOS.add(groupItemsDTO);
        }

        return groupItemsDTOS;
////        orderEntities.stream().collect(Collectors.groupingBy())
//        return (GroupByItemNameDTO) orderEntities.stream()
//                .map(orderEntity -> groupByItemNameEntityToDTOMapper.mapper((GroupByItemNameEntity) orderEntities));

//        return orderEntityList.stream()
//                .collect(Collectors.groupingBy(orderEntity -> orderEntity, Collectors.counting()))
//                .entrySet().stream().collect(Collectors.toList())
    }

    @Override
    public List<GroupItemsWithOrdersDTO> getGroupByItemsWithOrderInfo() {
        List<OrderEntity> repoAll = orderRepo.findAll();
        Map<String, List<OrdersInfoDTO>> ordersInfoMap = new HashMap<>();
        Map<String, Integer> quantity = new HashMap<>();
        for (OrderEntity orderEntity : repoAll) {
            for (ItemEntity itemEntity : orderEntity.getItems()) {

                List<OrdersInfoDTO> ordersInfoDTOS = new ArrayList<>();
                OrdersInfoDTO ordersInfoDTO = new OrdersInfoDTO();
                ordersInfoDTO.setCustomerName(orderEntity.getCustomerName());
                ordersInfoDTO.setOrderId(orderEntity.getId());
                ordersInfoDTOS.add(ordersInfoDTO);

                String key = itemEntity.getName();
                List<OrdersInfoDTO> value = ordersInfoDTOS;

                if (!ordersInfoMap.containsKey(key)) {
                    ordersInfoMap.put(key, value);
                    quantity.put(key, itemEntity.getQuantity());
                } else {
                    ordersInfoMap.get(key).add(ordersInfoDTO);
                    quantity.put(key, quantity.get(key) + itemEntity.getQuantity());
                }

            }
        }
        List<GroupItemsWithOrdersDTO> groupItemsWithOrdersDTOS = new ArrayList<>();
        for (Map.Entry<String, List<OrdersInfoDTO>> listMap : ordersInfoMap.entrySet()) {
            GroupItemsWithOrdersDTO groupItemsWithOrdersDTO = new GroupItemsWithOrdersDTO();
            groupItemsWithOrdersDTO.setItemName(listMap.getKey());
            groupItemsWithOrdersDTO.setOrders(listMap.getValue());
            groupItemsWithOrdersDTO.setTotalQuantity(quantity.get(listMap.getKey()));
            groupItemsWithOrdersDTOS.add(groupItemsWithOrdersDTO);
        }
        return groupItemsWithOrdersDTOS;
    }


}
