package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
    private Person person;
    private Tag tag;
    
    public Tagging(Person person, Tag tag) {
        super();
        this.person = person;
        this.tag = tag;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }


}
