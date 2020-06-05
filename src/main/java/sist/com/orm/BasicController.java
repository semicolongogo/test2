package sist.com.orm;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class BasicController {
	 
	
	//cmd=input--->InputAction--->execute--->ActionForWard
	
	@RequestMapping(value="mvcSpring/input.do")
	public String formInput(Model model,@RequestParam(name="name",required=false,defaultValue="異섏닔�옣")String name,@RequestParam(name="age",required=false,defaultValue="0")int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);		
    	return "mvcSpring/mvcEx1View";
    	
	}		
	@RequestMapping(value="location.do")
	public void locationFun(Model model) {
		model.addAttribute("msg", "HelloSpring");
		//return "mvcSpring/mvcEx1View2";
	}
	@RequestMapping(value="login.do")
	public String loginProcess(String id,String pw,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		if(id.equals("Admin")&& pw.equals("1234")) {
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(20);
			Cookie[] cookies = request.getCookies();
			if(cookies!=null) {
				for (int i = 0; i < cookies.length; i++) {
					cookies[i].setMaxAge(10);
					response.addCookie(cookies[i]);
				}
			}
			return "redirect:memberList.do";
		}
		return "redirect:jsp/adminLogin.jsp";
	}
	@RequestMapping(value = "cookielogin.do")
	public String cookieLoginProcess(String id, String pw, Model model, HttpServletResponse response) {
		if(id.equals("Admin")&& pw.equals("1234")) {
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
			cookie.setMaxAge(60);
			model.addAttribute("id", id);
			return "jsp/list";
		}
		return "redirect:jsp/adminLogin.jsp";
	}
	
	@RequestMapping(value="memberList.do")
	public String memberListAction(Model model) {
		model.addAttribute("list", "MessageList");
		return "jsp/list";
	}
	@RequestMapping(value="logout.do")
	public String logoutProcess(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:jsp/adminLogin.jsp";
	}
	@RequestMapping(value="logout1.do")
	public String logoutAction(HttpSession session) {
		session.invalidate();
		return "redirect:signin.jsp";
	}
	
	
	
	
	

}







