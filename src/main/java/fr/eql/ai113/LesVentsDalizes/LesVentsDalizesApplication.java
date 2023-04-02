package fr.eql.ai113.LesVentsDalizes;

import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class LesVentsDalizesApplication{// implements CommandLineRunner {
//public class LesVentsDalizesApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(LesVentsDalizesApplication.class, args);
	}


//	@Override
//	public void run(String...args)throws Exception{
//
//		Resource ressource = new ClassPathResource("import.sql");
//		Connection connection = dataSource.getConnection();
//		ScriptUtils.executeSqlScript(connection, new EncodedResource(ressource, "UTF-8"));
//		connection.close();
//	}
}
