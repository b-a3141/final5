package services;

import java.util.List;

import model.Attraction;
import model.User;
import model.promotion;
import persistence.PromotionDAO;
import persistence.commons.DAOFactory;

public class PromotionService {

	
	public List<promotion> list(){
		return DAOFactory.getPromotionDAO().findAll();
	}
	
	//int id, String name, String type, String description, String imagen, boolean capacity, int cost,int discount
	public promotion create(String name, String type, String description, String imagen, Boolean capacity, Integer cost, Integer discount ) {
		
		promotion promotion = new promotion(-1, name, type, description, imagen, capacity, cost , discount);
		
		if(promotion.isValid()) {
			PromotionDAO pd = DAOFactory.getPromotionDAO();
			pd.insert(promotion);
		}
		
		return promotion;
		
	}
	
	public promotion update(int id,String name, String type, String description, String imagen,
			boolean capacity, int cost, int discount) {
		
		//promotion promotion = new promotion(-1, name, type, description, imagen, capacity, cost, discount);
		
		PromotionDAO pd = DAOFactory.getPromotionDAO();
		promotion promotion = pd.find(id);
		
		promotion.setName(name);
		promotion.setType(type);
		promotion.setDescription(description);
		promotion.setImagen(imagen);
		promotion.setCapacity(capacity);
		promotion.setCost(cost);
		promotion.setDiscount(discount);
		
		if(promotion.isValid()) {
			pd.update(promotion);
		}
		
		return promotion;
		
	}

	public void      delete(int id) {
		promotion promotion = new promotion(id, null, null, null, null, false, id, id);
		PromotionDAO pd = DAOFactory.getPromotionDAO();
		pd.delete(promotion);
		
	}
	
	public promotion find(int id) {
		PromotionDAO pd = DAOFactory.getPromotionDAO();
		return pd.find(id);
	}

	public List<promotion> getPreferidas(User user) {
		return DAOFactory.getPromotionDAO().findPreferidas(user);
	}

	
	public List<promotion> getNotPreferidas(User user) {
		return DAOFactory.getPromotionDAO().findNotPreferidas(user);
	}
	
}
