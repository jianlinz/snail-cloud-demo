package com.snail.cloud.demo.c;

import indi.jl.sp.core.domain.PageChunk;
import indi.jl.sp.core.util.CollectionUtil;
import indi.jl.sp.core.util.JsonUtil;
import com.snail.cloud.demo.c.api.jpa.domain.DemoCDo;
import indi.jl.sp.test.common.BaseSpringTest;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoCTest extends BaseSpringTest {

    @Test
    public void save() {
        DemoCDo demoCDo = saveDo();
        DemoCDo save = post("/demoC", DemoCDo.class, JsonUtil.toJsonString(demoCDo));
        assert null != save.getId();
        assert null != save.getCreateTime();
        assert null != save.getUpdateTime();
    }
    
    @Test
    public void update() {
        DemoCDo save = saveDo();
        DemoCDo update = put("/demoC/" + save.getId(), DemoCDo.class, JsonUtil.toJsonString(save));
        assert save.getId() == update.getId();
        assert null != update.getCreateTime();
        assert null != update.getUpdateTime();
    }

    @Test
    public void delete() {
        saveDo();
        saveDo();
        Collection<DemoCDo> demoCDos = get("/demoC", DemoCDo.class, List.class);
        assert CollectionUtil.isNotEmpty(demoCDos);
        String ids = demoCDos.stream()
                .map(demoCDo -> demoCDo.getId().toString())
                .collect(Collectors.joining(","));
        delete("/demoC?ids=" + ids);
        assert CollectionUtil.isEmpty(get("/demoC", DemoCDo.class, List.class));
    }

    @Test
    public void find() {
        saveDo();
        saveDo();
        saveDo();
        saveDo();
        Collection<DemoCDo> demoCDos = get("/demoC", DemoCDo.class, List.class);
        assert demoCDos.size() > 3;

        PageChunk<DemoCDo> pageSize1 = getPage("/demoC/page?size=1&page=0", DemoCDo.class);
        assert pageSize1.getTotalElements() > 3;
        assert pageSize1.getContent().size() == 1;

        PageChunk<DemoCDo> pageSize20 = getPage("/demoC/page?size=20&page=0", DemoCDo.class);
        assert pageSize20.getContent().size() > 3;

        PageChunk<DemoCDo> pageSize20Page1 = getPage("/demoC/page?size=20&page=1", DemoCDo.class);
        assert pageSize20Page1.getContent().size() == 0;
    }
    
    private DemoCDo saveDo() {
        DemoCDo demoCDo = new DemoCDo();
        return post("/demoC", DemoCDo.class, JsonUtil.toJsonString(demoCDo));
    }
}