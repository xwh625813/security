package com.org.codell.service.ums;


import com.org.codell.dmg.model.UmsResource;

import java.util.List;

/**
 * 后台资源管理Service
 */
public interface UmsResourceService {

    /**
     * 查询全部资源
     */
    List<UmsResource> listAll();
}
