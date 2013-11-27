package com.aspose;

public class AsposeDownloadsSoapProxy implements com.aspose.AsposeDownloadsSoap {
  private String _endpoint = null;
  private com.aspose.AsposeDownloadsSoap asposeDownloadsSoap = null;
  
  public AsposeDownloadsSoapProxy() {
    _initAsposeDownloadsSoapProxy();
  }
  
  public AsposeDownloadsSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initAsposeDownloadsSoapProxy();
  }
  
  private void _initAsposeDownloadsSoapProxy() {
    try {
      asposeDownloadsSoap = (new com.aspose.AsposeDownloadsLocator()).getAsposeDownloadsSoap();
      if (asposeDownloadsSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)asposeDownloadsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)asposeDownloadsSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (asposeDownloadsSoap != null)
      ((javax.xml.rpc.Stub)asposeDownloadsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.aspose.AsposeDownloadsSoap getAsposeDownloadsSoap() {
    if (asposeDownloadsSoap == null)
      _initAsposeDownloadsSoapProxy();
    return asposeDownloadsSoap;
  }
  
  public com.aspose.ProductRelease getProductRelease(java.lang.String platform, java.lang.String productName) throws java.rmi.RemoteException{
    if (asposeDownloadsSoap == null)
      _initAsposeDownloadsSoapProxy();
    return asposeDownloadsSoap.getProductRelease(platform, productName);
  }
  
  
}