package com.hp.webssr.controllers;

import com.hp.webssr.entities.inputs.*;
import com.hp.webssr.entities.results.*;
import com.hp.webssr.businesfactory.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * process logic for qc users
 * */
@Controller
public class ALM_QC_User_Controller {
	/**
	 * do adding qc user to alm
	 * */
	@RequestMapping(value="/addUser.do",method=RequestMethod.POST)
	public @ResponseBody String addUser(addUser_Input user) throws Exception{
		
		addUser_Result result=ALM_QC_User_Factory.addUser(user);

		return result.toJsonString();
		
	}
	
	@RequestMapping(value="/queryAllFarm.do", method=RequestMethod.POST)
	public @ResponseBody String queryAllFarm(){
		return "qc1f.austin.hp.com;qc2f.austin.hp.com;qc3f.austin.hp.com";
	}
}
