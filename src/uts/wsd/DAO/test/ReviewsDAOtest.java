package uts.wsd.DAO.test;

import uts.wsd.domain.*;
import uts.wsd.DAO.*;

public class ReviewsDAOtest {

	public static void main(String args[]){
		Review review = new Review(1, 2, 3, 4, "blah", "Test headline","Test description");
		ReviewsDAO revdao = new ReviewsDAO();
		revdao.addReview(review);
		revdao.save();
	}
}
