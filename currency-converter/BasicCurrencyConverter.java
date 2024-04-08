/**
 * Issues with this design:
 * 1. Amount might be an object consisting of sub values (E.g., Rupee and Paise, Dollar and Cent, etc.)
 */
class CurrencyValueService {
    public double getCurrencyConversion(String srcType, String targetType) {
        // Access DB
        // Query API
        // Get from Cache
        return 0.0;
    }
}


public class BasicCurrencyConverter {

    public double convertTo(double amount, String srcType, String targetType) {
        CurrencyValueService currencyValueService = new CurrencyValueService();
        double conversionValue = currencyValueService.getCurrencyConversion(srcType, targetType);
        return amount * conversionValue;
    }

}
