package com.org.codell.controller.ums;


import com.org.codell.common.tools.CommonResult;
import com.org.codell.dmg.model.UmsAdmin;
import com.org.codell.dto.UmsAdminLoginParam;
import com.org.codell.service.ums.UmsAdminService;
import com.org.codell.service.ums.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private UmsAdminService adminService;
    @Resource
    private UmsRoleService umsRoleService;

//    @ApiOperation(value = "用户注册")
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult<UmsAdmin> register(@RequestBody UmsAdminParam umsAdminParam, BindingResult result) {
//        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
//        if (umsAdmin == null) {
//            CommonResult.failed();
//        }
//        return CommonResult.success(umsAdmin);
//    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

//    @ApiOperation(value = "刷新token")
//    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult refreshToken(HttpServletRequest request) {
//        String token = request.getHeader(tokenHeader);
//        String refreshToken = adminService.refreshToken(token);
//        if (refreshToken == null) {
//            return CommonResult.failed("token已经过期！");
//        }
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", refreshToken);
//        tokenMap.put("tokenHead", tokenHead);
//        return CommonResult.success(tokenMap);
//    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", umsRoleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        return CommonResult.success(data);
    }

    @GetMapping(value = "/brand/hasPrem")
    @ResponseBody
    public CommonResult hasPrm(){
        return CommonResult.success("访问到了brand");
    }

    @GetMapping(value = "/sku/hasPrem")
    @ResponseBody
    public CommonResult skuhasPrm(){
        return CommonResult.success("访问到了sku");
    }

}
