package com.wng.jenkin.config;

import com.wng.jenkin.repository.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.wng.jenkin.repository"},
        repositoryBaseClass = BaseRepositoryImpl.class)
public class JpaConfig {

}