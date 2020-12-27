import java.util.*;

import Number.*;

public class PhoneBook {
    private List<Subscriber> person;

    public List<Subscriber> getPerson() {
        return Collections.unmodifiableList(person);
    }

    public void removePerson(int index) {
        person.remove(index - 1);
    }

    public PhoneBook() {
        this.person = new ArrayList<>();
    }

    public void addPerson(Subscriber per) {
        person.add(per);
    }

    public int getSize() {
        return person.size();
    }

    public final List<Subscriber> find(String str) {
        List<Subscriber> findPerson = new ArrayList<>();

        for (Subscriber c : person) {
            if (c.getMail().contains(str))
                findPerson.add(c);
            for (NumberPhone num : c.getNumberPhone())
                if (num.getNumber().contains(str))
                    findPerson.add(c);
            if (c.getSurname().contains(str))
                findPerson.add(c);
            if (c.getName().contains(str))
                findPerson.add(c);
        }

        //В множестве лежат только уникальные значения
        Set<Subscriber> singledValues = new HashSet<Subscriber>(findPerson);

        //поэтому результаты не будут повторяться
        return new ArrayList<>(singledValues);
    }
}
