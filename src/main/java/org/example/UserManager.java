package org.example;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class UserManager {
    public List<User> users = new LinkedList<>();
    public List printArray(){
        System.out.println("-----Expected result----");
        List <User> print = (List<User>) users.stream();
        print.forEach(System.out::println);
        return print;
    }


    public List sortListByFirstNameAndAge() {
        System.out.println("Sort by FirstName in right order\n");
        return (List) users.stream().sorted((o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            return o2.getAge() - o1.getAge();
        });
    }
    public List sortListByAge() {
        List <User> byAge = (List<User>) users.stream().sorted(comparing(User::getAge));
        byAge.forEach(System.out::println);
        return byAge;
    }

    public double averageAgeByUsers() {
        System.out.println("-----Average age of users------");
        users.forEach(e -> System.out.println(e.age));
        double averageAge = users.stream().mapToInt(User::getAge).average().getAsDouble();
        System.out.println("Average age:" + averageAge);
        return averageAge;
    }

    public boolean usersUpperThanEighteen() {
        System.out.println("----Upper than 18------");
        System.out.println(users);
        return users.stream().allMatch(user -> user.getAge() > 18);
    }

    public boolean usersFirstLetterS() {
        System.out.println("----First letter S or A------");
        System.out.println(users);
        return users.stream().anyMatch(e -> e.firstName.charAt(0) == 'S' || e.firstName.charAt(0) == 'A');
    }
}
