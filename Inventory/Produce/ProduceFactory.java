package Inventory.Produce;

import Inventory.InventoryItem;

public class ProduceFactory {
    private ProduceFactory(){}

    public static InventoryItem build(String name, double unitPrice, int numberOfItems) throws Exception{
        String produceName = name.trim().toLowerCase(); //trimming for consistency
        switch (produceName) {
            case "asparagus":
                return new Asparagus(unitPrice, numberOfItems);
            case "celery":
                return new Asparagus(unitPrice, numberOfItems);
            case "dragonfruit":
                return new Asparagus(unitPrice, numberOfItems);
            case "strawberry":
                return new Asparagus(unitPrice, numberOfItems);
            case "watermelon":
                return new Asparagus(unitPrice, numberOfItems);
            default:
                throw new Exception();
        }
    }
}
