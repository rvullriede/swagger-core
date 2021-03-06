package com.wordnik.swagger.sample.util;


import java.util.Collections;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.wordnik.swagger.annotations.Api;


public class BasicApplication extends Application {


    private String ressourcePackage;


    @Override
    public Set<Class<?>> getClasses() {
        final ConfigurationBuilder config = new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(this.ressourcePackage)).setScanners(
                new TypeAnnotationsScanner(), new SubTypesScanner());

        final Set<Class<?>> classes = new Reflections(config).getTypesAnnotatedWith(Api.class);

        return classes;
    }


    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }


    public final String getRessourcePackage() {
        return this.ressourcePackage;
    }


    public final void setRessourcePackage(final String ressourcePackage) {
        this.ressourcePackage = ressourcePackage;
    }

}
