import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Number.*;
//
public class MyMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        int choose = -1;
        while (choose != 0) {
            System.out.println("0 - exit");
            System.out.println("1 - add a user");
            System.out.println("2 - delete the user");
            System.out.println("3 - display the phone book");
            System.out.println("4 - display entries that match the substring");
            System.out.println("5 - create to user");
            Scanner in = new Scanner(System.in);
            choose = in.nextInt();
            switch (choose) {
                case 1: {
                    String name;
                    String surname;
                    String mail;
                    String number;
                    Subscriber person;
                    List<NumberPhone> numberPhoneList = new ArrayList<>();
                    NumberPhoneType type = null;

                    System.out.println("Enter a name");
                    in.nextLine();
                    name = in.nextLine();

                    System.out.println("Enter a surname");
                    surname = in.nextLine();

                    System.out.println("Enter the number of phone numbers to enter:");

                    choose = in.nextInt();
                    for (int i = 0; i < choose; ++i) {
                        System.out.println("Enter a number phone");
                        in.nextLine();
                        number = in.nextLine();

                        System.out.println("Press 1 if the phone number is home");
                        System.out.println("Press 2 if the phone number is office");
                        System.out.println("Press 3 if the phone number is mobile");


                        choose = in.nextInt();
                        switch (choose) {
                            case 1:
                                type = NumberPhoneType.HOME_PHONE;
                                break;
                            case 2:
                                type = NumberPhoneType.OFFICE_PHONE;
                                break;
                            case 3:
                                type = NumberPhoneType.MOBILE_PHONE;
                                break;
                        }

                        NumberPhone numberPhone = new NumberPhone(number, type);
                        numberPhoneList.add(numberPhone);
                    }
                    System.out.println("Enter a mail");
                    in.nextLine();
                    mail = in.nextLine();

                    person = new Subscriber(name, surname, mail, numberPhoneList);
                    phoneBook.addPerson(person);
                    break;
                }
                case 2: {
                    System.out.println("Enter the index of the user whose data you want to delete");
                    choose = in.nextInt();
                    phoneBook.removePerson(choose);
                    break;
                }
                case 3: {
                    int i = 1;
                    for (Subscriber c : phoneBook.getPerson()) {
                        System.out.println(Integer.valueOf(i).toString() + ' ' + c.toString());
                        ++i;
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter a substring");
                    in.nextLine();
                    String str = in.nextLine();
                    List<Subscriber> findPerson = phoneBook.find(str);
                    int i = 1;
                    for (Subscriber c : findPerson) {
                        System.out.println(Integer.valueOf(i).toString() + ' ' + c.toString());
                    }
                    break;
                }
                case 5: {
                    int i = 1;
                    for (Subscriber c : phoneBook.getPerson()) {
                        System.out.println(Integer.valueOf(i).toString() + ' ' + c.toString());
                        ++i;
                    }
                    System.out.println("Enter the index of the contact you want to edit");

                    in.nextLine();
                    i = in.nextInt();

                    Subscriber person = phoneBook.getPerson().get(i);

                    System.out.println("1 - edit the name");
                    System.out.println("2 - edit the surname");
                    System.out.println("3 - edit the mail");
                    System.out.println("4 - edit the number/s");

                    choose = in.nextInt();
                    switch (choose) {
                        case 1: {
                            System.out.println("Enter name");
                            person.setName(in.nextLine());
                            break;
                        }
                        case 2: {
                            System.out.println("Enter surname");
                            person.setSurname(in.nextLine());
                            break;
                        }
                        case 3: {
                            System.out.println("Enter mail");
                            person.setMail(in.nextLine());
                            break;
                        }
                        case 4:
                            System.out.println("Enter 1 to delete a number");
                            System.out.println("Enter 2 to add a number");
                            choose = in.nextInt();
                            switch (choose) {
                                case 1: {
                                    i = 1;
                                    for (NumberPhone num : person.getNumberPhone())
                                        System.out.println(Integer.valueOf(i).toString() + ". " + num.getNumber());
                                    System.out.println("Enter the index of the phone number you want to delete");
                                    choose = in.nextInt();
                                    person.deleteNumber(choose);
                                    break;
                                }

                                case 2: {
                                    NumberPhoneType type = null;
                                    String number;
                                    System.out.println("Enter number phone");
                                    number = in.nextLine();

                                    System.out.println("1 - phone number is home");
                                    System.out.println("2 - phone number is office");
                                    System.out.println("3 - phone number is mobile");

                                    choose = in.nextInt();
                                    switch (choose) {
                                        case 1:
                                            type = NumberPhoneType.HOME_PHONE;
                                            break;
                                        case 2:
                                            type = NumberPhoneType.OFFICE_PHONE;
                                            break;
                                        case 3:
                                            type = NumberPhoneType.MOBILE_PHONE;
                                            break;
                                    }
                                    person.addNumber(new NumberPhone(number, type));
                                    break;
                                }
                            }
                            break;
                    }
                    break;
                }
            }
        }
    }
}