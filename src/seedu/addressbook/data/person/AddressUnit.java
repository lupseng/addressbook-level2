package seedu.addressbook.data.person;

/**
 * Represents a Address's Unit.
 */
public class AddressUnit {
    
    private String value;

    public AddressUnit(String value) {
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
