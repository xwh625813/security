package com.org.codell.service.ums;

import com.org.codell.dmg.model.UmsMenu;
import com.org.codell.dmg.model.UmsPermission;
import com.org.codell.dmg.model.UmsResource;
import com.org.codell.dmg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台角色管理Service
 */
public interface UmsRoleService {
    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);


}
