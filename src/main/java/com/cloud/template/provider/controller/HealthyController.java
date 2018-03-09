package com.cloud.template.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 健康检查
 */
@RestController
public class HealthyController {

    /**
     * 健康检查
     *
     * @return
     */
    @RequestMapping(value = "/test/healthy", method = RequestMethod.GET)
    public String testAlive() {
        return "alive";
    }

}
