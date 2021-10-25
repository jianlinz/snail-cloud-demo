package com.snail.cloud.demo.d.service;

import com.snail.cloud.demo.d.jpa.domain.DemoDDo;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DemoDService {
   
   
    /**
     * 保存
     *
     * @param demoDDo 保存对象
     * @return 保存后结果
     */
    @Transactional
    DemoDDo save(DemoDDo demoDDo);

    /**
     * 更新
     *
     * @param demoDDo 更新对象
     * @return 更新后结果
     */
    @Transactional
    DemoDDo update(DemoDDo demoDDo);

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
    Optional<DemoDDo> get(Long id);

    /**
     * 查询
     *
     * @param demoDDo 查询条件
     * @return 查询结果集
     */   
    List<DemoDDo> findAll(DemoDDo demoDDo);

    /**
     * 分页查询
     *
     * @param demoDDo   查询条件
     * @param pageable 分页参数
     * @return 查询结果集
     */
    PageChunk<DemoDDo> findAll(DemoDDo demoDDo, Pageable pageable);
}