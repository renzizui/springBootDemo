package github.javaguide.springbootfilter.config;

import github.javaguide.springbootfilter.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
@Configuration
public class MyFilterConfig {

    @Autowired
    MyFilter myFilter;

    @Bean
    public FilterRegistrationBean<MyFilter> setUpMyFilter(){
        FilterRegistrationBean<MyFilter> filterRegistrationBean=new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return filterRegistrationBean;
    }

}
