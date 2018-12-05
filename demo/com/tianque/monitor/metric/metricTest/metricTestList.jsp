<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib uri="/permissionTag" prefix="pop"%>
<div id="metricTest">
	<div class="manage-area">
		<div class="manage-area-title">
			<h2>指标项测试列表</h2>
		</div>
		<div class="manage-area-main">
			<div id="metricTestButton">
				<div class="tc-15-action-panel">
					<div data-role="qc-search" style="" class="tc-15-search tc-15-multi-search">
						<div class="search-int-mod">
							<input id="searchText" type="text" placeholder="请输入关键词">
							<button id="serach" type="submit">
								<i class="web-icos search-ico"></i>
							</button>
						</div>
					</div>
					<pop:permissionTag ename="addMetricTest">
						<button id="add" type="button" class="tc-15-btn m">新增</button>
					</pop:permissionTag>
					<pop:permissionTag ename="deleteMetricTest">
						<button id="delete" type="button" class="tc-15-btn m">删除</button>
					</pop:permissionTag>
					<pop:permissionTag ename="updateMetricTest">
						<button id="update" type="button" class="tc-15-btn m">修改</button>
					</pop:permissionTag>
					<button id="view" type="button" class="tc-15-btn m">查看</button>
					<button id="reload" type="button" class="tc-15-btn m">刷新</button>
				</div>
			</div>
			<div style="width: 100%;">
				<table id="metricTestList"> </table>
				<div id="metricTestListPager"></div>
			</div>
			<div id="metricTestDialog"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		document.onkeydown=function(event){
			var e = event || window.event || arguments.callee.caller.arguments[0];	  
			 if(e && e.keyCode==13){ // enter 键
				 onLoad();
			}
		};
		$("#metricTestList").jqGridFunction({
			datatype : "local",
			colModel : [ {name : "id",index : "id", sortable : false,hidden : true, frozen : true},
						 {name : "createDate",index : "create_date",label:'createDate',sortable : true,align : 'center'},
						 {name : "updateDate",index : "update_date",label:'updateDate',sortable : true,align : 'center'},
						 {name : "collectTime",index : "collect_time",label:'collectTime',sortable : true,align : 'center'},
						 {name : "projectId",index : "project_id",label:'projectId',sortable : true,align : 'center'},
						 {name : "projectType",index : "project_type",label:'projectType',sortable : true,align : 'center'},
						 {name : "metric",index : "metric",label:'metric',sortable : true,align : 'center'},
						 {name : "tags",index : "tags",label:'tags',sortable : true,align : 'center'},
						 {name : "cycle",index : "cycle",label:'cycle',sortable : true,align : 'center'},
						 {name : "collectTimestamp",index : "collect_timestamp",label:'collectTimestamp',sortable : true,align : 'center'},
						 {name : "value",index : "value",label:'value',sortable : true,align : 'center'},
			],
			multiselect : true,
			height:$(document).height()-$("div.manage-area-title").height()-$("#metricTestButton").height()-138,
			onSelectRow : function() {
			},
			ondblClickRow: showMetricTest
		});
		function showMetricTest(rowId){
			$('#metricTestDialog').createDialog({	  
				width: 600,							
				height: 500,
				title:'查看指标项测试',
				url:'/metricTest/dispatch?mode=view&id='+rowId,	 
				buttons: {
					"关闭" : function(){
						$(this).dialog("close");
				   }
				}
			});
		}
				
		function onLoad(){
			var text = $('#searchText').val();
			if(text=="请输入关键词"){
				text="";
			}
			var initParam = {
				"metricTest.id":1
			}
			$("#metricTestList").setGridParam({
				url:"/metricTest/findMetricTestList",
				datatype: "json",
				page:1
			});
			$("#metricTestList").setPostData(initParam);
			$("#metricTestList").trigger("reloadGrid");
		}
		
		onLoad();
		
		$("#reload").click(function(){
			$('#searchText').val("");
			onLoad();
		});
		
		$('#serach').click(function(){
			var text = $('#searchText').val();
			if(text=="请输入用户名"){
				return;
			}
			onLoad();
		});
		
		$("#add").click(function(){
			$('#metricTestDialog').createDialog({	  
				width: 600,							
				height: 500,
				title:'新增指标项测试',
				url:'/metricTest/dispatch?mode=add',	 
				buttons: {
					"保存" : function(){
						$("#maintainForm").submit();
					},
					"关闭" : function(){
						$(this).dialog("close");
				   }
				}
			});
		});
		$("#view").click(function(){
			var selectedIds = $("#metricTestList").jqGrid("getGridParam", "selarrrow");
			if (selectedIds.length !== 1) {
				$.messageBox({
					level : 'warn',
					message : '能且只能选择一条数据进行操作！'
				});
				return;
			}
			showMetricTest(selectedIds);
		});
		
		$("#update").click(function(){
			var selectedIds = $("#metricTestList").jqGrid("getGridParam", "selarrrow");
			if (selectedIds.length !== 1) {
				$.messageBox({
					level : 'warn',
					message : '能且只能选择一条数据进行操作！'
				});
				return;
			}
			$('#metricTestDialog').createDialog({	  
				width: 600,							
				height: 500,
				title:'修改指标项测试',
				url:'/metricTest/dispatch?mode=update&id='+selectedIds,	 
				buttons: {
					"保存" : function(){
						$("#maintainForm").submit();
					},
					"关闭" : function(){
						$(this).dialog("close");
				   }
				}
			});
	   });
		
		$("#delete").click(function(){
			if(!hasRowSelected()){
				$.messageBox({level:'warn',message:"请选择一条数据再进行操作！"});
				return;
			}
			$.confirm({
				title:"确认删除",
				message:"该条信息删除后,将无法恢复,您确认删除该条信息吗?",
				width:400,
				okFunc:function(){
					deleteData();
				}
			});
		});
		
		function deleteData(){
			$.ajax({
				url:'/metricTest/deleteMetricTestByIds',
				data:{
					"ids":getSelectedIds()
				},
				type: 'POST',
				success:function(data){
					if(data != null && data){
						$.messageBox({message:"删除成功！"});
						onLoad();
					}else{
						$.messageBox({message:data});
					}
				}
			});
		}
		
		function hasRowSelected(){
			if(null != $("#metricTestList").getGridParam("selrow")){
				return true;
			}
			return false;
		}
		
		function getSelectedIds(){
			return $("#metricTestList").jqGrid("getGridParam", "selarrrow");
		}
	});
</script>
