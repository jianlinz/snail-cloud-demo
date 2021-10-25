package com.snail.cloud.demo.d.api.jpa.domain;

import indi.jl.sp.data.jpa.domain.BaseDo;
import indi.jl.sp.core.util.JsonUtil;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "demo-d-api")
@Entity
@Table(name = "sc_demo_d_api")
public class DemoDApiDo extends BaseDo {

    public DemoDApiDo(){}

    @Column
    @ApiModelProperty("测试字段")
    private Integer test;

    public Integer getTest() {
        return test;
    }

    public DemoDApiDo setTest(Integer test) {
        this.test = test;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}