package br.com.unilito.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unilito.dto.PedidoDTO;

@Repository
@PropertySource("classpath:query/pedido.properties")
public class CustomRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Value("${SPI.QUERY.INSERT.PEDIDO}")
	private String queryInsert;

	public void persistir(PedidoDTO pedido) {
		final BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(pedido);
		jdbc.update(queryInsert, paramSource);
	}
}
