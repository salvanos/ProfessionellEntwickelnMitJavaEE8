/**
 * UploaderServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.java2enterprise.onlineshop;

public class UploaderServiceLocator extends org.apache.axis.client.Service implements de.java2enterprise.onlineshop.UploaderService {

    public UploaderServiceLocator() {
    }


    public UploaderServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UploaderServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UploaderPort
    private java.lang.String UploaderPort_address = "http://localhost:8080/onlineshop-web/UploaderService";

    public java.lang.String getUploaderPortAddress() {
        return UploaderPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UploaderPortWSDDServiceName = "UploaderPort";

    public java.lang.String getUploaderPortWSDDServiceName() {
        return UploaderPortWSDDServiceName;
    }

    public void setUploaderPortWSDDServiceName(java.lang.String name) {
        UploaderPortWSDDServiceName = name;
    }

    public de.java2enterprise.onlineshop.Uploader getUploaderPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UploaderPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUploaderPort(endpoint);
    }

    public de.java2enterprise.onlineshop.Uploader getUploaderPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            de.java2enterprise.onlineshop.UploaderPortBindingStub _stub = new de.java2enterprise.onlineshop.UploaderPortBindingStub(portAddress, this);
            _stub.setPortName(getUploaderPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUploaderPortEndpointAddress(java.lang.String address) {
        UploaderPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (de.java2enterprise.onlineshop.Uploader.class.isAssignableFrom(serviceEndpointInterface)) {
                de.java2enterprise.onlineshop.UploaderPortBindingStub _stub = new de.java2enterprise.onlineshop.UploaderPortBindingStub(new java.net.URL(UploaderPort_address), this);
                _stub.setPortName(getUploaderPortWSDDServiceName());
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
        if ("UploaderPort".equals(inputPortName)) {
            return getUploaderPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://web.onlineshop.java2enterprise.de/", "UploaderService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://web.onlineshop.java2enterprise.de/", "UploaderPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UploaderPort".equals(portName)) {
            setUploaderPortEndpointAddress(address);
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
