package org.example.listener;

import org.example.model.Reply;
import org.example.model.Request;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @KafkaListener(id = "server", topics = "kRequests")
    @SendTo
    public Reply listen(Request in) {
        System.out.println("Server received: " + in);
        return Reply.builder().name("reply").value(42L).build();
    }

}
