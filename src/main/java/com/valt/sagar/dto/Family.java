package com.valt.sagar.dto;

import java.util.List;

public class Family {

	private List<Man> mens;
	private List<Woman> womens;
	
	public List<Man> getMens() {
		return mens;
	}
	public void setMens(List<Man> mens) {
		this.mens = mens;
	}
	public List<Woman> getWomens() {
		return womens;
	}
	public void setWomens(List<Woman> womens) {
		this.womens = womens;
	}
	
	
}
