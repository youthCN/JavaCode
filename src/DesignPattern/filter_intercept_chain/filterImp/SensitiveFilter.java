package DesignPattern.filter_intercept_chain.filterImp;

import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;
import DesignPattern.filter_intercept_chain.filter.Filter;

//定义的过滤敏感字眼的过滤规则
public class SensitiveFilter implements Filter {

    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("request ---SensitiveFilter()");
        chain.doFilter(request, response, chain);
        //处理字符串中的敏感信息，
        response.responseStr = response.responseStr.replace("和谐", "河蟹").replace("抓人", "查水表");
        System.out.println("response ---SensitiveFilter()");
    }

}