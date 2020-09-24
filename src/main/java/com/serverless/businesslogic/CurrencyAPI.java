package com.serverless.businesslogic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TAYYAB
 */
public class CurrencyAPI implements Serializable {
    Map<String,Double> rates = new HashMap<String,Double>();
    String base;
    String date;

    public CurrencyAPI(Map<String, Double> rates, String base, String date) {
        this.rates.putAll(rates);
        this.base = base;
        this.date = date;
    }

    public CurrencyAPI() {
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
