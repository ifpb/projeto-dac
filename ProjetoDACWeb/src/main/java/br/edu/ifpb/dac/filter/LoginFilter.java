package br.edu.ifpb.dac.filter;

import br.edu.ifpb.dac.web.LoginUsuarioBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = (HttpSession)req.getSession();

        if(session.getAttribute("matricula")==null){
            res.sendRedirect(req.getContextPath() + "/login.xhtml");

        }else {
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
