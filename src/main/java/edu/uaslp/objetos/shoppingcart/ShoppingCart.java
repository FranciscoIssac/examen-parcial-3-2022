package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

public class ShoppingCart {
    private final List<Item> items =  new ArrayList<>();

    public boolean isEmpty() {
    }

    public BigDecimal getTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;

        for(Item item: items){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        return totalCost;
    }

    public void addItem(Item newItem) {
        for (Item item : items) {
            if(item.getCode().equals(newItem.getCode()) && item.getUnitCost().equals(newItem.getUnitCost())) {
                item.setQuantity(item.getQuantity() + 1);
            }
        }
        items.add(newItem);
    }

    public boolean getItemsCount() {
    }

    public List<Item> getItems() {
    }

    public void removeItem(String itemCode2) {
    }
}
