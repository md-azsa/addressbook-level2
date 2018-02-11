package seedu.addressbook.data.person;

public class Unit {
    private String unitNumber;

    public Unit(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    /**
     * Gets the unit number of the address
     *
     * @return unitNumber as String
     */
    @Override
    public String toString() {
        return unitNumber;
    }
}
