package com.cloud.template.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

/**
 * @author slannka
 */
@Slf4j
public class YamlPropertiesLoader implements SpringApplicationRunListener, Ordered {

    private YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    public YamlPropertiesLoader(SpringApplication application, String[] args) {
        //ignore
    }


    @Override
    public void started() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        try {
            Resource[] resources = context.getResources("classpath:conf/application*.yaml");

            String[] activeProfiles = context.getEnvironment().getActiveProfiles();
            log.info("Detect the Active profiles are {}", StringUtils.arrayToCommaDelimitedString(activeProfiles));

            PropertySource<?> load = loader.load("YamlProperties", resources[0], null);
            if (load == null) {
                log.error("Properties Load From YAML Fail");
                return;
            }
            context.getEnvironment().getPropertySources().addLast(load);
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Failed to load yaml configuration", e);
        }

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }

}
