package com.tianque.monitor.metric.service;

import com.github.pagehelper.PageInfo;
import com.tianque.monitor.metric.domain.MetricTest;
import com.tianque.monitor.metric.vo.MetricTestVO;

/**
 * MetricTestService
 * @author wangsihong@hztianque.com
 * @date 2018年12月05日 17:45:47
 */
public interface MetricTestService {

	/**
	 * addMetricTest
	 * @param metricTest
	 * @return MetricTest    返回类型 
	 */
	MetricTest addMetricTest(MetricTest metricTest);

	/**
	 * updateMetricTest
	 * @param metricTest
	 * @return MetricTest    返回类型 
	 */
	MetricTest updateMetricTest(MetricTest metricTest);

	/**
	 * deleteMetricTestByIds
	 * @param ids
	 * @return Boolean    返回类型 
	 */
	Boolean deleteMetricTestByIds(Long[] ids);

	/**
	 * getMetricTestById
	 * @param id
	 * @return MetricTest    返回类型 
	 */
	MetricTest getMetricTestById(Long id);  

	/**
	 * findMetricTestForPageHelper
	 * @param metricTestVO
	 * @return PageInfo<MetricTest>    返回类型 
	 */
	PageInfo<MetricTest> findMetricTestForPageHelper(MetricTestVO metricTestVO);

}
