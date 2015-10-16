/**
 * ReviewsSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.wsd.soap.client;

public interface ReviewsSOAP extends java.rmi.Remote {
    public void logout() throws java.rmi.RemoteException, uts.wsd.soap.client.JAXBException, uts.wsd.soap.client.IOException;
    public uts.wsd.soap.client.Review[] fetchReviews() throws java.rmi.RemoteException;
    public void postReview(java.lang.String arg0, java.lang.String arg1, int arg2, int arg3) throws java.rmi.RemoteException, uts.wsd.soap.client.Exception;
    public void deleteReview(int arg0) throws java.rmi.RemoteException, uts.wsd.soap.client.JAXBException, uts.wsd.soap.client.IOException;
    public void login(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, uts.wsd.soap.client.JAXBException, uts.wsd.soap.client.IOException;
}
