//package com.hongshen.boke.controller.kafka;
//
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.support.ProducerListener;
//import org.springframework.stereotype.Component;
//
///**
// * Created with IDEA
// *
// * @author:qianhongshen
// * @Date:2019/6/20 14:34
// * @Desc:
// */
//@Component
//public class KafkaListener implements ProducerListener {
//
//    @Override
//    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
//        System.out.println("我成功了");
//    }
//
//    @Override
//    public void onError(ProducerRecord producerRecord, Exception exception) {
//        System.out.println("我失败了");
//    }
//}
