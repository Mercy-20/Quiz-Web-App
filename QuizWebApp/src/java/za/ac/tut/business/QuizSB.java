/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LEBO MERCY MOGALE
 */
@Stateless
public class QuizSB implements QuizSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
    public int determineQuestionToAsk(HttpSession session) {
        int questionToAsk;
        boolean hasBeenAskedBefore;

        List<Integer> questionsAsked = (List<Integer>)session.getAttribute("questionsAsked");
        
        do {
            questionToAsk = generateQuestionToAsk();//
            
            if(hasQuestionBeenAskedBefore(questionToAsk, questionsAsked)){
                hasBeenAskedBefore = true;
           } else {
                hasBeenAskedBefore = false;
            }
        } while(hasBeenAskedBefore);
        
        return questionToAsk;
    }

    private int generateQuestionToAsk() {
        int questionToAsk = (int)Math.floor(Math.random()*5);
        
        return questionToAsk;
        //To change body of generated methods, choose Tools | Templates.
    }

    private boolean hasQuestionBeenAskedBefore(int questionToAsk, List<Integer> questionsAsked) {
        boolean isFound = true;
        int count = 0;
        
        while((count < questionsAsked.size()) && (questionsAsked.get(count) != questionToAsk)){
            count++;
        }
        
        if(count == questionsAsked.size()){
            isFound = false;
        }
        
        return isFound;
    }

    @Override
    public String getQuestion(int questionToAsk, HttpSession session) {
        List<String> questions = (List<String>)session.getAttribute("questions");
        String question = questions.get(questionToAsk);
        return question;
    }

    @Override
    public String getCorrectAnswer(HttpSession session) {
        //get the answer to the question asked
        Integer questionAskedIndex = (Integer)session.getAttribute("questionAskedIndex");
        List<String> answers = (List<String>)session.getAttribute("answers");
        String correctAnswer = answers.get(questionAskedIndex);
        return correctAnswer;        
    }

    @Override
    public String determineOutcome(String answer, String correctAnswer) {
        String outcome = "Wrong";
        
        if(answer.toUpperCase().equals(correctAnswer)){
            outcome = "Correct";
        }
        
        return outcome;
    }

    @Override
    public void validateAnswer(String answer) throws QuizException {
        if(!isValid(answer)){
            throw new QuizException(answer + " is invalid. Please enter either A, B, C or D.");
        }
    }
    
    private boolean isValid(String answer){
        boolean isValid = false;
        
        if(answer.endsWith("A") || answer.equals("B") || answer.equals("C") || answer.equals("D")){
            isValid = true;
        }
        
        return isValid;
    }
}
