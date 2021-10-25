package com.snail.cloud.demo.c.api.jpa.domain;

import indi.jl.sp.data.jpa.domain.BaseDo;
import indi.jl.sp.core.util.JsonUtil;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "demo-c")
@Entity
@Table(name = "sp_demo_c")
public class DemoCDo extends BaseDo {

    public DemoCDo(){}

    @Column
    @ApiModelProperty("测试字段")
    private Integer test;

    public Integer getTest() {
        return test;
    }

    public DemoCDo setTest(Integer test) {
        this.test = test;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}