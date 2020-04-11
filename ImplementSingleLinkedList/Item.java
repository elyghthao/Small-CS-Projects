import java.util.Objects;

public class Item {
    private int data;
    private boolean isValid;

    public Item(int data, boolean isValid) {
        this.data = data;
        this.isValid = isValid;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return data == item.data &&
                isValid == item.isValid;
    }

    @Override
    public String toString() {
        return "{" + "data:" + data + ", isValid:" + String.valueOf(isValid) + '}';
    }
}
