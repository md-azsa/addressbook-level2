package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #01-01, 422123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be [BLOCK], [STREET], [UNIT], [POSTAL_CODE]";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    public static final String COMMA = ",";

    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTAL_CODE_INDEX = 3;

    public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        parseAddressArgumentToComponents(trimmedAddress);
        this.value = buildAddressByCombiningComponents();
    }


    /**
     * Method removes the comma in the address argument
     * Initializes the class components of Address: Block, Street, Unit, PostalCode
     */
    public void parseAddressArgumentToComponents (String trimmedAddress) {
        String[] parsedAddress = trimmedAddress.split(",");
        this.block = new Block(parsedAddress[BLOCK_INDEX].trim());
        this.street = new Street(parsedAddress[STREET_INDEX].trim());
        this.unit = new Unit(parsedAddress[UNIT_INDEX].trim());
        this.postalCode = new PostalCode(parsedAddress[POSTAL_CODE_INDEX].trim());
    }

    /**
     * Method glues every component together to form the address
     *
     * @return The address as String
     */
    public String buildAddressByCombiningComponents() {
        return block + COMMA + street + COMMA + unit + COMMA + postalCode;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
