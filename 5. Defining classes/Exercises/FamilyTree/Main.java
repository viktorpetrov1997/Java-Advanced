package DefiningClasses.Exercises.FamilyTree;

import java.util.*;

public class Main
{
    private static Person getPersonInfo(String personInfo, List<Person> personList)
    {
        for(Person person : personList)
        {
            if(person.getName().equals(personInfo) || person.getBirthday().equals(personInfo))
            {
                return person;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String personWhoWeAreSearchingInformationFor = scanner.nextLine();

        LinkedHashMap<String, List<String>> parentsChildren = new LinkedHashMap<>();
        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            if(input.contains(" - "))
            {
                String parentData = input.split(" - ")[0];
                String childData = input.split(" - ")[1];

                parentsChildren.putIfAbsent(parentData, new ArrayList<>());
                parentsChildren.get(parentData).add(childData);
            }
            else
            {
                String[] data = input.split("\\s+");
                String name = data[0] + " " + data[1];
                String birthday = data[2];

                Person person = new Person(name, birthday);
                personList.add(person);
            }
            input = scanner.nextLine();
        }

        for(Map.Entry<String, List<String>> entry : parentsChildren.entrySet())
        {
            Person parent = getPersonInfo(entry.getKey(), personList);

            for(String childInfo : entry.getValue())
            {
                Person child = getPersonInfo(childInfo, personList);

                if(parent != null && child != null)
                {
                    parent.addChild(child);
                    child.addParent(parent);
                }
            }
        }
        System.out.println(getPersonInfo(personWhoWeAreSearchingInformationFor, personList));
    }
}
