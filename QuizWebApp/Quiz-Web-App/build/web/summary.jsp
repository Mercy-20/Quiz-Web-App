<%-- 
    Document   : summary
    Created on : 20 Apr 2023, 2:21:06 PM
    Author     : LEBO MERCY MOGALE
--%>

<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Page</title>
    </head>
    <body>
        <h1>Summary</h1>
        <%
            DecimalFormat df = new DecimalFormat("0%");
            String name = (String)session.getAttribute("name");
            Integer numQuestionsAsked = (Integer)session.getAttribute("numQuestionsAsked");
            Integer numCorrectAnswers = (Integer)session.getAttribute("marks");
            Double percMarkObtained  = ((double)numCorrectAnswers/numQuestionsAsked);    
            
            List<String> questionsAsked = (List<String>)session.getAttribute("actualQuestionsAsked");
            List<String> answersProvided = (List<String>)session.getAttribute("actualAnswersProvided");
            List<String> correctAnswers  = (List<String>)session.getAttribute("correctAnswers");
            List<String> outcomes  = (List<String>)session.getAttribute("outcomes");
            
            String data = "";
            
            for(int i = 0; i < questionsAsked.size(); i++){
                data = data + "<b>" + "Question " + (i + 1) + "</b>" + "<br>" + 
                        questionsAsked.get(i) + "<br>" + 
                       "<b>" + "Your answer: " + "</b>" + answersProvided.get(i) + "<br>" +
                       "<b>" + "Correct answer: " + "</b>" + correctAnswers.get(i) + "<br>" +
                       "<b>" + "Outcome: " + "</b>" + outcomes.get(i) + "<br><br>";
            }
        %>
        <p>
            <b>Name:<b> <%=name%> <br>
            <b>Number of questions asked:</b> <%=numQuestionsAsked%> <br>
            <b>Number of correct answers:</b> <%=numCorrectAnswers%> <br>
            <b>Percentage mark obtained :</b> <%=df.format(percMarkObtained)%> <br><br>
            <%=data%>
        </p>
        <p>Click <a href="index.html">here</a> to go back to home page</p>
    </body>
</html>
