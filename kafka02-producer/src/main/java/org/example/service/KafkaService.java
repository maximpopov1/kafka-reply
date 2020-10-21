package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.model.Reply;
import org.example.model.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final ReplyingKafkaTemplate<String, Request, Reply> template;
    @Value("${kafka.topic.request}")
    private String requestTopic;

    @SneakyThrows
    public Reply getReply() {

        Request request = Request.builder().name("name").value(1L).build();
        ProducerRecord<String, Request> record = new ProducerRecord<>(requestTopic, request);
        RequestReplyFuture<String, Request, Reply> future = template.sendAndReceive(record);
        SendResult<String, Request> result = future.getSendFuture().get(10, TimeUnit.SECONDS);
        System.out.println("Result: " + result.getRecordMetadata());
        ConsumerRecord<String, Reply> consumerRecord = future.get(10, TimeUnit.SECONDS);
        System.out.println("Return value: " + consumerRecord.value());

        return consumerRecord.value();
    }

}
