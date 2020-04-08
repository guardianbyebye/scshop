package cn.edu.cdu.wjl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("/cn.edu.cdu.wjl.Dao")
public class scshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(scshopApplication.class, args);
    }
}
