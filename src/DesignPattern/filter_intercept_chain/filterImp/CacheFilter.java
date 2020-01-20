package DesignPattern.filter_intercept_chain.filterImp;

import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;
import DesignPattern.filter_intercept_chain.filter.Filter;

import java.util.HashMap;
import java.util.Map;

//缓存拦截器
public class CacheFilter implements Filter {

    protected Map<Request, Response> cacheMap = new HashMap<>();

    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("request ---CacheFilter()");
        if (cacheMap.containsKey(request)) {
            chain.doIntercept();
            System.out.println("response ---CacheFilter()");
            response.responseStr = cacheMap.get(request).responseStr;
            return;
        }
        cacheMap.put(request, response);
        chain.doFilter(request, response, chain);
        System.out.println("response ---CacheFilter()");
    }

}