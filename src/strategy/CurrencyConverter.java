package strategy;

import java.io.IOException;

public interface CurrencyConverter {
    double convert(double amount) throws IOException, InterruptedException;
}