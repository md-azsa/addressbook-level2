package seedu.addressbook.data.person;

public class Street {
    private String streetName;

    public Street(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the street name of the address
     *
     * @return streetName as String
     */
    @Override
    public String toString() {
        return streetName;
    }
}
