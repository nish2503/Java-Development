package com.nish.project.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
info=@Info(
title="Department Employee One-to-Many API",
version="1.0",
description="Spring boot one to many mapping project"
))
public class OpenApiConfig {

}