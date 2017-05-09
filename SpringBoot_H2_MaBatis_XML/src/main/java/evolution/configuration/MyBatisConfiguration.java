package evolution.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// There is no need to define SqlSessionFactoryBean because mybatis will take care of itself.
// According to the official website: In normal MyBatis-Spring usage, you will not need to use SqlSessionFactoryBean or the corresponding SqlSessionFactory directly. Instead, the session factory will be injected into MapperFactoryBeans or other DAOs that extend SqlSessionDaoSupport.
@Configuration// Denote the current class as the configuration class. 
@MapperScan(basePackages = "evolution")// Set it as the root package to make re-factoring easier.
@EnableTransactionManagement
public class MyBatisConfiguration {
	// The following bean is optional.
	// If provided, mybatis uses the data source you defined.
	// If not provided, mybatis uses the default data source with URL equals jdbc:h2:mem:testdb
	@Bean// Inject DataSource
	@ConfigurationProperties("datasource")// Reads the properties from application.properties automatically. The prefix is datasource. 
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}	
}
