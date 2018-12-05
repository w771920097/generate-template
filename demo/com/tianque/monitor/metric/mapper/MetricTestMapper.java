package com.tianque.monitor.metric.mapper;

import java.util.List;

import com.tianque.core.mybatis.MyBatisMapper;
import com.tianque.monitor.metric.metricTest.MetricTest;

/**
 * MetricTestMapper
 * @author wangsihong@hztianque.com
 * @date 2018年12月05日 17:39:07
 */
@MyBatisMapper
public interface MetricTestMapper {

	/**
	 * addMetricTest
	 * @param metricTest   设定文件 
	 * @return void    返回类型 
	 */
	void addMetricTest(MetricTest metricTest);

	/**
	 * updateMetricTest
	 * @param metricTest   设定文件 
	 * @return void    返回类型 
	 */
	void updateMetricTest(MetricTest metricTest);

	/**
	 * deleteMetricTestByIds
	 * @param ids
	 * @return Long    返回类型 
	 */
	Long deleteMetricTestByIds(Long[] ids);

	/**
	 * getMetricTestById
	 * @param id
	 * @return MetricTest    返回类型 
	 */
	MetricTest getMetricTestById(Long id);

	/**
	 * findMetricTestForList
	 * @param metricTest
	 * @return List<MetricTest>    返回类型
	 */
	List<MetricTest> findMetricTestForList(MetricTest metricTest);

}
