package DesignPattern.filter_intercept_chain.filterImp;

import DesignPattern.filter_intercept_chain.domain.Request;
import DesignPattern.filter_intercept_chain.domain.Response;
import DesignPattern.filter_intercept_chain.filter.Filter;

import java.util.ArrayList;
import java.util.List;

//过滤链条
public class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<Filter>();
    //用于标记规则的引用顺序
    int index = 0;

    boolean isIntercept = false;//是否拦截

    //往规则链条中添加规则
    public FilterChain addFilter(Filter f) {
        filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response, FilterChain chain) {
        //index初始化为0,filters.size()为3，不会执行return操作
        if (isIntercept) {
            index = 0;
            isIntercept = false;
            return;
        } else {
            if (index == filters.size()) {
                index = 0;
                return;
            }
            //每添加一个过滤规则，index自增1
            Filter f = filters.get(index);
            index++;
            //根据索引值获取对应的规律规则对字符串进行处理
            f.doFilter(request, response, chain);
        }

    }

    public void doIntercept() {
        this.isIntercept = true;
    }

}
