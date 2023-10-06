<%-- 
    Document   : invalidAnswer
    Created on : 20 Apr 2023, 2:16:04 PM
    Author     : LEBO MERCY MOGALE
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Out Of Range Page</title>
    </head>
    <body>
        <h1>Out of range</h1>
        <%
            String ans = (String)session.getAttribute("answer");
            String question = (String)session.getAttribute("question");
        %>
        <p>
            The provided answer is <%=ans%>. It is not part of the valid letters(A, B, C or D).<br>
            Please answer the question correctly.
        </p>
        <form action="AnswerServlet.do" method="POST">
            <table>
                <tr>
                    <td></td>
                    <td><%=question%></td>
                </tr>
                <tr>
                    <td>Answer (Enter either A, B, C or D):  </td>
                    <td><input type="text" name="ans"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"/></td>
                </tr>
            </table>
        </form>        
    </body>
</html>