
 package Java;

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

 import java.util.Collections;
 import java.util.List;
 import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class Test {

    // Tesztelés
    public static void main(String[] args) {
        Labirinth labirinth;
        
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

        Scanner scanner = new Scanner(System.in);
        while (testCase != 24) {
              printTests();
              System.out.print("\nVálassz egy tesztesetet: ");
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
                     test23();
                      break;
                 case 24:
                      endTest();
                      break;
                 default:
                      System.out.println("Nincs megfelelő függvény ehhez a számhoz.");
                 }
              }
              scanner.close();
        }
    }

    /**
    * Function to print the names and numbers of possible test cases.
    */
    static void printTests() {
         System.out.println("\nLehetséges tesztesetek:");
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
         System.out.println();

         processCommandFile("commands01.txt");        
    }
}

