package com.snail.cloud.demo.b.api.jpa.domain;

import indi.jl.sp.data.jpa.domain.BaseDo;
import indi.jl.sp.core.util.JsonUtil;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "demo-b")
@Entity
@Table(name = "sp_demo_b")
public class DemoBDo extends BaseDo {

    public DemoBDo(){}

    @Column
    @ApiModelProperty("测试字段")
    private Integer test;

    public Integer getTest() {
        return test;
    }

    public DemoBDo setTest(Integer test) {
        this.test = test;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}