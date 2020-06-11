//package com.hongshen.boke.adapter.Interceptor;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Created with IDEA
// *
// * @author:qianhongshen
// * @Date:2018/11/7 17:06
// * @Desc:
// */
//public class InterceptorConfig implements HandlerInterceptor {
//    private static final Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);
//
//    /**
//     * 进入controller层之前拦截请求
//     * @param httpServletRequest
//     * @param httpServletResponse
//     * @param o
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//
//        logger.info("---------------------开始进入请求地址拦截----------------------------");
//        HttpSession session = httpServletRequest.getSession();
//        String url = httpServletRequest.getRequestURI().toString();
//        //判断session是否为空
//        if (session.getAttribute("user")==null){
//            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/manager/login.html");
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        logger.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        logger.info("---------------视图渲染之后的操作-------------------------0");
//    }
//}
