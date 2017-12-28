package com.cts.tririga.entity;



public class Article { 
	
	private int om_pkg_id;
	
    private String om_pkg_name;
	public int getOm_pkg_id() {
		return om_pkg_id;
	}
	public void setOm_pkg_id(int om_pkg_id) {
		this.om_pkg_id = om_pkg_id;
	}
	public String getOm_pkg_name() {
		return om_pkg_name;
	}
	public void setOm_pkg_name(String om_pkg_name) {
		this.om_pkg_name = om_pkg_name;
	}
    
	@Override
    public String toString() {
        return "OM{" +
                "id=" + om_pkg_id +
                ", name='" + om_pkg_name +
                '}';
    }
}