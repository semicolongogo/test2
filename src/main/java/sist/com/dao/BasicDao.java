package sist.com.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sist.com.dto.BootBoardBean;
import sist.com.dto.DeptBean;
import sist.com.dto.GoodOrBadBean;
import sist.com.dto.MemberBean;
import sist.com.dto.ParamBean;
import sist.com.dto.Scrab1;
import sist.com.dto.ScrabBean;
@Component
public class BasicDao  extends SqlSessionDaoSupport{

	@Autowired
	protected void initDao(SqlSessionTemplate st) throws Exception {
		// TODO Auto-generated method stub
		this.setSqlSessionTemplate(st);
	}
	
	public void insetMember() {
		System.out.println(this.getSqlSession());
	}
	public List<DeptBean>selectDeptList(){
		return this.getSqlSession().selectList("selectDeptList");
	}
	public String memberIdCheck(String id) {
		return this.getSqlSession().selectOne("memberIdCheck",id);
	}
	public void insertWrite(BootBoardBean bean) {
		
		//System.out.println(bean);
		this.getSqlSession().insert("insertWrite", bean);
		//this.getSqlSession().update("updateList",bean);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
	}
	public List<Object>selectBootList(HashMap<String, Object>map){
		return this.getSqlSession().selectList("selectBootList",map);
	}
	public void updateHit(int no){
		this.getSqlSession().update("updateHit",no);
	}
	public List<BootBoardBean>infoBoardList(int no){
		return this.getSqlSession().selectList("infoBoardList",no);
	}
	public void updateList(BootBoardBean bean) {
		this.getSqlSession().update("updateList",bean);
	}
	
	public void insertUpdate(int no, String msg) {
		this.getSqlSession().insert("insertUpdate", new ParamBean(msg,no));
		this.getSqlSession().update("upupup", new ParamBean(msg,no));
	}
	public List<ParamBean> selectParam(){
		return this.getSqlSession().selectList("selectParam");
	}
	public String getPassword(int no) {
		return this.getSqlSession().selectOne("getPassword",no);
	}
	public void deleteInfo(int no) {
		this.getSqlSession().delete("deleteInfo",no);
	}
	public void updateInfo(BootBoardBean bean) {
		this.getSqlSession().update("updateInfo",bean);
	}
	public Integer getTotalBoot(HashMap<String, Object>map) {
		return this.getSqlSession().selectOne("getTotalBoot",map);
	}
	public void insertScrap(ScrabBean sbb) {
		this.getSqlSession().insert("insertScrap",sbb);
	}
	public List<BootBoardBean> selectScrab(String id){
		return this.getSqlSession().selectList("selectScrab",id);
	}
	public void insertScFun(Scrab1 sb) {
		this.getSqlSession().insert("insertScFun",sb);
	}
	public void deleteScFun(Scrab1 sb) {
		this.getSqlSession().delete("deleteScFun", sb);
	}
	public int getGood(GoodOrBadBean gob) {
		return this.getSqlSession().selectOne("getGood",gob);
	}
	public int getBad(GoodOrBadBean gob) {
		return this.getSqlSession().selectOne("getBad",gob);
	}
	public void insertGood(GoodOrBadBean gob) {
		this.getSqlSession().insert("insertGood", gob);
	}
	public void deleteGood(GoodOrBadBean gob) {
		this.getSqlSession().delete("deleteGood", gob);
	}
	public int selectAllGood(int no) {
		return this.getSqlSession().selectOne("selectAllGood",no);
	}
	public int selectAllBad(int no) {
		return this.getSqlSession().selectOne("selectAllBad",no);
	}
	public void insertBad(GoodOrBadBean gob) {
		this.getSqlSession().insert("insertBad",gob);
	}
	public void	insertMemFun(MemberBean mmb) {
		this.getSqlSession().insert("insertMemFun",mmb);
	}

}





