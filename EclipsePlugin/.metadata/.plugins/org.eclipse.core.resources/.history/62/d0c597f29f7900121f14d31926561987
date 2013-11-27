/**
 * AsposeDownloadsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aspose;

public class AsposeDownloadsLocator extends org.apache.axis.client.Service implements com.aspose.AsposeDownloads {

    public AsposeDownloadsLocator() {
    }


    public AsposeDownloadsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AsposeDownloadsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AsposeDownloadsSoap
    private java.lang.String AsposeDownloadsSoap_address = "http://community.aspose.com/community/SecureServices/AsposeDownloads.asmx";

    public java.lang.String getAsposeDownloadsSoapAddress() {
        return AsposeDownloadsSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AsposeDownloadsSoapWSDDServiceName = "AsposeDownloadsSoap";

    public java.lang.String getAsposeDownloadsSoapWSDDServiceName() {
        return AsposeDownloadsSoapWSDDServiceName;
    }

    public void setAsposeDownloadsSoapWSDDServiceName(java.lang.String name) {
        AsposeDownloadsSoapWSDDServiceName = name;
    }

    public com.aspose.AsposeDownloadsSoap getAsposeDownloadsSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AsposeDownloadsSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAsposeDownloadsSoap(endpoint);
    }

    public com.aspose.AsposeDownloadsSoap getAsposeDownloadsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aspose.AsposeDownloadsSoapStub _stub = new com.aspose.AsposeDownloadsSoapStub(portAddress, this);
            _stub.setPortName(getAsposeDownloadsSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAsposeDownloadsSoapEndpointAddress(java.lang.String address) {
        AsposeDownloadsSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.aspose.AsposeDownloadsSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aspose.AsposeDownloadsSoapStub _stub = new com.aspose.AsposeDownloadsSoapStub(new java.net.URL(AsposeDownloadsSoap_address), this);
                _stub.setPortName(getAsposeDownloadsSoapWSDDServiceName());
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
        if ("AsposeDownloadsSoap".equals(inputPortName)) {
            return getAsposeDownloadsSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://aspose.com/", "AsposeDownloads");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://aspose.com/", "AsposeDownloadsSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AsposeDownloadsSoap".equals(portName)) {
            setAsposeDownloadsSoapEndpointAddress(address);
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
