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
public class QuestionServlet extends HttpServlet {
@EJB
    private QuizSBLocal quizSB;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("Name of student: " + (String)session.getAttribute("name"));
        int questionToAsk = quizSB.determineQuestionToAsk(session);        
        String question = quizSB.getQuestion(questionToAsk, session);
        
        updateSession(session, questionToAsk, question);
        System.out.println("Hi...");
        
        RequestDispatcher disp = request.getRequestDispatcher("question.jsp");
        disp.forward(request, response);
    }

    private void updateSession(HttpSession session, int questionToAsk, String question) {
        Integer questionAskedIndex = questionToAsk;
        session.setAttribute("question", question);
        List<Integer> questionsAsked = (List<Integer>)session.getAttribute("questionsAsked");
        questionsAsked.add(questionToAsk);
        session.setAttribute("questionsAsked", questionsAsked);
        session.setAttribute("questionAskedIndex", questionAskedIndex);
        
        Integer numQuestionsAsked = (Integer)session.getAttribute("numQuestionsAsked");
        numQuestionsAsked++;
        session.setAttribute("numQuestionsAsked", numQuestionsAsked);
        
        List<String> actualQuestionsAsked = (List<String>)session.getAttribute("actualQuestionsAsked");
        actualQuestionsAsked.add(question);
        session.setAttribute("actualQuestionsAsked", actualQuestionsAsked);
    }

}
