package com.divya.ordermanagementservice.service;

import com.divya.ordermanagementservice.DTOToEntityMapper.OrderDTOToEntityMapper;
import com.divya.ordermanagementservice.EntityToDTOMapper.OrderEntityToDTOMapper;
import com.divya.ordermanagementservice.common.Status;
import com.divya.ordermanagementservice.dto.OrderDTO;
import com.divya.ordermanagementservice.entity.OrderEntity;
import com.divya.ordermanagementservice.repository.OrderFullFillRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderFullFillServiceImpl implements OrderFullFillService {

    private final OrderFullFillRepo orderFullFillRepo;

    private final OrderDTOToEntityMapper orderDTOToEntityMapper;

    private final OrderEntityToDTOMapper orderEntityToDTOMapper;

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        orderDTO.setStatus(Status.INPROGRESS);
        OrderEntity orderEntity = orderDTOToEntityMapper.map(orderDTO);
        orderFullFillRepo.save(orderEntity);
        OrderDTO orderDto = orderEntityToDTOMapper.map(orderEntity);
        return orderDto;
    }
}

