package com.snail.cloud.demo.b.api;

import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = DemoBApiConfiguration.APPLICATION, path = "/api/demoB", primary = false)
public interface BApi {

    @GetMapping(value = "/{id}")
    DataVO<DemoBDo> get(@PathVariable(value = "id") Long id);
}
