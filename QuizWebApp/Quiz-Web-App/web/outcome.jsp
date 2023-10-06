<%-- 
    Document   : outcome
    Created on : 20 Apr 2023, 2:18:54 PM
    Author     : LEBO MERCY MOGALE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Outcome</h1>
        <%
            String question = (String)session.getAttribute("question");
            String answer = (String)session.getAttribute("answer");
            String correctAnswer = (String)session.getAttribute("correctAnswer");
            String outcome = (String)session.getAttribute("outcome");
        %>
        <p>
            Please see below the outcome.
        </p>
        <table>
            <tr>
                <td><b>Question:</b></td>
                <td><%=question%></td>
            </tr>
            <tr>
                <td><b>Your answer:</b></td>
                <td><%=answer%></td>
            </tr>
            <tr>
                <td><b>Correct answer:</b> </td>
                <td><%=correctAnswer%></td>
            </tr>
            <tr>
                <td><b>Outcome:</b> </td>
                <td><%=outcome%></td>
            </tr>
        </table>
        <p>
            Please click <a href="QuestionServlet.do">here</a> to get another question or <a href="summary.jsp">here</a> to display test summary.
        </p>
    </body>
</html>
