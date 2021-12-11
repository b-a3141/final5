package services;

import java.util.ArrayList;
import java.util.List;
import model.Attraction;
import model.User;
import model.promotion;
import persistence.AttractionDAO;
import persistence.PromotionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class UserOwnedService {

	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();
	PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
	


	
	public List<promotion> ttractionsOwnedList(User user) {

		userDAO.attractionObtained(user.getId());
		
		List<promotion> promotionsOwned ;
		

		return null;
	}

	public List<Attraction> attractionsOwnedList(Integer userId) {
		List<Integer> atrCompradasId =	userDAO.attractionObtained(userId);
		List<Attraction> attractionsBy = new ArrayList<Attraction>();
		for(Integer attracionId : atrCompradasId ) {
			attractionsBy.add( attractionDAO.find(attracionId) );
		}
		System.out.println(attractionsBy);
		
		return attractionsBy;
	}

}
