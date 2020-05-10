package com.coinker.server.hi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServerHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerHiApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServerHiApplication.class.getName());


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String callHome() {
        LOG.log(Level.INFO, "calling trace service-aaa  ");
        return restTemplate.getForObject("http://localhost:7779/hi", String.class);
    }

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public String info() {
        LOG.log(Level.INFO, "calling trace service-aaa ");
        return "i'm service-aaa";

    }
}
