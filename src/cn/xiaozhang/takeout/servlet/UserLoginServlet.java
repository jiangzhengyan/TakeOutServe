package cn.xiaozhang.takeout.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.xiaozhang.takeout.bean.Response;
import cn.xiaozhang.takeout.bean.User;
import cn.xiaozhang.takeout.utils.CommonUtil;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		
		
		System.out.println("name:"+name+" password:"+password);
		
		
		Random random=new Random(System.currentTimeMillis());
		
		int num=random.nextInt(9999)+1;
		
		if(name==null||name.length()==0)
		{
			name="random"+num;
		}
		
		int type = Integer.parseInt(request.getParameter("type"));

		String phone=null;
		if (type==2) {
			phone = request.getParameter("phone");
		}
		
		Response res = new Response();
		res.setCode("0");
		User user = new User();
		
		user.set_id(num);
		user.setName(name);
		user.setBalance(1.0f);
		user.setDiscount(0);
		user.setIntegral(0);
		if (phone != null)
			user.setPhone(phone);
		res.setData(JSONObject.fromObject(user).toString());

		CommonUtil.renderJson(response, res);
	}
}
