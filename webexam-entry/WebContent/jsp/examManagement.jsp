<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, edisonbetter.webexam.domain.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Management</title>
<script type="text/javascript">
	function check(action) {
		document.forms[0].action = "examAction!" + action + ".action";
		document.forms[0].submit();
	}
</script>
</head>

<%
	List<Exam> examList = (List)request.getAttribute("examList");
	int m = 0;
%>
<body>
	<form name="crud" action="" method="post">
		<table width="776" border="1">
			<tr>
				<td height="38" colspan="4"> <div align="center">Message: ${msg}</div></td>
			</tr>
			<tr>
				<td height="27">Select</td>
				<td width="320"><div align="right">Exam</div></td>
				<td width="420"><div align="right">Configure exam</div></td>
				<td width="320"><div align="right">Take Exam</div></td>
			</tr>
			
			<%
				for(int i=0; examList != null && i<examList.size(); i++){
					Exam exam = examList.get(i);
					m++;
			%>
			<tr>
				<td><input type="checkbox" name="checkbox"></td>
				<td><input type="text" name="name" value="<%=exam.getName()%>"></td>
				<td><input type="button" name="createItem" value="Configure exam" onClick="return check('createQuestion')"></td>
				<td><input type="button" name="exam" value="Take exam" onclick="return check('exam')"></td>
			</tr>
			<%
				}	
			%>
			
			<tr>
				<td><input type="checkbox" name="checkbox"></td>
				<td><input type="text" name="name" value=""></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td colspan="4"><div align="center"></div>
				<div align="center">
					<input type="button" name="create" value="Create Exam" onclick="return check('create')">
					<input type="button" name="update" value="Update Exam" onclick="return check('update')">
					<input type="button" name="delete" value="Delete Exam" onclick="return check('delete')">
				</div></td>
			</tr>
		</table>
	</form>
</body>
</html>