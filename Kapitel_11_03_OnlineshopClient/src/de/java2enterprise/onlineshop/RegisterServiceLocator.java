/**
 * RegisterServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.java2enterprise.onlineshop;

public class RegisterServiceLocator extends org.apache.axis.client.Service implements de.java2enterprise.onlineshop.RegisterService {

    public RegisterServiceLocator() {
    }


    public RegisterServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RegisterServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RegisterPort
    private java.lang.String RegisterPort_address = "http://localhost:8080/onlineshop-web/RegisterService";

    public java.lang.String getRegisterPortAddress() {
        return RegisterPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RegisterPortWSDDServiceName = "RegisterPort";

    public java.lang.String getRegisterPortWSDDServiceName() {
        return RegisterPortWSDDServiceName;
    }

    public void setRegisterPortWSDDServiceName(java.lang.String name) {
        RegisterPortWSDDServiceName = name;
    }

    public de.java2enterprise.onlineshop.Register getRegisterPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RegisterPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRegisterPort(endpoint);
    }

    public de.java2enterprise.onlineshop.Register getRegisterPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            de.java2enterprise.onlineshop.RegisterPortBindingStub _stub = new de.java2enterprise.onlineshop.RegisterPortBindingStub(portAddress, this);
            _stub.setPortName(getRegisterPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRegisterPortEndpointAddress(java.lang.String address) {
        RegisterPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (de.java2enterprise.onlineshop.Register.class.isAssignableFrom(serviceEndpointInterface)) {
                de.java2enterprise.onlineshop.RegisterPortBindingStub _stub = new de.java2enterprise.onlineshop.RegisterPortBindingStub(new java.net.URL(RegisterPort_address), this);
                _stub.setPortName(getRegisterPortWSDDServiceName());
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
        if ("RegisterPort".equals(inputPortName)) {
            return getRegisterPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://web.onlineshop.java2enterprise.de/", "RegisterService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://web.onlineshop.java2enterprise.de/", "RegisterPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RegisterPort".equals(portName)) {
            setRegisterPortEndpointAddress(address);
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
