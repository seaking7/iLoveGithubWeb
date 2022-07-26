package com.poc.iLoveGithubWeb.config;

import com.poc.iLoveGithubWeb.config.auth.LoginUserArgumentResolver;
import com.poc.iLoveGithubWeb.infrastructure.rank.RankRepository;
import com.poc.iLoveGithubWeb.infrastructure.user.JdbcUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public RankRepository getJdbcRankRepository(){
        return new RankRepository(dataSource);
    }

    @Bean
    public JdbcUserRepository getJdbcUserRepository(){
        return new JdbcUserRepository(dataSource);
    }

}
