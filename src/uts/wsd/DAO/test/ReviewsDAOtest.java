package uts.wsd.DAO.test;

import uts.wsd.domain.*;
import uts.wsd.DAO.*;

public class ReviewsDAOtest {

	public static void main(String args[]){
		//Review review = new Review(1, 2, 3, 4, "blah", "Test headline","Test description");
		Review review2 = new Review(1, 2, 3, 4, "blah", "Test blahalhasidladwa","T561531的时嗄8489n");
		ReviewsDAO revdao = new ReviewsDAO();
		revdao.setFilePath("reviews.xml");
		revdao.addReview(review2);
	}
}
