package br.com.unilito.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoPagamento {

	CREDITO(0), DEBITO(1), BOLETO(2);

	@JsonValue
	private Integer id;

	public TipoPagamento parse(Integer id) {
		return Arrays.stream(values()).filter(tipo -> tipo.id.equals(id)).findFirst().orElse(null);
	}
}
