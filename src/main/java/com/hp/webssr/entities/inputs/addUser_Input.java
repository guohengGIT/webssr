package com.hp.webssr.entities.inputs;

import com.hp.webssr.common.*;
import java.io.Serializable;
/**
 * input for adding qc user
 * */
public class addUser_Input extends BaseInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String QCFarm="";
	private String QCUsers="";
	
	public String getQCFarm() {
		return QCFarm;
	}
	/**
	 * eg:
	 *  <Type>string</Type>
        <Format>qc1c.atlanta.hp.com</Format>
	 * */
	public void setQCFarm(String qCFarm) {
		QCFarm = qCFarm;
	}
	
	public String getQCUsers() {
		return QCUsers;
	}
	/**
	 *  <Type>string</Type>
        <Format>foo.bar@hp.com%john.doe@hp.com</Format>
        <Des>list of QC users separated by percent symbol</Des>
	 * */
	public void setQCUsers(String qCUsers) {
		QCUsers = qCUsers;
	}

	@SuppressWarnings("finally")
	public String toJsonString() throws Exception {
		String strResult = "";
		try {
			strResult = JsonUtility.ToJsonString(this);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			return strResult;
		}
	}
	
}
