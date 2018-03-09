## 此工程项目的模板工程

### 编码规范

### 工程层级划分
* domain - 主要是领域对象，包括枚举、常量、VO对象，服务之间传递信息所需要的model等等
* dao - 数据库对应的DO对象，DAO对象等，专门负责处理数据库的东西
* service - 主要负责提供原子服务，包含外部rpc服务的封装，相对原子的数据处理过程，对dao层的操作等等
* biz - 主要处理各种业务流程，组合service层的原子服务达到某个目的，处理某个业务
* provider - 不直面客户端的也可以没有这个模块，主要负责接收外部请求，做权限管理（比如验证登陆）、参数校验，然后调用biz层的接口完成做具体业务处理
* task - 用于处理定时任务、外部调度任务的模块，负责接受任务消息或者调度请求，然后调用biz层的接口完成某件任务
* common - 主要是一些工具类（时间、MD5工具等等），以及一些对象转换的converter


### 更新说明

#### 2017年10月31日
* 当前修改了FastJson的版本至1.2.29：fastjson在1.2.24以及之前版本存在远程代码执行高危安全漏洞
* 建议使用Apache commons-lang3，取代原始的commons-lang
* 建议使用Apache commons-collections4，取代原始的commons-collections：CollectionUtils.removeAll存在Bug
* 建议使用JavaConfig的方式配置框架设置
* 建议使用JodaTime取代java.util.Date
