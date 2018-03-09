package com.cloud.template.config;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
public class SpringConfigApollo {

    @Bean
    public ApolloConfigBean apolloConfigBean(){
        return new ApolloConfigBean();
    }

}
