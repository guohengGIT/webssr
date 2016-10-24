package com.hp.webssr.common;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtility {
	private static ObjectMapper _mapper = null;

	private static synchronized ObjectMapper _getMapperInstance() {
		if (_mapper == null) {
			_mapper = new ObjectMapper();
		}
		return _mapper;
	}

	@SuppressWarnings("finally")
	public static String ToJsonString(Object obj) throws Exception {
		String strResult = "";
		try {
			ObjectMapper objectMapper = _getMapperInstance();
			strResult = objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			return strResult;
		}
	}

	@SuppressWarnings("finally")
	public static Object jsonToBean(String json, Class<?> Obj) throws Exception {
		Object _obj = null;
		try {
			ObjectMapper objectMapper = _getMapperInstance();
			_obj = objectMapper.readValue(json, Obj);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			return _obj;
		}
	}
}
