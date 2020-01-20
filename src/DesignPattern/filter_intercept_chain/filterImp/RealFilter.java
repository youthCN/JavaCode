package DesignPattern.filter_intercept_chain.filterImp;

import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;
import DesignPattern.filter_intercept_chain.filter.Filter;

public class RealFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("request ---RealFilter()");
        if (request.url.getHost().contains("192.168")) {
            response.responseStr = "<和谐社会，不会抓人>";
        }
        chain.doFilter(request,response,chain);
        System.out.println("response ---RealFilter()");
    }
}
