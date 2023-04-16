package com.divya.springschedulerdemo.jobs;

import com.divya.springschedulerdemo.model.CustomerModel;
import com.divya.springschedulerdemo.repository.CustomerRepo;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class CreateCustomerJob {

    static final Logger LOGGER =
            Logger.getLogger(CreateCustomerJob.class.getName());

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    @Autowired
    private CustomerRepo customerRepo;

    @Scheduled(cron = "${interval-in-cron}")
    @SchedulerLock(name = "myscheduledTask")
//    lockAtLeastForString = "PT5M", lockAtMostForString = "PT14M"
    public void computePrice() throws InterruptedException {
        String url = "http://localhost:8083/api/createCustomer";
        CustomerModel customerModel1 = new CustomerModel();
        customerModel1.setId(123);
        customerModel1.setName("fghjn");
        HttpEntity<CustomerModel> customerModelHttpEntity = new HttpEntity<>(customerModel1);
        ResponseEntity<CustomerModel> response = new RestTemplate().exchange(url, HttpMethod.POST, customerModelHttpEntity, CustomerModel.class);
        LOGGER.info("customer created : " + response);
    }
}
