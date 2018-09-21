package com.support;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnectionFactory;

public class Queue {

	private String queueManagerName = "remote";
	private String channel = "remote.local";
	private Integer port = 1424;
	private String queueName = "rq";
	private String queuehost = "localhost";
	private static final String transport = "Client";
	private String message = "custome message";

	public static void main(String[] args) throws Exception{
		Queue q = new Queue();
		q.mqExample("Hey I am from java code");

	}

	public MQQueueConnectionFactory createMQConnectionFactory(String host, String channel, Integer port,
			String queueManagerName) throws JMSException {
		try{

		MQQueueConnectionFactory mqQueueConnectionFactory = new MQQueueConnectionFactory();
		mqQueueConnectionFactory.setHostName(host);
		mqQueueConnectionFactory.setChannel(channel);
		mqQueueConnectionFactory.setPort(port);
		mqQueueConnectionFactory.setQueueManager(queueManagerName);
		mqQueueConnectionFactory.setChannel(channel);

			return mqQueueConnectionFactory;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void mqSendMessage(MQQueueConnectionFactory mqQueueConnectionFactory, String qName, String message) throws JMSException {

        String queueString = "queue:///";
        try{
        	QueueConnection conn = mqQueueConnectionFactory.createQueueConnection();
        	QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        	MQQueue mqQueue = (MQQueue) session.createQueue(queueString.concat(queueName));
        	QueueSender sender = session.createSender(mqQueue);
            TextMessage textMessage = session.createTextMessage(message);
            conn.start();
            sender.send(textMessage);

        }catch(Exception e){
        	e.printStackTrace();
        }

    }

	public void mqExample(String message) throws JMSException {
		MQQueueConnectionFactory mqConnection = createMQConnectionFactory(queuehost, channel, port, queueManagerName);
		mqSendMessage(mqConnection, queueName, message);
	}

}
