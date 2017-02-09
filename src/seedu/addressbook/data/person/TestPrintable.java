package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.tag.UniqueTagList;

public class TestPrintable {
    public static void main(String[] args) throws IllegalValueException {
        Person p = new Person(new Name("name"), new Phone("98659435", false), new Email("email@la.com", false),
                new Address("address", false), new UniqueTagList());
        System.out.println(getPrintableString(p.getPhone(), p.getEmail(), p.getAddress()));
    }

    /**
     * Returns a concatenated version of the printable strings of each object.
     * 
     * @throws IllegalValueException
     */
    static String getPrintableString(Printable... printables) throws IllegalValueException {
        String result = "";
        for (Printable p : printables) {
            result += p.getPrintableString();

        }
        return result;
    }
}