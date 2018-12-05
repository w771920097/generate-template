<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container_24">
	<form id="maintainForm" method="post" action="">
		<input id="id" name="id" type="hidden" value="${metricTest.id}" />
		<input id="mode" name="mode" type="hidden" value="${mode}" />
		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">collectTime：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="collectTime" id="collectTime" maxlength="20"
				value="${metricTest.collectTime}"
				class="text-input {required:true,messages:{required:'请输入collectTime'}}">
		</div>

		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">projectId：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="projectId" id="projectId" maxlength="20"
				value="${metricTest.projectId}"
				class="text-input {required:true,messages:{required:'请输入projectId'}}">
		</div>

		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">projectType：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="projectType" id="projectType" maxlength="20"
				value="${metricTest.projectType}"
				class="text-input {required:true,messages:{required:'请输入projectType'}}">
		</div>

		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">metric：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="metric" id="metric" maxlength="20"
				value="${metricTest.metric}"
				class="text-input {required:true,messages:{required:'请输入metric'}}">
		</div>

		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">tags：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="tags" id="tags" maxlength="20"
				value="${metricTest.tags}"
				class="text-input {required:true,messages:{required:'请输入tags'}}">
		</div>

		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">cycle：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="cycle" id="cycle" maxlength="20"
				value="${metricTest.cycle}"
				class="text-input {required:true,messages:{required:'请输入cycle'}}">
		</div>

		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">collectTimestamp：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="collectTimestamp" id="collectTimestamp" maxlength="20"
				value="${metricTest.collectTimestamp}"
				class="text-input {required:true,messages:{required:'请输入collectTimestamp'}}">
		</div>

		<div class="grid_5 label-right">
			<em class="form-req">*</em> <label class="form-lb1">value：</label>
		</div>
		<div class="grid_7">
			<input type="text" name="value" id="value" maxlength="20"
				value="${metricTest.value}"
				class="text-input {required:true,messages:{required:'请输入value'}}">
		</div>

		<div class="clearLine">&nbsp;</div>
	</form>
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				var mode = $("#mode").val();
				if (mode == "add") {
					$("#maintainForm").attr("action",
							"/metricTest/addMetricTest");
				} else if (mode == "update") {
					$("#maintainForm").attr("action",
							"/metricTest/updateMetricTest");
				} else if (mode == "view") {
					$(".form-txt").attr("disabled", true);
					$(".form-checkBox").attr("disabled", true);
				}
				$("#maintainForm").formValidate(
						{
							rules : {},
							messages : {},
							submitHandler : function(form) {
								$(form).ajaxSubmit(
										{
											success : function(data) {
												if (data.message != undefined) {
													$.messageBox({
														message : data,
														level : "error"
													});
													return;
												}
												if (mode == "add") {
													$.messageBox({
														message : "新增指标项测试成功!"
													});
												} else if (mode == "update") {
													$.messageBox({
														message : "修改指标项测试成功!"
													});
												}

												$("#metricTestList").trigger(
														"reloadGrid");
												$("#metricTestDialog").dialog(
														"close");
											},
											error : function(XMLHttpRequest,
													textStatus, errorThrown) {
												alert("提交数据时发生错误");
											}
										});
							}
						});
			});
</script>
