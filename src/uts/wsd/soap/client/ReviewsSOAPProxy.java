package uts.wsd.soap.client;

public class ReviewsSOAPProxy implements uts.wsd.soap.client.ReviewsSOAP {
  private String _endpoint = null;
  private uts.wsd.soap.client.ReviewsSOAP reviewsSOAP = null;
  
  public ReviewsSOAPProxy() {
    _initReviewsSOAPProxy();
  }
  
  public ReviewsSOAPProxy(String endpoint) {
    _endpoint = endpoint;
    _initReviewsSOAPProxy();
  }
  
  private void _initReviewsSOAPProxy() {
    try {
      reviewsSOAP = (new uts.wsd.soap.client.ReviewsSOAPServiceLocator()).getReviewsSOAPPort();
      if (reviewsSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reviewsSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reviewsSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reviewsSOAP != null)
      ((javax.xml.rpc.Stub)reviewsSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uts.wsd.soap.client.ReviewsSOAP getReviewsSOAP() {
    if (reviewsSOAP == null)
      _initReviewsSOAPProxy();
    return reviewsSOAP;
  }
  
  public void logout() throws java.rmi.RemoteException, uts.wsd.soap.client.JAXBException, uts.wsd.soap.client.IOException{
    if (reviewsSOAP == null)
      _initReviewsSOAPProxy();
    reviewsSOAP.logout();
  }
  
  public uts.wsd.soap.client.Review[] fetchReviews() throws java.rmi.RemoteException{
    if (reviewsSOAP == null)
      _initReviewsSOAPProxy();
    return reviewsSOAP.fetchReviews();
  }
  
  public void postReview(java.lang.String arg0, java.lang.String arg1, int arg2, int arg3) throws java.rmi.RemoteException, uts.wsd.soap.client.Exception{
    if (reviewsSOAP == null)
      _initReviewsSOAPProxy();
    reviewsSOAP.postReview(arg0, arg1, arg2, arg3);
  }
  
  public void deleteReview(int arg0) throws java.rmi.RemoteException, uts.wsd.soap.client.JAXBException, uts.wsd.soap.client.IOException{
    if (reviewsSOAP == null)
      _initReviewsSOAPProxy();
    reviewsSOAP.deleteReview(arg0);
  }
  
  public void login(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, uts.wsd.soap.client.JAXBException, uts.wsd.soap.client.IOException{
    if (reviewsSOAP == null)
      _initReviewsSOAPProxy();
    reviewsSOAP.login(arg0, arg1);
  }
  
  
}