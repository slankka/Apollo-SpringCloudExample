package com.cloud.template.provider.controller;

import com.cloud.template.config.ApolloConfigBean;
import com.cloud.template.domain.enums.BizExceptionEnum;
import com.cloud.template.domain.exception.BizException;
import com.cloud.template.provider.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class ApolloBridgedController {

    @Autowired
    private ApolloConfigBean apolloConfigBean;

    @RequestMapping("/hello")
    public ApiResponse hello(@RequestParam("key") String key) {

        if (apolloConfigBean == null || apolloConfigBean.getConfig() == null) {
            throw new BizException(BizExceptionEnum.PARAM_ERROR, "Apollo配置注入失败");
        }
        return ApiResponse.buildSuccess(apolloConfigBean.getConfig(key));

    }

}
