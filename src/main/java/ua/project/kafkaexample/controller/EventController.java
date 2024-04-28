package ua.project.kafkaexample.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.project.kafkaexample.producer.KafkaMessageProducer;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Slf4j
public class EventController {

    private final KafkaMessageProducer producer;

    @PostMapping("send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        for (int i = 0; i < 10000; i++) {
            producer.sendMessage(message);
        }

        return ResponseEntity.ok("Message '%s' sent".formatted(message));
    }

}
