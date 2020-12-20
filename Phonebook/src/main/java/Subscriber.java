import java.util.Collections;
import java.util.List;
import java.util.Objects;
import Number.*;

public class Subscriber {

    private String name;
    private String surname;
    private String mail;
    private List<NumberPhone> numberPhone;

    public Subscriber(String name, String surname, String mail, List<NumberPhone> numberPhone) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.numberPhone = numberPhone;
    }

    public final String getName() {
        return name;
    }

    public final String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMail(String mail) { this.mail = mail; }

    public List<NumberPhone> getNumberPhone() { return Collections.unmodifiableList(numberPhone); }

    public void deleteNumber(int index){
        numberPhone.remove(index);
    }

    public void addNumber(NumberPhone number){
        numberPhone.add(number);
    }

    @Override
    public String toString() {
        return name + ' ' + surname + ' ' + numberPhone.toString() + ' ' + mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber person = (Subscriber) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(mail, person.mail) &&
                Objects.equals(numberPhone, person.numberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, mail, numberPhone);
    }
}
