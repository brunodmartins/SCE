/**
 * 
 */
package br.com.sce;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Classe: StandaloneDataConfig <br>
 * 
 * @author Bruno <br>
 * 
 *         Propósito: <br>
 *         Data de criação: 01/05/2015 <br>
 */
//@Configuration
//@Profile("test")
public class StandaloneDataConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
				.addScript("file:src/test/java/bancoTeste.sql")
				.build();
	}

}
