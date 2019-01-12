package com.valt.sagar;

public class SalesArea {

	public SalesArea(String system, String vkorg, String vtweg, String spart) {
		super();
		this.vkorg = vkorg;
		this.vtweg = vtweg;
		this.spart = spart;
		this.system = system;
	}

	String vkorg;
	public String getVkorgData() { return vkorg; }
	public String getVkorg() { return vkorg; }

	String vtweg;
	public String getVtwegData() { return vtweg; }
	public String getVtweg() { return vtweg; }

	String spart;
	public String getSpartData() { return spart; }
	public String getSpart() { return spart; }

	String system;
	public String getSystem() { return system; }

}
