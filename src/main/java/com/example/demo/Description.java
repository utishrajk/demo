package com.example.demo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Description implements Serializable {

	private String get;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public Description() {
		this.get= "";
	}
	
	public Description(String str) {
		this.get = str;
	}

	public String getGet() {
		return get;
	}

	public void setGet(String get) {
		this.get = get;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}