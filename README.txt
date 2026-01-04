<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!--web项目的容器规则-->
    <!--    1.父容器由web监听器优先加载，子容器通过DispatcherServlet加载-->
    <!--    2.父容器只有一个，子容器可以通过DispatcherServlet开启多个-->
    <!--    3.子容器可以访问父容器的bean，反之不能-->


    <!-- 父容器配置 - 共享的bean（如Service、DAO等） -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <!-- 父容器从多个配置文件读取 -->
        <param-value>
            classpath:applicationContext-dao.xml,
            classpath:applicationContext-service.xml,
            classpath:applicationContext-tx.xml
        </param-value>
    </context-param>

    <!-- 第一个子容器 - SpringMVC前端控制器 -->
    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 子容器特有的配置（Controller、视图解析器等） -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!-- 第二个子容器 - REST API前端控制器 -->
    <servlet>
        <servlet-name>RestServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 另一个子容器的特有配置 -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:restmvc.xml</param-value>
        </init-param>
        <load-on-startup>2</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>RestServlet</servlet-name>
        <url-pattern>/api/*</url-pattern>
    </servlet-mapping>
</web-app>