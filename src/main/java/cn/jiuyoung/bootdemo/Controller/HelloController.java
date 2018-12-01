package cn.jiuyoung.bootdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HelloController
 */
@Controller
public class HelloController {

    @RequestMapping("/welcome")
    @ResponseBody
    public String index(){
        return "Hello Spring boot";
    }
    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("host", "http://www.jiuyoung.cn");
        return "index";
    }

    @RequestMapping("/ss")
    public String hello() throws Exception{
        throw new Exception("出现错误");
    }
}