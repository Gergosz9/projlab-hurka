package Java;

import java.util.*;

import static Java.ItemTrigger.*;

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
     * 
     * A gép frissíti a szobákat, mire az elátkozott szobában kinyílnak az ajtók,
     * majd véletlenszerűen visszazáródnak.
     */
    static void test01() {
        System.out.println(
                "Forgatókönyv:\n" +
                        "A gép frissíti a szobákat, mire az elátkozott szobában kinyílnak az ajtók, majd véletlenszerűen visszazáródnak.");

        Room r1 = new Room("tmp1", 1, false, false, null, null);
        Room r2 = new Room("tmp2", 1, false, false, null, null);
        Room r3 = new Room("tmp3", 1, false, false, null, null);
        Room r4 = new Room("tmp4", 1, false, false, null, null);
        List<Room> closed = new ArrayList<Room>();
        closed.add(r1);
        closed.add(r2);
        List<Room> open = new ArrayList<Room>();
        open.add(r3);
        open.add(r4);

        System.out.println(
                "Létrehozott objektumok: " +
                        "\nname: r1" +
                        "\nname: r2" +
                        "\nname: r3" +
                        "\nname: r4");

        Room room = new Room("atkozott", 10, false, false, closed, open);

        System.out.println("name: " + room.getName() + "attribute: closedRooms: {tmp1,tmp2}, openRooms: {tmp3,tmp4}");

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
     * 
     * A hallgató készletéhez hozzáadásra kerül két tranzisztor,
     * ezeket összekapcsolja, majd az egyiket lerakja, mozog egy szobát,
     * aztán visszateleportál a lerakott tranzisztorhoz.
     */
    static void test02() {
        System.out.println(
                "Forgatókönyv:\n" +
                        "A hallgató készletéhez hozzáadásra kerül két tranzisztor, ezeket összekapcsolja, majd az egyiket lerakja, mozog egy szobát, aztán visszateleportál a lerakott tranzisztorhoz.");

        Labirinth labirinth = new Labirinth();
        Room room = new Room("temp1", 1, false, false, null, null);
        Student student = new Student("student", labirinth);
        Transistor t1 = new Transistor(1);
        Transistor t2 = new Transistor(1);

        System.out.println(
                "Létrehozott objektumok: " +
                        "\nname: room" +
                        "\nname: student" +
                        "\nname: t1" +
                        "\nname: t2" +
                        "\nname: labirinth");

        student.move(room);
        student.pickUpItem(t1);
        student.pickUpItem(t2);

        System.out.println("Pairing transistors");
        student.useItem(ItemTrigger.UseActiveItem, 1);

        System.out.println("dropping transistor");
        student.dropItem(t1, student.getMyLocation());

        System.out.println("Student moving");
        student.move(new Room("temp2", 1, false, false, null, null));

        System.out.println("Teleporting with transistor");
        student.useItem(ItemTrigger.UseActiveItem, 2);
    }

    /**
     * Function that runs the 3rd test case
     * 
     * A hallgató felhasználja a készletében található Camembert, ezzel gázossá
     * teszi a szobát.
     */
    static void test03() {
        System.out.println(
                "Forgatókönyv:\n" +
                        "A hallgató felhasználja a készletében található Camembert, ezzel gázossá teszi a szobát.");

        Labirinth labirinth = new Labirinth();
        Room r1 = new Room("temp1", 1, false, false, null, null);
        Room r2 = new Room("temp2", 1, false, false, null, null);
        Student student = new Student("student", labirinth);
        Teacher teacher = new Teacher("teacher", labirinth);

        Camembert c1 = new Camembert();
        Camembert c2 = new Camembert();

        System.out.println(
                "Létrehozott objektumok: " +
                        "\nname: r1" +
                        "\nname: r2" +
                        "\nname: student" +
                        "\nname: teacher" +
                        "\nname: c1" +
                        "\nname: c2" +
                        "\nname: labirinth");

        student.move(r1);
        teacher.move(r2);

        student.pickUpItem(c1);
        System.out.println("Student uses Camembert");
        student.useItem(ItemTrigger.UseActiveItem, 1);

        teacher.pickUpItem(c2);
        System.out.println("teacher uses Camembert");
        teacher.useItem(ItemTrigger.UseActiveItem, 1);

    }

    /**
     * Function that runs the 4th test case
     * 
     * A hallgató felhasználja a készletében lévő törlőrongyot, ezzel az adott
     * szobát bénítóvá téve a tanárok számára.
     */
    static void test04() {
        System.out.println(
                "Forgatókönyv:\n" +
                        "A hallgató felhasználja a készletében lévő törlőrongyot, ezzel az adott szobát bénítóvá téve a tanárok számára.");

        Labirinth labirinth = new Labirinth();
        Room r1 = new Room("temp1", 1, false, false, null, null);
        Student student = new Student("student", labirinth);
        student.move(r1);

        Rag rag = new Rag();

        System.out.println(
                "Létrehozott objektumok: " +
                        "\nname: r1" +
                        "\nname: student" +
                        "\nname: rag" +
                        "\nname: labirinth");

        student.pickUpItem(rag);
        System.out.println("Students uses rag");
        student.useItem(ItemTrigger.UseActiveItem, 1);
    }

    /**
     * Function that runs the 5th test case
     * 
     * A hallgató készletéhez hozzáadásra kerül egy Logarléc, ezzel megnyeri a
     * játékot és véget is ér.
     */
    static void test05() {
        System.out.println(
                "Forgatókönyv:\n" +
                        "A hallgató készletéhez hozzáadásra kerül egy Logarléc, ezzel megnyeri a játékot és véget is ér.");

        Labirinth labirinth = new Labirinth();
        Room r1 = new Room("temp1", 1, false, false, null, null);
        Student student = new Student("student", labirinth);
        student.move(r1);

        System.out.println(
                "Létrehozott objektumok: " +
                        "\nname: r1" +
                        "\nname: student" +
                        "\nname: sr" +
                        "\nname: labirinth");

        SlideRule sr = new SlideRule();
        System.out.println("Student picks up Logarléc");
        student.pickUpItem(sr);
        System.out.println("Student uses Logarléc");
        student.useItem(ItemTrigger.UseActiveItem, 1);
        System.out.println("Student... wins?...");
    }

    /**
     * Function that runs the 6th test case
     */
    static void test06() {
          System.out.println("\n Forgatókönyv:\n\n A hallgató rendelkezik TVSZ-el.\n" +
                "A hallgató belép egy szobába, ahol egy tanár van.\n" +
                "A hallgató nem esik ki a játékból.\n" +
                "A TVSZ használhatósága eggyel csökken.");

           System.out.println("\n Létrehozott objektumok:\n" +
                "\n name: Student\n" +
                "attribute inventory : List<Item>, TVSZ;\n" +
                "\n name:Teacher\n" +
                "\n name:Room\n" +
                "\n name: TVSZ\n" +
                "attribute durability : int, 3");

            Student s;
            Teacher t;
            TVSZ tvsz;
            Room r;

            System.out.println("\n Meghívott metódusok:\n" +
                "\n name: t.move(r)" +
                "\n name: s.move(r)" +
                "\n name: s.useItem(TeacherAttack)" +
                "\n name: tvsz.use(TeacherAttack, s)");
    
            t.move(r);
            s.move(r);
            s.useItem(TeacherAttack);
            tvsz.use(TeacherAttack, s);
    }

      /**
      * Function that runs the 7th test case 
      */
      static void test07(){
          System.out.println("\nForgatókönyv:\n\n" +
                "A hallgató rendelkezik TVSZ-el.\n" +
                "A tanár belép a szobába, ahol a hallgató van.\n" +
                "A hallgató nem esik ki a játékból.\n" +
                "A TVSZ használhatósága eggyel csökken.");

          System.out.println("\nLétrehozott objektumok:\n" +
                "\n name: Student\n" +
                "attribute inventory : List<Item>, TVSZ;\n" +
                "\n name:Teacher" +
                "\n name:Room\n" +
                "\n name: TVSZ\n" +
                "attribute durability : int, 3");

          Student s;
          Teacher t;
          TVSZ tvsz;
          Room r;

          System.out.println("\n Meghívott metódusok:\n" +
                "\n name: s.move(r)" +
                "\n name: t.move(r)" +
                "\n name: s.useItem(TeacherAttack)" +
                "\n name: tvsz.use(TeacherAttack, s)");
    
          s.move(r);
          t.move(r);
          s.useItem(TeacherAttack);
          tvsz.use(TeacherAttack, s);

      }
      
      /**
      * Function that runs the 8th test case 
      */
      static void test08(){
          System.out.println("\nForgatókönyv:\n\n" +
                "A hallgató rendelkezik Söröspohárral.\n" +
                "A hallgató belép egy szobába, ahol egy tanár van.\n" +
                "A hallgató nem esik ki a játékból.");
      
          System.out.println("\nLétrehozott objektumok:\n" +
                "\n name: Student\n" +
                "attribute inventory : List<Item>, Beer;\n" +
                "\n name:Teacher" +
                "\n name:Room\n" +
                "\n name: Beer\n" +
                "attribute durability : int, 3");

          Student s;
          Teacher t;
          Beer b;
          Room r;

         System.out.println("\n Meghívott metódusok:\n" +
                "\n name: t.move(r)" +
                "\n name: s.move(r)" +
                "\n name: s.useItem(TeacherAttack)" +
                "\n name: b.use(TeacherAttack, s)");
    
          t.move(r);
          s.move(r);
          s.useItem(TeacherAttack);
          b.use(TeacherAttack, s);
      }
      
      /**
      * Function that runs the 9th test case 
      */
      static void test09(){
          System.out.println("\nForgatókönyv:\n\n" +
                "A hallgató rendelkezik Söröspohárral.\n" +
                "A tanár belép a szobába, ahol a hallgató van.\n" +
                "A hallgató nem esik ki a játékból.");

                System.out.println("\nLétrehozott objektumok:\n" +
                "\n name: Student\n" +
                "attribute inventory : List<Item>, Beer;\n" +
                "\n name:Teacher" +
                "\n name:Room\n" +
                "\n name: Beer\n" +
                "attribute durability : int, 3");

          Student s;
          Teacher t;
          Beer b;
          Room r;

         System.out.println("\n Meghívott metódusok:\n" +
                "\n name: s.move(r)" +
                "\n name: t.move(r)" +
                "\n name: s.useItem(TeacherAttack)" +
                "\n name: b.use(TeacherAttack, s)");
    
          s.move(r);
          t.move(r);
          s.useItem(TeacherAttack);
          b.use(TeacherAttack, s);
      }
      
      /**
      * Function that runs the 10th test case 
      */
      static void test10(){
          System.out.println("\nForgatókönyv:\n\n" +
                "A karakter gázos szobába lép.\n" +
                "A karakterre nem hat a gázos szoba hatása.");

                System.out.println("\nLétrehozott objektumok:\n" +
                "\n name: Student\n" +
                "attribute inventory : List<Item>, Mask;\n" +
                "\n name:Room\n" +
                "attribute gassed : boolean, true\n" +
                "\n name: Mask\n" +
                "attribute durability : int, 3");

          Student s;
          Mask m;
          Room r;

         System.out.println("\n Meghívott metódusok:\n" +
                "\n name: s.move(r)" +
                "\n name: s.useItem(GasAttack)" +
                "\n name: m.use(GasAttack, s)");
    
          s.move(r);
          s.useItem(GasAttack);
          m.use(GasAttack, s);         
      }
      
      /**
      * Function that runs the 11th test case 
      */
      static void test11(){
          System.out.println("\nForgatókönyv:\n\n" +
                "A szoba, amiben a karakter van, gázos lesz.\n" +
                "A karakterre nem hat a gázos szoba hatása. ");
          
           System.out.println("\nLétrehozott objektumok:\n" +
                "\n name: Student\n" +
                "attribute inventory : List<Item>, Mask;\n" +
                "\n name:Room\n" +
                "attribute gassed : boolean, false\n" +
                "\n name: Mask\n" +
                "attribute durability : int, 3");

          Student s;
          Mask m;
          Room r;

         System.out.println("\n Meghívott metódusok:\n" +
                "\n name: s.move(r)" +
                "\n name: r.setGas(true)" +
                "\n name: s.useItem(GasAttack)" +
                "\n name: m.use(GasAttack, s)");
    
          s.move(r);
          r.gassed = true; //elm ezt a camambert megcsinálná, itt a tesztbe hogyan kéne?
          s.useItem(GasAttack);
          m.use(GasAttack, s);         
      }
      
      /**
      * Function that runs the 12th test case 
      */
      static void test12(){
          System.out.println("\nForgatókönyv:\n\n" +
                "Véget ér egy menet.\n" +
                "A karakterek készletében lévő tárgyak használhatósága csökken.");
            
          System.out.println("\nLétrehozott objektumok:\n" +
                "\n name: Student\n" +
                "attribute inventory : List<Item>, Beer;\n" +
                "\n name: Beer\n" +
                "attribute durability : int, 3");

          Beer b;
          Student s;

         System.out.println("\n Meghívott metódusok:\n" +
                "\n name: s.useItem(NewRound)" +
                "\n name: b.use(NewRound, s)");
    
          s.useItem(NewRound);
          b.use(NewRound, s);     
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
        scanner.close();
    }
}
