# this demo for v2ray-controller
> 此项目是一个[v2ray](https://www.v2ray.com/)代理控制台，用于管理v2ray+nginx的配置、，当前版本为第一版，稳定性正在测试中
> 
> 开发文档以及项目说明会随着项目的更新逐步完善，目前项目还在建设中 **欢迎大家积极参与** 感谢大家支持
> 
> **仅作为技术交流用，不要传播！！！**
# 项目介绍
本项目基于`spring boot` 对接`v2ray`与`nginx`，使用java io读取`/etc/v2ray/config.json`与`/nginx/config`配置文件实现替换文件内容
读取文件内容生成可供各类软件读取的`vmess`、`VLESS`链接与二维码，实现快捷生成、导入、修改与获取配置

自定义订阅链接，用户可以在软件上添加订阅地址，一键更新订阅。请以管理员身份运行本程序，若环境中包含的软件未运行或运行时未发现本地有相关软件，可能
会造成项目启动失败，推荐于`linux`系统运行本项目

兼容jdk：openjdk-11

ubuntu openjdk 下载安装命令：
```
sudo apt install openjdk-11-jdk
```

CentOS openjdk 下载安装命令：
```
 yum install -y java-11-openjdk java-11-openjdk-devel
```


**未来内容拓展**

实现用户登陆注册，对用户进行权限管理，对单一用户实现更为精确的管理

增设网站用户白名单与黑名单，让你的小偏袒无处不在

网站实现前后端分离，降低运营者美化门槛

# 接口详情
**地址：**
{domian}:{port}/proxy/modifyConfig
## 链接参数
`domian`: 为服务器的域名地址

`port`: 为本平台的访问端口，默认为 8201
## 页面内功能参数
`appPort`: 为当前平台服务器端口

`v2rayPort`: 为 `v2ray` 的配置参数

# 更新了一个readme.md的内容，主要用于git学习测试
## 这是二级标题
### 这是三级标题
###### 这是六级标题 
