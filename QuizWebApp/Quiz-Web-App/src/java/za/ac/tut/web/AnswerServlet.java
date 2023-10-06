/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.QuizSBLocal;

/**
 *
 * @author LEBO MERCY MOGALE
 */
public class AnswerServlet extends HttpServlet {
@EJB
    private QuizSBLocal quizSB;
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession();
            String answer = request.getParameter("ans");
            
            //validate answer
            if(!isAnswerValid(answer)){
                session.setAttribute("answer", answer);
                response.sendRedirect("invalidAnswer.jsp");
            } else {
            
            String correctAnswer = quizSB.getCorrectAnswer(session);
            String outcome = quizSB.determineOutcome(answer, correctAnswer);
            Integer marks = updateMarks(outcome, session);
            
            updateSession(session, answer, correctAnswer, outcome, marks);
            Integer cnt = (Integer)session.getAttribute("numQuestionsAsked");
            String location = "outcome.jsp";
            
            if(cnt == 5){
                location = "summary.jsp";
            }
            
           
            RequestDispatcher disp = request.getRequestDispatcher(location);
            disp.forward(request, response);
        }

    }

    private Integer updateMarks(String outcome, HttpSession session) {
        Integer currentMarks = (Integer)session.getAttribute("marks");
        if(outcome.equals("Correct")){
            currentMarks = currentMarks + 1;
        } 
        
        return currentMarks;
    }

    private void updateSession(HttpSession session, String answer, String correctAnswer, String outcome, Integer marks) {
        session.setAttribute("answer", answer);
        session.setAttribute("correctAnswer", correctAnswer);
        session.setAttribute("outcome", outcome);
        session.setAttribute("marks", marks);
        
        List<String> actualAnswersProvided = (List<String>)session.getAttribute("actualAnswersProvided");
        actualAnswersProvided.add(answer);
        session.setAttribute("actualAnswersProvided", actualAnswersProvided);
        
        List<String> outcomes = (List<String>)session.getAttribute("outcomes");
        outcomes.add(outcome);
        session.setAttribute("outcomes", outcomes);
        
        List<String> correctAnswers = (List<String>)session.getAttribute("correctAnswers");
        correctAnswers.add(correctAnswer);
        session.setAttribute("correctAnswers", correctAnswers);
    }
    
    private boolean isAnswerValid(String answer){
        boolean isValid = false;
        
        if(answer.endsWith("A") || answer.equals("B") || answer.equals("C") || answer.equals("D")){
            isValid = true;
        }
        
        return isValid;
        
    }

    

}
