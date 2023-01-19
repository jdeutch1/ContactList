/**
 * A subclass of Person that represents an Athlete
 *
 * Created for Menlo School CS2
 *
 * @author: Jackson Deutch
 * @version: 2022-2023
 */
public class Athlete extends Person
{
    String sport;

    public Athlete(String firstName, String lastName, String phoneNumber, String sport)
    {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    public String getSport()
    {
        return sport;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Sport: " + sport;
    }
}
