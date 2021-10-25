package com.snail.cloud.demo.c.service;

import com.snail.cloud.demo.c.api.jpa.domain.DemoCDo;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DemoCService {
   
   
    /**
     * 保存
     *
     * @param demoCDo 保存对象
     * @return 保存后结果
     */
    @Transactional
    DemoCDo save(DemoCDo demoCDo);

    /**
     * 更新
     *
     * @param demoCDo 更新对象
     * @return 更新后结果
     */
    @Transactional
    DemoCDo update(DemoCDo demoCDo);

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
    Optional<DemoCDo> get(Long id);

    /**
     * 查询
     *
     * @param demoCDo 查询条件
     * @return 查询结果集
     */   
    List<DemoCDo> findAll(DemoCDo demoCDo);

    /**
     * 分页查询
     *
     * @param demoCDo   查询条件
     * @param pageable 分页参数
     * @return 查询结果集
     */
    PageChunk<DemoCDo> findAll(DemoCDo demoCDo, Pageable pageable);
}