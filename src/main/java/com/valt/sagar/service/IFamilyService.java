package com.valt.sagar.service;

import java.util.List;
import java.util.function.Function;

import com.valt.sagar.dto.Family;
import com.valt.sagar.dto.Human;

public interface IFamilyService {

	public List<? extends Human> listKids(Family family);
	
	public List<String> getFamilyMembers(Family family);
	
	public List<String> getFamilyMembers(Family family,Function<Family, List<String>> function);
}
