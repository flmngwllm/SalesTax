package com.Will;
import java.math.BigDecimal;

public class Items {

    private String name;
    private int itemNum;
    private boolean salesTaxToApply;
    private BigDecimal price;
    private boolean imported;

    public String getName() {
        return name;
    }

    public int getItemNum() {
        return itemNum;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public boolean isSalesTaxToApply(){
        return salesTaxToApply;
    }

    public void setSalesTaxToApply(boolean salesTaxToApply) {
        this.salesTaxToApply = salesTaxToApply;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public boolean isImported(){
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public void printItems(){
        System.out.println("Item Name: " + this.getName());
        System.out.println("Number of items: " + this.getItemNum());
        System.out.println("Apply sales tax: " + this.isSalesTaxToApply());
        System.out.println("Is imported: " + this.isImported());
        System.out.println("Price: " + this.getPrice());
    }
}
