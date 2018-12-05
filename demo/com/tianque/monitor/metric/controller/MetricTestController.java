package com.tianque.monitor.metric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianque.base.vo.GridPage;
import com.tianque.monitor.metric.domain.MetricTest;
import com.tianque.monitor.metric.service.MetricTestService;
import com.tianque.monitor.metric.vo.MetricTestVO;

/**
 * MetricTestController
 * @author wangsihong@hztianque.com
 * @date 2018年12月05日 17:39:07
 */
@Controller
@RequestMapping(value = "/metricTest")
public class MetricTestController {

	private static final String ADD = "add";
	private static final String MODE = "mode";
	private static final String VIEW = "view";
	private static final String UPDATE = "update";

	@Autowired
	private MetricTestService metricTestService;

	@RequestMapping(value = "/dispatch")
	public String dispatch(String mode, Long id, ModelMap modelMap) {
		modelMap.put(MODE, mode);
		if (ADD.equals(mode)) {
		//TODO 设置路径
		return "/metricTest/metricTestDlg";
	}else if(UPDATE.equals(mode) || VIEW.equals(mode)) {
		modelMap.put("metricTest", metricTestService.getMetricTestById(id));
		//TODO 设置路径
		return "/metricTest/metricTestDlg";
	}
	//TODO 设置路径
	return "/metricTest/metricTestDlg";
	}

	@PermissionFilter(ename = "metricTest")
	@RequestMapping(value = "/listPage")
	public String listPage() {
		return "/metricTest/metricTestList";
	}

	@RequestMapping(value = "/addMetricTest")
	@ResponseBody
	public MetricTest addMetricTest(@ModelAttribute MetricTest metricTest) {
		return metricTestService.addMetricTest(metricTest);
	}

	@RequestMapping(value = "/updateMetricTest")
	@ResponseBody
	public MetricTest updateMetricTest(@ModelAttribute MetricTest metricTest) {
		return metricTestService.updateMetricTest(metricTest);
	}

	@RequestMapping(value = "/deleteMetricTestByIds")
	@ResponseBody
	public Boolean deleteMetricTestByIds(@RequestParam(value = "ids[]", required = true) Long[] ids) {
		metricTestService.deleteMetricTestByIds(ids);
		return true;
	}

	@RequestMapping(value = "/findMetricTestList")
	@ResponseBody
	public GridPage<MetricTestVO> findMetricTestList(
			@ModelAttribute MetricTestVO metricTestVO) {
		GridPage<MetricTestVO> gridPage = new GridPage<MetricTestVO>(
				metricTestService.findMetricTestForPageHelper(metricTestVO));
		return gridPage;
	}

}
