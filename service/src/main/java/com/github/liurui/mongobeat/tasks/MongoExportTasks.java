package com.github.liurui.mongobeat.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class MongoExportTasks {
    public static final Logger  LOGGER = LoggerFactory.getLogger(MongoExportTasks.class);


    @Scheduled(fixedDelay = 5000)
    public  void run(){
        LOGGER.info(DateFormat.getDateTimeInstance().format(new Date()));
    }
}
