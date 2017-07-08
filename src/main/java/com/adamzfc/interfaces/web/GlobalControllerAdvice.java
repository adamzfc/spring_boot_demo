package com.adamzfc.interfaces.web;

import com.adamzfc.application.MenuService;
import com.adamzfc.security.SecurityUser;
import com.adamzfc.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.adamzfc.infrastructure.CommonUtils.getStackTrace;

@ControllerAdvice
public class GlobalControllerAdvice {
    private Logger logger;

    public GlobalControllerAdvice() {
        logger = LoggerFactory.getLogger(getClass());
    }

    @Autowired
    private MenuService menuService;

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler
    public void handleControllerException(HttpServletRequest request, HttpServletResponse response, Throwable ex) throws IOException {
        ex.printStackTrace();
        String ajax = request.getHeader("X-Requested-With");
        response.setCharacterEncoding("utf-8");
        if (StringUtils.isEmpty(ajax)) {
            response.sendRedirect("/error");
        } else {
            response.getWriter().println("出错了:" + ex.getMessage());
        }

    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
            throw e;
//        logger.error("Request: " + req.getRequestURI() + " raised " + e);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", getStackTrace(e));
        mav.addObject("url", req.getRequestURL());
        mav.addObject("timestamp", new Date().toString());
        mav.addObject("status", 500);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ModelAttribute
    public void addCommonModel(Model model, HttpServletRequest request) {
        SecurityUser user = SecurityUtil.getUser();
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("navs", menuService.getNavMenus(user.getUid()));
        }
    }


}
