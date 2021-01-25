package com.txj.business.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * pre：主要用在路由映射的阶段是寻找路由映射表的
 * routing: 具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
 * error: 一旦前面的过滤器出错了，会调用error过滤器
 * post: 当routing，error运行完后才会调用该过滤器，是在最后阶段的
 *
 * @author lenovo
 */
@Component
public class SelfFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *  是否走过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 可以设置过滤请求
     *
     * @return Object
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
            // 令 zuul 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            // 设置返回的错误码
            ctx.setResponseStatusCode(401);
            // 设置返回的 body
            ctx.setResponseBody("");
        return null;
    }
}
