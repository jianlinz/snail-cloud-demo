package com.snail.cloud.demo.c.resource;

import indi.jl.sp.core.controller.BaseController;
import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.demo.c.api.jpa.domain.DemoCDo;
import com.snail.cloud.demo.c.service.DemoCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "demo-c-api")
@RestController
@RequestMapping("/api/demoC")
public class DemoCResource extends BaseController {

    private final DemoCService demoCService;

    @Autowired
    public DemoCResource(DemoCService demoCService) {
        this.demoCService = demoCService;
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询demo-b")
    public ResponseEntity<DataVO<DemoCDo>> get(@PathVariable(value = "id") Long id) {
        return responseOfGet(demoCService.get(id).orElse(null));
    }

}