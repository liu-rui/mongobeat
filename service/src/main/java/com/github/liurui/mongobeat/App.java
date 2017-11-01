package com.github.liurui.mongobeat;


import com.github.liurui.mongobeat.repositories.MongoInputable;
import com.github.liurui.mongobeat.tasks.MongoExportTasks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@SpringBootApplication
//@EnableScheduling
//@EnableKafka
public class App 
{

    @Bean
    public  MongoExportTasks  mongoExportTasks(){
        return new MongoExportTasks();
    }



//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
//
//        methodInvokingJobDetailFactoryBean.setTargetObject(new MongoExportTasks());
//        methodInvokingJobDetailFactoryBean.setTargetMethod("run");
//        methodInvokingJobDetailFactoryBean.setConcurrent(false);
//        methodInvokingJobDetailFactoryBean.setBeanName("mongoExportTasks");
//
//        simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean .getObject());
//        simpleTriggerFactoryBean.setStartDelay(10000);
//        simpleTriggerFactoryBean.setRepeatInterval(5000);
//        simpleTriggerFactoryBean.setGroup("default");
//        simpleTriggerFactoryBean.setName("default");
//
//        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
////        schedulerFactoryBean.setJobDetails(methodInvokingJobDetailFactoryBean.getObject());
//
//        return schedulerFactoryBean;
//    }


    public static void main( String[] args )
    {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class);
        MongoInputable mongoOperatable = applicationContext.getBean(MongoInputable.class);

        mongoOperatable.count();


//        KafkaTemplate kafkaTemplate = applicationContext.getBean(KafkaTemplate.class);
//
//
//        kafkaTemplate.send("test1" , "hello world");
    }
}
