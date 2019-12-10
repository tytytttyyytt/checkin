package cn.edu.zjut.qiandao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Query;


@SpringBootApplication
@MapperScan("cn.edu.zjut.qiandao.mapper")
@EnableTransactionManagement
public class QiandaoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(QiandaoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(QiandaoApplication.class, args);
	}

}
