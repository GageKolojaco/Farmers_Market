package Inventory.Produce;

import Inventory.InventoryItem;

public class ProduceFactory {

    public static InventoryItem build(String name, double unitPrice, int numberOfItems){
        String produceName = name.trim().toLowerCase(); //trimming for consistency
        switch (produceName) {
            case "asparagus":
                return new Asparagus(unitPrice, numberOfItems);
            case "celery":
                return new Celery(unitPrice, numberOfItems);
            case "dragonfruit":
                return new Dragonfruit(unitPrice, numberOfItems);
            case "strawberry":
                return new Strawberry(unitPrice, numberOfItems);
            case "watermelon":
                return new Watermelon(unitPrice, numberOfItems);
            default:
                return null;
        }
    }
}
