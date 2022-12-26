package com.divya.checkoutservice.service;

import com.divya.checkoutservice.dto.OrderDTO;
import com.divya.checkoutservice.dtotoentitymapper.OrderDTOToEntityMapper;
import com.divya.checkoutservice.entity.OrderEntity;
import com.divya.checkoutservice.entitytodtomapper.OrderEntityToDTOMapper;
import com.divya.checkoutservice.repository.OrderRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Spy
    private OrderDTOToEntityMapper orderDTOToEntityMapper;

    @Mock
    private OrderEntityToDTOMapper orderEntityToDTOMapper;

    @Mock
    private OrderRepo orderRepo;

    @Test
    public void testCreateWithValidData() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1);
//        Mockito.doReturn(orderEntity)
//                .when(orderDTOToEntityMapper).map(any());
//        Mockito.when(orderDTOToEntityMapper.map(any()))
//                .thenReturn(orderEntity);
        Mockito.when(orderRepo.save(any()))
                .thenReturn(orderEntity);
        Mockito.when(orderEntityToDTOMapper.map(any()))
                .thenReturn(orderDTO);
        OrderDTO result = orderService.create(orderDTO);
        Assertions.assertEquals(1, result.getId());
//        Mockito.verify(orderDTOToEntityMapper, Mockito.only())
//                .map(any());
        Mockito.verify(orderRepo, Mockito.only()).save(any());
        Mockito.verify(orderEntityToDTOMapper, Mockito.only()).map(any());
    }
}