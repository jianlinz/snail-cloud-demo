package com.snail.cloud.demo.d;

import indi.jl.sp.core.domain.PageChunk;
import indi.jl.sp.core.util.CollectionUtil;
import indi.jl.sp.core.util.JsonUtil;
import com.snail.cloud.demo.d.jpa.domain.DemoDDo;
import indi.jl.sp.test.common.BaseSpringTest;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoDTest extends BaseSpringTest {

    @Test
    public void save() {
        DemoDDo demoDDo = saveDo();
        DemoDDo save = post("/demoD", DemoDDo.class, JsonUtil.toJsonString(demoDDo));
        assert null != save.getId();
        assert null != save.getCreateTime();
        assert null != save.getUpdateTime();
    }
    
    @Test
    public void update() {
        DemoDDo save = saveDo();
        DemoDDo update = put("/demoD/" + save.getId(), DemoDDo.class, JsonUtil.toJsonString(save));
        assert save.getId() == update.getId();
        assert null != update.getCreateTime();
        assert null != update.getUpdateTime();
    }

    @Test
    public void delete() {
        saveDo();
        saveDo();
        Collection<DemoDDo> demoDDos = get("/demoD", DemoDDo.class, List.class);
        assert CollectionUtil.isNotEmpty(demoDDos);
        String ids = demoDDos.stream()
                .map(demoDDo -> demoDDo.getId().toString())
                .collect(Collectors.joining(","));
        delete("/demoD?ids=" + ids);
        assert CollectionUtil.isEmpty(get("/demoD", DemoDDo.class, List.class));
    }

    @Test
    public void find() {
        saveDo();
        saveDo();
        saveDo();
        saveDo();
        Collection<DemoDDo> demoDDos = get("/demoD", DemoDDo.class, List.class);
        assert demoDDos.size() > 3;

        PageChunk<DemoDDo> pageSize1 = getPage("/demoD/page?size=1&page=0", DemoDDo.class);
        assert pageSize1.getTotalElements() > 3;
        assert pageSize1.getContent().size() == 1;

        PageChunk<DemoDDo> pageSize20 = getPage("/demoD/page?size=20&page=0", DemoDDo.class);
        assert pageSize20.getContent().size() > 3;

        PageChunk<DemoDDo> pageSize20Page1 = getPage("/demoD/page?size=20&page=1", DemoDDo.class);
        assert pageSize20Page1.getContent().size() == 0;
    }
    
    private DemoDDo saveDo() {
        DemoDDo demoDDo = new DemoDDo();
        return post("/demoD", DemoDDo.class, JsonUtil.toJsonString(demoDDo));
    }
}