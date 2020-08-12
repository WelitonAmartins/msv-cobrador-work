package br.com.unilito.worker;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.unilito.dto.PedidoDTO;
import br.com.unilito.service.PedidoService;
import br.com.unilito.utils.Utils;

@Service
public class CreditoWorker {

	@Autowired
	private PedidoService pedidoService;

	@RabbitListener(queues = "#{creditoQueue.name}")
	public void recupararMSG(String msg) throws IOException {
		final PedidoDTO pedido = Utils.paraObjViaJson(msg, new TypeReference<PedidoDTO>() {
		});

		pedidoService.salvarPedido(pedido);
	}

}
