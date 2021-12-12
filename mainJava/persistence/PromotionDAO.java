package persistence;

import java.util.List;

import model.User;
import model.promotion;
import persistence.commons.GenericDAO;

public interface PromotionDAO extends GenericDAO<promotion> {

	public abstract List<promotion> findPreferidas(User user);

	public abstract List<promotion> findNotPreferidas(User user);

}
