/**
 * ISelfServiceRouter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface ISelfServiceRouter extends java.rmi.Remote {
    public org.SelfServiceRouter.SSRResult selfService(java.lang.String strUserId, java.lang.String strApplicationName, java.lang.String strMethodName, java.lang.String[] arrArguments) throws java.rmi.RemoteException;
}
