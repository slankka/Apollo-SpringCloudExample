## SpringCloud with Apollo(ctrip)

# The Project cannot start normally.

APP.ID: hello

已经存在一条:

ApolloConfig{appId='hello', cluster='default', namespaceName='application', configurations={hello=30001}, releaseKey='20180309161318-97e01da2c6abf01d'}

如果，把下面的代码中的三个注解去掉
```
//@Configuration
//@EnableApolloConfig
public class SpringConfigApollo {

    @Bean
    public ApolloConfigBean apolloConfigBean(){
        return new ApolloConfigBean();
    }

}

@RestController
public class ApolloBridgedController {

    //@Autowired
    private ApolloConfigBean apolloConfigBean;
    ....
```

注释掉之后，JDBC可以创建HikariCP数据源，该项目可以正常启动。也就是说下面的报错
${hikari.driverclassname}注入失败，在没有Apollo注解的参与下，是不存在的


## The Error Information

```
[DEBUG] [01:05:13.546][ApolloSpringApplicationRunListener][59]:Apollo bootstrap config is not enabled for context org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1835e65: startup date [Thu Jan 01 08:00:00 CST 1970]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@8d39c4, see property: ${apollo.bootstrap.enabled}
[INFO] [01:05:13.566][AbstractApplicationContext][578]:Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1835e65: startup date [Sat Mar 10 01:05:13 CST 2018]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@8d39c4
[INFO] [01:05:14.180][XmlBeanDefinitionReader][317]:Loading XML bean definitions from URL [file:/D:/work_project/project_java/boot-template/target/classes/spring/applicationContext.xml]
[INFO] [01:05:14.278][XmlBeanDefinitionReader][317]:Loading XML bean definitions from URL [file:/D:/work_project/project_java/boot-template/target/classes/spring/applicationContext-mybatis.xml]
[WARN] [01:05:14.438][ClassPathMapperScanner][167]:No MyBatis mapper was found in '[com.cloud.template]' package. Please check your configuration.
[INFO] [01:05:14.458][DefaultListableBeanFactory][839]:Overriding bean definition for bean 'org.springframework.transaction.config.internalTransactionAdvisor' with a different definition: replacing [Root bean: class [org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration; factoryMethodName=transactionAdvisor; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/transaction/annotation/ProxyTransactionManagementConfiguration.class]]
[INFO] [01:05:14.459][ConfigurationClassBeanDefinitionReader][298]:Skipping bean definition for [BeanMethod:name=transactionalEventListenerFactory,declaringClass=org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration]: a definition for bean 'org.springframework.transaction.config.internalTransactionalEventListenerFactory' already exists. This top-level bean definition is considered as an override.
[WARN] [01:05:14.521][ClassPathMapperScanner][167]:No MyBatis mapper was found in '[com.cloud.template.dao]' package. Please check your configuration.
[WARN] [01:05:14.522][ConfigurationClassPostProcessor][386]:Cannot enhance @Configuration bean definition 'refreshScope' since its singleton instance has been created too early. The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type: Consider declaring such methods as 'static'.
[INFO] [01:05:14.670][GenericScope][263]:BeanFactory id=a8592d60-8868-3d9d-8370-784b1e8996fd
[INFO] [01:05:15.026][DefaultApplicationProvider][96]:App ID is set to hello by app.id property from /META-INF/app.properties
[WARN] [01:05:15.029][DefaultServerProvider][40]:C:/opt/settings/server.properties does not exist or is not readable.
[INFO] [01:05:15.029][DefaultServerProvider][109]:Environment is set to [DEV] by JVM system property 'env'.
[DEBUG] [01:05:15.029][DefaultServerProvider][161]:Data Center is set to null. Because it is not available in either (1) JVM system property 'idc', (2) OS env variable 'IDC' nor (3) property 'idc' from the properties InputStream.
[DEBUG] [01:05:15.091][ResourceUtils][78]:Reading config from resource file:/D:/.m2/repository/com/ctrip/framework/apollo/apollo-core/0.10.0-SNAPSHOT/apollo-core-0.10.0-20180308.114306-4.jar!/apollo-env.properties
[DEBUG] [01:05:15.092][ResourceUtils][52]:Reading properties:
uat.meta=http://172.16.1.180:8088
pro.meta=http://172.16.1.180:8088
lpt.meta=${lpt_meta}
local.meta=http://localhost:8088
dev.meta=http://172.16.2.203:8088
fat.meta=http://172.16.2.203:8088

[DEBUG] [01:05:33.389][RemoteConfigRepository][201]:Loading config from http://172.16.2.203:8088/configs/hello/default/application?ip=172.16.15.6
[DEBUG] [01:05:33.406][RemoteConfigRepository][222]:Loaded config for application: ApolloConfig{appId='hello', cluster='default', namespaceName='application', configurations={hello=30001}, releaseKey='20180309161318-97e01da2c6abf01d'}
[DEBUG] [01:05:33.406][RemoteConfigRepository][134]:Remote Config refreshed!
[DEBUG] [01:05:33.406][RemoteConfigRepository][109]:Schedule periodic refresh with interval: 5 MINUTES
[DEBUG] [01:05:33.408][RemoteConfigLongPollService$2][117]:Long polling will start in 2000 ms.
[INFO] [01:05:33.430][AutowiredAnnotationBeanPostProcessor][153]:JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
[INFO] [01:05:33.525][PostProcessorRegistrationDelegate$BeanPostProcessorChecker][328]:Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [class org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$f9633a79] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
[INFO] [01:05:33.560][PostProcessorRegistrationDelegate$BeanPostProcessorChecker][328]:Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [class org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$157d3d76] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
[INFO] [01:05:33.926][TomcatEmbeddedServletContainer][81]:Tomcat initialized with port(s): 7233 (http)
[INFO] [01:05:34.106][EmbeddedWebApplicationContext][272]:Root WebApplicationContext: initialization completed in 20540 ms
[INFO] [01:05:34.439][ServletRegistrationBean][189]:Mapping servlet: 'dispatcherServlet' to [/]
[INFO] [01:05:34.444][AbstractFilterRegistrationBean][258]:Mapping filter: 'characterEncodingFilter' to: [/*]
[INFO] [01:05:34.444][AbstractFilterRegistrationBean][258]:Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
[INFO] [01:05:34.444][AbstractFilterRegistrationBean][258]:Mapping filter: 'httpPutFormContentFilter' to: [/*]
[INFO] [01:05:34.445][AbstractFilterRegistrationBean][258]:Mapping filter: 'requestContextFilter' to: [/*]
[WARN] [01:05:34.487][AbstractApplicationContext][546]:Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hikariCPConfig': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: private java.lang.String com.cloud.template.config.HikariCPConfig.driverClassName; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'hikari.driverclassname' in string value "${hikari.driverclassname}"
[WARN] [01:05:34.509][DirectJDKLog][180]:The web application [ROOT] appears to have started a thread named [Abandoned connection cleanup thread] but has failed to stop it. This is very likely to create a memory leak. Stack trace of thread:
 java.lang.Object.wait(Native Method)
 java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
 com.mysql.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:43)
[ERROR] [01:05:34.514][SpringApplication][827]:Application startup failed
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hikariCPConfig': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: private java.lang.String com.cloud.template.config.HikariCPConfig.driverClassName; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'hikari.driverclassname' in string value "${hikari.driverclassname}"
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:334) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1214) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:772) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:839) ~[spring-context-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:538) ~[spring-context-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:118) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:766) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.createAndRefreshContext(SpringApplication.java:361) [spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:307) [spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1191) [spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1180) [spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at com.cloud.template.Bootstrap.main(Bootstrap.java:16) [classes/:?]
Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: private java.lang.String com.cloud.template.config.HikariCPConfig.driverClassName; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'hikari.driverclassname' in string value "${hikari.driverclassname}"
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:573) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:331) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	... 17 more
```