package com.valt.sagar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.valt.sagar.dto.Family;
import com.valt.sagar.dto.Man;
import com.valt.sagar.dto.Woman;
import com.valt.sagar.service.FamilyServiceImpl;
import com.valt.sagar.service.IFamilyService;

public class ProgramFunction {

	public static void main(String[] args) {

		Function<Family, List<String>> getMens = e -> {return e.getMens().stream().map(Man::getName).collect(Collectors.toList());};
		Function<Family, List<String>> getWomens = e -> {return e.getWomens().stream().map(Woman::getName).collect(Collectors.toList());};
		
		Family family= new Family();
		List<Man> menList = new ArrayList<>();
		Man man = new Man();
		man.setAge(4);
		man.setName("Pranav");
		menList.add(man);
		man = new Man();
		man.setAge(34);
		man.setName("Giri");
		menList.add(man);

		List<Woman> womenList = new ArrayList<>();
		Woman woman = new Woman();
		woman.setAge(1);
		woman.setName("Preksha");
		womenList.add(woman);
		woman = new Woman();
		woman.setAge(31);
		woman.setName("Priya");
		womenList.add(woman);
		
		family.setMens(menList);
		family.setWomens(womenList);
		
		IFamilyService familyService = new FamilyServiceImpl();
		System.out.println(familyService.listKids(family));
		System.out.println(familyService.getFamilyMembers(family));
		System.out.println(familyService.getFamilyMembers(family, getMens));
		System.out.println(familyService.getFamilyMembers(family, getWomens));
		
	}
}
