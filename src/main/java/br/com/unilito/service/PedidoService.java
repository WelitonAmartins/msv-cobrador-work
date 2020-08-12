package br.com.unilito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unilito.dto.PedidoDTO;
import br.com.unilito.repository.CustomRepository;

@Service
public class PedidoService {

	@Autowired
	private CustomRepository customRepository;

	public Long salvarPedido(PedidoDTO pedido) {

		pedido.setStatus("Recebido");
		final Long idPedido = customRepository.persistir(pedido);
		return idPedido;
	}
}
