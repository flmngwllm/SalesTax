package com.Will;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;



public class TotalPrice {

    private static final BigDecimal rounding = new BigDecimal("0.05");


    public static BigDecimal calculateSalesTax(Items item) {
        BigDecimal salesTax = BigDecimal.ZERO;
        if (item.isSalesTaxToApply()) {
            salesTax = item.getPrice().multiply(new BigDecimal(item.getItemNum()));
            salesTax = salesTax.multiply(new BigDecimal("0.05"));
            salesTax = salesTax.multiply(new BigDecimal("20")).setScale(0, RoundingMode.UP).setScale(2);
            salesTax = salesTax.divide(new BigDecimal("20"), RoundingMode.UP);

        }
        return salesTax;
    }

    public static BigDecimal calculateImportTax(Items item){
        BigDecimal importTax =  BigDecimal.ZERO;
        if(item.isImported()){
            importTax = item.getPrice().multiply(new BigDecimal(item.getItemNum()));
            importTax = importTax.multiply(new BigDecimal("0.05"));
            importTax = importTax.multiply(new BigDecimal("20")).setScale(0, RoundingMode.UP).setScale(2);
            importTax = importTax.divide(new BigDecimal("20"), RoundingMode.UP);

        }
        return importTax;
    }

    public static BigDecimal calculatePrice(Items item){
        BigDecimal calculatedPrice = item.getPrice().add(calculateSalesTax(item).add(calculateImportTax(item)));
        return calculatedPrice;
    }
}
