package cn.xiaozhang.takeout.bean;

import java.util.ArrayList;


public class HomeInfo1 {
	ArrayList<Promotion> promotionList;
	ArrayList<Category> categorieList;
	ArrayList<Seller> nearbySellerList;
	ArrayList<Seller> ortherSellerList;
	
	
	
	
	
	public HomeInfo1(ArrayList<Promotion> promotionList,
			ArrayList<Category> categorieList,
			ArrayList<Seller> nearbySellerList,
			ArrayList<Seller> ortherSellerList) {
		super();
		this.promotionList = promotionList;
		this.categorieList = categorieList;
		this.nearbySellerList = nearbySellerList;
		this.ortherSellerList = ortherSellerList;
	}
	
	
	public ArrayList<Promotion> getPromotionList() {
		return promotionList;
	}
	public void setPromotionList(ArrayList<Promotion> promotionList) {
		this.promotionList = promotionList;
	}
	public ArrayList<Category> getCategorieList() {
		return categorieList;
	}
	public void setCategorieList(ArrayList<Category> categorieList) {
		this.categorieList = categorieList;
	}
	public ArrayList<Seller> getNearbySellerList() {
		return nearbySellerList;
	}
	public void setNearbySellerList(ArrayList<Seller> nearbySellerList) {
		this.nearbySellerList = nearbySellerList;
	}
	public ArrayList<Seller> getOrtherSellerList() {
		return ortherSellerList;
	}
	public void setOrtherSellerList(ArrayList<Seller> ortherSellerList) {
		this.ortherSellerList = ortherSellerList;
	}
	
	
	
	
	
	
	
	
	
}
