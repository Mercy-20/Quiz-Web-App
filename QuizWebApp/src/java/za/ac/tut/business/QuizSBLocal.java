/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package za.ac.tut.business;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LEBO MERCY MOGALE
 */
@Local
public interface QuizSBLocal {
    public int determineQuestionToAsk(HttpSession session);

    public String getQuestion(int questionToAsk, HttpSession session);

    public String getCorrectAnswer(HttpSession session);

    public String determineOutcome(String answer, String correctAnswer);

    void validateAnswer(String answer) throws QuizException;
}
