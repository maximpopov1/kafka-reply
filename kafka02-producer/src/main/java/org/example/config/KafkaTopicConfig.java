package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.request}")
    private String requestTopic;

    @Value("${kafka.topic.reply}")
    private String replyTopic;

    @Bean
    public NewTopic requestTopic() {
        return TopicBuilder.name(requestTopic).partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic replyTopic() {
        return TopicBuilder.name(replyTopic).partitions(1).replicas(1).build();
    }

}
