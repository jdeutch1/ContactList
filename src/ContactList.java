import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Jackson Deutch
 * @version: 2022-2023
 */

public class ContactList
{
    private ArrayList<Person> contacts = new ArrayList<Person>();
    public ContactList() {}

    /**
     * Prints menu options to console
     */
    public void printMenuOptions()
    {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact()
    {
        Scanner s = new Scanner(System.in);

        // Determine student or athlete
        System.out.println("Select a type of contact you want to add:");
        System.out.println("1. Student");
        System.out.println("2. Athlete");
        int choice = s.nextInt();
        s.nextLine();

        // Get name and number of person
        System.out.println("Please fill in the following information.");
        System.out.println("First Name:");
        String firstName = s.nextLine();
        System.out.println("Last Name:");
        String lastName = s.nextLine();
        System.out.println("Phone Number");
        String phoneNumber = s.nextLine();

        // Get specific variables depending on subclass
        if (choice == 1)
        {
            System.out.println("Grade:");
            int grade = s.nextInt();
            s.nextLine();
            contacts.add(new Student(lastName, firstName, phoneNumber, grade));
        }
        else
        {
            System.out.println("Sport");
            String sport = s.nextLine();
            contacts.add(new Athlete(lastName, firstName, phoneNumber, sport));
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts()
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy)
    {
        if (sortBy == 0)
        {
            this.sortByFirst();
        }
        else if (sortBy == 1)
        {
            this.sortByLast();
        }
        else
        {
            this.sortByPhoneNumber();
        }
    }

    /**
     * Sorts Contact list by first name
     * Sorted alphabetically top to bottom
     * Sorted through bubble sort algorithm
     */
    public void sortByFirst()
    {
        for (int i = 0; i < contacts.size() - 1; i++)
        {
            for (int j = 0; j < contacts.size() - i - 1; j++)
            {
                if (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) == -1)
                {
                    Collections.swap(contacts, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts Contact list by last name
     * Sorted alphabetically top to bottom
     * Sorted through bubble sort algorithm
     */
    public void sortByLast()
    {
        for (int i = 0; i < contacts.size() - 1; i++)
        {
            for (int j = 0; j < contacts.size() - i - 1; j++)
            {
                if (contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) == -1)
                {
                    Collections.swap(contacts, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts Contact list by phone number
     * Sorted with lower numbers at top, higher at bottom
     * Sorted through bubble sort algorithm
     */
    public void sortByPhoneNumber()
    {
        for (int i = 0; i < contacts.size() - 1; i++)
        {
            for (int j = 0; j < contacts.size() - i - 1; j++)
            {
                if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) == -1)
                {
                    Collections.swap(contacts, j, j + 1);
                }
            }
        }
    }

    /**
     * Takes input of first name and returns person w/matching first name
     * Returns null if no match
     */
    public Person searchByFirstName(String firstName)
    {
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getFirstName().equals(firstName))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    /**
     * Takes input of last name and returns person w/matching last name
     * Returns null if no match
     */
    public Person searchByLastName(String lastName)
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getLastName().equals(lastName))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    /**
     * Takes input of phone number and returns person w/matching phone number
     * Returns null if no match
     */
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents()
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i) instanceof Student)
            {
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run()
    {
        System.out.println("Welcome to your Contacts List");
        Scanner s = new Scanner(System.in);
        int input = -1;
        while (input != 0)
        {
            System.out.println("Please pick from the following menu options");
            printMenuOptions();
            input = s.nextInt();
            s.nextLine();
            if (input == 1)
            {
                this.addContact();
            }
            else if (input == 2) {
                this.sort(0);
                this.printContacts();
            }
            else if (input == 3) {
                this.sort(1);
                this.printContacts();
            }
            else if (input == 4)
            {
                this.sort(2);
                this.printContacts();
            }
            else if(input == 5)
            {
                this.listStudents();
            }
            else if (input == 6)
            {
                String firstName;
                System.out.println("Enter a name:");
                firstName = s.nextLine();
                if (searchByFirstName(firstName) == null)
                {
                    System.out.println(firstName + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByFirstName(firstName));
                }
            }
            else if (input == 7)
            {
                String lastName;
                System.out.println("Enter a name:");
                lastName = s.nextLine();
                if (searchByLastName(lastName) == null)
                {
                    System.out.println(lastName + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByLastName(lastName));
                }
            }
            else if (input == 8)
            {
                String number;
                System.out.println("Enter a number:");
                number = s.nextLine();
                if (searchByPhoneNumber(number) == null)
                {
                    System.out.println(number + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByPhoneNumber(number));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
