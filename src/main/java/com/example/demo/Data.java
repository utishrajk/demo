package com.example.demo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data implements Serializable {

	private List<Link> link = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<Link> getLink() {
		return link;
	}

	public void setLink(List<Link> link) {
		this.link = link;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}