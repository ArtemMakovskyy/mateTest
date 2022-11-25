package main.clone.practice2;

public class Fish {
    private String kind;
    private int length;

    @Override
    public int hashCode() {
        int result = 13;
        result = result * 31 + (kind == null ? 0 : kind.hashCode());
        return result * 31 + (length);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass().equals(Fish.class)) {
            return ((Fish) o).kind.equals(this.kind) && ((Fish) o).length == this.length;
        }
        return false;
    }

    @Override
    protected Fish clone()  {
        try {
            return (Fish) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
