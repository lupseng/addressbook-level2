package seedu.addressbook.data.person;

/**
 * Represents a Address's Postal Code.
 */
public class AddressPostalCode {
    
    private String value;

    public AddressPostalCode(String value) {
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
