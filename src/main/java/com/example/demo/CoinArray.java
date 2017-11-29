package com.example.demo;

import java.io.Serializable;
import java.util.List;

public class CoinArray implements Serializable {
	
	List<Coin> list;

	public List<Coin> getList() {
		return list;
	}

	public void setList(List<Coin> list) {
		this.list = list;
	}
	
	

}
