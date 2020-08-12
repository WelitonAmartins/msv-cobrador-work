package br.com.unilito.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import br.com.unilito.dto.LogBoleto;
import br.com.unilito.dto.PedidoDTO;

@Repository
@PropertySource("classpath:query/pedido.properties")
public class CustomRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Value("${SPI.QUERY.INSERT.PEDIDO}")
	private String queryInsert;

	@Value("${SPI.QUERY.INSERT.LOG.BOLETO}")
	private String queryInsertLogBoleto;

	public Long persistir(PedidoDTO pedido) {
		final GeneratedKeyHolder key = new GeneratedKeyHolder();
		final BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(pedido);
		jdbc.update(queryInsert, paramSource, key, new String[] { "id" });
		return key.getKey().longValue();
	}

	public void persistirBoleto(LogBoleto boleto) {
		final BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(boleto);
		jdbc.update(queryInsertLogBoleto, paramSource);
	}
}
