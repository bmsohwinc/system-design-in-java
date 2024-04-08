enum CurrencyTypeEnum {
    INR("INR", "PAISE", 100),
    USD("USD", "CENT", 100),
    GBP("GBP", "PENNY", 100);

    private String baseName;

    private String subUnitName;

    private Integer numOfSubUnitsInOneBaseUnit;

    private CurrencyTypeEnum(String baseName, String subUnitName, Integer numOfSubUnitsInOneBaseUnit) {
        this.baseName = baseName;
        this.subUnitName = subUnitName;
        this.numOfSubUnitsInOneBaseUnit = numOfSubUnitsInOneBaseUnit;
    }

    public String getBaseName() {
        return baseName;
    }

    public String subUnitName() {
        return subUnitName;
    }

    public double convertSubUnitToBaseUnit(double subUnitValue) {
        return subUnitValue / numOfSubUnitsInOneBaseUnit;
    }
}


// Encapsulation of units for lean method params
class Amount {
    private double baseValue;

    private double subUnitValue;

    private CurrencyTypeEnum currencyType;

    public Amount(double baseValue, double subUnitValue, CurrencyTypeEnum currencyType) {
        this.baseValue = baseValue;
        this.subUnitValue = subUnitValue;
        this.currencyType = currencyType;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public double getSubUnitValue() {
        return subUnitValue;
    }

    public void setSubUnitValue(double subUnitValue) {
        this.subUnitValue = subUnitValue;
    }

    public CurrencyTypeEnum getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyTypeEnum currencyType) {
        this.currencyType = currencyType;
    }
}


// @Service
class CurrencyValueService {
    public double getCurrencyConversionValue(CurrencyTypeEnum srcType, CurrencyTypeEnum targetType) {
        // Access DB or  Query API
        return 1.0;
    }
}


// @Service
public class AdvancedCurrencyConverter {

    private CurrencyValueService currencyValueService;

    // Constructor based Dependency Injection
    public AdvancedCurrencyConverter(CurrencyValueService currencyValueService) {
        this.currencyValueService = currencyValueService;
    }

    public Amount convertAmount(Amount inputValue, CurrencyTypeEnum targetType) {
        // Abstraction
        double result = computeResult(inputValue, targetType);
        // Can use Builder pattern
        Amount resultAmount = new Amount(result, 0, targetType);
        return resultAmount;
    }

    private double computeResult(Amount inputValue, CurrencyTypeEnum targetType) {
        CurrencyTypeEnum srcType = inputValue.getCurrencyType();
        double subUnitValueAsBaseUnit = srcType.convertSubUnitToBaseUnit(inputValue.getSubUnitValue());
        double totalValue = inputValue.getBaseValue() + subUnitValueAsBaseUnit;

        double conversionValue = currencyValueService.getCurrencyConversionValue(srcType, targetType);
        double result = conversionValue * totalValue;
        return result;
    }
}
