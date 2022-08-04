package di.example.config;

import di.example.MarkDao;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@ComponentScan("di.example") //kad  uskauotu visus pachadge ir suprastu kad tos klases uyra spring
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationConfig {
    //bean kuriame kai reikia metodu kuria butu spring scoupe, bet nereikia atskiros klases
    /*@Bean
    public MarkDao customBeanMarksDao() {
        return () -> List.of(9.0, 8.0, 5.0, 8.5, 7.0 );

    }*/
}
