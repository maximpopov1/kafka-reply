package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Reply;
import org.example.service.KafkaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final KafkaService service;

    @GetMapping
    public Reply getReply() {
        return service.getReply();
    }

}
