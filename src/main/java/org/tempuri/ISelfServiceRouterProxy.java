package org.tempuri;

public class ISelfServiceRouterProxy implements org.tempuri.ISelfServiceRouter {
  private String _endpoint = null;
  private org.tempuri.ISelfServiceRouter iSelfServiceRouter = null;
  
  public ISelfServiceRouterProxy() {
    _initISelfServiceRouterProxy();
  }
  
  public ISelfServiceRouterProxy(String endpoint) {
    _endpoint = endpoint;
    _initISelfServiceRouterProxy();
  }
  
  private void _initISelfServiceRouterProxy() {
    try {
      iSelfServiceRouter = (new org.tempuri.SSRLocator()).getbasicSoapEndPoint();
      if (iSelfServiceRouter != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iSelfServiceRouter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iSelfServiceRouter)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iSelfServiceRouter != null)
      ((javax.xml.rpc.Stub)iSelfServiceRouter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ISelfServiceRouter getISelfServiceRouter() {
    if (iSelfServiceRouter == null)
      _initISelfServiceRouterProxy();
    return iSelfServiceRouter;
  }
  
  public org.SelfServiceRouter.SSRResult selfService(java.lang.String strUserId, java.lang.String strApplicationName, java.lang.String strMethodName, java.lang.String[] arrArguments) throws java.rmi.RemoteException{
    if (iSelfServiceRouter == null)
      _initISelfServiceRouterProxy();
    return iSelfServiceRouter.selfService(strUserId, strApplicationName, strMethodName, arrArguments);
  }
  
  
}