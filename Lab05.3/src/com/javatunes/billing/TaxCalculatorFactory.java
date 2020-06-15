package com.javatunes.billing;

import com.javatunes.product.OrderLocation;

public class TaxCalculatorFactory {
    private TaxCalculatorFactory() {
    }

    public static TaxCalculator getTaxCalculatorStrategy(OrderLocation orderLocation) {
        TaxCalculator taxCalculator;
        if("EUROPE".equals(orderLocation.toString())) {
            taxCalculator = new EuropeTax();
        } else if("USA".equals(orderLocation.toString())) {
            taxCalculator = new USATax();
        } else {
            taxCalculator = new OnlineTax();
        }
        return taxCalculator;
    }
}
