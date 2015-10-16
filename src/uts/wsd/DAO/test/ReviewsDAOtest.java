package uts.wsd.DAO.test;

import uts.wsd.domain.*;

import java.util.Date;

import uts.wsd.DAO.*;

public class ReviewsDAOtest {

	public static void main(String args[]){
		//Review review = new Review(1, 2, 3, 4, "blah", "Test headline","Test description");
		Review review2 = new Review(1, 2, 2, 4, new Date(), "Final update","yayayayay");
		ReviewsDAO revdao = new ReviewsDAO_Impl();
		//revdao.setFilePath("reviews.xml");
		//revdao.addReview(review2);
		
	}
}
