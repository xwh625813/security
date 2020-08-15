package com.org.codell.dao.ums;

import com.org.codell.dmg.model.UmsResource;
import com.org.codell.dmg.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义后台用户与角色管理Dao
 */
public interface UmsRelationAdminRoleDao {

    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);



    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
