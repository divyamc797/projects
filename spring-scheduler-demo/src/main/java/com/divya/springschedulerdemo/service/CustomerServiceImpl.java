package com.divya.springschedulerdemo.service;

import com.divya.springschedulerdemo.entity.CustomerEntity;
import com.divya.springschedulerdemo.model.CustomerModel;
import com.divya.springschedulerdemo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
//    @Scheduled(cron = "0 0/15 * * * ?")
//    @SchedulerLock(name = "CustomerServiceImpl_createCustomer",
//            lockAtLeastForString = "PT5M", lockAtMostForString = "PT14M")
    public CustomerModel createCustomer(CustomerModel customerModel) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerModel.getId());
        customerEntity.setName(customerModel.getName());
        CustomerEntity saveCustomer = customerRepo.save(customerEntity);
        CustomerModel customerModel1 = new CustomerModel();
        customerModel1.setId(saveCustomer.getId());
        customerModel1.setName(saveCustomer.getName());
        return customerModel1;
    }
}
