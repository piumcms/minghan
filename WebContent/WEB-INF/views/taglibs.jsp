<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://shiro.apache.org/tags" %> 
<%@ taglib uri="/WEB-INF/tld/ll.tld" prefix="ll" %>
<c:set var="ly" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	var ctx = '<%=request.getContextPath() %>';
</script>

