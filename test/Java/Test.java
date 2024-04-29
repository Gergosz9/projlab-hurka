
 package Java;

import Java.*;

 import java.util.*;

 import Java.Characters.Student;
 import Java.Characters.Teacher;
 import Java.Items.Beer;
 import Java.Items.Camembert;
 import Java.Items.Mask;
 import Java.Items.Rag;
 import Java.Items.SlideRule;
 import Java.Items.TVSZ;
 import Java.Items.Transistor;

 import Java.Characters.Student;
 import Java.Characters.Teacher;
 import Java.Items.AirFreshener;
 import Java.Items.Beer;
 import Java.Items.Camembert;
 import Java.Items.Mask;
 import Java.Items.Rag;
 import Java.Items.SlideRule;
 import Java.Items.Transistor;
 import Java.util.GameStorageUtil;

 import Java.TestHandler;

 import java.util.Collections;
 import java.util.List;
 import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

 /**
  * Class that is responsible for the running of tests
  *
  */
public class Test {

    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);

    static String[] tests = {
            "Tranzisztor használata",
            "Camembert használata",
            "Törlőrongy használata",
            "Logarléc megszerzése",
            "TVSZ használata 1",
            "TVSZ használata 2",
            "Söröspohár használata 1",
            "Söröspohár használata 2",
            "Maszk használata",
            "Légtisztító használata",
            "Tanár összefut hallgatóval",
            "Hallgató összefut tanárral",
            "Gázos szoba maszk nélkül",
            "Tanár rongyos szobába lép.",
            "Karakter átlép egy másik szobába",
            "Tárgy felvétele",
            "Tárgy letétele",
            "Kitessékelés",
            "Ragacsos szoba működése",
            "ragacsos szoba takarítása",
            "szoba ragacsossá válik",
            "egy tanár találkozik több diákkal",
            "egy diák találkozik több tanárral",
            "(tranzisztor nincsen párosítva)",
            "Tesztelés vége"
    };

    /**
     * Main function to run the tests
     *
     * Prints the options then waits for a number,
     * and calls the test fuction with the selected number
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 0;
        while (testCase != 24) {
              printTests();
              System.out.print("\nVálassz egy tesztesetet: ");
              testCase = scanner.nextInt();

              switch (testCase) {
                 case 1:
                     ItemTest.test01();
                     break;
                 case 2:
                     ItemTest.test02();
                     break;
                  case 3:
                     ItemTest.test03();
                     break;
                 case 4:
                     ItemTest.test04();
                     break;
                 case 5:
                     ItemTest.test05();
                     break;
                 case 6:
                     ItemTest.test06();
                     break;
                 case 7:
                     ItemTest.test07();
                     break;
                 case 8:
                     ItemTest.test08();
                     break;
                 case 9:
                     ItemTest.test09();
                     break;
                 case 10:
                     ItemTest.test10();
                     break;
                 case 11:
                     CharacterTest.test11();
                     break;
                 case 12:
                     CharacterTest.test12();
                     break;
                 case 13:
                     CharacterTest.test13();
                     break;
                 case 14:
                     CharacterTest.test14();
                     break;
                 case 15:
                     CharacterTest.test15();
                     break;
                 case 16:
                     CharacterTest.test16();
                     break;
                 case 17:
                     CharacterTest.test17();
                     break;
                 case 18:
                     CharacterTest.test18();
                     break;
                 case 19:
                     RoomTest.test19();
                     break;
                 case 20:
                     RoomTest.test20();
                     break;
                 case 21:
                     RoomTest.test21();
                     break;
                 case 22:
                     RoomTest.test22();
                     break;
                 case 23:
                     RoomTest.test23();
                      break;
                 case 24:
                      //endTest();
                      break;
                 default:
                      System.out.println("Nincs megfelelő függvény ehhez a számhoz.");
                 }
        }
        scanner.close();
    }

    /**
    * Function to print the names and numbers of possible test cases.
    */
    static void printTests() {
         System.out.println("\nLehetséges tesztesetek:");
         for (int i = 1; i <= 25; i++) {
             if (i == 1 || i == 25)
                 System.out.println("\n");
             System.out.println(i + ": " + tests[i - 1]);
         }
    }
}
