package seedu.addressbook.data.person;

/**
 * Represents a Address's Street.
 */
public class AddressStreet {
    
    private String value;

    public AddressStreet(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    } 
    
    @Override
    public String toString() {
        return value;
    }
}
