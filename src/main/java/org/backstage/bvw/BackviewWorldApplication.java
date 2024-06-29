package org.backstage.bvw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackviewWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackviewWorldApplication.class, args);
	}

}
