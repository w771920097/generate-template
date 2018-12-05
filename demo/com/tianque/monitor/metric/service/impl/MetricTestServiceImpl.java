package com.tianque.monitor.metric.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianque.core.base.util.StringUtil;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.monitor.metric.domain.MetricTest;
import com.tianque.monitor.metric.mapper.MetricTestMapper;
import com.tianque.monitor.metric.service.MetricTestService;
import com.tianque.monitor.metric.vo.MetricTestVO;

/**
 * MetricTestServiceImpl
 * @author wangsihong@hztianque.com
 * @date 2018年12月05日 17:39:07
 */
@Service("metricTestService")
public class MetricTestServiceImpl implements MetricTestService {

	@Autowired
	private MetricTestMapper metricTestMapper;

	@Override
	public MetricTest addMetricTest(MetricTest metricTest) {
		if (metricTest == null) {
			throw new BusinessValidationException("新增指标项测试参数为空");
		}
		try {
			metricTestMapper.addMetricTest(metricTest);
			return metricTest;
		} catch (Exception e) {
			throw new ServiceValidationException("新增指标项测试出错"+metricTest, e);
		}
	}

	@Override
	public MetricTest updateMetricTest(MetricTest metricTest) {
		if (metricTest == null || metricTest.getId() == null) {
			throw new BusinessValidationException("更新指标项测试参数为空");
		}
		try {
			metricTestMapper.updateMetricTest(metricTest);
			return metricTest;
		} catch (Exception e) {
			throw new ServiceValidationException("更新指标项测试出错"+metricTest, e);
		}
	}

	@Override
	public Boolean deleteMetricTestByIds(Long[] ids) {
		if (null != ids && ids.length == 0) {
			throw new BusinessValidationException("删除指标项测试参数有误");
		}
		try {
			Long count = metricTestMapper.deleteMetricTestByIds(ids);
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServiceValidationException("删除指标项测试出错", e);
		}
	}

	@Override
	public MetricTest getMetricTestById(Long id) {
		if (null == id) {
			throw new BusinessValidationException("查询指标项测试参数错误");
		}
		try {
			return metricTestMapper.getMetricTestById(id);
		} catch (Exception e) {
			throw new ServiceValidationException("查询指标项测试出错", e);
		}
	}

	@Override
	public PageInfo<MetricTest> findMetricTestForPageHelper(
			MetricTestVO metricTestVO) {
		if (null == metricTestVO || null == metricTestVO.getMetricTest()) {
			throw new BusinessValidationException("查询指标项测试列表参数错误");
		}
		PageHelper.startPage(metricTestVO.getPage(),metricTestVO.getRows(), 
				StringUtil.joinSortFieldOrder(metricTestVO.getSidx(),metricTestVO.getSord()));
		try {
			List<MetricTest> list = metricTestMapper.findMetricTestForList(metricTestVO.getMetricTest());
			return new PageInfo<MetricTest>(list);
		} catch (Exception e) {
			throw new ServiceValidationException("查询指标项测试出错"+metricTestVO, e);
		}
	}

}
