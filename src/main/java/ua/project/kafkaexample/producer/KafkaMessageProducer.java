package ua.project.kafkaexample.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaMessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;


    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send(topicName, message);

        send.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Message '%s' sent successfully".formatted(result) + " with offset %s".formatted(result.getRecordMetadata().offset()));
            } else {
                System.out.printf("unable to send message %s due to: %s%n", message, exception.getMessage());
            }
        });
    }
}
