package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.*;

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
            throw new InvalidDataException("Null or empty string not allowed for item code");
        }
        if(Objects.equals(newItem.getProviderCode(), "")) {
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }
        if(newItem.getUnitCost().compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new InvalidDataException("Cost must be greater than zero");
        }
        if(newItem.getQuantity() > 5) {
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

        boolean flag = true;

        for (Item item : items) {
            if(item.getCode().equals(newItem.getCode()) && item.getUnitCost().equals(newItem.getUnitCost())) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                flag = false;
            }
        }
        if(flag) {
            items.add(newItem);
        }
    }

    public int getItemsCount() {
        int count = 0;
        for (Item item : items) {
            count = count + item.getQuantity();
        }

        return count;
    }

    public List<Item> getItems() {

        return items;
    }

    public void removeItem(String itemCode) {
        Item itemToRemove = new Item();
        itemToRemove.setUnitCost(BigDecimal.valueOf(0));
        for (Item item : items) {
            if (item.getCode().equals(itemCode) && item.getUnitCost().compareTo(itemToRemove.getUnitCost()) >= 0) {
                itemToRemove = item;
            }
        }
        if (itemToRemove.getQuantity() > 1) {
            itemToRemove.setQuantity(itemToRemove.getQuantity() - 1);
        } else {
            items.remove(itemToRemove);
        }
    }
}
