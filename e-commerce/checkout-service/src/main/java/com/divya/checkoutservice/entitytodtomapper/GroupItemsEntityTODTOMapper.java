//package com.divya.checkoutservice.entitytodtomapper;
//
//import com.divya.checkoutservice.dto.GroupItemsDTO;
//import com.divya.checkoutservice.entity.GroupItemsEntity;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class GroupItemsEntityTODTOMapper {
//    public GroupItemsDTO mapper(GroupItemsEntity groupItemsEntity) {
//        GroupItemsDTO groupItemsDTO = new GroupItemsDTO();
//        groupItemsDTO.setItemName(groupItemsEntity.getItemName());
//        List<Integer> orderIdList = new ArrayList();
//        for (int orderId : groupItemsEntity.getOrderId()) {
//            orderIdList.add(orderId);
//        }
//        groupItemsDTO.setOrderId(groupItemsEntity.getOrderId());
////        groupItemsDTO.setOrderId(orderIdList.stream()
////                .collect(Collectors.groupingBy(GroupItemsDTO::getItemName, Collectors.toList())));
//        groupItemsDTO.setCount(groupItemsEntity.getCount());
//        groupItemsDTO.setCount(groupItemsEntity.getOrderId().stream()
//                .collect(Collectors.groupingBy(GroupItemsEntity::getOrderId, Collectors.summingInt(GroupItemsEntity::getCount))));
//        return groupItemsDTO;
//    }
//}
