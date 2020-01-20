package DesignPattern.filter_intercept_chain.filter;

import DesignPattern.filter_intercept_chain.filterImp.FilterChain;
import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
