package com.travelin.travelinchat.components;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/14/2023, Fri
 **/

@Component
public class GetRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest httpServletRequest) {
            if (httpServletRequest.getMethod().equalsIgnoreCase("GET") && httpServletRequest.getContentLength() > 0) {
                throw new ServletException("GET requests cannot have a body");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
