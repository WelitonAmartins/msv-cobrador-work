package br.com.unilito.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.unilito.utils.UtilsConstants;

@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue creditoQueue() {
		return new Queue(UtilsConstants.QUEUE_CREDITO, false);
	}

	@Bean
	public Queue debitoQueue() {
		return new Queue(UtilsConstants.QUEUE_DEBITO, false);
	}

	@Bean
	public Queue boletoQueue() {
		return new Queue(UtilsConstants.QUEUE_BOLETO, false);
	}

	@Bean
	public Queue logQueue() {
		return new Queue(UtilsConstants.QUEUE_LOG, false);
	}
}
