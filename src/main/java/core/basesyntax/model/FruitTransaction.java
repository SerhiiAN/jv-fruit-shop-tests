package core.basesyntax.model;

import java.util.Arrays;
import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, String quantity) {
        this.operation = Operation.getByCode(operation);
        this.fruit = fruit;
        this.quantity = Integer.parseInt(quantity);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Operation getByCode() {
        return operation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FruitTransaction)) {
            return false;
        }
        FruitTransaction other = (FruitTransaction) obj;
        return Objects.equals(this.operation, other.operation)
                && Objects.equals(this.fruit, other.fruit)
                && Objects.equals(this.quantity, other.quantity);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getByCode(String operation) {
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getCode().equals(operation))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("There is no such enum: "
                            + operation));
        }

        public String getCode() {
            return code;
        }
    }
}
