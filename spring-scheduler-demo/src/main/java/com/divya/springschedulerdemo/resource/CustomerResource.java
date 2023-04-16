package com.divya.springschedulerdemo.resource;

import com.divya.springschedulerdemo.model.CustomerModel;
import com.divya.springschedulerdemo.service.CustomerService;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerModel> create(@RequestBody CustomerModel customerModel) {
        return ResponseEntity.ok(customerService.createCustomer(customerModel));
    }
}
