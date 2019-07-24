package com.zryx.company.controller;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.News;
import com.zryx.company.model.Users;
import com.zryx.company.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 123
 * @create 2019/7/10
 */
@RestController
public class IndexController extends BaseController {

//    @Autowired
//    private NewsService newsService;
//
//    @Autowired
//    private ProductService productService;

    @Autowired
    private UsersService usersService;

//    /**
//     * 初始化首页新闻数据
//     * @return
//     */
//    @PostMapping("/top8News")
//    public String top8News() {
//        List<News> top8News = newsService.selTop8News();
//        String result = dealQueryResult(top8News,top8News);
//        return result;
//    }
//
//    /**
//     * 初始化商品信息
//     * @return
//     */
//    @PostMapping("/initProducts")
//    public String initProducts() {
//        List<Product> products = productService.allProducts();
//        String result = dealQueryResult(products,products);
//        return result;
//    }

    /**
     * 聊天
     *
     * @return
     */
    @PostMapping("/chat")
    public String chat(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            throw new CustomException(1000, "您未曾登录");
        }
        return dealSuccessResutl("into chat", null);
    }

    @PostMapping("/login")
    public String login(HttpSession session, Users user) {
        if (usersService.Login(session, user)) {
            return dealSuccessResutl("login success", null);
        }
        throw new CustomException(1100, "登录失败，用户名或密码错误");
    }

    @PostMapping("/logoutServlet")
    public String logoutServlet(HttpSession session) {
        if (usersService.isLogout(session)) {
            return dealSuccessResutl("成功退出", null);
        }
        throw new CustomException(1300, "退出失败");
    }
}
