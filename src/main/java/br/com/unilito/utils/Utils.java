package br.com.unilito.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.java.Log;

@Log
public class Utils {

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
	}

	public static <T> T paraObjViaJson(final String conteudoJson, final TypeReference<T> tipoObjeto)
			throws IOException {
		try {
			return mapper.readValue(conteudoJson, tipoObjeto);
		} catch (final IOException e) {
			log.info("Erro ao converter o DTO para Json.");
//			throw new Exception("Erro ao converter o DTO para Json.");
			throw e;
		}
	}
}
