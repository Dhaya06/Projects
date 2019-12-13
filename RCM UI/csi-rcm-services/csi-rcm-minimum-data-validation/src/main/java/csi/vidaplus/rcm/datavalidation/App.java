package csi.vidaplus.rcm.datavalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.csi.microservices.SpringBootApplication;


@EnableFeignClients
@EnableHystrix
public class App extends SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}