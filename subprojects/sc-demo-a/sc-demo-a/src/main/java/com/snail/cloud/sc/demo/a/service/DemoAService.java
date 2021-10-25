package com.snail.cloud.sc.demo.a.service;

import com.snail.cloud.sc.demo.a.api.jpa.domain.DemoADo;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DemoAService {
   
   
    /**
     * 保存
     *
     * @param demoADo 保存对象
     * @return 保存后结果
     */
    @Transactional
    DemoADo save(DemoADo demoADo);

    /**
     * 更新
     *
     * @param demoADo 更新对象
     * @return 更新后结果
     */
    @Transactional
    DemoADo update(DemoADo demoADo);

    /**
     * 根据id集合删除
     *
     * @param ids ids
     */
    @Transactional
    void deleteByIds(List<Long> ids);
    
    /**
     * 根据id 查询 
     *
     * @param id 主键
     * @return 查询结果
     */
    Optional<DemoADo> get(Long id);

    /**
     * 查询
     *
     * @param demoADo 查询条件
     * @return 查询结果集
     */   
    List<DemoADo> findAll(DemoADo demoADo);

    /**
     * 分页查询
     *
     * @param demoADo   查询条件
     * @param pageable 分页参数
     * @return 查询结果集
     */
    PageChunk<DemoADo> findAll(DemoADo demoADo, Pageable pageable);
}