package com.snail.cloud.demo.b;

import indi.jl.sp.core.domain.PageChunk;
import indi.jl.sp.core.util.CollectionUtil;
import indi.jl.sp.core.util.JsonUtil;
import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
import indi.jl.sp.test.common.BaseSpringTest;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoBTest extends BaseSpringTest {

    @Test
    public void save() {
        DemoBDo demoBDo = saveDo();
        DemoBDo save = post("/demoB", DemoBDo.class, JsonUtil.toJsonString(demoBDo));
        assert null != save.getId();
        assert null != save.getCreateTime();
        assert null != save.getUpdateTime();
    }
    
    @Test
    public void update() {
        DemoBDo save = saveDo();
        DemoBDo update = put("/demoB/" + save.getId(), DemoBDo.class, JsonUtil.toJsonString(save));
        assert save.getId() == update.getId();
        assert null != update.getCreateTime();
        assert null != update.getUpdateTime();
    }

    @Test
    public void delete() {
        saveDo();
        saveDo();
        Collection<DemoBDo> demoBDos = get("/demoB", DemoBDo.class, List.class);
        assert CollectionUtil.isNotEmpty(demoBDos);
        String ids = demoBDos.stream()
                .map(demoBDo -> demoBDo.getId().toString())
                .collect(Collectors.joining(","));
        delete("/demoB?ids=" + ids);
        assert CollectionUtil.isEmpty(get("/demoB", DemoBDo.class, List.class));
    }

    @Test
    public void find() {
        saveDo();
        saveDo();
        saveDo();
        saveDo();
        Collection<DemoBDo> demoBDos = get("/demoB", DemoBDo.class, List.class);
        assert demoBDos.size() > 3;

        PageChunk<DemoBDo> pageSize1 = getPage("/demoB/page?size=1&page=0", DemoBDo.class);
        assert pageSize1.getTotalElements() > 3;
        assert pageSize1.getContent().size() == 1;

        PageChunk<DemoBDo> pageSize20 = getPage("/demoB/page?size=20&page=0", DemoBDo.class);
        assert pageSize20.getContent().size() > 3;

        PageChunk<DemoBDo> pageSize20Page1 = getPage("/demoB/page?size=20&page=1", DemoBDo.class);
        assert pageSize20Page1.getContent().size() == 0;
    }
    
    private DemoBDo saveDo() {
        DemoBDo demoBDo = new DemoBDo();
        return post("/demoB", DemoBDo.class, JsonUtil.toJsonString(demoBDo));
    }
}