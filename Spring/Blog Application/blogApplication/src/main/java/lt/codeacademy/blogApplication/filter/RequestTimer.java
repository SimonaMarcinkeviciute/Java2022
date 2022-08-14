package lt.codeacademy.blogApplication.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestTimer implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("*********************************************************************");
        StopWatch watch = new StopWatch();
        watch.start();
        filterChain.doFilter(servletRequest, servletResponse);
        watch.stop();
        log.debug("Request took: {}", watch.getLastTaskTimeMillis());
        log.debug("*********************************************************************");


    }
}
