package com.org.codell.service.ums;

import com.org.codell.dmg.model.UmsAdmin;
import com.org.codell.dmg.model.UmsResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 后台管理员Service
 */
public interface UmsAdminService {
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    UmsAdmin getAdminByUsername(String username);

    List<UmsResource> getResourceList(Long adminId);
}
