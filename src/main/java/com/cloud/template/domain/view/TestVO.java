package com.cloud.template.domain.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * testvo
 */
@Data
public class TestVO implements Serializable {
    private long id;
    private String name;
    private Date createTime;
    private Date updateTime;

}
