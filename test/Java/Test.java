package Java;

import java.util.*;

/*
 * The Test class contains the test for the program, 
 * and a main function to run the selected tests.
 */
public class Test {

    /**
     * Array containing the names of possible test cases.
     */
    static String[] tests = {
            "Átkozott szobában ajtók változása", // 1
            "Tranzisztor használata", // 2
            "Camembert használata", // 3
            "Törlőrongy használata", // 4
            "Logarléc megszerzése", // 5
            "TVSZ használata 1", // 6
            "TVSZ használata 2", // 7
            "Söröspohár használata 1", // 8
            "Söröspohár használata 2", // 9
            "Maszk használata 1", // 10
            "Maszk használata 2", // 11
            "Passzív tárgyak használata", // 12
            "Hallgató összefut tanárral", // 13
            "Tanár összefut hallgatóval", // 14
            "Egy szoba ketté válik", // 15
            "Két szoba összeolvad", // 16
            "Gázos szoba maszk nélkül", // 17
            "Tanár rongyos szobába lép.", // 18
            "Tanuló átlép egy másik szobába", // 19
            "Tanár átlép egy másik szobába", // 20
            "Tárgy felvétele", // 21
            "Tárgy letétele", // 22
            "Tesztelés vége" // 23
    };

    /**
     * Function to print the names and numbers of possible test cases.
     */
    static void printTests() {
        System.out.println("Lehetséges tesztesetek:");
        for (int i = 1; i <= 23; i++) {
            if (i == 1 || i == 23)
                System.out.println("\n");
            System.out.println(i + ": " + tests[i - 1]);
        }
    }

    /**
     * Function that runs the 1st test case
     */
    static void test01() {
        Room r1 = new Room("tmp1", testCase, false, false, null, null);
        Room r2 = new Room("tmp2", testCase, false, false, null, null);
        Room r3 = new Room("tmp3", testCase, false, false, null, null);
        Room r4 = new Room("tmp4", testCase, false, false, null, null);
        List<Room> closed = new ArrayList<Room>();
        closed.add(r1);
        closed.add(r2);
        List<Room> open = new ArrayList<Room>();
        open.add(r3);
        open.add(r4);

        Room room = new Room("atkozott", 10, false, false, closed, open);
        System.out.println("open doors:\n");
        for (Room r : room.getOpenRooms()) {
            System.out.print(r.getName() + ", ");
        }
        System.out.println("\nclosed doors:\n");
        for (Room r : room.getClosedRooms()) {
            System.out.print(r.getName() + ", ");
        }

        room.updateDoors();
        System.out.println("[" + room.getName() + "]: SHUFFLING OPEN DOORS");
        System.out.println("open doors:");
        for (Room r : room.getOpenRooms()) {
            System.out.print(r.getName() + ", ");
        }
        System.out.println("closed doors:");
        for (Room r : room.getClosedRooms()) {
            System.out.print(r.getName() + ", ");
        }
    }

    /**
     * Function that runs the 2nd test case
     */
    static void test02() {
        Labirinth labirinth = new Labirinth();
        Room room = new Room("temp1", 1, false, false, null, null);
        Student student = new Student("student", labirinth);
        student.move(room);
        Transistor t1 = new Transistor(1);
        Transistor t2 = new Transistor(1);
        student.pickUpItem(t1);
        student.pickUpItem(t2);

        System.out.println("Pairing transistors");
        student.useItem(ItemTrigger.UseActiveItem);

        System.out.println("dropping transistor");
        student.dropItem(t1, student.getMyLocation());

        System.out.println("Student moving");
        student.move(new Room("temp2", 1, false, false, null, null));

        System.out.println("Teleporting with transistor");
        student.useItem(ItemTrigger.UseActiveItem);
    }

    /**
     * Function that runs the 3rd test case
     */
    static void test03() {
        Labirinth labirinth = new Labirinth();
        Room r1 = new Room("temp1", 1, false, false, null, null);
        Room r2 = new Room("temp2", 1, false, false, null, null);
        Student student = new Student("student", labirinth);
        Teacher teacher = new Teacher("teacher", labirinth);

        Camembert c1 = new Camembert();
        Camembert c2 = new Camembert();

        student.move(r1);
        teacher.move(r2);

        student.pickUpItem(c1);
        System.out.println("Student uses Camembert");
        student.useItem(ItemTrigger.UseActiveItem);

        teacher.pickUpItem(c2);
        System.out.println("teacher uses Camembert");
        teacher.useItem(ItemTrigger.UseActiveItem);

    }

    /**
     * Function that runs the 4th test case
     */
    static void test04() {

    }

    /**
     * Function that runs the 5th test case
     */
    static void test05() {

    }

    /**
     * Function that runs the 6th test case
     */
    static void test06() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test07() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test08() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test09() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test10() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test11() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test12() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test13() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test14() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test15() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test16() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test17() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test18() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test19() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test20() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test21() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void test22() {

    }

    /**
     * Function that runs the 1st test case
     */
    static void endTest() {
        testCase = 23;
        System.out.print("\nA tesztelés befejezték.");

    }

    /**
     * Variable that defines the current test case
     */
    static int testCase;

    /**
     * The main function that runs the testing
     *
     * It consists of a while loop that first lists possible test cases,
     * prompts the user for a number,
     * and then runs the test with the specified sequence number.
     * Then lists the tests again and asks for a number.
     * To finish testing, you must provide the corresponding input.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (testCase != 23) {
            printTests();
            System.out.print("Válassz egy tesztesetet: ");
            testCase = scanner.nextInt();

            switch (testCase) {
                case 1:
                    test01();
                    break;
                case 2:
                    test02();
                    break;
                case 3:
                    test03();
                    break;
                case 4:
                    test04();
                    break;
                case 5:
                    test05();
                    break;
                case 6:
                    test06();
                    break;
                case 7:
                    test07();
                    break;
                case 8:
                    test08();
                    break;
                case 9:
                    test09();
                    break;
                case 10:
                    test10();
                    break;
                case 11:
                    test11();
                    break;
                case 12:
                    test12();
                    break;
                case 13:
                    test13();
                    break;
                case 14:
                    test14();
                    break;
                case 15:
                    test15();
                    break;
                case 16:
                    test16();
                    break;
                case 17:
                    test17();
                    break;
                case 18:
                    test18();
                    break;
                case 19:
                    test19();
                    break;
                case 20:
                    test20();
                    break;
                case 21:
                    test21();
                    break;
                case 22:
                    test22();
                    break;
                case 23:
                    endTest();
                    break;
                default:
                    System.out.println("Nincs megfelelő függvény ehhez a számhoz.");
            }
        }
    }
}
