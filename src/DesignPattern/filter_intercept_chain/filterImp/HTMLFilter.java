package DesignPattern.filter_intercept_chain.filterImp;

import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;
import DesignPattern.filter_intercept_chain.filter.Filter;

//处理字符串中的HTML标记
public class HTMLFilter implements Filter {

    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("request ---HTMLFilter()");
        chain.doFilter(request, response, chain);
        //将字符串中出现的"<>"符号替换成"[]"
        response.responseStr = response.responseStr.replace('<', '[').replace('>', ']');
        System.out.println("response ---HTMLFilter()");
    }

}