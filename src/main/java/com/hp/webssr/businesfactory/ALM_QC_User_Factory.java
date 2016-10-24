package com.hp.webssr.businesfactory;
import com.hp.webssr.entities.inputs.*;
import com.hp.webssr.services.*;
import com.hp.webssr.entities.results.*;
import com.hp.webssr.consts.*;

import java.rmi.RemoteException;

import org.SelfServiceRouter.*;
public class ALM_QC_User_Factory {
	private ALM_QC_User_Factory(){}
	/**
	 * do adding qc user
	 * @throws RemoteException 
	 */
	public static addUser_Result addUser(addUser_Input form) throws RemoteException
	{
		addUser_Result result=new addUser_Result();
		boolean flag=form!=null && form.getQCFarm().length()>0 && form.getQCUsers().length()>0 && form.getUserId().length()>0;
		if(flag)
		{
			SSRResult tmpResult=SelfRouterSericeClient.getInstance().SelfService(
					form.getUserId(), 
					form.getApplicationName(),
					form.getMethodName(),
					new String[]{ form.getQCFarm(), form.getQCUsers()});
			result=_getResult(tmpResult);
		}
		else
		{
			result.setReturnCode(Result_ReturnCodes.Failed);
			result.setErrorText("The params are not right");
		}
		return result;
	}
	
	private static addUser_Result _getResult(SSRResult ssrResult)
	{
		addUser_Result tmpResult=new addUser_Result();
		if(ssrResult!=null)
		{
			tmpResult.setReturnCode(ssrResult.getReturnCode());
			tmpResult.setErrorText(ssrResult.getLogMessage());
			tmpResult.setUserMessage(ssrResult.getUserMessage());
		}
		return tmpResult;
	}
}
