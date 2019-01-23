package com.cbs.edu.eshop.initializer;

import com.cbs.edu.eshop.config.AppConfig;
import com.cbs.edu.eshop.config.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
    package com.websystique.springmvc.configuration;

    import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

    public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[] { HelloWorldConfiguration.class };
        }

        @Override
            protected Class<?>[] getServletConfigClasses() {
        return null;
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/" };
        }

    }
 */
public class SpringWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class, WebMvcConfig.class);
        ctx.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
