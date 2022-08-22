package com.poc.iLoveGithubWeb.config;

import com.poc.iLoveGithubWeb.config.auth.LoginUserArgumentResolver;
import com.poc.iLoveGithubWeb.infrastructure.rank.bak.GlobalRankRepository;
import com.poc.iLoveGithubWeb.infrastructure.user.JdbcUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    private final DataSource dataSource;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }

    @Bean
    public GlobalRankRepository getJdbcRankRepository(){
        return new GlobalRankRepository(dataSource);
    }

    @Bean
    public JdbcUserRepository getJdbcUserRepository(){
        return new JdbcUserRepository(dataSource);
    }

    
    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter() {
        FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean
                = new FilterRegistrationBean<>( new ShallowEtagHeaderFilter());
        filterRegistrationBean.addUrlPatterns("/assets/*", "/images/*");

        filterRegistrationBean.setName("etagFilter");
        return filterRegistrationBean;
    }

//    @Bean
//    public JavaMailSender getJavaMailSender(){
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        return mailSender;
//    }
}
