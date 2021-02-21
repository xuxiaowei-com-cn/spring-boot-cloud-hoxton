# UI(Ribbon、Feign)(界面模块)

## dependencies

- Developer Tools
    - Lombok
    - Spring Configuration Processor

- Web
    - Spring Web
        - 提供 Web 服务
    - Spring Session

- Template Engines
    - Thymeleaf

- SQL
    - JDBC API
    - MyBatis Framework
    - MS SQL Server Driver
    - MySQL Driver
    - Oracle Driver

- I/O
    - Validation

- NoSQL
    - Spring Data Redis(Access+Driver)

- Spring Cloud Security
    - Cloud Security
    - Cloud OAuth2

- Spring Cloud Config
    - Config Client
        - 提供读取配置服务器中的配置

- Spring Cloud Discovery
    - Enable Discovery Client
        - 提供 @EnableEurekaClient 注解

- Spring Cloud Routing
    - Zuul[Maintenance]
        - 提供 @EnableZuulProxy 注解
        - 包含 Ribbon 依赖
        - 包含 Hystrix 依赖
    - OpenFeign
        - 提供 @EnableFeignClients 注解
        - 包含 Ribbon 依赖
        - Feign
            - 使用 Netflix 的 Feign 客户端库来通过 Ribbon 调用服务

- Alibaba
    - Nacos Service Discovery

- Other
    - mybatis-plus-boot-starter
    - mybatis-plus-generator
    - dynamic-datasource-spring-boot-starter
    - velocity
    - p6spy
    - patchca

## SQL

- spring-security-core-*.*.*.RELEASE.jar
    - org.springframework.security.core.userdetails.jdbc
        - users.ddl
