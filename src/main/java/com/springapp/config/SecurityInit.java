package com.springapp.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
* Created by св on 7/5/2014.
*/
@Order(1)
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
}
