package com.snail.cloud.demo.d.api;

import com.snail.cloud.demo.d.api.jpa.domain.DemoDApiDo;
import indi.jl.sp.core.domain.PageChunk;
import indi.jl.sp.core.util.CollectionUtil;
import indi.jl.sp.core.util.JsonUtil;
import indi.jl.sp.test.common.BaseSpringTest;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoDApiTest extends BaseSpringTest {

    @Test
    public void save() {
        DemoDApiDo demoDApiDo = saveDo();
        DemoDApiDo save = post("/demoDApi", DemoDApiDo.class, JsonUtil.toJsonString(demoDApiDo));
        assert null != save.getId();
        assert null != save.getCreateTime();
        assert null != save.getUpdateTime();
    }
    
    @Test
    public void update() {
        DemoDApiDo save = saveDo();
        DemoDApiDo update = put("/demoDApi/" + save.getId(), DemoDApiDo.class, JsonUtil.toJsonString(save));
        assert save.getId() == update.getId();
        assert null != update.getCreateTime();
        assert null != update.getUpdateTime();
    }

    @Test
    public void delete() {
        saveDo();
        saveDo();
        Collection<DemoDApiDo> demoDApiDos = get("/demoDApi", DemoDApiDo.class, List.class);
        assert CollectionUtil.isNotEmpty(demoDApiDos);
        String ids = demoDApiDos.stream()
                .map(demoDApiDo -> demoDApiDo.getId().toString())
                .collect(Collectors.joining(","));
        delete("/demoDApi?ids=" + ids);
        assert CollectionUtil.isEmpty(get("/demoDApi", DemoDApiDo.class, List.class));
    }

    @Test
    public void find() {
        saveDo();
        saveDo();
        saveDo();
        saveDo();
        Collection<DemoDApiDo> demoDApiDos = get("/demoDApi", DemoDApiDo.class, List.class);
        assert demoDApiDos.size() > 3;

        PageChunk<DemoDApiDo> pageSize1 = getPage("/demoDApi/page?size=1&page=0", DemoDApiDo.class);
        assert pageSize1.getTotalElements() > 3;
        assert pageSize1.getContent().size() == 1;

        PageChunk<DemoDApiDo> pageSize20 = getPage("/demoDApi/page?size=20&page=0", DemoDApiDo.class);
        assert pageSize20.getContent().size() > 3;

        PageChunk<DemoDApiDo> pageSize20Page1 = getPage("/demoDApi/page?size=20&page=1", DemoDApiDo.class);
        assert pageSize20Page1.getContent().size() == 0;
    }
    
    private DemoDApiDo saveDo() {
        DemoDApiDo demoDApiDo = new DemoDApiDo();
        return post("/demoDApi", DemoDApiDo.class, JsonUtil.toJsonString(demoDApiDo));
    }
}