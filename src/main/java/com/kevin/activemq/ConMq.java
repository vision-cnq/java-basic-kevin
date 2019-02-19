package com.kevin.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;

/**
 * @author kevin
 * @version 1.0
 * @description     消费者
 * @createDate 2019/1/24
 */
public class ConMq {

    //队列模式
    public static final String queueName = "queue-test";


    public static void main(String[] args) throws JMSException {

        //5. 创建一个目标
        Destination destination = MqSession.session().createQueue(queueName);
        //6. 创建一个消费者
        MessageConsumer consumer = MqSession.session().createConsumer(destination);
        //监听生产者方式接受消息，生产者产生消息才开始接收 需要监听器 实现MessageListener (javax.jms.MessageListener包)
        consumer.setMessageListener(new Listener());
    }
}
