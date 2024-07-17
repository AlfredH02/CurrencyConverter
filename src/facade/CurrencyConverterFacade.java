package facade;

import factory.CurrencyConverterFactory;
import strategy.CurrencyConverter;

import java.io.IOException;

public class CurrencyConverterFacade {
    public double convert(String fromCurrency, String toCurrency, double amount) throws IOException, InterruptedException {
        CurrencyConverter converter = CurrencyConverterFactory.getConverter(fromCurrency, toCurrency);
        return converter.convert(amount);
    }
}
