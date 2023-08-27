package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class UsersTest {
    static UserManager userManager;
    static UserManager userSortedManager;
    static UserManager userSortedByAgeManager;
    static UserManager userEighteenManager;
    static UserManager userEighteenManagerNeg;


    @BeforeAll
    public static void initUsers() {
        userManager = new UserManager();
        userManager.users.add(new User("Inga", "Oppa", 67));
        userManager.users.add(new User("Ronn", "Wizli", 75));
        userManager.users.add(new User("Nastya", "Yatsenko", 25));
        userManager.users.add(new User("Peter", "Parker", 8));
        userManager.users.add(new User("Kris", "Petrova", 25));
        userManager.users.add(new User("Bodya", "Leonar", 25));
    }
    @BeforeAll
    public static void initSortedUsersByFirstNameAndAge() {
        userSortedManager = new UserManager();
        userSortedManager.users.add(new User("Ronn", "Wizli", 75));
        userSortedManager.users.add(new User("Inga", "Oppa", 67));
        userSortedManager.users.add(new User("Nastya", "Yatsenko", 25));
        userSortedManager.users.add(new User("Kris", "Petrova", 25));
        userSortedManager.users.add(new User("Bodya", "Leonar", 25));
        userSortedManager.users.add(new User("Peter", "Parker", 8));
    }
    @BeforeAll
    public static void initSortedUsersByAge() {
        userSortedByAgeManager = new UserManager();
        userSortedByAgeManager.users.add(new User("Peter", "Parker", 8));
        userSortedByAgeManager.users.add(new User("Nastya", "Yatsenko", 25));
        userSortedByAgeManager.users.add(new User("Bodya", "Leonar", 25));
        userSortedByAgeManager.users.add(new User("Kris", "Petrova", 25));
        userSortedByAgeManager.users.add(new User("Inga", "Oppa", 67));
        userSortedByAgeManager.users.add(new User("Ronn", "Wizli", 75));
    }

    @BeforeAll
    public static void initUpToEighteen() {
        userEighteenManager = new UserManager();
        userEighteenManager.users.add(new User("Ronn", "Oppa", 67));
        userEighteenManager.users.add(new User("Kris", "Wizli", 75));
        userEighteenManager.users.add(new User("Bodya", "Leonar", 19));
    }

    @BeforeAll
    public static void initUpToEighteenNegative() {
        userEighteenManagerNeg = new UserManager();
        userEighteenManagerNeg.users.add(new User("Kris", "Yatsenko", 25));
        userEighteenManagerNeg.users.add(new User("Peter", "Petrova", 8));
        userEighteenManagerNeg.users.add(new User("Nastya", "Yatsenko", 21));
    }

    @BeforeEach
    public void printAfterTest() {
        System.out.println("Let`s start");
    }

    @Test
    @DisplayName("Sorted users by first name")
    @Tag("POSITIVE")
    public void testSortedUsersByFirstName() {
        Assertions.assertEquals(userManager.sortListByFirstNameAndAge().toString(), userSortedManager.printArray().toString());
    }

    @Test
    @DisplayName("Sorted users by first name TRUE")
    @Tag("POSITIVE")
    public void testSortedUsersByFirstNameTrue() {
        Assertions.assertTrue(userManager.sortListByFirstNameAndAge().toString().equals(userSortedManager.printArray().toString()));
    }

    @Test
    @DisplayName("Negative test by first name")
    @Tag("NEGATIVE")
    public void negativeTestSortedUsersByFirstName() {
        Assertions.assertFalse(userManager.sortListByFirstNameAndAge().toString().equals(userManager.printArray().toString()));
    }

    @Test
    @DisplayName("Sorted users by AGE in right order")
    public void testSortedUsersByAgeName() {
        Assertions.assertEquals(userManager.sortListByAge().toString(), userSortedByAgeManager.printArray().toString());
    }

    @Test
    @DisplayName("Sorted test by AGE TRUE")
    public void testSortedUsersByAgeTrue() {
        Assertions.assertTrue(userManager.sortListByAge().toString().equals(userSortedByAgeManager.printArray().toString()));
    }
    @Test
    @DisplayName("Sorted test by AGE Negative")
    public void negativeTestSortedUsersByAgeTrue() {
        Assertions.assertFalse(userManager.sortListByAge().toString().equals(userManager.printArray().toString()));
    }
    @Test
    @DisplayName("Average age")
    public void testAverageAge() {
        Assertions.assertEquals(37.5, userSortedByAgeManager.averageAgeByUsers());
    }

    @ParameterizedTest
    @DisplayName("Average age TRUE")
    @CsvSource(value = {"44","37.5","2"})
    public void testAverageAgeTrue(double averageAge) {
        if(averageAge == 44 || averageAge == 2)
            Assertions.assertNotEquals(userSortedByAgeManager.averageAgeByUsers(), averageAge);
        else
            Assertions.assertEquals(userSortedByAgeManager.averageAgeByUsers(), averageAge);
    }
    @Test
    @DisplayName("Negative average age TRUE")
    public void negativeTestAverageAgeTrue() {
        Assertions.assertNotEquals(-44, userManager.averageAgeByUsers(), 0.0);
    }

    @Test
    @DisplayName("Users up to 18")
    public void usersUpToEighteen() throws InterruptedException {
        Thread.sleep (5000);
        Assertions.assertTrue(userEighteenManager.usersUpperThanEighteen());
    }
    @Test
    @DisplayName("Users up to 18 Negative")
    public void usersUpToEighteenTrue() throws InterruptedException {
        Thread.sleep (5000);
        Assertions.assertFalse(userEighteenManagerNeg.usersUpperThanEighteen());
    }

    @RepeatedTest(value = 10, name = "S or A in firstName")
    public void isSorAinFirstName(RepetitionInfo repetitionInfo) throws InterruptedException {
        Thread.sleep (5000);
        System.out.println(repetitionInfo.getCurrentRepetition() + " from " + repetitionInfo.getTotalRepetitions());
        Assertions.assertTrue(userEighteenManager.usersFirstLetterS());
    }
    @Test
    public void isSorAinFirstNameNeg(){
        Assertions.assertFalse(userEighteenManagerNeg.usersFirstLetterS());
    }
    @AfterEach
    public void afterTests() {
        System.out.println("The end of this test");
    }
    @AfterAll
    public static void closeTests() {
        userManager = null;
        userEighteenManager = null;
        userSortedManager = null;
        userSortedByAgeManager = null;
    }
}
