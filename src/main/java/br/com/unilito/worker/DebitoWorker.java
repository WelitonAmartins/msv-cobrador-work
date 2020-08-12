package br.com.unilito.worker;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.unilito.dto.LogBoleto;
import br.com.unilito.dto.PedidoDTO;
import br.com.unilito.service.EmailService;
import br.com.unilito.service.LogBoletoService;
import br.com.unilito.utils.Utils;

@Service
public class DebitoWorker {

	@Autowired
	private LogBoletoService logBoletoService;

	@Autowired
	private EmailService emailService;

	@RabbitListener(queues = "#{debitoQueue.name}")
	public void recupararMSG(String msg) throws IOException {
		final PedidoDTO pedido = Utils.paraObjViaJson(msg, new TypeReference<PedidoDTO>() {
		});
		final LogBoleto logBoleto = logBoletoService.salvarLogBoleto(pedido);
		emailService.sendSimpleMessage(pedido.getEmail(), "Lito Boleto", gerarCorpoEmail(pedido, logBoleto));
	}

	private String gerarCorpoEmail(PedidoDTO pedido, LogBoleto logBoleto) {
		final StringBuffer msg = new StringBuffer();
		msg.append("Bom dia ").append(pedido.getEmail()).append("\n Seu boleto foi gerado com sucesso!")
				.append("\n numero do Boleto:").append(logBoleto.getNumeroBoleto());
		return msg.toString();
	}

}
