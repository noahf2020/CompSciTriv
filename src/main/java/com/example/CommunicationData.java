package com.example;

import java.io.Serializable;
import java.net.InetAddress;

public class CommunicationData implements Serializable {
    private static final long serialVersionUID = 1234567890L;

    String QuestionNumber;
    String AnswerNumber;
    String fromIPAddress;

    public CommunicationData(String questionNumber, String answerNumber, String fromIPAddress) {
        this.QuestionNumber = questionNumber;
        this.AnswerNumber = answerNumber;
        this.fromIPAddress = fromIPAddress;
    }

    public String getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        QuestionNumber = questionNumber;
    }

    public String getAnswerNumber() {
        return AnswerNumber;
    }

    public void setAnswerNumber(String answerNumber) {
        AnswerNumber = answerNumber;
    }

    public void setFromIPAddress(InetAddress fromIPAddress) {
        this.fromIPAddress = fromIPAddress.getHostAddress();
    }
    public void setFromIPAddress(String fromIPAddress) {
        this.fromIPAddress = fromIPAddress;
    }
    public String getFromIPAddress() {
        return fromIPAddress;
    }
    public String toString() {
        return "Message: \"" + AnswerNumber + " from: " + fromIPAddress + " to:";
    }

}
