package net.therap.lab.ee6.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jahangir
 * @since 1/31/12 3:40 PM
 */
@WebFilter(filterName = "ProfilerFilter", urlPatterns = "/*", asyncSupported = true)
public class ProfilerFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        long start = System.currentTimeMillis();
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("URI = " + request.getRequestURI() + "Time = " + (System.currentTimeMillis() - start) + "ms");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
