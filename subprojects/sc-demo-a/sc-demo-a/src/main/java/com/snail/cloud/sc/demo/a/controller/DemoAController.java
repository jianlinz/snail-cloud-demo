package com.snail.cloud.sc.demo.a.controller;

import indi.jl.sp.core.controller.BaseController;
import indi.jl.sp.core.util.StringUtil;
import indi.jl.sp.core.vo.DataVO;
import com.snail.cloud.sc.demo.a.api.jpa.domain.DemoADo;
import com.snail.cloud.sc.demo.a.service.DemoAService;
import com.snail.cloud.demo.b.api.BApi;
import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
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

@Api(tags = "demo-a")
@RestController
@RequestMapping("/demoA")
public class DemoAController extends BaseController {

    private final DemoAService demoAService;

    @Autowired
    private  BApi bApi;

    @Autowired
    public DemoAController(DemoAService demoAService) {
        this.demoAService = demoAService;
    }

    @PostMapping
    @ApiOperation("‍新增demo-a")
    public ResponseEntity<DataVO<DemoADo>> post(@RequestBody DemoADo demoADo) {
        return responseOfPost(demoAService.save(demoADo));
    }

    @DeleteMapping
    @ApiOperation("批量删除demo-a")
    public ResponseEntity<DataVO<String>> delete(@RequestParam @ApiParam(value = "id集合 逗号分隔") String ids) {
        demoAService.deleteByIds(StringUtil.convertLong(ids));
        return responseOfDelete();
    }

    @PutMapping("/{id}")
    @ApiOperation("更新demo-a")
    public ResponseEntity<DataVO<DemoADo>> put(@PathVariable Long id, @RequestBody DemoADo demoADo) {
        demoADo.setId(id);
        return responseOfPut(demoAService.update(demoADo));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询demo-a")
    public ResponseEntity<DataVO<DemoADo>> get(@PathVariable Long id) {
        return responseOfGet(demoAService.get(id).orElse(null));
    }

    @GetMapping
    @ApiOperation("根据条件查询集合demo-a")
    public ResponseEntity<DataVO<List<DemoADo>>> findAll(DemoADo demoADo) {
        return responseOfGet(demoAService.findAll(demoADo));
    }

    @GetMapping("/page")
    @ApiOperation("根据条件分页查询demo-a")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "当前页数,默认0", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "每页条数,默认10", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "排序 默认根据创建时间倒叙")
    })
    public ResponseEntity<DataVO<PageChunk<DemoADo>>> findAll(DemoADo demoADo, @PageableDefault(sort = DEFAULT_SORT, direction = Sort.Direction.DESC) @ApiIgnore Pageable pageable) {
        return responseOfGet(demoAService.findAll(demoADo, pageable));
    }

    @GetMapping("/{id}/demoB")
    @ApiOperation("根据id查询demo-a")
    public ResponseEntity<DataVO<DemoBDo>> getDemoB(@PathVariable Long id) {
        return responseOfGet(bApi.get(id));
    }

}