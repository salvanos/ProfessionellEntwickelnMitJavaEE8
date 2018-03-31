package de.java2enterprise.onlineshop;

public class UploaderProxy implements de.java2enterprise.onlineshop.Uploader {
  private String _endpoint = null;
  private de.java2enterprise.onlineshop.Uploader uploader = null;
  
  public UploaderProxy() {
    _initUploaderProxy();
  }
  
  public UploaderProxy(String endpoint) {
    _endpoint = endpoint;
    _initUploaderProxy();
  }
  
  private void _initUploaderProxy() {
    try {
      uploader = (new de.java2enterprise.onlineshop.UploaderServiceLocator()).getUploaderPort();
      if (uploader != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uploader)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uploader != null)
      ((javax.xml.rpc.Stub)uploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public de.java2enterprise.onlineshop.Uploader getUploader() {
    if (uploader == null)
      _initUploaderProxy();
    return uploader;
  }
  
  public void upload(java.lang.String arg0, byte[] arg1) throws java.rmi.RemoteException{
    if (uploader == null)
      _initUploaderProxy();
    uploader.upload(arg0, arg1);
  }
  
  
}