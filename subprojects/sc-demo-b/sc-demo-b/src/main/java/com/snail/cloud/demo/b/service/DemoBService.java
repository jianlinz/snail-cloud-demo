package com.snail.cloud.demo.b.service;

import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DemoBService {
   
   
    /**
     * 保存
     *
     * @param demoBDo 保存对象
     * @return 保存后结果
     */
    @Transactional
    DemoBDo save(DemoBDo demoBDo);

    /**
     * 更新
     *
     * @param demoBDo 更新对象
     * @return 更新后结果
     */
    @Transactional
    DemoBDo update(DemoBDo demoBDo);

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
    Optional<DemoBDo> get(Long id);

    /**
     * 查询
     *
     * @param demoBDo 查询条件
     * @return 查询结果集
     */   
    List<DemoBDo> findAll(DemoBDo demoBDo);

    /**
     * 分页查询
     *
     * @param demoBDo   查询条件
     * @param pageable 分页参数
     * @return 查询结果集
     */
    PageChunk<DemoBDo> findAll(DemoBDo demoBDo, Pageable pageable);
}