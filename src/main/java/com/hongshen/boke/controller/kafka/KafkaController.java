//package com.hongshen.boke.controller.kafka;
//
//import com.hongshen.boke.dao.object.ArticleDO;
//import com.hongshen.boke.utils.JsonUtil;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * Created with IDEA
// *
// * @author:qianhongshen
// * @Date:2019/6/19 15:03
// * @Desc: kafka测试
// */
//@RestController
//@RequestMapping("kafka")
//public class KafkaController {
//    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
//    /**
//     * 注入kafkaTemplate
//     */
//    @Autowired
//    private KafkaTemplate<Object, Object> kafkaTemplate;
//
//    @Autowired
//    private com.hongshen.boke.controller.kafka.KafkaListener listener;
//
//    @RequestMapping("/kafka")
//    public String testKafka() {
//        ArticleDO aDo = new ArticleDO();
//        aDo.setTitle("这是标题");
//        aDo.setContent("这是内容");
//        String json = JsonUtil.toJson(aDo);
//        kafkaTemplate.setProducerListener(listener);
//        kafkaTemplate.send("qian", json);
//        return "success";
//    }
//
//
//    /**
//     * 消费者使用日志打印消息
//     */
//
//    @KafkaListener(topics = "qian")
//    public void receive(ConsumerRecord<Object, Object> consumer) {
//        Object value = consumer.value();
//        ArticleDO articleDOS = JsonUtil.parseJson((String) value, ArticleDO.class);
//        System.out.println("topic名称:" + consumer.topic() + ",key:" + consumer.key() + ",分区位置:" + consumer.partition()
//                + ", 下标" + consumer.offset());
//    }
//
//}
