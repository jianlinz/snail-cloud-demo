package com.snail.cloud.sc.demo.a.api.jpa.domain;

import indi.jl.sp.data.jpa.domain.BaseDo;
import indi.jl.sp.core.util.JsonUtil;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "demo-a")
@Entity
@Table(name = "sp_demo_a")
public class DemoADo extends BaseDo {

    public DemoADo(){}

    @Column
    @ApiModelProperty("测试字段")
    private Integer test;

    public Integer getTest() {
        return test;
    }

    public DemoADo setTest(Integer test) {
        this.test = test;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}