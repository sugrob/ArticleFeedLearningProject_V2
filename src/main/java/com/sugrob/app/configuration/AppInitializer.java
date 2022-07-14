package com.sugrob.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Autowired
    private CharacterEncodingFilter characterEncodingFilter;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
            AppConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
            WebMvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] filters = new Filter[] {characterEncodingFilter};
        return filters;
    }
}