package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.File;

public class ExamRequest {

	private Consult ordered;
	private List<Consult> received;
	private String type;
	private File results;

	public Consult getOrdered() {
		return ordered;
	}

	public List<Consult> getReceived() {
		return received;
	}

	public String getType() {
		return type;
	}

	public File getResults() {
		return results;
	}

	public void setOrdered(Consult ordered) {
		this.ordered = ordered;
	}

	public void setReceived(List<Consult> received) {
		this.received = received;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setResults(File results) {
		this.results = results;
	}

}
