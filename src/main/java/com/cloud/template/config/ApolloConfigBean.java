package com.cloud.template.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class ApolloConfigBean {

    private static final String DEFAULT_VALUE = "undefined";

    @ApolloConfig
    private Config config;
    @Value("${batch:100}")
    private int batch;

    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        if (changeEvent.isChanged("batch")) {
            batch = config.getIntProperty("batch", 100);
        }

        log.info("Changes for namespace {}", changeEvent.getNamespace());
        for (String key : changeEvent.changedKeys()) {
            ConfigChange change = changeEvent.getChange(key);
            log.info("Change - key: {}, oldValue: {}, newValue: {}, changeType: {}",
                    change.getPropertyName(), change.getOldValue(), change.getNewValue(),
                    change.getChangeType());
        }
    }

    public int getBatch() {
        return this.batch;
    }

    public Config getConfig() {
        return this.config;
    }

    public String getConfig(String key) {
        String result = config.getProperty(key, DEFAULT_VALUE);
        log.info(String.format("Loading key : %s with value: %s", key, result));
        return result;
    }

}