package com.divya.checkoutservice.resource;

import com.divya.checkoutservice.dto.GroupItemsDTO;
import com.divya.checkoutservice.dto.GroupItemsWithOrdersDTO;
import com.divya.checkoutservice.dto.OrderDTO;
import com.divya.checkoutservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderResource {

    //manual constructor based injection
//    private OrderService orderService;
//
//    @Autowired
//    public OrderResource(OrderService orderService) {
//        this.orderService = orderService;
//    }

    //final keyword indicates it ll be initialized in constructor
    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.create(orderDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> get(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @PostMapping("/fullFill/{id}")
    public ResponseEntity<OrderDTO> fullFill(@PathVariable int id){
        return ResponseEntity.ok(orderService.fullFillOrder(id));
    }

//    @GetMapping("/analytics")
//    public ResponseEntity<OrderDTO> getOrdersByItem(){
//        return ResponseEntity.ok(orderService.getOrderByItems());
//    }

    @GetMapping("/analytics")
    public ResponseEntity<List<GroupItemsDTO>> getGroupByItem(){
        return ResponseEntity.ok(orderService.getGroupByItems());
    }

    @GetMapping("/analyticsWithOrderList")
    public ResponseEntity<List<GroupItemsWithOrdersDTO>> getGroupByItemsWithOrderInfo(){
        return ResponseEntity.ok(orderService.getGroupByItemsWithOrderInfo());
    }
}
