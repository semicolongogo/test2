package sist.com.orm;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sist.com.dao.BasicDao;
import sist.com.dto.BootBoardBean;
import sist.com.dto.DeptBean;
import sist.com.dto.GoodOrBadBean;
import sist.com.dto.MemberBean;
import sist.com.dto.PagingBean;
import sist.com.dto.Scrab1;
import sist.com.dto.ScrabBean;

@Controller
@SessionAttributes(value= {"bootList"})
public class AppleController {
	@Inject
	private BasicDao dao;
	@Resource
	private PagingBean page;
	
	@RequestMapping(value="crudTest.do")
	public String crudTestView(Model model) {
		model.addAttribute("deptList", dao.selectDeptList());
		return "mvcCrud/crudView";
	}
	
    @RequestMapping(value="loginFun.do")
	public String loginActionFun(String idFun, String pwFun, HttpSession session,HttpServletResponse response,Model model) {
    	Cookie cookie = new Cookie("id", idFun);
    	String pw = dao.memberIdCheck(idFun);
    	if(pw.equals(pwFun)) {
    		session.setAttribute("id", idFun);
    		response.addCookie(cookie);
    		model.addAttribute("id", idFun);
    		return "redirect:bootList.do";
    	}
		
		return "redirect:signin.jsp";
	}
    @RequestMapping(value="bootInsert.do")
    public String insertBoot(BootBoardBean bean, @RequestParam(value="file", required=false)MultipartFile file, Model model, HttpServletRequest request) {
    	String fileName = file.getOriginalFilename();
    	String locations="C:\\Users\\user\\Desktop\\spring2\\web\\src\\main\\webapp\\upload\\";
    	FileOutputStream fos = null;
    	if(fileName.length()>0) {
    		try {
				fos=new FileOutputStream(new File(locations+fileName));
				fos.write(file.getBytes());
				bean.setFileName(fileName);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if(fos!=null)fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
    	}else {
    		bean.setFileName("noimg.jpg");
    	}
    	//System.out.println(bean);
    	dao.insertWrite(bean);
    	//dao.updateList(bean);
    	
    	
    	
    	//model.addAttribute("bootList", dao.selectBootList());
    	//page.makeProcess(request, model);
    	return "redirect:bootList.do";
    }
    @ModelAttribute(name="bList")
    /*public List<BootBoardBean>selectBoard(){
    	//return dao.selectBootList();    	
    }*/
    
    @RequestMapping(value="clickList1.do")
    public String clickTest1() {
    	return "redirect:mvcCrud/view1.jsp";
    }
    @RequestMapping(value="clickList2.do")
    public String clickTest2() {
    	return "mvcCrud/view2";
    }
    
    @RequestMapping(value="bootList.do")
    public String selectBootList(HttpServletRequest request,Model model) {
    	page.makeProcess(request, model);
    	return "board";
    }
    @RequestMapping(value="infogogo.do")
    public String selectInfo(@RequestParam(value="no",required=false,defaultValue="0")int no,Model model,HttpSession session) {
    	String id = (String)session.getAttribute("id");
    	return "redirect:infoBoard.do?no="+no+"&job=info&id="+id+"";
    }
    @RequestMapping(value="infoBoard.do")
    public String infoBoardList(GoodOrBadBean gob,@RequestParam(value="no",required=false,defaultValue="0")int no,String id,Model model) {
    	
    	model.addAttribute("id", id);
    	model.addAttribute("infoList", dao.infoBoardList(no));
    	gob.setId(id);
    	gob.setNo(no);
    	
    	try {
			//System.out.println("성공");
			model.addAttribute("good", dao.getGood(gob));
			model.addAttribute("bad", dao.getBad(gob));
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("good", 0);
			model.addAttribute("bad", 0);
			
		}
    	
    	try {
    		model.addAttribute("allGood", dao.selectAllGood(no));
	    	model.addAttribute("allBad", dao.selectAllBad(no));
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("allGood", 0);
	    	model.addAttribute("allBad", 0);
		}
    	
    	return "info";
    }
    @RequestMapping(value = "goodUpdate.do")
    public String goodUpdateFun(GoodOrBadBean gob,HttpSession session,int no,String action) {
    	String id = (String)session.getAttribute("id");
    	if(action.equals("plusg")) {
    		gob.setId(id);
        	gob.setNo(no);
        	gob.setGood(1);
        	gob.setBad(0);
        	dao.deleteGood(gob);
        	dao.insertGood(gob);
        	return "redirect:infoBoard.do?no="+no+"&job=info&id="+id+"";
    	}else if(action.equals("minus")) {
    		gob.setId(id);
        	gob.setNo(no);
        	dao.deleteGood(gob);
        	return "redirect:infoBoard.do?no="+no+"&job=info&id="+id+"";
    	}else if(action.equals("plusb")) {
    		gob.setId(id);
        	gob.setNo(no);
        	gob.setGood(0);
        	gob.setBad(1);
        	dao.deleteGood(gob);
        	dao.insertBad(gob);
        	return "redirect:infoBoard.do?no="+no+"&job=info&id="+id+"";
    	}
    	
    	return "redirect:infoBoard.do?no="+no+"&job=info&id="+id+"";
    }
    @RequestMapping(value="transactionTest1.do")
    public String transView(@RequestParam(value="no",required=false, defaultValue="0")int no, String msg, Model model) {
    	dao.insertUpdate(no, msg);
    	model.addAttribute("a", dao.selectParam());
    	return "transactionDemo/view";
    }
	@RequestMapping(value="deleteif.do")
	public String deleteInfo(int nosexy) {
		dao.deleteInfo(nosexy);
		return "redirect:bootList.do";
	}
	@RequestMapping(value="downLoad.do")
	public ModelAndView downFile(@RequestParam(value="fileName")String fileName) {
		String location="C:\\Users\\user\\Desktop\\spring2\\web\\src\\main\\webapp\\upload\\";
		File file = new File(location.concat(fileName));
		return new ModelAndView("download","downloadFile",file);
	}
    @RequestMapping(value="jsonView.do")
    public String selectJsonDept(Model model) {
    	List<DeptBean>list=dao.selectDeptList();
    	
    	JSONArray jsonArray = new JSONArray();
    	
    	for(int i=0;i<list.size();i++) {
    		DeptBean deptb=list.get(i);
    		JSONObject jsonObject = new JSONObject();
    		jsonObject.put("deptno", deptb.getDeptno());
    		jsonObject.put("dname", deptb.getDname());
    		jsonObject.put("loc", deptb.getLoc());
    		jsonArray.add(jsonObject);
    	}
    	model.addAttribute("json", jsonArray);
    	return"ajaxjson/ajaxJsonResult";
    }
    @RequestMapping(value="scrabFun.do")
    public String insertScrab(ScrabBean sbb) {
    	dao.insertScrap(sbb);
    	return "redirect:bootList.do";
    }
    @RequestMapping(value="mypage.do")
    public String selectMyScrab(Model model,HttpSession session) {
    	String id =(String)session.getAttribute("id");
    	model.addAttribute("scrabList",dao.selectScrab(id));
    	return "mypage";
    }
    @RequestMapping(value = "scrab.do")
    public String insertScrab1(Scrab1 sb,int no,HttpSession session) {
    	String id =(String)session.getAttribute("id");
    	sb.setNo(no);
    	sb.setId(id);
    	//System.out.println(id+no);
    	dao.insertScFun(sb);
    	return "redirect:bootList.do";
    }
    @RequestMapping(value = "deleteScrab.do")
    public String deleteScrab(Scrab1 sb,int no,HttpSession session) {
    	String id =(String)session.getAttribute("id");
    	sb.setNo(no);
    	sb.setId(id);
    	dao.deleteScFun(sb);
    	return "redirect:mypage.do";
    }
    @RequestMapping(value = "signupFun.do")
    public ModelAndView signupM(MemberBean mmb,ModelAndView modelv) {
    	dao.insertMemFun(mmb);
    	modelv.setViewName("signin");
    	return modelv;
    }

}








