package seedu.addressbook.data.person;

public class PostalCode {
    private String postalCodeNumber;

    public PostalCode (String postalCodeNumber) {
        this.postalCodeNumber = postalCodeNumber;
    }

    /**
     * Gets the postal code number of the address
     *
     * @return postalCodeNumber as String
     */
    @Override
    public String toString() {
        return postalCodeNumber;
    }
}
