package springdemo.studentManagement;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import springdemo.studentManagement.data.StudentRecordsDatabase;
import springdemo.studentManagement.model.StudentRecord;

@Configuration
@ComponentScan(basePackages = "springdemo")
public class SpringConf {

	@Bean
	@Scope("singleton")
	public Scanner scanner()
	{
		return new Scanner(System.in);
	}
	
	@Bean
	@Scope("singleton")
	public StudentRecordsDatabase studentRecordsDatabase(@Autowired HashMap<Integer, StudentRecord> hashMap) {
		return new StudentRecordsDatabase(hashMap);
	}
	
	@Bean
	@Scope("singleton")
	public HashMap<Integer, StudentRecord> hashMap(){
		HashMap<Integer, StudentRecord> hashmap= new HashMap<Integer, StudentRecord>();
		hashmap.put(1, new StudentRecord());
		return hashmap;
	}
}