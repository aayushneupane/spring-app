package aayush.neupane.me.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aayush.neupane.me.web.dao.Offer;
import aayush.neupane.me.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;
	
	@Autowired
	public void setOffersDAO(OffersDAO offersDAO) {
		this.offersDao = offersDAO;
	}
	
	public List<Offer> getCurrent(){
		return offersDao.getOffers();
	}
	
	public void createOffer(Offer offer) {
		offersDao.createOffer(offer);
	}
	
}
