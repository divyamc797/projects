package com.example.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

//Create Kafka Topic

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaGuidesTopic() {
        return TopicBuilder.name("javaGuides").build();
    }

}
