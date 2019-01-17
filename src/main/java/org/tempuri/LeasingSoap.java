/**
 * LeasingSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface LeasingSoap extends java.rmi.Remote {
     String processData(String XMLData, int preliminary) throws java.rmi.RemoteException;
     String getGuestCardData(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
     String getResidentsByStatusChange(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
     String getResidentsByStatusChangeOrTransactionDate(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
     String getPropertyResidents(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
     String updatePropertyResidents(String userID, String password, String portfolioName, int preliminary, String XMLData) throws java.rmi.RemoteException;
     String getSingleResident(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
     String getPropertyUnits(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
     String getPropertyList(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
     String getLeaseExpirationsByMonth(String userID, String password, String portfolioName, String XMLData) throws java.rmi.RemoteException;
}
