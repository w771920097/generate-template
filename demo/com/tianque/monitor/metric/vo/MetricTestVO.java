package com.tianque.monitor.metric.vo;

import com.tianque.base.vo.BaseVO;
import com.tianque.monitor.metric.domain.MetricTest;

/**
 * MetricTestVO
 * @author wangsihong@hztianque.com
 * @date 2018年12月05日 17:39:07 
 */
public class MetricTestVO extends BaseVO{

	//TODO serialVersionUID

	private MetricTest metricTest;

	public MetricTest getMetricTest() {
		return metricTest;
	}

	public void setMetricTest(MetricTest metricTest) {
		this.metricTest = metricTest;
	}

	@Override
	public String toString() {
		return super.toString() + "MetricTestVO [metricTest=" + metricTest + "]";
	}
}
