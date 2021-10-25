package com.snail.cloud.demo.d.api.service;

import com.snail.cloud.demo.d.api.jpa.domain.DemoDApiDo;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DemoDApiService {
   
   
    /**
     * 保存
     *
     * @param demoDApiDo 保存对象
     * @return 保存后结果
     */
    @Transactional
    DemoDApiDo save(DemoDApiDo demoDApiDo);

    /**
     * 更新
     *
     * @param demoDApiDo 更新对象
     * @return 更新后结果
     */
    @Transactional
    DemoDApiDo update(DemoDApiDo demoDApiDo);

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
    Optional<DemoDApiDo> get(Long id);

    /**
     * 查询
     *
     * @param demoDApiDo 查询条件
     * @return 查询结果集
     */   
    List<DemoDApiDo> findAll(DemoDApiDo demoDApiDo);

    /**
     * 分页查询
     *
     * @param demoDApiDo   查询条件
     * @param pageable 分页参数
     * @return 查询结果集
     */
    PageChunk<DemoDApiDo> findAll(DemoDApiDo demoDApiDo, Pageable pageable);
}