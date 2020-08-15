package com.org.codell.service.ums.impl;

import com.github.pagehelper.PageHelper;
import com.org.codell.dao.ums.UmsRoleDao;
import com.org.codell.dmg.model.UmsMenu;
import com.org.codell.service.ums.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 后台角色管理Service实现类
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleDao umsRoleDao;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return umsRoleDao.getMenuList(adminId);
    }

}
