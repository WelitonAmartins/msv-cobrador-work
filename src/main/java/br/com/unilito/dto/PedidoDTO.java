package br.com.unilito.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDate dtPedido;
	private BigDecimal valor;
	private String email;
	private Integer tipo;
	private String status;
}
