package com.valt.sagar;

import java.util.function.Predicate;

public class ProgramPredicate {

	private static Predicate<? super SalesArea> areaFilter = ProgramPredicate.areaFilter("P92", "8232", "1E", "00");

	public static void main(String[] args) {
		
		SalesArea salesArea = new SalesArea("P92", "8232", "1E", "00");
		System.out.println(areaFilter.test(salesArea));
		Predicate<String> name = ProgramPredicate.isName("Sagar");
		System.out.println(name.test("Sagar"));
	}
	
	public static Predicate<? super SalesArea> areaFilter(String sys, String vkorg, String vtweg, String spart) {
		return sa -> {
			if(sys!=null && !sys.equals(sa.getSystem())) return false;
			if(vkorg!=null && !vkorg.equals(sa.getVkorg())) return false;
			if(vtweg!=null && !vtweg.equals(sa.getVtweg())) return false;
			if(spart!=null && !spart.equals(sa.getSpart())) return false;
			return true;
		};
	}
	
	public static Predicate<String> isName(String str){
		return s->s.equalsIgnoreCase(str);
		
	}
}
