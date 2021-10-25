package com.snail.cloud.demo.c.api;

import com.snail.cloud.demo.c.api.jpa.domain.DemoCDo;
import indi.jl.sp.core.vo.DataVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = DemoCApiConfiguration.APPLICATION, path = "/api/demoC", primary = false)
public interface CApi {

    @GetMapping(value = "/{id}")
    DataVO<DemoCDo> get(@PathVariable(value = "id") Long id);
}
