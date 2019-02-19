package com.kevin.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

/**
 * @author kevin
 * @version 1.0
 * @description     生产者
 * @createDate 2019/1/24
 */
public class ProMq {

    //队列模式
    public static final String queueName = "queue-test";


    public static void main(String[] args) throws JMSException {


        //5. 创建一个目标
        Destination destination = MqSession.session().createQueue(queueName);
        //6. 创建一个生产者
        MessageProducer producer = MqSession.session().createProducer(destination);


        for (int i = 0; i < 10000; i++) {
            //7. 创建消息
            TextMessage textMessage = MqSession.session().createTextMessage("test" + i);
            //8. 发布消息
            producer.send(textMessage);
            System.out.println("发送消息" + textMessage.getText());
        }
        //9. 关闭链接        
        MqSession.session().close();
    }

}
