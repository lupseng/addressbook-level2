package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be entered in the following format "
                                                              + "a/BLOCK, STREET, UNIT, POSTAL_CODE ";
    public static final String ADDRESS_VALIDATION_REGEX = "[^,]*,[^,]+,[^,]+,[^,\n]+";

    public static final int INDEX_BLOCK = 0;
    public static final int INDEX_STREET = 1;
    public static final int INDEX_UNIT = 2;
    public static final int INDEX_POSTALCODE = 3;

    public final String value;
    private boolean isPrivate;
    
    private AddressBlock block;
    private AddressStreet street;
    private AddressUnit unit;
    private AddressPostalCode postalCode;

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
        
        String[] splitTrimmedAddress = trimmedAddress.split(",");
        
        this.block = new AddressBlock(splitTrimmedAddress[INDEX_BLOCK].trim());
        this.street = new AddressStreet(splitTrimmedAddress[INDEX_STREET].trim());
        this.unit = new AddressUnit(splitTrimmedAddress[INDEX_UNIT].trim());
        this.postalCode = new AddressPostalCode(splitTrimmedAddress[INDEX_POSTALCODE].trim());
        this.value = this.block + " " + this.street + " " + this.unit + " " + this.postalCode;
    }

    /**
     * Returns true if a given string is a valid person email.
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
