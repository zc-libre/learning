package com.zc.tenant.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.zc.tenant.constant.CommonConstant.TENANT_ID;

/**
 * @author zhao.cheng
 * @date 2020/9/27 15:41
 */
public class TenantFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String tenantId = request.getParameter(TENANT_ID);

    }
}
