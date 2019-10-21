package com.jalasoft.ocrwebservice.filters;

import com.jalasoft.ocrwebservice.service.Cache;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURL().toString();
        System.out.println(url);
        System.out.println(req.getHeader("Authorization"));
        String token = req.getHeader("Authorization");
       if (url.contains("/login") || Cache.getInstance().isValid(token.split(" ")[1])){
           System.out.println("444444444444444444");
            chain.doFilter(request,response);
        }
        else{
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token invalid");
        }
    }
}
