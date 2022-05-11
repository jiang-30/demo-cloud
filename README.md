- Maven
- SpringBoot
- MyBatisPlus
- SpringCloud
  - Gateway
- SpringCloudAlibaba
  - Nacos
- other
  - Redis
  - Jwt
  - Swagger


- convert 
  controller请求转化为service请求的转化类 
  dto转化为vo的转化类


DTO 数据传输对象 controller中使用
entity、BO service 中使用
entity mapper中使用

语义层次差不多的代码放到一个方法中。


```
zheng
├── zheng-common -- SSM框架公共模块
├── zheng-admin -- 后台管理模板
├── zheng-ui -- 前台thymeleaf模板[端口:1000]
├── zheng-config -- 配置中心[端口:1001]
├── zheng-upms -- 用户权限管理系统
|    ├── zheng-upms-common -- upms系统公共模块
|    ├── zheng-upms-dao -- 代码生成模块，无需开发
|    ├── zheng-upms-client -- 集成upms依赖包，提供单点认证、授权、统一会话管理
|    ├── zheng-upms-rpc-api -- rpc接口包
|    ├── zheng-upms-rpc-service -- rpc服务提供者
|    └── zheng-upms-server -- 用户权限系统及SSO服务端[端口:1111]
├── zheng-cms -- 内容管理系统
|    ├── zheng-cms-common -- cms系统公共模块
|    ├── zheng-cms-dao -- 代码生成模块，无需开发
|    ├── zheng-cms-rpc-api -- rpc接口包
|    ├── zheng-cms-rpc-service -- rpc服务提供者
|    ├── zheng-cms-search -- 搜索服务[端口:2221]
|    ├── zheng-cms-admin -- 后台管理[端口:2222]
|    ├── zheng-cms-job -- 消息队列、任务调度等[端口:2223]
|    └── zheng-cms-web -- 网站前台[端口:2224]
├── zheng-pay -- 支付系统
|    ├── zheng-pay-common -- pay系统公共模块
|    ├── zheng-pay-dao -- 代码生成模块，无需开发
|    ├── zheng-pay-rpc-api -- rpc接口包
|    ├── zheng-pay-rpc-service -- rpc服务提供者
|    ├── zheng-pay-sdk -- 开发工具包
|    ├── zheng-pay-admin -- 后台管理[端口:3331]
|    └── zheng-pay-web -- 演示示例[端口:3332]
├── zheng-ucenter -- 用户系统(包括第三方登录)
|    ├── zheng-ucenter-common -- ucenter系统公共模块
|    ├── zheng-ucenter-dao -- 代码生成模块，无需开发
|    ├── zheng-ucenter-rpc-api -- rpc接口包
|    ├── zheng-ucenter-rpc-service -- rpc服务提供者
|    └── zheng-ucenter-web -- 网站前台[端口:4441]
├── zheng-wechat -- 微信系统
|    ├── zheng-wechat-mp -- 微信公众号管理系统
|    |    ├── zheng-wechat-mp-dao -- 代码生成模块，无需开发
|    |    ├── zheng-wechat-mp-service -- 业务逻辑
|    |    └── zheng-wechat-mp-admin -- 后台管理[端口:5551]
|    └── zheng-ucenter-app -- 微信小程序后台
├── zheng-api -- API接口总线系统
|    ├── zheng-api-common -- api系统公共模块
|    ├── zheng-api-rpc-api -- rpc接口包
|    ├── zheng-api-rpc-service -- rpc服务提供者
|    └── zheng-api-server -- api系统服务端[端口:6666]
├── zheng-oss -- 对象存储系统
|    ├── zheng-oss-sdk -- 开发工具包
|    ├── zheng-oss-web -- 前台接口[端口:7771]
|    └── zheng-oss-admin -- 后台管理[端口:7772]
├── zheng-message -- 实时通知系统
|    ├── zheng-message-sdk -- 开发工具包
|    ├── zheng-message-server -- 服务端[端口:8881,SocketIO端口:8882]
|    └── zheng-message-client -- 客户端
├── zheng-shop -- 电子商务系统
└── zheng-demo -- 示例模块(包含一些示例代码等)
     ├── zheng-demo-rpc-api -- rpc接口包
     ├── zheng-demo-rpc-service -- rpc服务提供者
     └── zheng-demo-web -- 演示示例[端口:9999]
```


