package cn.cerc.jmis.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import cn.cerc.jdb.core.TDateTime;

public class QueueConnectionTest {

    public static void main(String[] args) {
        QueueConnection conn;
        try {
            conn = new QueueConnection();
        } catch (JMSException e1) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 3; i++) {
                            conn.sendMessage("activeMQ", "curTime:" + TDateTime.Now());
                            Thread.sleep(1000);
                        }
                    } catch (JMSException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Session session = conn.createSession();
                    Queue queue = session.createQueue("activeMQ");
                    MessageConsumer consumer = session.createConsumer(queue);
                    while (true) {
                        Message msg = consumer.receive();
                        if (msg != null && msg instanceof TextMessage) {
                            System.out.println(
                                    Thread.currentThread().getName() + " receive:" + ((TextMessage) msg).getText());
                            msg.acknowledge();
                        } else {
                            System.out.println("receive is null");
                            break;
                        }
                        Thread.sleep(100);
                    }
                    consumer.close();
                } catch (JMSException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
