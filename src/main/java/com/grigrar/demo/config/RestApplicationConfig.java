package com.grigrar.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.condition.ResourceCondition;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

import static org.springframework.core.annotation.AnnotationFilter.packages;

@ApplicationPath("/rest") // url
@Configuration
public class RestApplicationConfig extends ResourceConfig {

    public RestApplicationConfig(){
        super();
        packages("com.grigrar.demo");
    }
}
