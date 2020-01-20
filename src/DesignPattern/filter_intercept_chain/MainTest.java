package DesignPattern.filter_intercept_chain;

import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;
import DesignPattern.filter_intercept_chain.filterImp.*;

public class MainTest {
    public static void main(String[] args) {

        FilterChain fc = new FilterChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addFilter(new CommonFilter())
                .addFilter(new CacheFilter())
                .addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new RealFilter());

        String msg = "https://192.168.11.77";
        Request request = new Request(msg);
        Response response = new Response();
        fc.doFilter(request, response, fc);

        System.out.println(request.getRequest());
        System.out.println(response.getResponse());

        System.out.println("---------------------------------------------------");

        String msg2 = "https://192.168.11.77";
        Request request2 = new Request(msg2);
        Response response2 = new Response();
        fc.doFilter(request2, response2, fc);

        System.out.println(request2.getRequest());
        System.out.println(response2.getResponse());
    }
}
