package com.snail.cloud.demo.d.controller;

import com.snail.cloud.demo.d.service.DemoDService;
import indi.jl.sp.core.controller.BaseController;
import indi.jl.sp.core.util.StringUtil;
import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.demo.d.jpa.domain.DemoDDo;
import com.snail.cloud.demo.b.api.BApi;
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

@Api(tags = "demo-d")
@RestController
@RequestMapping("/demoD")
public class DemoDController extends BaseController {

    private final DemoDService demoDService;

    private final BApi bApi;

    @Autowired
    public DemoDController(DemoDService demoDService, BApi bApi) {
        this.demoDService = demoDService;
        this.bApi = bApi;
    }

    @PostMapping
    @ApiOperation("‍新增demo-d")
    public ResponseEntity<DataVO<DemoDDo>> post(@RequestBody DemoDDo demoDDo) {
        return responseOfPost(demoDService.save(demoDDo));
    }

    @DeleteMapping
    @ApiOperation("批量删除demo-d")
    public ResponseEntity<DataVO<String>> delete(@RequestParam @ApiParam(value = "id集合 逗号分隔") String ids) {
        demoDService.deleteByIds(StringUtil.convertLong(ids));
        return responseOfDelete();
    }

    @PutMapping("/{id}")
    @ApiOperation("更新demo-d")
    public ResponseEntity<DataVO<DemoDDo>> put(@PathVariable Long id, @RequestBody DemoDDo demoDDo) {
        demoDDo.setId(id);
        return responseOfPut(demoDService.update(demoDDo));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询demo-d")
    public ResponseEntity<DataVO<DemoDDo>> get(@PathVariable Long id) {
        return responseOfGet(demoDService.get(id).orElse(null));
    }

    @GetMapping
    @ApiOperation("根据条件查询集合demo-d")
    public ResponseEntity<DataVO<List<DemoDDo>>> findAll(DemoDDo demoDDo) {
        return responseOfGet(demoDService.findAll(demoDDo));
    }

    @GetMapping("/page")
    @ApiOperation("根据条件分页查询demo-d")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "当前页数,默认0", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "每页条数,默认10", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "排序 默认根据创建时间倒叙")
    })
    public ResponseEntity<DataVO<PageChunk<DemoDDo>>> findAll(DemoDDo demoDDo, @PageableDefault(sort = DEFAULT_SORT, direction = Sort.Direction.DESC) @ApiIgnore Pageable pageable) {
        return responseOfGet(demoDService.findAll(demoDDo, pageable));
    }

}