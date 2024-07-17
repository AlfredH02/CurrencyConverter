package factory;

import strategy.CurrencyConverter;
import strategy.CurrencyConverterImpl;

public class CurrencyConverterFactory {
    public static CurrencyConverter getConverter(String fromCurrency, String toCurrency) {
        return new CurrencyConverterImpl(fromCurrency, toCurrency);
    }
}