package cn.xk.controller;

import cn.xk.domian.VO;
import cn.xk.domian.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running..");
        System.out.println("dev01");
        return "success";
//        return "redirect:success";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2() {
        /**
         * Model模型，封装数据，
         * view 视图，展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置视图
        modelAndView.setViewName("success");
        //设置模型数据
        modelAndView.addObject("username", "张三");
        return modelAndView;
    }

    //    框架会直接注入，当有参数的时
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "lisi");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "username");
        return "success";
    }

    //不常用
    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "王五");
        return "success";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello response");
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() {
        return "Hello Response";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws IOException {
        User user = new User();
        user.setUsername("张三");
        user.setAge(18);
        //使用jackson的转化工具将对象转化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    public User save10() {
        User user = new User();
        user.setUsername("张三");
        user.setAge(18);
        return user;
    }

//    获取请求参数

    //    基本数据类型
    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    //获取POJO类型参数
    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }

    //获取数组类型参数
    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    //获取集合带vo
    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    //获取集合不带vo
    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    //将请求参数映射
    //参数绑定注解@requestParam
    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "张三") String username) {
        System.out.println(username);
    }

    //占位符
    @RequestMapping("/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable("name") String username) {
        System.out.println(username);
    }

    //自定义类型转化器
    @RequestMapping("/quick18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    //    Servlet API
    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    //    获取请求头
    @RequestMapping("/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent") String user_agent) {
        System.out.println(user_agent);
    }

//    获取Cookie
    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionID) {
        System.out.println(jsessionID);
    }


}
