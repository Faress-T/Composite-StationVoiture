package fr.miage.lroux.compositestationvoiture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@LoadBalancerClients
@SpringBootApplication
public class CompositeStationVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompositeStationVoitureApplication.class, args);
    }

}
