package uts.wsd.soap.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class ReviewsSOAPClient {
	public static void main(String[] args) throws ServiceException, JAXBException, IOException, RemoteException{
		ReviewsSOAPServiceLocator locator = new ReviewsSOAPServiceLocator();
		ReviewsSOAP reviewsSOAP = locator.getReviewsSOAPPort();
		
		//reviewsSOAP.postReview("Testing facade", "How facade works", 2, 2);
		//reviewsSOAP.deleteReview(3);
		reviewsSOAP.login("kate", "kate");
		reviewsSOAP.postReview("Testing facade", "How facade works", 2, 2);
		reviewsSOAP.deleteReview(1);
		
	}
}
