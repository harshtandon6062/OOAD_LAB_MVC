package com.pes.ooad.mvc.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<WebServlet> h2ServletRegistration() {
        ServletRegistrationBean<WebServlet> registrationBean =
                new ServletRegistrationBean<>(new WebServlet(), "/h2-console/*");
        registrationBean.addInitParameter("webAllowOthers", "true");
        registrationBean.addInitParameter("trace", "false");
        return registrationBean;
    }
}
