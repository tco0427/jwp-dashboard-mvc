package com.techcourse;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import nextstep.mvc.servlet.AnnotationHandlerMapping;
import nextstep.mvc.servlet.AnnotationHandlerAdapter;
import nextstep.mvc.servlet.DispatcherServlet;
import nextstep.web.WebApplicationInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppWebApplicationInitializer implements WebApplicationInitializer {
    private static final String BASIC_PACKAGE = "com.techcourse.controller";
    private static final Logger log = LoggerFactory.getLogger(AppWebApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) {
        final DispatcherServlet dispatcherServlet = new DispatcherServlet();

        dispatcherServlet.addHandlerMapping(new AnnotationHandlerMapping(BASIC_PACKAGE));
        dispatcherServlet.addHandlerAdapter(new AnnotationHandlerAdapter());

        final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        log.info("Start AppWebApplication Initializer");
    }
}
