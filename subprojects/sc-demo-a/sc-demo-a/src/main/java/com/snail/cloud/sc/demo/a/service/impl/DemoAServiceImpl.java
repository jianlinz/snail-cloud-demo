package com.snail.cloud.sc.demo.a.service.impl;

import com.snail.cloud.sc.demo.a.jpa.dao.DemoADao;
import com.snail.cloud.sc.demo.a.api.jpa.domain.DemoADo;
import com.snail.cloud.sc.demo.a.service.DemoAService;
import org.springframework.beans.factory.annotation.Autowired;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoAServiceImpl implements DemoAService {

    private final DemoADao demoADao;

    @Autowired
    public DemoAServiceImpl(DemoADao demoADao) {
        this.demoADao = demoADao;
    }

    @Override
    public Optional<DemoADo> get(Long id) {
        return demoADao.getById(id);
    }

    @Override
    public DemoADo save(DemoADo demoADo) {
        return demoADao.save(demoADo);
    }

    @Override
    public DemoADo update(DemoADo demoADo) {
        return demoADao.update(demoADo);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        demoADao.deleteByIds(ids);
    }
    
    @Override
    public List<DemoADo> findAll(DemoADo demoADo) {
        return demoADao.findAll(demoADo);
    }

    @Override
    public PageChunk<DemoADo> findAll(DemoADo demoADo, Pageable pageable) {
        return demoADao.findAll(demoADo, pageable);
    }

}