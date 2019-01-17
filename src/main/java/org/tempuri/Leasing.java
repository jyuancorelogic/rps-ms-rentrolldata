/**
 * Leasing.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface Leasing extends javax.xml.rpc.Service {
     String getLeasingSoap12Address();

     org.tempuri.LeasingSoap getLeasingSoap12() throws javax.xml.rpc.ServiceException;

     org.tempuri.LeasingSoap getLeasingSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
     String getLeasingSoapAddress();

     org.tempuri.LeasingSoap getLeasingSoap() throws javax.xml.rpc.ServiceException;

     org.tempuri.LeasingSoap getLeasingSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
