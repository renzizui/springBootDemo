package github.javaguide.springbootfilter.filter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器开始对请求进行预处理");
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String requestUri=request.getRequestURI();
        System.out.println("请求的接口为："+requestUri);
        long startTime=System.currentTimeMillis();
        //通过doFilter方法实现过滤功能
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime=System.currentTimeMillis();
        System.out.println("该用户的请求已经处理完毕，请求花费的时间："+(endTime-startTime));
    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器");
    }
}
