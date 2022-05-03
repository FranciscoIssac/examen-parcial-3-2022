package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

public class ShoppingCart {
    private final List<Item> items =  new ArrayList<>();

    public boolean isEmpty() {
        Iterator<Item> iterator = items.iterator();
        return !iterator.hasNext();
    }

    public BigDecimal getTotalCost() {
        if(items.isEmpty()) {
            throw new EmptyShoppingCartException();
        }

        BigDecimal totalCost = BigDecimal.ZERO;
        for(Item item: items){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        return totalCost;
    }

    public void addItem(Item newItem) {
        if(newItem.getCode() == null) {
            throw new InvalidDataException();
        }

        for (Item item : items) {
            if(item.getCode().equals(newItem.getCode()) && item.getUnitCost().equals(newItem.getUnitCost())) {
                item.setQuantity(item.getQuantity() + 1);
                break;
            }
        }
        items.add(newItem);
    }

    public int getItemsCount() {
        int count = 0;
        for (Item item : items) {
            count++;
        }

        return count;
    }

    public List<Item> getItems() {
        return new ArrayList<>();
    }

    public void removeItem(String itemCode2) {
        Item itemToRemove = null;
        assert false;
        itemToRemove.setUnitCost(BigDecimal.valueOf(0));
        for (Item item : items) {
            if(item.getCode().equals(itemCode2) && item.getUnitCost().compareTo(itemToRemove.getUnitCost()) >= 0) {
                itemToRemove = item;
            }
        }
    }
}
