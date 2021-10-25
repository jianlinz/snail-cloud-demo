package com.snail.cloud.demo.b.controller;

import indi.jl.sp.core.controller.BaseController;
import indi.jl.sp.core.util.StringUtil;
import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
import com.snail.cloud.demo.b.service.DemoBService;
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

@Api(tags = "demo-b")
@RestController
@RequestMapping("/demoB")
public class DemoBController extends BaseController {

    private final DemoBService demoBService;

    @Autowired
    public DemoBController(DemoBService demoBService) {
        this.demoBService = demoBService;
    }
    
    @PostMapping
    @ApiOperation("‍新增demo-b")
    public ResponseEntity<DataVO<DemoBDo>> post(@RequestBody DemoBDo demoBDo) {
        return responseOfPost(demoBService.save(demoBDo));
    }

    @DeleteMapping
    @ApiOperation("批量删除demo-b")
    public ResponseEntity<DataVO<String>> delete(@RequestParam @ApiParam(value = "id集合 逗号分隔") String ids) {
        demoBService.deleteByIds(StringUtil.convertLong(ids));
        return responseOfDelete();
    }

    @PutMapping("/{id}")
    @ApiOperation("更新demo-b")
    public ResponseEntity<DataVO<DemoBDo>> put(@PathVariable Long id, @RequestBody DemoBDo demoBDo) {
        demoBDo.setId(id);
        return responseOfPut(demoBService.update(demoBDo));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询demo-b")
    public ResponseEntity<DataVO<DemoBDo>> get(@PathVariable Long id) {
        return responseOfGet(demoBService.get(id).orElse(null));
    }

    @GetMapping
    @ApiOperation("根据条件查询集合demo-b")
    public ResponseEntity<DataVO<List<DemoBDo>>> findAll(DemoBDo demoBDo) {
        return responseOfGet(demoBService.findAll(demoBDo));
    }

    @GetMapping("/page")
    @ApiOperation("根据条件分页查询demo-b")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "当前页数,默认0", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "每页条数,默认10", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "排序 默认根据创建时间倒叙")
    })
    public ResponseEntity<DataVO<PageChunk<DemoBDo>>> findAll(DemoBDo demoBDo,@PageableDefault(sort = DEFAULT_SORT, direction = Sort.Direction.DESC) @ApiIgnore Pageable pageable) {
        return responseOfGet(demoBService.findAll(demoBDo, pageable));
    }
    
}