<%-- 
    Document   : question
    Created on : 20 Apr 2023, 2:19:35 PM
    Author     : LEBO MERCY MOGALE
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Page</title>
    </head>
    <body>
        <%
            String question = (String)session.getAttribute("question");
            Integer numQuestionsAsked = (Integer)session.getAttribute("numQuestionsAsked");
            Integer numQuestions = (Integer)session.getAttribute("numQuestions");
            String name = (String)session.getAttribute("name");
        %>
        
        <h1>Question <%=numQuestionsAsked%> of <%=numQuestions%></h1>
        <h3>[Test taker: <%=name%>]</h3>
        <p>
            Please answer the following question:
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