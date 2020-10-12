package com.serverless.businesslogic;

/**
 * @author TAYYAB
 */
public class CurrencyConverter {

    private static double CONVERSION_RATE = 73.3482;

    public Currency convert(Currency inputCurrency) {
        try {
            Double todayRate = CONVERSION_RATE * inputCurrency.getAmount();
            inputCurrency.setConvertedValue(todayRate);

        } catch (Exception e) {
            return null;
        }
        return inputCurrency;
    }

    /*public static void main(String[] args)  {
        CurrencyConverter test = new CurrencyConverter();
        Currency convert = test.convert(new Currency(10, "USD", "INR", 0));
        System.out.println("Converted Value " + convert.getConvertedValue());
    }*/
}
