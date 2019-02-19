package com.kevin.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;


import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/1/24
 */
public class MqSession {

    public static final String url = "tcp://127.0.0.1:61616";


    public static Session session() throws JMSException {


        //1. 创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //2. 创建Connection
        Connection connection = connectionFactory.createConnection();
        //3. 启动链接        
        connection.start();
        //4. 创建会话
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

}
