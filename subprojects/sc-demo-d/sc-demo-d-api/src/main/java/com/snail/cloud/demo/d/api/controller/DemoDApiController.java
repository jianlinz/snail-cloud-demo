package com.snail.cloud.demo.d.api.controller;

import com.snail.cloud.demo.d.api.service.DemoDApiService;
import indi.jl.sp.core.controller.BaseController;
import indi.jl.sp.core.util.StringUtil;
import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.demo.d.api.jpa.domain.DemoDApiDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "demo-d-api")
@RestController
@RequestMapping("/demoDApi")
public class DemoDApiController extends BaseController {

    private final DemoDApiService demoDApiService;

    @Autowired
    public DemoDApiController(DemoDApiService demoDApiService) {
        this.demoDApiService = demoDApiService;
    }
    
    @PostMapping
    @ApiOperation("‍新增demo-d-api")
    public ResponseEntity<DataVO<DemoDApiDo>> post(@RequestBody DemoDApiDo demoDApiDo) {
        return responseOfPost(demoDApiService.save(demoDApiDo));
    }

    @DeleteMapping
    @ApiOperation("批量删除demo-d-api")
    public ResponseEntity<DataVO<String>> delete(@RequestParam @ApiParam(value = "id集合 逗号分隔") String ids) {
        demoDApiService.deleteByIds(StringUtil.convertLong(ids));
        return responseOfDelete();
    }

    @PutMapping("/{id}")
    @ApiOperation("更新demo-d-api")
    public ResponseEntity<DataVO<DemoDApiDo>> put(@PathVariable Long id, @RequestBody DemoDApiDo demoDApiDo) {
        demoDApiDo.setId(id);
        return responseOfPut(demoDApiService.update(demoDApiDo));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询demo-d-api")
    public ResponseEntity<DataVO<DemoDApiDo>> get(@PathVariable Long id) {
        return responseOfGet(demoDApiService.get(id).orElse(null));
    }

    @GetMapping
    @ApiOperation("根据条件查询集合demo-d-api")
    public ResponseEntity<DataVO<List<DemoDApiDo>>> findAll(DemoDApiDo demoDApiDo) {
        return responseOfGet(demoDApiService.findAll(demoDApiDo));
    }

    @GetMapping("/page")
    @ApiOperation("根据条件分页查询demo-d-api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "当前页数,默认0", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "每页条数,默认10", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "排序 默认根据创建时间倒叙")
    })
    public ResponseEntity<DataVO<PageChunk<DemoDApiDo>>> findAll(DemoDApiDo demoDApiDo,@PageableDefault(sort = DEFAULT_SORT, direction = Sort.Direction.DESC) @ApiIgnore Pageable pageable) {
        return responseOfGet(demoDApiService.findAll(demoDApiDo, pageable));
    }
    
}