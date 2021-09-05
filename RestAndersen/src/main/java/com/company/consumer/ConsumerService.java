package com.company.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "messages")
    public void consume(String message){
        System.out.println("Consuming the message: "+message);
    }
}
