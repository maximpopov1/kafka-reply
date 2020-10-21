package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.request}")
    private String requestTopic;

    @Bean
    public NewTopic requestTopic() {
        return TopicBuilder.name(requestTopic).partitions(1).replicas(1).build();
    }

}
