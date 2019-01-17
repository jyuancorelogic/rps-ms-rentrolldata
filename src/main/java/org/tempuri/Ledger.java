/**
 * Ledger.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package org.tempuri;

public interface Ledger extends javax.xml.rpc.Service {
    public java.lang.String getLedgerSoap12Address();

    public org.tempuri.LedgerSoap getLedgerSoap12() throws javax.xml.rpc.ServiceException;

    public org.tempuri.LedgerSoap getLedgerSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getLedgerSoapAddress();

    public org.tempuri.LedgerSoap getLedgerSoap() throws javax.xml.rpc.ServiceException;

    public org.tempuri.LedgerSoap getLedgerSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
