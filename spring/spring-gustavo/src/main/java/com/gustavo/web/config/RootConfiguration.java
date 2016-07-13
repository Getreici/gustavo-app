package com.gustavo.web.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan({ "com.gustavo.web" })
@PropertySource("classpath:application-${ENVIRONMENT}.properties")
public class RootConfiguration {

//	private static final String AWS_S3_ACCESSKEY = "aws.s3.accesskey";
//	private static final String AWS_S3_SECRETKEY = "aws.s3.secretkey";
//	private static final String AWS_S3_BUCKETNAME = "aws.s3.bucketname";
//	private static final String AWS_S3_TEMP_DIR = "aws.s3.tempDir";

	@Resource
	private Environment environment;

	@Bean
	public MethodInvokingFactoryBean log4jInitializer() {
		MethodInvokingFactoryBean initializer = new MethodInvokingFactoryBean();
		initializer.setStaticMethod("org.springframework.util.Log4jConfigurer.initLogging");
		initializer.setArguments(new String[] { "classpath:log4j-${ENVIRONMENT}.xml" });

		return initializer;
	}
}