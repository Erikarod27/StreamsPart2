import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Daniel", "Ramirez", 25));
        persons.add(new Person("Katy", "Cole", 36));
        persons.add(new Person("Lawrence", "Walters", 56));
        persons.add(new Person("Krista", "Maddox", 25));
        persons.add(new Person("Renaldo", "Glover", 42));
        persons.add(new Person("Diane", "Lang", 11));
        persons.add(new Person("Lillian","Santiago",22));
        persons.add(new Person("Millard","Branch",77));
        persons.add(new Person("Lorrie", "Turner", 51));
        persons.add(new Person("Francis", "Wilkerson", 38));

        while(true) {
            System.out.println("---Search by name---");
            System.out.println("1. First name");
            System.out.println("2. Last name");
            System.out.println("3. Age statistics");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter the first name: ");
                    String firstName = scanner.next();
                    persons.stream()
                            .filter(person -> person.getFirstName().equalsIgnoreCase(firstName))
                            .forEach(System.out::println);

                    break;
                case 2:
                    System.out.print("Enter the last name: ");
                    String lastName = scanner.next();
                    persons.stream()
                            .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                            .forEach(System.out::println);
                    break;
                case 3:
                    int oldestAge = persons.stream()
                            .mapToInt(Person::getAge)
                            .max()
                            .orElseThrow(() -> new IllegalStateException("No persons found"));
                    int youngestAge = persons.stream()
                            .mapToInt(Person::getAge)
                            .min()
                            .orElseThrow(() -> new IllegalStateException("No persons found"));
                    OptionalDouble averageAge = persons.stream()
                            .mapToInt(Person::getAge)
                            .average();
                    System.out.println("Oldest age: " + oldestAge);
                    System.out.println("Youngest age: " + youngestAge);
                    if (averageAge.isPresent()) {
                        System.out.println("Average age: " + averageAge.getAsDouble());
                    } else {
                        System.out.println("Average age: N/A");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
