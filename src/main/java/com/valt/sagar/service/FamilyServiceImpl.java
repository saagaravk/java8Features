package com.valt.sagar.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.valt.sagar.dto.Family;
import com.valt.sagar.dto.Human;
import com.valt.sagar.dto.Man;
import com.valt.sagar.dto.Woman;

public class FamilyServiceImpl implements IFamilyService {

	private static Predicate<? extends Human> getKids(int age){
		return a -> {
			if(a.getAge()<age){
				return true;
			}else{
			return false;
			}
		};
	}
	
	private static Function<Family, List<String>> getMens = e -> {return e.getMens().stream().map(Man::getName).collect(Collectors.toList());};
	private static Function<Family, List<String>> getWomens = e -> {return e.getWomens().stream().map(Woman::getName).collect(Collectors.toList());};
	//private static Function<Family, List<String>> getNames = e -> {return new ArrayList<String>();	};
	@Override
	public List<? extends Human> listKids(Family family) {
		 Stream<Man> menFilter = family.getMens().stream().filter((Predicate<? super Man>) FamilyServiceImpl.getKids(5));
		 List<Man> men = menFilter.collect(Collectors.toList());
		 Stream<Woman> womenFilter = family.getWomens().stream().filter((Predicate<? super Woman>) FamilyServiceImpl.getKids(5));
		 List<Woman> women = womenFilter.collect(Collectors.toList());
		 
		 List<Human> kids = new ArrayList<>();
		 kids.addAll(men.stream().filter((Predicate<? super Man>) FamilyServiceImpl.getKids(5)).collect(Collectors.toList()));
		 kids.addAll(women.stream().filter((Predicate<? super Woman>) FamilyServiceImpl.getKids(5)).collect(Collectors.toList()));
		 System.out.println(men.size()+women.size());
		 return kids;
		 
	}
	@Override
	public List<String> getFamilyMembers(Family family) {
		List<String> names = new ArrayList<>();
		names.addAll(getMens.apply(family));
		names.addAll(getWomens.apply(family));
		return names;
	}
	
	@Override
	public List<String> getFamilyMembers(Family family, Function<Family, List<String>> function) {
		return function.apply(family);
	}

}
