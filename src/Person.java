/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Jackson Deutch
 * @version: 2022-2023
 */

public class Person
{
    /**
     * Instance Variables
     */
    String firstName;
    String lastName;
    String phoneNumber;
    public Person(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String toString()
    {
        return firstName + " " + lastName +  " - #" + phoneNumber;
    }
}
