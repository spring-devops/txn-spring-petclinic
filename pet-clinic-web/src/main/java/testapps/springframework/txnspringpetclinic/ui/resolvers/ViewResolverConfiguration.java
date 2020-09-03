package testapps.springframework.txnspringpetclinic.ui.resolvers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.annotation.Resource;

@Component
@Configuration
@EnableWebMvc
public class ViewResolverConfiguration implements WebMvcConfigurer {

    private final JspUrlService jspUrlService;
    private final ThymeLeafUrlService thymeLeafUrlService;
    private final AppRootPrefixService appRootPrefixService;

    public ViewResolverConfiguration(JspUrlService jspUrlService, ThymeLeafUrlService thymeLeafUrlService, AppRootPrefixService appRootPrefixService) {
        this.jspUrlService = jspUrlService;
        this.thymeLeafUrlService = thymeLeafUrlService;
        this.appRootPrefixService = appRootPrefixService;
    }

    @Bean
    @Description("JSP Template Resolver")
    public SpringResourceTemplateResolver jspTemplateResolver(){
        final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix(appRootPrefixService.getRootUrlPrefix());
        templateResolver.setSuffix(".jsp");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        templateResolver.setOrder(1);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    @Description("JSP Based View Resolver")
    public ViewResolver configureJspViewResolver () {
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setViewClass(JstlView.class);
        //Examples for JSP - the first oen wil not work on Tomcat. Second one is for Tomcat
        //jspViewResolver.setPrefix("classpath:/templates/");
        //jspViewResolver.setPrefix("/WEB-INF/templates/");
        jspViewResolver.setPrefix(appRootPrefixService.getRootUrlPrefix());
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewNames(new String[] {jspUrlService.getViewName()});
        jspViewResolver.setOrder(1);
        return jspViewResolver;
    }

    @Resource
    protected ApplicationContext applicationContext;

    @Bean
    @Description("Thymeleaf Template Resolver")
    public SpringResourceTemplateResolver thymeleafTemplateResolver(){
        final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix(appRootPrefixService.getRootUrlPrefix());
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        templateResolver.setOrder(0);
        return templateResolver;
    }

    @Resource
    protected SpringTemplateEngine springTemplateEngine;

    @Bean
    @Description("Thymeleaf Based View Resolver")
    public ThymeleafViewResolver thymeleafViewResolver(){
        final ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        //Examples for Thymeleaf - it will work correctly in both scenarios
        //thymeleafViewResolver.setPrefix("classpath:/templates/");
        //thymeleafViewResolver.setPrefix("/WEB-INF/templates/");
        thymeleafViewResolver.setViewNames(new String[] {thymeLeafUrlService.getViewName()});
        thymeleafViewResolver.setExcludedViewNames(new String[] {jspUrlService.getViewName()});
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        //The Thymeleaf gets control first and is thus asked to exclude view names for JSPs
        thymeleafViewResolver.setOrder(0);
        return thymeleafViewResolver;
    }

/*

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
*/


    @Description("Static Content Resolver")
    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        System.out.println("ViewResolverConfiguration >>> Adding Resource Handlers for static content ...");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/static/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }


    //These are old style declarations to help understand only
    /*
    <bean id="templateResolver" class="org.thymeleaf.templateresolver.ServletContextTemplateResolver">
         <property name="prefix" value="/WEB-INF/views/" />
         <property name="suffix" value=".html" />
         <property name="viewNames" value="thymeleaf/*" />
         <property name="templateMode" value="HTML5" />
    </bean>

    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
         <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
         <property name="prefix" value="/WEB-INF/views/" />
         <property name="viewNames" value="jsp/*" />
         <property name="suffix" value=".jsp" />
    </bean>
    */

}
