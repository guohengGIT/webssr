/**
 * SSRLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SSRLocator extends org.apache.axis.client.Service implements org.tempuri.SSR {

    public SSRLocator() {
    }


    public SSRLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SSRLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for basicSoapEndPoint
    private java.lang.String basicSoapEndPoint_address = "http://c0047723.extranet.hp.com/SelfServiceRouter3/SelfServiceRouter.svc/soap";

    public java.lang.String getbasicSoapEndPointAddress() {
        return basicSoapEndPoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String basicSoapEndPointWSDDServiceName = "basicSoapEndPoint";

    public java.lang.String getbasicSoapEndPointWSDDServiceName() {
        return basicSoapEndPointWSDDServiceName;
    }

    public void setbasicSoapEndPointWSDDServiceName(java.lang.String name) {
        basicSoapEndPointWSDDServiceName = name;
    }

    public org.tempuri.ISelfServiceRouter getbasicSoapEndPoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(basicSoapEndPoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getbasicSoapEndPoint(endpoint);
    }

    public org.tempuri.ISelfServiceRouter getbasicSoapEndPoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicSoapEndPointStub _stub = new org.tempuri.BasicSoapEndPointStub(portAddress, this);
            _stub.setPortName(getbasicSoapEndPointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setbasicSoapEndPointEndpointAddress(java.lang.String address) {
        basicSoapEndPoint_address = address;
    }


    // Use to get a proxy class for basicSoapEndPoint1
    private java.lang.String basicSoapEndPoint1_address = "http://c0047723.extranet.hp.com/SelfServiceRouter3/SelfServiceRouter.svc/ssr";

    public java.lang.String getbasicSoapEndPoint1Address() {
        return basicSoapEndPoint1_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String basicSoapEndPoint1WSDDServiceName = "basicSoapEndPoint1";

    public java.lang.String getbasicSoapEndPoint1WSDDServiceName() {
        return basicSoapEndPoint1WSDDServiceName;
    }

    public void setbasicSoapEndPoint1WSDDServiceName(java.lang.String name) {
        basicSoapEndPoint1WSDDServiceName = name;
    }

    public org.tempuri.ISelfServiceRouter getbasicSoapEndPoint1() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(basicSoapEndPoint1_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getbasicSoapEndPoint1(endpoint);
    }

    public org.tempuri.ISelfServiceRouter getbasicSoapEndPoint1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicSoapEndPointStub _stub = new org.tempuri.BasicSoapEndPointStub(portAddress, this);
            _stub.setPortName(getbasicSoapEndPoint1WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setbasicSoapEndPoint1EndpointAddress(java.lang.String address) {
        basicSoapEndPoint1_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.ISelfServiceRouter.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicSoapEndPointStub _stub = new org.tempuri.BasicSoapEndPointStub(new java.net.URL(basicSoapEndPoint_address), this);
                _stub.setPortName(getbasicSoapEndPointWSDDServiceName());
                return _stub;
            }
            if (org.tempuri.ISelfServiceRouter.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicSoapEndPointStub _stub = new org.tempuri.BasicSoapEndPointStub(new java.net.URL(basicSoapEndPoint1_address), this);
                _stub.setPortName(getbasicSoapEndPoint1WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("basicSoapEndPoint".equals(inputPortName)) {
            return getbasicSoapEndPoint();
        }
        else if ("basicSoapEndPoint1".equals(inputPortName)) {
            return getbasicSoapEndPoint1();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "SSR");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "basicSoapEndPoint"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "basicSoapEndPoint1"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("basicSoapEndPoint".equals(portName)) {
            setbasicSoapEndPointEndpointAddress(address);
        }
        else 
if ("basicSoapEndPoint1".equals(portName)) {
            setbasicSoapEndPoint1EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
