## Requirements
1. Given a value, source currency type, and target currency type, output the value in target currency type
2. Value can be in decimals, or in two denominations (Rupees & Paise, Dollar & Cents, etc.)
3. Show converted value up to allowed precision (2 decimal places in most currencies)

## Design considerations
1. Encapsulate the money value and currency type in an `Amount` class
2. Use `baseValue` and `subUnitValue` to handle both decimal inputs and two denomination inputs
3. Create `CurrencyType` Enums to handle type values and related sub unit to base unit conversions
4. Delegate obtaining of conversion value to a `CurrencyConversionService` class
5. Reduce LOC with abstractions (private methods for specific conversions)