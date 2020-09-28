package com.zc.clickhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */

@ApiIgnore
@Controller
public class HomeController {


    /**
     * 跳转的首页
     *
     * @param httpServletResponse 跳转的http请求
     */
    @RequestMapping("/")
    public void homePage(HttpServletResponse httpServletResponse
    ) {

        try {
            httpServletResponse.sendRedirect("/doc.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
