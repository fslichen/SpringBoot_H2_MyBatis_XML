package evolution;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evolution.entity.AnotherEntity;
import evolution.entity.AnyEntity;
import evolution.mapper.AnotherMapper;
import evolution.mapper.AnyMapper;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AnyMapper anyMapper;// Tag AnyMapper with @Mapper.
	
	@Autowired
	private AnotherMapper anotherMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void initialize() throws SQLException {
		// Create table any_table.
		Statement statement = dataSource.getConnection().createStatement();
		statement.execute("drop table if exists any_table");
		statement.execute("create table any_table(id int primary key auto_increment"
				+ ", name varchar(20), gender varchar(10))");
		statement.execute("insert into any_table(name, gender) values('Chen', 'M')");
		statement.execute("insert into any_table(name, gender) values('Ling', 'F')");
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		initialize();
		// Test AnyEntity and AnotherEntity
		List<AnyEntity> anyEntities = anyMapper.selectByName("Chen");
		System.out.println("Select by Name = " + anyEntities);
		anyEntities = anyMapper.selectAll();
		System.out.println("Select All = " + anyEntities);
		int count = anyMapper.selectCount();
		System.out.println("Select Count = " + count);
		List<String> names = anyMapper.selectNames();
		System.out.println("Select Names = " + names);
		List<AnotherEntity> anotherEntities = anyMapper.selectIdsAndNames();
		System.out.println("Select Ids and Names = " + anotherEntities);
		anyEntities = anotherMapper.findByOptionalName("Chen");
		System.out.println(anyEntities);
		anyEntities = anotherMapper.findByOptionalName(null);
		System.out.println(anyEntities);
		anyEntities = anotherMapper.findByOptionalNameOrGender("Chen", "M");
		System.out.println(anyEntities);
		anotherMapper.updateById(1, "Elsa", "F");
		anyEntities = anyMapper.selectByName("Elsa");
		System.out.println(anyEntities);
		anyEntities = anotherMapper.findByNames(Arrays.asList("Chen", "Elsa"));
		System.out.println(anyEntities);
	}
}
