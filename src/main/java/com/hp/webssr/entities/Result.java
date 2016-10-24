package com.hp.webssr.entities;

import com.hp.webssr.common.JsonUtility;
import com.hp.webssr.consts.*;

/**
 * when the client call the server, the server do a response the base
 * information base result class, every Result-Class must inherit from this
 */
public class Result {
	/**
	 * map the ReturnCodem field from SSR 200: means the action has done
	 * successfully 500: No backend Executor, Can't find handler or method other
	 * codes: the defination is in QC_Backend
	 */
	private String ReturnCode = "";
	/**
	 * map the LogMessage field from SSR
	 */
	private String ErrorText = "";
	/**
	 * map the output of QC_Backend
	 */
	private String UserMessage = "";

	public Result() {
		this.setReturnCode(Result_ReturnCodes.Failed);
		this.setReturnCode(ErrorCodes.GetErrorTextByErrorCodes(ErrorCodes.Error_Code_001));
	}

	public String getErrorText() {
		return ErrorText;
	}

	public void setErrorText(String errorText) {
		ErrorText = errorText;
	}

	public String getReturnCode() {
		return ReturnCode;
	}

	public void setReturnCode(String returnCode) {
		ReturnCode = returnCode;
		if (returnCode == Result_ReturnCodes.Successfully) {
			this.setErrorText("");
		} else {
			this.setErrorText(returnCode);
		}
	}

	@SuppressWarnings("finally")
	public String toJsonString() throws Exception {
		String strResult = "";
		try {
			strResult = JsonUtility.ToJsonString(this);
		} catch (Exception e) {
			this.setErrorText(e.getMessage());
		} finally {
			return strResult;
		}
	}

	public String getUserMessage() {
		return UserMessage;
	}

	public void setUserMessage(String userMessage) {
		UserMessage = userMessage;
	}
}
