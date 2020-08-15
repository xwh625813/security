package com.org.codell.service.ums.impl;

import com.org.codell.service.ums.UmsResourceService;
import com.org.codell.dmg.mapper.UmsResourceMapper;
import com.org.codell.dmg.model.UmsResource;
import com.org.codell.dmg.model.UmsResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台资源管理Service实现类
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {
    @Autowired
    private UmsResourceMapper resourceMapper;

    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.selectByExample(new UmsResourceExample());
    }
}
