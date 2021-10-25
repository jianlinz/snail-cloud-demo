package com.snail.cloud.sc.demo.a;

import indi.jl.sp.core.domain.PageChunk;
import indi.jl.sp.core.util.CollectionUtil;
import indi.jl.sp.core.util.JsonUtil;
import com.snail.cloud.sc.demo.a.api.jpa.domain.DemoADo;
import indi.jl.sp.test.common.BaseSpringTest;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemoATest extends BaseSpringTest {

    @Test
    public void save() {
        DemoADo demoADo = saveDo();
        DemoADo save = post("/demoA", DemoADo.class, JsonUtil.toJsonString(demoADo));
        assert null != save.getId();
        assert null != save.getCreateTime();
        assert null != save.getUpdateTime();
    }
    
    @Test
    public void update() {
        DemoADo save = saveDo();
        DemoADo update = put("/demoA/" + save.getId(), DemoADo.class, JsonUtil.toJsonString(save));
        assert save.getId() == update.getId();
        assert null != update.getCreateTime();
        assert null != update.getUpdateTime();
    }

    @Test
    public void delete() {
        saveDo();
        saveDo();
        Collection<DemoADo> demoADos = get("/demoA", DemoADo.class, List.class);
        assert CollectionUtil.isNotEmpty(demoADos);
        String ids = demoADos.stream()
                .map(demoADo -> demoADo.getId().toString())
                .collect(Collectors.joining(","));
        delete("/demoA?ids=" + ids);
        assert CollectionUtil.isEmpty(get("/demoA", DemoADo.class, List.class));
    }

    @Test
    public void find() {
        saveDo();
        saveDo();
        saveDo();
        saveDo();
        Collection<DemoADo> demoADos = get("/demoA", DemoADo.class, List.class);
        assert demoADos.size() > 3;

        PageChunk<DemoADo> pageSize1 = getPage("/demoA/page?size=1&page=0", DemoADo.class);
        assert pageSize1.getTotalElements() > 3;
        assert pageSize1.getContent().size() == 1;

        PageChunk<DemoADo> pageSize20 = getPage("/demoA/page?size=20&page=0", DemoADo.class);
        assert pageSize20.getContent().size() > 3;

        PageChunk<DemoADo> pageSize20Page1 = getPage("/demoA/page?size=20&page=1", DemoADo.class);
        assert pageSize20Page1.getContent().size() == 0;
    }
    
    private DemoADo saveDo() {
        DemoADo demoADo = new DemoADo();
        return post("/demoA", DemoADo.class, JsonUtil.toJsonString(demoADo));
    }
}