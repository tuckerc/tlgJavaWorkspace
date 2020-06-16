package com.javatunes.billing;

import com.javatunes.product.OrderLocation;

public class TaxCalculatorFactory {
    private TaxCalculatorFactory() {
    }

    public static TaxCalculator getTaxCalculatorStrategy(OrderLocation orderLocation) {
        TaxCalculator taxCalculator = null;
        if("EUROPE".equals(orderLocation.toString())) {
            taxCalculator = new EuropeTax();
        } else if("USA".equals(orderLocation.toString())) {
            taxCalculator = new USATax();
        } else if("ONLINE".equals(orderLocation.toString())){
            taxCalculator = new OnlineTax();
        }
        return taxCalculator;
    }
}
