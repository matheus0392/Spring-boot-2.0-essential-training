package dev.msnascimento.training;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

	@Value("${amqp.queue.name}")
	private String queueName;

	@Bean
	public MessageListenerAdapter listenerAdapter(RoomCleanerProcessor processor, TopicExchange topicExchange) {
		return new MessageListenerAdapter(processor, "receiveMessage");
	}

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connection,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		container.setConnectionFactory(connection);
		return container;
	}

}
