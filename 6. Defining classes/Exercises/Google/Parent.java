package DefiningClasses.Exercises.Google;

public class Parent
{
    private String parentName;
    private String parentBirthday;

    public Parent(String parentName, String parentBirthday)
    {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString()
    {
        return this.parentName + " " + this.parentBirthday;
    }
}