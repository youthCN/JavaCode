package DesignPattern.filter_intercept_chain.filterImp;

import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;
import DesignPattern.filter_intercept_chain.filter.Filter;

import java.util.*;

public class CommonFilter implements Filter {
    Map<String, String> commonRequestParams = new HashMap<>();

    {
        commonRequestParams.put("deviceId", "1357");
        commonRequestParams.put("mac", "9989");
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("request ---CommonFilter()");
        for (Map.Entry<String, String> set : commonRequestParams.entrySet()) {
            request.addParams(set.getKey(), set.getValue());
        }
        chain.doFilter(request,response,chain);
        System.out.println("response ---CommonFilter()");
    }
}
