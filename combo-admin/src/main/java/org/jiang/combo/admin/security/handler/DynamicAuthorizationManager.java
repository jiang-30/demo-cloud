package org.jiang.combo.admin.security.handler;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public class DynamicAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
//        boolean isAuthenticated = authentication.get().isAuthenticated();
        Collection<? extends GrantedAuthority> authorities = authentication.get().getAuthorities();

        // 当前请求上下文
        // 我们可以获取携带的参数
        Map<String, String> variables = requestAuthorizationContext.getVariables();
        // 我们可以获取原始request对象
        HttpServletRequest request = requestAuthorizationContext.getRequest();

        System.out.println("dynamic: " + request.getRequestURI());
        //todo 根据这些信息 和业务写逻辑即可 最终决定是否授权 isGranted
        boolean isGranted = true;

        return new AuthorizationDecision(isGranted);
    }
}
