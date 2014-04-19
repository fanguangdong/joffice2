<%@page import="java.io.Serializable"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.htsoft.oa.service.flow.ProcessFormService"%>
<%@page import="com.htsoft.oa.model.flow.ProcessRun"%>
<%@page import="com.htsoft.core.util.AppUtil"%>
<%@page import="com.htsoft.oa.service.flow.ProcessRunService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//显示流程的明细，（为流程的标题及内容）
	//传入piId,即流程实例ID
	
	List pfList=(List)request.getAttribute("pfList");
	if(pfList==null){
		String runId=request.getParameter("runId");
		ProcessRunService processRunService=(ProcessRunService)AppUtil.getBean("processRunService");
		ProcessFormService processFormService=(ProcessFormService)AppUtil.getBean("processFormService");
		if(StringUtils.isNotEmpty(runId)){
			ProcessRun processRun=processRunService.get(new Long(runId));
			
			//取到绑定的实体 TODO
			
		}
		pfList=processFormService.getByRunId(new Long(runId));
		request.setAttribute("pfList", pfList);
		
		
		
	}
	
%>
	<table class="table-info" cellpadding="0" cellspacing="1" width="96%">
		<tr>
			<th colspan="8"><h2>流程审批信息</h2></th>
		</tr>
		<tr>
			<th width="30">序号</th>
			<th>任务名</th>
			<th>执行人</th>
			<th>开始于</th>
			<th>结束于</th>
			<th>耗时(秒)</th>
			<th>状态</th>
			<th>审批意见</th>
		</tr>
		<c:forEach items="${pfList}" var="processForm" varStatus="i">
		<tr>
			<td align="center">${i.count}</td>
			<td>${processForm.activityName}</td>
			<td>${processForm.creatorName}</td>
			<td><fmt:formatDate value="${processForm.createtime}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td>
				<c:if test="${not empty processForm.endtime}">
					<fmt:formatDate value="${processForm.endtime}" pattern="yyyy-MM-dd HH:mm"/>
				</c:if>
			</td>
			<td>
				${processForm.durTimes/1000}
			</td>
			<td>
				<c:choose>
					<c:when test="${processForm.status==1}"><font color='green'>审批通过</font></c:when>
					<c:when test="${processForm.status==-1}"><font color='red'>驳回</font></c:when>
					<c:when test="${processForm.status==0}">未审批</c:when>
				</c:choose>
			</td>
			<td>${processForm.comments}</td>
		</tr>
		</c:forEach>
	</table>
	<c:if test="${not empty entity}">
	<table class="table-info" cellpadding="0" cellspacing="1" width="96%">
		<tr>
			<th>
				业务数据
			</th>
		</tr>
		<tr>
			<td>
				${entityHtml}
			</td>
		</tr>
	</table>
	</c:if>
