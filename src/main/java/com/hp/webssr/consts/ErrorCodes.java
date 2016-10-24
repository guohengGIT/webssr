package com.hp.webssr.consts;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodes {
	public static final String Error_Code_001="Error_Code_001";
	public static final String Error_Code_002="Error_Code_002";
	
	public static final String GetErrorTextByErrorCodes(String ErrorCodes)
	{
		if(_Code_Text_Mapping!=null && _Code_Text_Mapping.containsKey(ErrorCodes))
		{
			return _Code_Text_Mapping.get(ErrorCodes).toString();
		}
		return "unknown error";
	}
	private static Map<String, String> _Code_Text_Mapping=null;
	static{
		_Code_Text_Mapping=new HashMap<String, String>();
		_Code_Text_Mapping.put(ErrorCodes.Error_Code_001, "Init error");
	}
}
