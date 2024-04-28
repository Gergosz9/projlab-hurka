
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


public class Test {

    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);

    static String[] tests = {
            "Tranzisztor használata", //1
            "Camembert használata", //2
            "Törlőrongy használata", //3
            "Logarléc megszerzése", //4
            "TVSZ használata 1", //5
            "TVSZ használata 2", //6
            "Söröspohár használata 1", //7
            "Söröspohár használata 2", //8
            "Maszk használata", //9
            "Légtisztító használata", //10
            "Tanár összefut hallgatóval", //11
            "Hallgató összefut tanárral", //12
            "Gázos szoba maszk nélkül", //13
            "Tanár rongyos szobába lép.", //14
            "Karakter átlép egy másik szobába", //15
            "Tárgy felvétele", //16
            "Tárgy letétele", //17
            "Kitessékelés", //18
            "Ragacsos szoba működése", //19
            "ragacsos szoba takarítása", //20
            "szoba ragacsossá válik", //21
            "egy tanár találkozik több diákkal", //22
            "egy diák találkozik több tanárral", //23
            "(tranzisztor nincsen párosítva)", //24
            "Tesztelés vége"
    };

    // Tesztelés
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 0;
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
                     RoomTest.test19();
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
