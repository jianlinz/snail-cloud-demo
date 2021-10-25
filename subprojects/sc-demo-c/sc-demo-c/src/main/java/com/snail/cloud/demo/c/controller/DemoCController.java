package com.snail.cloud.demo.c.controller;

import indi.jl.sp.core.controller.BaseController;
import indi.jl.sp.core.util.StringUtil;
import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.demo.c.api.jpa.domain.DemoCDo;
import com.snail.cloud.demo.c.service.DemoCService;
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

@Api(tags = "demo-c")
@RestController
@RequestMapping("/demoC")
public class DemoCController extends BaseController {

    private final DemoCService demoCService;

    @Autowired
    public DemoCController(DemoCService demoCService) {
        this.demoCService = demoCService;
    }
    
    @PostMapping
    @ApiOperation("‍新增demo-c")
    public ResponseEntity<DataVO<DemoCDo>> post(@RequestBody DemoCDo demoCDo) {
        return responseOfPost(demoCService.save(demoCDo));
    }

    @DeleteMapping
    @ApiOperation("批量删除demo-c")
    public ResponseEntity<DataVO<String>> delete(@RequestParam @ApiParam(value = "id集合 逗号分隔") String ids) {
        demoCService.deleteByIds(StringUtil.convertLong(ids));
        return responseOfDelete();
    }

    @PutMapping("/{id}")
    @ApiOperation("更新demo-c")
    public ResponseEntity<DataVO<DemoCDo>> put(@PathVariable Long id, @RequestBody DemoCDo demoCDo) {
        demoCDo.setId(id);
        return responseOfPut(demoCService.update(demoCDo));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询demo-c")
    public ResponseEntity<DataVO<DemoCDo>> get(@PathVariable Long id) {
        return responseOfGet(demoCService.get(id).orElse(null));
    }

    @GetMapping
    @ApiOperation("根据条件查询集合demo-c")
    public ResponseEntity<DataVO<List<DemoCDo>>> findAll(DemoCDo demoCDo) {
        return responseOfGet(demoCService.findAll(demoCDo));
    }

    @GetMapping("/page")
    @ApiOperation("根据条件分页查询demo-c")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "当前页数,默认0", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "每页条数,默认10", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "排序 默认根据创建时间倒叙")
    })
    public ResponseEntity<DataVO<PageChunk<DemoCDo>>> findAll(DemoCDo demoCDo,@PageableDefault(sort = DEFAULT_SORT, direction = Sort.Direction.DESC) @ApiIgnore Pageable pageable) {
        return responseOfGet(demoCService.findAll(demoCDo, pageable));
    }
    
}