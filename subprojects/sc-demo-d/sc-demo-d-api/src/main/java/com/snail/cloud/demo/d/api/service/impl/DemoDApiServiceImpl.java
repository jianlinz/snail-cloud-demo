package com.snail.cloud.demo.d.api.service.impl;

import com.snail.cloud.demo.d.api.service.DemoDApiService;
import com.snail.cloud.demo.d.api.jpa.dao.DemoDApiDao;
import com.snail.cloud.demo.d.api.jpa.domain.DemoDApiDo;
import org.springframework.beans.factory.annotation.Autowired;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoDApiServiceImpl implements DemoDApiService {

    private final DemoDApiDao demoDApiDao;

    @Autowired
    public DemoDApiServiceImpl(DemoDApiDao demoDApiDao) {
        this.demoDApiDao = demoDApiDao;
    }

    @Override
    public Optional<DemoDApiDo> get(Long id) {
        return demoDApiDao.getById(id);
    }

    @Override
    public DemoDApiDo save(DemoDApiDo demoDApiDo) {
        return demoDApiDao.save(demoDApiDo);
    }

    @Override
    public DemoDApiDo update(DemoDApiDo demoDApiDo) {
        return demoDApiDao.update(demoDApiDo);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        demoDApiDao.deleteByIds(ids);
    }
    
    @Override
    public List<DemoDApiDo> findAll(DemoDApiDo demoDApiDo) {
        return demoDApiDao.findAll(demoDApiDo);
    }

    @Override
    public PageChunk<DemoDApiDo> findAll(DemoDApiDo demoDApiDo, Pageable pageable) {
        return demoDApiDao.findAll(demoDApiDo, pageable);
    }

}