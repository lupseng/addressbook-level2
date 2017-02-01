package seedu.addressbook.data.person;

/**
 * Represents a Address's block. Can be empty.
 */
public class AddressBlock {
    
    private String value;

    public AddressBlock() {
        this.value = "";
    }

    public AddressBlock(String value) {
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
