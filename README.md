# SpringBoot集成JWT+SpringSecurity

实现一套前后端分离的权限鉴权骨架

1、登录认证：127.0.0.1:8090/admin/login;即返回token

![image-20200815135142652](C:\Users\XWH\AppData\Roaming\Typora\typora-user-images\image-20200815135142652.png)

2、权限认证：127.0.0.1:8090/sku/hasPrem；对于设置了模拟白名单和拥有权限的api请求给与放行

![image-20200815135332308](C:\Users\XWH\AppData\Roaming\Typora\typora-user-images\image-20200815135332308.png)

未拥有权限&需要鉴权的资源URL-------------------------------------------------------------------------------------------------------------------

![image-20200815135420966](C:\Users\XWH\AppData\Roaming\Typora\typora-user-images\image-20200815135420966.png)

