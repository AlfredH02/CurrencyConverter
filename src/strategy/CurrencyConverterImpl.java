package strategy;

import service.ExchangeRateService;

import java.io.IOException;

public class CurrencyConverterImpl implements CurrencyConverter {
    private final String fromCurrency;
    private final String toCurrency;

    public CurrencyConverterImpl(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    @Override
    public double convert(double amount) throws IOException, InterruptedException {
        double rate = ExchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}