package com.example;

import java.io.Serializable;
import java.net.InetAddress;

public class CommunicationData implements Serializable {
    private static final long serialVersionUID = 1234567890L;

    String from;
    String to;
    String answer;
    Integer type;
    String fromIPAddress;

    public CommunicationData(String from, String to, String answer, Integer type) {
        this.from = from;
        this.to = to;
        this.answer = answer;
        this.type = type;
        //gtesting
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String message) {
        this.answer = message;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFromIPAddress() {
        return fromIPAddress;
    }

    public void setFromIPAddress(InetAddress fromIPAddress) {
        this.fromIPAddress = fromIPAddress.getHostAddress();
    }

    public String toString() {
        return "Message: \"" + answer + " from: " + from + fromIPAddress + " to:" + to;
    }

}
