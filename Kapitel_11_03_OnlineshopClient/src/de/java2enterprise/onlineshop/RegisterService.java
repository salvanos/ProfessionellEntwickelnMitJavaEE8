/**
 * RegisterService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.java2enterprise.onlineshop;

public interface RegisterService extends javax.xml.rpc.Service {
    public java.lang.String getRegisterPortAddress();

    public de.java2enterprise.onlineshop.Register getRegisterPort() throws javax.xml.rpc.ServiceException;

    public de.java2enterprise.onlineshop.Register getRegisterPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
