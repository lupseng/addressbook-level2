package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.UniqueTagList;

public class UtilsTest {
    @Test
    public void isAnyNull() {
        // empty list
        assertFalse(Utils.isAnyNull());

        // Any non-empty list
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));
        assertFalse(Utils.isAnyNull(0));
        assertFalse(Utils.isAnyNull(Integer.MAX_VALUE + Integer.MAX_VALUE));
        assertFalse(Utils.isAnyNull(false));;
        assertFalse(Utils.isAnyNull(this));
        String emptyString = "";
        assertFalse(Utils.isAnyNull(emptyString));

        // non empty list with just one null at the beginning
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));
        Object obj = null;
        assertTrue(Utils.isAnyNull(obj));

        // non empty list with nulls in the middle
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));

        // non empty list with one null as the last element
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));

        // confirms nulls inside the list are not considered
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
        HashMap<String,String> hm = new HashMap<String, String>();
        assertFalse(Utils.isAnyNull(hm));
        
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);
        assertAreUnique("A", "a");
        assertAreUnique("     A        ", "A");
        assertAreUnique(new Integer(1), new Float(1.0));
        assertAreUnique(1, 1.0);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
        assertNotUnique("", "a", "b", "");
        
        //two identical object
        assertNotUnique("A", "a".toUpperCase());
        assertNotUnique("     A        ".trim(), "A");
        assertNotUnique("abcdef".substring(0, 3), "abc");
        assertNotUnique(Integer.max(10, 100), Integer.min(1000, 100));
        
        // confirms value inside array are not considered
        int[] notUniqueArray = {1,10,1};
        assertAreUnique(notUniqueArray);
        
        // confirms object with same values are not considered
        Person testPerson1 = new Person(new Name(Name.EXAMPLE), new Phone(Phone.EXAMPLE, false), new Email(Email.EXAMPLE, false),
                                          new Address(Address.EXAMPLE, false), new UniqueTagList());
        Person testPerson2 = new Person(new Name(Name.EXAMPLE), new Phone(Phone.EXAMPLE, false), new Email(Email.EXAMPLE, false),
                                          new Address(Address.EXAMPLE, false), new UniqueTagList());
        assertAreUnique(testPerson1, testPerson2);
        
        testPerson2  = testPerson1;
        assertNotUnique(testPerson1, testPerson2);
                
        //values in string variable checked
        String testString1 = null;
        assertAreUnique("", testString1);
       
        String testString2 = null;
        assertNotUnique(testString1, testString2);
        
        testString1 = "";
        testString2 = "";
        assertNotUnique(testString1, testString2);
        
        testString1 = "abc";
        testString2 = "abc";
        assertNotUnique(testString1, testString2);
        
        testString2 = testString1;
        assertNotUnique(testString1, testString2);
        
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
