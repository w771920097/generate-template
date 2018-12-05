package com.tianque.monitor.metric.domain;

import com.tianque.base.domain.BaseDomain;

/**
 * MetricTest
 * @author wangsihong@hztianque.com
 * @date 2018年12月05日 17:39:07
 */
public class MetricTest extends BaseDomain {

	//TODO serialVersionUID

	/**
	 * 采集时间
	 */
	private Date collectTime;

	/**
	 * 
	 */
	private Long projectId;

	/**
	 * 
	 */
	private String projectType;

	/**
	 * 
	 */
	private String metric;

	/**
	 * 
	 */
	private String tags;

	/**
	 * 
	 */
	private Long cycle;

	/**
	 * 
	 */
	private Long collectTimestamp;

	/**
	 * 
	 */
	private Double value;

	public Date getCollectTime() {
		return collectTime; 
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public Long getProjectId() {
		return projectId; 
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectType() {
		return projectType; 
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getMetric() {
		return metric; 
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getTags() {
		return tags; 
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Long getCycle() {
		return cycle; 
	}

	public void setCycle(Long cycle) {
		this.cycle = cycle;
	}

	public Long getCollectTimestamp() {
		return collectTimestamp; 
	}

	public void setCollectTimestamp(Long collectTimestamp) {
		this.collectTimestamp = collectTimestamp;
	}

	public Double getValue() {
		return value; 
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return super.toString()+"MetricTest ["
			+ "collectTime=" + collectTime + ", projectId=" + projectId + ", projectType=" + projectType + ", metric=" + metric + ", tags=" + tags + ", cycle=" + cycle + ", collectTimestamp=" + collectTimestamp + ", value=" + value + ", "
			+ "]";
	}
}
