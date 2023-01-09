//package com.divya.checkoutservice.dtotoentitymapper;
//
//import com.divya.checkoutservice.dto.GroupItemsDTO;
//import com.divya.checkoutservice.entity.GroupByItemNameEntity;
//import com.divya.checkoutservice.entity.GroupItemsEntity;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@Component
//public class GroupByItemNameDTOToEntityMapper {
//    private final GroupItemsDTOToEntityMapper groupItemsDTOToEntityMapper;
//
//    public GroupByItemNameEntity mapper(GroupByItemNameDTO groupByItemNameDTO) {
//        GroupByItemNameEntity groupByItemNameEntity = new GroupByItemNameEntity();
//        List<GroupItemsEntity> groupItemsEntities = new ArrayList<>();
//        for (GroupItemsDTO groupItemsDTO : groupByItemNameDTO.getGroupItemsDTOS()) {
//            GroupItemsEntity groupItemsEntity = groupItemsDTOToEntityMapper.mapper(groupItemsDTO);
//            groupItemsEntities.add(groupItemsEntity);
//        }
//        groupByItemNameEntity.setGroupItemsEntities(groupItemsEntities);
//        return groupByItemNameEntity;
//    }
//}
