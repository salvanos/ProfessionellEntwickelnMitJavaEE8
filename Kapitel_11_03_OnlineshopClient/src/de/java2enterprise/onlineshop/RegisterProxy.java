package de.java2enterprise.onlineshop;

public class RegisterProxy implements de.java2enterprise.onlineshop.Register {
  private String _endpoint = null;
  private de.java2enterprise.onlineshop.Register register = null;
  
  public RegisterProxy() {
    _initRegisterProxy();
  }
  
  public RegisterProxy(String endpoint) {
    _endpoint = endpoint;
    _initRegisterProxy();
  }
  
  private void _initRegisterProxy() {
    try {
      register = (new de.java2enterprise.onlineshop.RegisterServiceLocator()).getRegisterPort();
      if (register != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)register)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)register)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (register != null)
      ((javax.xml.rpc.Stub)register)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public de.java2enterprise.onlineshop.Register getRegister() {
    if (register == null)
      _initRegisterProxy();
    return register;
  }
  
  public java.lang.String persist(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (register == null)
      _initRegisterProxy();
    return register.persist(arg0, arg1);
  }
  
  
}