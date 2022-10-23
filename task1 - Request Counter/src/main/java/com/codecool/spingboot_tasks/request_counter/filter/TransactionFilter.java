package com.codecool.spingboot_tasks.request_counter.filter;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
@RequiredArgsConstructor
public class TransactionFilter implements Filter {

    private final RequestCountStatsService service;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request; // use it to get http method: req.getMethod()
        //HttpServletRequest res = (HttpServletRequest) response; 
        //action before request
        System.out.println("aaaaaa");
        chain.doFilter(request, response);

        count(req);

        System.out.println("bbbbb");
        //action after request
    }

    private void count(HttpServletRequest req) {
        try {
            if(req.getRequestURI().contains("stat"))
            service.increaseCounter(req.getMethod());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}