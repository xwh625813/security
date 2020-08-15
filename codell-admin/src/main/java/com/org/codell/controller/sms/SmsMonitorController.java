package com.org.codell.controller.sms;

import com.org.codell.common.tools.CommonResult;
import com.org.codell.dmg.model.UmsAdmin;
import com.org.codell.dto.UmsAdminLoginParam;
import com.org.codell.service.ums.UmsAdminService;
import com.org.codell.service.ums.UmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SmsMonitorController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private UmsAdminService adminService;
    @Resource
    private UmsRoleService umsRoleService;


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

    @GetMapping(value = "/order/hasPrem")
    @ResponseBody
    public CommonResult orderPrm(){
        return CommonResult.success("访问到了order");
    }

    @GetMapping(value = "/swagger/hasPrem")
    @ResponseBody
    public CommonResult swaggerPrm(){
        return CommonResult.success("访问到了swagger");
    }


    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/swagger/login", method = RequestMethod.POST)
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

}
