package cn.edu.zucc.stumanager.Interceptor;

import cn.edu.zucc.stumanager.databean.TeacherEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURL().toString();
        if (url.indexOf("/login") >= 0) {
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        TeacherEntity user = (TeacherEntity)session.getAttribute("user");
        if (user != null) {
            return true;
        }
        httpServletRequest.setAttribute("msg","您还没登录,请先登录");
        httpServletRequest.getRequestDispatcher("/views/index.jsp").
                forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
