package sist.com.orm;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sist.com.dao.BasicDao;
import sist.com.dto.BootBoardBean;
import sist.com.dto.DeptBean;

@RestController
public class AjaxController {
	@Resource
	BasicDao dao;
	
	@RequestMapping(value="passwordCheck.do")
    public Map<String, String> getPassCheck(int no, String password, String action) {
    	Map<String, String>map = new HashMap<String, String>();
    	String dbPass=dao.getPassword(no);
    	map.put("state", String.valueOf(dbPass!=null&&dbPass.equals(password)));
    	map.put("action", action);
    	return map;
    }
  //restContrller retrun으로 json String 이니깐 controller로 하세요!!
	@RequestMapping(value="modInfo.do")
    public String modInfo(int no, String subject, String contents) {
    	//System.out.println(no+" "+subject+" "+contents);
    	BootBoardBean bean = new BootBoardBean();
    	bean.setNo(no);
    	bean.setSubject(subject);
    	bean.setContents(contents);
    	dao.updateInfo(bean);
    	return "성공";
    }
	@RequestMapping(value="ajaxMap.do")
	public Object testFun1(HttpServletResponse response,@RequestParam(value="job",required=false,defaultValue="java")String job) throws Exception{
		if(job.equals("oracle")) {
			return "<img src=\"/orm/upload/13.jpg\" width=\"200\" height=\"200\">";
		}else if(job.equals("jsp")) {
			return "<script>alert('Oh! Sexy!');</script>";
		}else if(job.equals("zz")) {
			return "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
					"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
					"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>"
					+ "<div class=\"container\">\r\n" + 
					"  <h2>OMG!!!!!!!!</h2>\r\n" + 
					"  <p>This is so Sexy!!!!!!!!!!!!!</p>            \r\n" + 
					"  <table class=\"table table-bordered\">\r\n" + 
					"    <thead>\r\n" + 
					"      <tr>\r\n" + 
					"        <th>Firstname</th>\r\n" + 
					"        <th>Lastname</th>\r\n" + 
					"        <th>Email</th>\r\n" + 
					"      </tr>\r\n" + 
					"    </thead>\r\n" + 
					"    <tbody>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>John</td>\r\n" + 
					"        <td>Doe</td>\r\n" + 
					"        <td>john@example.com</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Mary</td>\r\n" + 
					"        <td>Moe</td>\r\n" + 
					"        <td>mary@example.com</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>July</td>\r\n" + 
					"        <td>Dooley</td>\r\n" + 
					"        <td>july@example.com</td>\r\n" + 
					"      </tr>\r\n" + 
					"    </tbody>\r\n" + 
					"  </table>\r\n" + 
					"</div>\r\n" + 
					"";
		} else if(job.equals("hh")) {
			response.sendRedirect("/ajaxjson/ajaxView.jsp");
		}
		return "RestController Msg";
	}
	@RequestMapping(value="ajaxMap2.do")
	public Object ajaxJsonFun1(String job){
		return dao.infoBoardList(Integer.parseInt(job));
	}
	@RequestMapping(value="ajaxMap3.do")
	public List<DeptBean> listFun1(){
		return dao.selectDeptList();
	}

}
