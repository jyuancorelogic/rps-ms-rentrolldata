/**
 * LeasingLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LeasingLocator extends org.apache.axis.client.Service implements org.tempuri.Leasing {

    public LeasingLocator() {
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LeasingSoapWSDDServiceName = "LeasingSoap";
    // Use to get a proxy class for LeasingSoap12
    private java.lang.String LeasingSoap12_address = "http://207.54.51.115/amsiweb/edexweb/esite/leasing.asmx";

    // The WSDD service name defaults to the port name.
    private java.lang.String LeasingSoap12WSDDServiceName = "LeasingSoap12";

    // Use to get a proxy class for LeasingSoap
    private java.lang.String LeasingSoap_address = "http://207.54.51.115/amsiweb/edexweb/esite/leasing.asmx";
    private java.util.HashSet ports = null;



    public LeasingLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LeasingLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }



    public java.lang.String getLeasingSoap12Address() {
        return LeasingSoap12_address;
    }

    public java.lang.String getLeasingSoap12WSDDServiceName() {
        return LeasingSoap12WSDDServiceName;
    }

    public void setLeasingSoap12WSDDServiceName(java.lang.String name) {
        LeasingSoap12WSDDServiceName = name;
    }

    public org.tempuri.LeasingSoap getLeasingSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LeasingSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLeasingSoap12(endpoint);
    }

  public org.tempuri.LeasingSoap getLeasingSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.LeasingSoap12Stub _stub = new org.tempuri.LeasingSoap12Stub(portAddress, this);
            _stub.setPortName(getLeasingSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLeasingSoap12EndpointAddress(java.lang.String address) {
        LeasingSoap12_address = address;
    }



    public java.lang.String getLeasingSoapAddress() {
        return LeasingSoap_address;
    }


    public java.lang.String getLeasingSoapWSDDServiceName() {
        return LeasingSoapWSDDServiceName;
    }

    public void setLeasingSoapWSDDServiceName(java.lang.String name) {
        LeasingSoapWSDDServiceName = name;
    }

    public org.tempuri.LeasingSoap getLeasingSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LeasingSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLeasingSoap(endpoint);
    }

    public org.tempuri.LeasingSoap getLeasingSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.LeasingSoapStub _stub = new org.tempuri.LeasingSoapStub(portAddress, this);
            _stub.setPortName(getLeasingSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLeasingSoapEndpointAddress(java.lang.String address) {
        LeasingSoap_address = address;
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
            if (org.tempuri.LeasingSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.LeasingSoap12Stub _stub = new org.tempuri.LeasingSoap12Stub(new java.net.URL(LeasingSoap12_address), this);
                _stub.setPortName(getLeasingSoap12WSDDServiceName());
                return _stub;
            }
            if (org.tempuri.LeasingSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.LeasingSoapStub _stub = new org.tempuri.LeasingSoapStub(new java.net.URL(LeasingSoap_address), this);
                _stub.setPortName(getLeasingSoapWSDDServiceName());
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
        if ("LeasingSoap12".equals(inputPortName)) {
            return getLeasingSoap12();
        }
        else if ("LeasingSoap".equals(inputPortName)) {
            return getLeasingSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Leasing");
    }



    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "LeasingSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "LeasingSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LeasingSoap12".equals(portName)) {
            setLeasingSoap12EndpointAddress(address);
        }
        else 
if ("LeasingSoap".equals(portName)) {
            setLeasingSoapEndpointAddress(address);
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
