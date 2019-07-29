package cn.xiaozhang.takeout.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import cn.xiaozhang.takeout.ConstantValue;
import cn.xiaozhang.takeout.bean.Category;
import cn.xiaozhang.takeout.bean.Head;
import cn.xiaozhang.takeout.bean.HomeInfo;
import cn.xiaozhang.takeout.bean.HomeItem;
import cn.xiaozhang.takeout.bean.Promotion;
import cn.xiaozhang.takeout.bean.Response;
import cn.xiaozhang.takeout.bean.Seller;
import cn.xiaozhang.takeout.utils.CommonUtil;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.err.println("HomeServlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		System.err.println("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.err.println("doPost");
		// 获取经纬度信息，并依据经纬度信息从数据库中获取需要检索的附近商家信息（mysql自持距离范围检索）

		// 测试使用静态数据
		Response resp = new Response();
		resp.setCode("0");

		// 设置data部分数据
		// 促销信息
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		for (int id = 1; id < 4; id++) {
			Promotion promotion = new Promotion();
			promotion.setId(id);
			// http://localhost:8080/TakeoutService/home/
			promotion.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/promotion/" + id + ".jpg");

			promotion.setInfo("促销活动...");
			promotionList.add(promotion);
		}
		// 分类信息
		String[] catetories=new String[]{"美食","甜品饮料","商店超市","早餐","果蔬","新店","下午茶","麻辣烫"};
		ArrayList<Category> categorieList = new ArrayList<Category>();
		for (int id = 1; id < 9; id++) {
			Category category = new Category();
			category.setId(id);
			category.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/category/" + id + ".png");
			category.setName(catetories[id-1]);
			categorieList.add(category);
		}

		// nearbySellerList
		ArrayList<Seller> nearbySellerList = new ArrayList<Seller>();
		Seller seller_ = new Seller();
		seller_.setId(1);
		seller_.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/category/" + 1 + ".png");
		seller_.setName("青大外卖项目");
		seller_.setSendPrice("10");
		seller_.setDeliveryFee("5");
		seller_.setScore("5");

		nearbySellerList.add(seller_);

		for (int i = 2; i < 10; i++) {
			Seller seller = new Seller();
			seller.setId(i);
			seller.setName("青大第" + i + "家分店");
			seller.setSendPrice("10");
			seller.setDeliveryFee("5");
			nearbySellerList.add(seller);
		}

		// ortherSellerList
		ArrayList<Seller> ortherSellerList = new ArrayList<Seller>();

		for (int i = 10; i < 20; i++) {
			Seller seller = new Seller();
			seller.setId(i);
			seller.setName("青大附中第" + i + "家分店");
			seller.setSendPrice("10");
			seller.setDeliveryFee("5");
			ortherSellerList.add(seller);
		}

		List<HomeItem> body = new ArrayList<HomeItem>();
		for (Seller seller : nearbySellerList) {
			HomeItem sellerItem = new HomeItem();
			sellerItem.type = 0;
			sellerItem.seller = seller;
			body.add(sellerItem);
		}

		HomeItem item = new HomeItem();
		item.type = 1;
		item.recommendInfos = new ArrayList<String>();

		item.recommendInfos.add("黄焖鸡");
		item.recommendInfos.add("米线");
		item.recommendInfos.add("德克士");
		item.recommendInfos.add("胖哥俩");
		item.recommendInfos.add("西红柿炒鸡蛋");
		item.recommendInfos.add("爱尚学");

		body.add(item);

		for (Seller seller : ortherSellerList) {
			HomeItem sellerItem = new HomeItem();
			sellerItem.type = 0;
			sellerItem.seller = seller;
			body.add(sellerItem);
		}

		HomeInfo info = new HomeInfo(new Head(promotionList, categorieList), body);
		Response res = new Response();
		res.setCode("0");
		res.setData(JSONObject.fromObject(info).toString());

		CommonUtil.renderJson(response, res);

	
	}

}
