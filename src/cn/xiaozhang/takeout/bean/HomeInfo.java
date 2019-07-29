package cn.xiaozhang.takeout.bean;

import java.util.List;


public class HomeInfo {
	Head head;
	List<HomeItem> body;

	
	public HomeInfo(Head head, List<HomeItem> body) {
		super();
		this.head = head;
		this.body = body;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public List<HomeItem> getBody() {
		return body;
	}

	public void setBody(List<HomeItem> body) {
		this.body = body;
	}
}
