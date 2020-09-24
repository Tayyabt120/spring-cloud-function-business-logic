package com.serverless.businesslogic;

/**
 * @author TAYYAB
 */
public class Currency {
    double amount;
    String from;
    String to;
    double convertedValue;

    public Currency() {
    }

    public Currency(double amount, String from, String to, double convertedValue) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.convertedValue = convertedValue;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
}
