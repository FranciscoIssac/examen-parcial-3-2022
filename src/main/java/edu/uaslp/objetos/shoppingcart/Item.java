package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private String itemCode;
    private BigDecimal unitCost;
    private int i;
    private String providerCode;

    public Item() {

    }

    public Item(String itemCode, String providerCode, BigDecimal unitCost, int i) {
        this.itemCode = itemCode;
        this.providerCode = providerCode;
        this.unitCost = unitCost;
        this.i = i;
    }

    public String getCode() {
        return itemCode;
    }

    public void setCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return i;
    }

    public void setQuantity(int i) {
        this.i = i;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }
}
