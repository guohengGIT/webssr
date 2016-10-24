package com.hp.webssr.services;

import java.rmi.RemoteException;

import org.SelfServiceRouter.*;
import org.tempuri.*;
public class SelfRouterSericeClient {
	 private static String _SelfServiceUrl="";
	 private SelfRouterSericeClient(){}
	 private static SelfRouterSericeClient _Instance=null;
	 private static ISelfServiceRouterProxy _Instance_SelfServiceRouter_Client=null;
	 static{
		 _Instance=new SelfRouterSericeClient();
		 _Instance_SelfServiceRouter_Client=new ISelfServiceRouterProxy(new String());
		 set_SelfServiceUrl("http://qc2f-itg-ssr.itcs.hp.com/SelfServiceRouter3/SelfServiceRouter.svc?wsdl");
	 }
	 public static SelfRouterSericeClient getInstance()
	 {
		 return _Instance;
	 }
	 
	 public SSRResult SelfService(String strUserId, String strApplicationName, String strMethodName, String[] arrArguments) throws RemoteException
	 {
		 return SelfRouterSericeClient._Instance_SelfServiceRouter_Client.selfService(strUserId, strApplicationName, strMethodName, arrArguments);
	 }

	 private static String get_SelfServiceUrl() {
		return SelfRouterSericeClient._SelfServiceUrl;
	 }

	 private static void set_SelfServiceUrl(String _SelfServiceUrl) {
		SelfRouterSericeClient._SelfServiceUrl = _SelfServiceUrl;
	}
}
