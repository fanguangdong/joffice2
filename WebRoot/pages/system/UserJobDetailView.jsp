<%@ page pageEncoding="utf-8" import="com.htsoft.core.util.AppUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.htsoft.oa.service.system.UserJobService,com.htsoft.oa.model.system.UserJob" %>
<%@ page import="com.htsoft.oa.model.hrm.Job" %>
<%@ page import="java.util.List,java.util.ArrayList"%>
<!-- 
	description : 根据userId查询该员工的所有职位信息
	author : 宏天软件
	updater : YHZ
	company : www.jee-soft.cn
	createtime : 2011-1-14AM
 -->
<%
	Long userId = new Long(request.getParameter("userId"));
	UserJobService ujs = (UserJobService) AppUtil.getBean("userJobService");
	List<UserJob> list = ujs.findByUserIdJobs(userId);
	//用户名称
	request.setAttribute("username", list.get(0).getAppUser().getUsername()); 
	// 主职位
	String isMain = null; //默认为空
	for(int i=0;i<list.size();i++){
		UserJob j = list.get(i);
		if (j.getIsMain() != null && j.getIsMain().equals(UserJob.ISMIAN)){ //主职位
			isMain = j.getJob().getJobName();
			list.remove(i);
		}
	}
	request.setAttribute("jobName", isMain); //主职位
	if(list == null || list.size() < 1)
		request.setAttribute("list",null);
	else
		request.setAttribute("list",list);
%>
<table class="table-info" align="center" cellpadding="0" cellspacing="1" width="98%">
	<tr>
		<th style="width:20%;">用户名称：</th>
		<td>${username }</td>
	</tr>
	<tr>
		<th style="width:20%;">主职位：</th>
		<c:if test="${empty jobName}">
			<td style="color:red;">NULL</td>
		</c:if>
		<c:if test="${not empty jobName}">
			<td>${jobName }</td>
		</c:if>
	</tr>
	<tr>
		<th style="width:20%;">副职位：</th>
		<c:if test="${not empty list}" >
			<td>
				<c:forEach var="userJob" items="${list}">
					${userJob.job.jobName }<br/>
				</c:forEach>
			</td>
		</c:if>
		<c:if test="${empty list}">
			<td style="color:red;">NULL</td>
		</c:if>
	</tr>
</table>