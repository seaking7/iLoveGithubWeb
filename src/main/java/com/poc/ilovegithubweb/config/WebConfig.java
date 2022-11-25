package com.poc.ilovegithubweb.config;

import java.util.List;

import javax.sql.DataSource;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poc.ilovegithubweb.config.auth.LoginUserArgumentResolver;
import com.poc.ilovegithubweb.infrastructure.rank.bak.GlobalRankRepository;
import com.poc.ilovegithubweb.infrastructure.user.JdbcUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final LoginUserArgumentResolver loginUserArgumentResolver;
	private final DataSource dataSource;
	@Value("${tomcat.ajp.protocol}")
	String ajpProtocol;
	@Value("${tomcat.ajp.port}")
	int ajpPort;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(loginUserArgumentResolver);
	}

	@Bean
	public GlobalRankRepository getJdbcRankRepository() {
		return new GlobalRankRepository(dataSource);
	}

	@Bean
	public JdbcUserRepository getJdbcUserRepository() {
		return new JdbcUserRepository(dataSource);
	}

	@Bean
	public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter() {
		FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean
			= new FilterRegistrationBean<>(new ShallowEtagHeaderFilter());
		filterRegistrationBean.addUrlPatterns("/assets/*", "/images/*");

		filterRegistrationBean.setName("etagFilter");
		return filterRegistrationBean;
	}

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createAjpConnector());
		return tomcat;
	}

	private Connector createAjpConnector() {
		Connector ajpConnector = new Connector(ajpProtocol);
		ajpConnector.setPort(ajpPort);
		ajpConnector.setSecure(false);
		ajpConnector.setAllowTrace(false);
		ajpConnector.setScheme("http");
		((AbstractAjpProtocol<?>)ajpConnector.getProtocolHandler()).setSecretRequired(false);
		return ajpConnector;
	}

}
