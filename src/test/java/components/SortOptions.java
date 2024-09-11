package components;

public enum SortOptions {

    DEFAULT_SORT("Name","(A to Z)"),

    SORT_AZ("Name","(A to Z)"),
    SORT_ZA("Name","(Z to A)"),
    SORT_LOHI("Price","(low to high)"),
    SORT_HILO("Price","(high to low)");

    private String discription;
    private String value;

    private SortOptions(String discription, String value) {
        this.discription = discription;
        this.value = value;
    }

    @Override
    public String toString(){
        return discription + " " + value;
    }

}
