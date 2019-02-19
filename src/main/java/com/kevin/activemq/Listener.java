package com.kevin.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author kevin
 * @version 1.0
 * @description     监听器
 * @createDate 2019/1/24
 */
public class Listener implements MessageListener {


    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("消息：" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
