package ua.project.kafkaexample.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageConsumer {

    @KafkaListener(topics = {"new-test-topic-new"}, groupId = "test-group-1")
    public void consume1(String message) {
        log.info("consumer1 the message {}", message);

    }

    @KafkaListener(topics = {"new-test-topic-new"}, groupId = "test-group-1")
    public void consume2(String message) {
        log.info("consumer2 the message {}", message);

    }


    @KafkaListener(topics = {"new-test-topic-new"}, groupId = "test-group-1")
    public void consume3(String message) {
        log.info("consumer3 the message {}", message);

    }
}
