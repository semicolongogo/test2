package sist.com.orm;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sist.com.dto.ParamBean;

@Controller
@SessionAttributes({"pb","map"})
public class MvcController {
	
    @RequestMapping(value = "headerAction.do")
    public String header(@RequestHeader("Accept")String acceptType, 
    		@RequestHeader("Host")String host,
    		@RequestHeader(value = "User-Agent",required=false, defaultValue="my")String userAgent, Model model) {
    	model.addAttribute("Accept", acceptType);
    	model.addAttribute("host", host);
    	model.addAttribute("User-Agent", userAgent);
    	return "mvcSpring/MvcEx2Result";
    }
    @RequestMapping(value = "headerAction2.do")
    public String header2(@RequestHeader Map<String, String>map,ModelMap model) {
    	model.addAttribute("map", map);
    	return "mvcSpring/MvcEx2Result2";
    }
    @RequestMapping(value = "cookieTest.do")
    public String cookieDemo(@RequestParam(value="color",required=false,defaultValue="white")String color, Model model, HttpServletResponse response) {
    	Cookie cookie = new Cookie("color", color);
    	cookie.setMaxAge(30);
    	response.addCookie(cookie);
    	model.addAttribute("color", color);
    	return "mvcSpring/colorView";
    }
    @RequestMapping(value = "cookieCheck.do")
    public String cookieCheckPro(@CookieValue(value="color",required=false,defaultValue="white")String color, Model model) {
    	model.addAttribute("color", color);
    	return "mvcSpring/colorCookie";
    }
    @ModelAttribute(name="strMsg")
    public List<String>StringMsg(){
    	List<String>list=new ArrayList<String>();
    	list.add("딸기");
    	list.add("수박");
    	list.add("멜론");
    	list.add("라임");
    	return list;
    }
    
    @RequestMapping(value = "mvcLocation1.do",method=RequestMethod.GET)
    public String locationFun1(Model model) {
    	model.addAttribute("msg", "HelloSpring");
    	return "mvcSpring/mvcEx4Result";
    }
    @RequestMapping(value = "mvcLocation2.do",method=RequestMethod.POST)
    public String locationFun2(Model model) {
    	model.addAttribute("msg", "HelloSpring");
    	return "redirect:mvcSpring/mvcEx4Result.jsp";
    }
    @RequestMapping(value = "mvcLocation3.do",method=RequestMethod.GET)
    public String locationFun3(@ModelAttribute(name="param2")ParamBean pb,Model model) {
    	HashMap<String, String>map=new HashMap<String, String>();
    	map.put("a", "Action");
    	map.put("b", "Bean");
    	map.put("c", "Crud");
    	model.addAttribute("pb", pb);
    	model.addAttribute("map", map);
    	return "redirect:mvcSpring/mvcEx4Result.jsp";
    }
    @RequestMapping(value = "mvcLocation4.do",method=RequestMethod.GET)
    public String locationFun4(Model model,String job,int no,RedirectAttributes ar) {
    	
    	ar.addAttribute("job", job);
    	ar.addAttribute("no", no);
    	return "mvcSpring/mvcEx4Result";
    }
    
}
