package com.tianque.monitor.metric.domain;

import com.tianque.base.domain.BaseDomain;

/**
 * MetricTest
 * @author wangsihong@hztianque.com
 * @date 2018年11月07日08:33:11
 */
public class MetricTest extends BaseDomain {

	//TODO serialVersionUID

	/**
	 * 
	 */
	private Long collectTimestamp;

	/**
	 * 
	 */
	private Date collectTime;

	/**
	 * 
	 */
	private String metric;

	/**
	 * 
	 */
	private String projectType;

	/**
	 * 
	 */
	private Double value;

	/**
	 * 
	 */
	private Long cycle;

	/**
	 * 
	 */
	private Long projectId;

	/**
	 * 
	 */
	private String tags;

	public Long getCollectTimestamp() {
		return collectTimestamp; 
	}

	public void setCollectTimestamp(Long collectTimestamp) {
		this.collectTimestamp = collectTimestamp;
	}

	public Date getCollectTime() {
		return collectTime; 
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public String getMetric() {
		return metric; 
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getProjectType() {
		return projectType; 
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public Double getValue() {
		return value; 
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getCycle() {
		return cycle; 
	}

	public void setCycle(Long cycle) {
		this.cycle = cycle;
	}

	public Long getProjectId() {
		return projectId; 
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTags() {
		return tags; 
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return super.toString()+"MetricTest ["
			+ "projectType=" + projectType + ", metric=" + metric + ", tags=" + tags + ", value=" + value + ", cycle=" + cycle + ", projectId=" + projectId + ", collectTimestamp=" + collectTimestamp + ", collectTime=" + collectTime + ", "
			+ "]";
	}
}
