package com.snail.cloud.demo.c.api;

import indi.jl.sp.core.domain.PageChunk;
import indi.jl.sp.core.util.CollectionUtil;
import indi.jl.sp.core.util.JsonUtil;
import indi.jl.sp.test.common.BaseSpringTest;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoCApiTest extends BaseSpringTest {

    @Test
    public void save() {
        DemoCApiDo demoCApiDo = saveDo();
        DemoCApiDo save = post("/demoCApi", DemoCApiDo.class, JsonUtil.toJsonString(demoCApiDo));
        assert null != save.getId();
        assert null != save.getCreateTime();
        assert null != save.getUpdateTime();
    }
    
    @Test
    public void update() {
        DemoCApiDo save = saveDo();
        DemoCApiDo update = put("/demoCApi/" + save.getId(), DemoCApiDo.class, JsonUtil.toJsonString(save));
        assert save.getId() == update.getId();
        assert null != update.getCreateTime();
        assert null != update.getUpdateTime();
    }

    @Test
    public void delete() {
        saveDo();
        saveDo();
        Collection<DemoCApiDo> demoCApiDos = get("/demoCApi", DemoCApiDo.class, List.class);
        assert CollectionUtil.isNotEmpty(demoCApiDos);
        String ids = demoCApiDos.stream()
                .map(demoCApiDo -> demoCApiDo.getId().toString())
                .collect(Collectors.joining(","));
        delete("/demoCApi?ids=" + ids);
        assert CollectionUtil.isEmpty(get("/demoCApi", DemoCApiDo.class, List.class));
    }

    @Test
    public void find() {
        saveDo();
        saveDo();
        saveDo();
        saveDo();
        Collection<DemoCApiDo> demoCApiDos = get("/demoCApi", DemoCApiDo.class, List.class);
        assert demoCApiDos.size() > 3;

        PageChunk<DemoCApiDo> pageSize1 = getPage("/demoCApi/page?size=1&page=0", DemoCApiDo.class);
        assert pageSize1.getTotalElements() > 3;
        assert pageSize1.getContent().size() == 1;

        PageChunk<DemoCApiDo> pageSize20 = getPage("/demoCApi/page?size=20&page=0", DemoCApiDo.class);
        assert pageSize20.getContent().size() > 3;

        PageChunk<DemoCApiDo> pageSize20Page1 = getPage("/demoCApi/page?size=20&page=1", DemoCApiDo.class);
        assert pageSize20Page1.getContent().size() == 0;
    }
    
    private DemoCApiDo saveDo() {
        DemoCApiDo demoCApiDo = new DemoCApiDo();
        return post("/demoCApi", DemoCApiDo.class, JsonUtil.toJsonString(demoCApiDo));
    }
}