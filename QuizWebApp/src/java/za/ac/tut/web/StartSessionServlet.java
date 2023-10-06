/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LEBO MERCY MOGALE
 */
public class StartSessionServlet extends HttpServlet {


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
         //start a session
        HttpSession session = request.getSession(true);

        //get name
        String name = request.getParameter("name");
        
        //update session
        initializeSession(session, name);
        
        //redirect to the QuestionServlet
        response.sendRedirect("QuestionServlet.do");       
    }

    private void initializeSession(HttpSession session, String name) {
        Integer numQuestions = 5, numQuestionsAsked = 0, numCorrectAnswers = 0, marks = 0;
        List<Integer> questionsAsked = new ArrayList<>();
        List<String> questions = getQuestions();
        List<String> answers = getAnswers();
        List<String> actualQuestionsAsked = new ArrayList<>();
        List<String> actualAnswersProvided = new ArrayList<>();
        List<String> outcomes = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        
        session.setAttribute("name", name);
        
        session.setAttribute("numQuestions", numQuestions);
        session.setAttribute("numQuestionsAsked", numQuestionsAsked);
        session.setAttribute("numCorrectAnswers", numCorrectAnswers);
        session.setAttribute("questions", questions);
        session.setAttribute("answers", answers);
        session.setAttribute("questionsAsked", questionsAsked);
        session.setAttribute("marks", marks);
        session.setAttribute("actualQuestionsAsked", actualQuestionsAsked);
        session.setAttribute("actualAnswersProvided", actualAnswersProvided);
        session.setAttribute("outcomes", outcomes);
        session.setAttribute("correctAnswers", correctAnswers);
    }

    private List<String> getQuestions() {
        List<String> questions = new ArrayList<>();
        String question1 = "What is A | B if A = true and B = false?<br>" +
                              "A. true<br>" +
                              "B. false<br>" +
                              "C. !true<br>" +
                              "D. false!";
        String question2 = "What is A & B if A = true and B = false?<br>" +
                              "A. true<br>" +
                              "B. false<br>" +
                              "C. !false<br>" +
                              "D. false!";
        String question3 = "What is !(A & B) if A = true and B = false?<br>" +
                              "A. true<br>" +
                              "B. false<br>" +
                              "C. !true<br>" +
                              "D. true! ";
        String question4 = "What is !(A | B) if A = true and B = false?<br>" +
                              "A. true<br>" +
                              "B. false<br>" +
                              "C. !false<br>" +
                              "D. false!";
        String question5 = "What is (!A & B) if A = true and B = false?<br>" +
                              "A. true<br>" +
                              "B. false<br>" +
                              "C. !false<br>" +
                              "D. false!";
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        
        return questions;
    }

    private List<String> getAnswers() {
        List<String> answers = new ArrayList<>();
        
        answers.add("A");
        answers.add("B");
        answers.add("A");
        answers.add("B");
        answers.add("B");
    
        return answers;
    }


}
