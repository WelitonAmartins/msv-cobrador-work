package br.com.unilito.service;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unilito.dto.LogBoleto;
import br.com.unilito.dto.PedidoDTO;
import br.com.unilito.repository.CustomRepository;

@Service
public class LogBoletoService {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private CustomRepository customRepository;

	public LogBoleto salvarLogBoleto(final PedidoDTO pedido) throws IOException {

		final Long idPedido = pedidoService.salvarPedido(pedido);
		final LogBoleto logBoleto = new LogBoleto();

		logBoleto.setIdPedido(idPedido);
		logBoleto.setDtPedido(LocalDate.now());
		logBoleto.setNumeroBoleto(String.valueOf(System.currentTimeMillis()));

		customRepository.persistirBoleto(logBoleto);

		return logBoleto;
	}

}
