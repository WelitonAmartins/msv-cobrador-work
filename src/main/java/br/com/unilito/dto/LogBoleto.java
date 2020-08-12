package br.com.unilito.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogBoleto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDate dtPedido;
	private Long idPedido;
	private String numeroBoleto;
}
