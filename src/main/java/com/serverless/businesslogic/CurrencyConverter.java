package com.serverless.businesslogic;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author TAYYAB
 */
public class CurrencyConverter {

    public Currency convert(Currency inputCurrency) {
        try {
            URL urlForGetRequest = new URL("https://api.exchangeratesapi.io/latest?base=" + inputCurrency.getFrom());
            String readLine = null;
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            int responseCode = conection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                CurrencyAPI currencyAPIResponse = mapper.readValue(response.toString(), CurrencyAPI.class);
                Double todayRate = currencyAPIResponse.getRates().get(inputCurrency.getTo());
                inputCurrency.setConvertedValue(todayRate * inputCurrency.getAmount());
            } else {
                System.out.println("GET NOT WORKED");
            }
        } catch (Exception e) {
            return null;
        }
        return inputCurrency;
    }

    /*public static void main(String[] args) throws IOException {
        CurrencyConverter test = new CurrencyConverter();
        Currency convert = test.convert(new Currency(10, "USD", "INR", 0));
        System.out.println("Converted Value " + convert.getConvertedValue());
    }*/
}
