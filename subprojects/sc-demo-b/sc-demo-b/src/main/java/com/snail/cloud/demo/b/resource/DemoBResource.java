package com.snail.cloud.demo.b.resource;

import indi.jl.sp.core.controller.BaseController;
import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
import com.snail.cloud.demo.b.service.DemoBService;
import com.snail.cloud.demo.c.api.CApi;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "demo-b-api")
@RestController
@RequestMapping("/api/demoB")
public class DemoBResource extends BaseController {

    private final DemoBService demoBService;

    private final CApi cApi;

    @Autowired
    public DemoBResource(DemoBService demoBService, CApi cApi) {
        this.demoBService = demoBService;
        this.cApi = cApi;
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询demo-b")
    public ResponseEntity<DataVO<DemoBDo>> get(@PathVariable(value = "id") Long id) {
        cApi.get(id);
        return responseOfGet(demoBService.get(id).orElse(null));
    }

}