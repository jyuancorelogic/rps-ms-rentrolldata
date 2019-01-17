/**
 * LedgerSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package org.tempuri;

public interface LedgerSoap extends java.rmi.Remote {
   String addACHPayment(String userID, String password, String portfolioName, int preliminary, String XMLData, boolean bCreateACH) throws java.rmi.RemoteException;
   String addBilling(String userID, String password, String portfolioName, int preliminary, String XMLData) throws java.rmi.RemoteException;
   String addPaymentWithCheckImage(String userID, String password, String portfolioName, int preliminary, String XMLData, byte[] tiff_Image_Front, byte[] tiff_Image_Back) throws java.rmi.RemoteException;
   String addPayment(String userID, String password, String portfolioName, int preliminary, String XMLData) throws java.rmi.RemoteException;
   String updatePayment(String userID, String password, String portfolioName, int preliminary, String XMLData) throws java.rmi.RemoteException;
   String updateSettlementData(String userID, String password, String portfolioName, int preliminary, String XMLData) throws java.rmi.RemoteException;
   String returnPayment(String userID, String password, String portfolioName, int preliminary, String XMLData) throws java.rmi.RemoteException;
   String approveEdexBatches(String userID, String password, String portfolioName, int preliminary, String XMLData) throws java.rmi.RemoteException;
}
