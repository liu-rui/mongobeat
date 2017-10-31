package com.github.liurui.mongobeat.repositories;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    public  static  final Logger LOGGER  = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "test1")
    public void processMessage(String content){
        LOGGER.error(content);
    }
}
