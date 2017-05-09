package evolution;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evolution.entity.AnyEntity;
import evolution.mapper.AnyMapper;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AnyMapper anyMapper;// Tag AnyMapper with @Mapper.
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void initialize() throws SQLException {
		// Initialize
		Statement statement = dataSource.getConnection().createStatement();
		statement.execute("drop table if exists any_table");
		statement.execute("create table any_table(id int primary key auto_increment"
				+ ", name varchar(20))");
		statement.execute("insert into any_table(name) values('Chen')");
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		initialize();
		List<AnyEntity> anyEntities = anyMapper.selectByName("Chen");
		System.out.println(anyEntities);
	}
}
