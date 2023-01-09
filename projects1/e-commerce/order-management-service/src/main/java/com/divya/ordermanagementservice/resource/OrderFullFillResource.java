package com.divya.ordermanagementservice.resource;

import com.divya.ordermanagementservice.dto.OrderDTO;
import com.divya.ordermanagementservice.service.OrderFullFillService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderFullFill")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderFullFillResource {

    private final OrderFullFillService orderFullFillService;

    @PostMapping()
    ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderFullFillService.update(orderDTO));
    }
}
