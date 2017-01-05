package com.tim.common.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tim.syh on 2016/10/29.
 */
@AllArgsConstructor
@NoArgsConstructor
public class ResultSet {
	private boolean success;
	private long code;
	private List<Object> results;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Object[] getResults() {
		return this.results == null ? null : this.results.toArray();
	}

	public void setResults(List<Object> results) {
		this.results = results;
	}

	public void addResult(Object result) {
		if (this.results == null) {
			this.results = new ArrayList<Object>();
		}
		this.results.add(result);
	}
}
