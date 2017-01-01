package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//@PropertySource(value = { "classpath:application.properties" })
public class AppConfig 
{
 
	@Value("${spring.datasource.url}")
	private String dBUrl;

	@Value("${spring.datasource.drivername}")
	private String driverName;
	
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
  	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
  		return new PropertySourcesPlaceholderConfigurer();
  	}   
 
    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(dataSource());
    }
 
 
    @Bean
    public DataSource dataSource()  {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

            dataSource.setDriverClassName(driverName);
            dataSource.setUrl(dBUrl);
            dataSource.setUsername(userName);
            dataSource.setPassword(password);

        return dataSource;
    }
}
