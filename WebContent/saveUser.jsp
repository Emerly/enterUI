<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>��½����</title>


</head>
    <base href="<%=basePath%>">
    
    <title>���ý���</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<% String message = (String)(request.getAttribute("message")); %>
  </head>
  
  <body>
   <form  method="POST" name="Login" action="saveUserServlet">
     <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
      <td align="center" valign="middle"> 
		<table width="30%" bgcolor=" #F0F8FF" style="border-color" >
		  <tr align = "center">
                 <td colspan="3"  style = "color:red; font-size:34px;">��������</td>    
            </tr>
			<tr align=center>
				<td>�û���:</td>
				<td><input type="input" name="username" id="username">
				</td>
				</td>
			</tr>
			<tr align=center>
				<td>�� ��:</td>
				<td><input type="password" name="password" id="password">
				</td>
			</tr>
			<tr></tr>
			<tr align="right">
				<td>
				<span style = "color:red; font-size:13px;" id = "td2"><%=message %></span>
				</td>
				</tr>
			
			<tr align=center>
				<td colspan="2"><input type="submit" value="�� ¼"  />
					<input type="reset" value="�� ��" />
				</td>
			</tr>
			
				</td>

		</table>
		</td>
	 </tr>
	 </table>
	</form>
  </body>
</html>
