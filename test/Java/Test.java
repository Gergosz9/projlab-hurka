
package Java;

// import java.util.*;

// import Java.Characters.Student;
// import Java.Characters.Teacher;
// import Java.Items.Beer;
// import Java.Items.Camembert;
// import Java.Items.Mask;
// import Java.Items.Rag;
// import Java.Items.SlideRule;
// import Java.Items.TVSZ;
// import Java.Items.Transistor;

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

// /*
//  * The Test class contains the test for the program, 
//  * and a main function to run the selected tests.
//  */
public class Test {

//     /**
//      * Array containing the names of possible test cases.
//      */
//     static String[] tests = {
//             "Átkozott szobában ajtók változása", // 1
//             "Tranzisztor használata", // 2
//             "Camembert használata", // 3
//             "Törlőrongy használata", // 4
//             "Logarléc megszerzése", // 5
//             "TVSZ használata 1", // 6
//             "TVSZ használata 2", // 7
//             "Söröspohár használata 1", // 8
//             "Söröspohár használata 2", // 9
//             "Maszk használata 1", // 10
//             "Maszk használata 2", // 11
//             "Passzív tárgyak használata", // 12
//             "Hallgató összefut tanárral", // 13
//             "Tanár összefut hallgatóval", // 14
//             "Egy szoba ketté válik", // 15
//             "Két szoba összeolvad", // 16
//             "Gázos szoba maszk nélkül", // 17
//             "Tanár rongyos szobába lép.", // 18
//             "Tanuló átlép egy másik szobába", // 19
//             "Tanár átlép egy másik szobába", // 20
//             "Tárgy felvétele", // 21
//             "Tárgy letétele", // 22
//             "Tesztelés vége" // 23
//     };

//     /**
//      * Function to print the names and numbers of possible test cases.
//      */
//     static void printTests() {
//         System.out.println("\nLehetséges tesztesetek:");
//         for (int i = 1; i <= 23; i++) {
//             if (i == 1 || i == 23)
//                 System.out.println("\n");
//             System.out.println(i + ": " + tests[i - 1]);
//         }
//     }

//     /**
//      * Function that runs the 1st test case
//      * 
//      * A gép frissíti a szobákat, mire az elátkozott szobában kinyílnak az ajtók,
//      * majd véletlenszerűen visszazáródnak.
//      */
//     static void test01() {
//         System.out.println(
//                 "Forgatókönyv:\n" +
//                         "A gép frissíti a szobákat, mire az elátkozott szobában kinyílnak az ajtók, majd véletlenszerűen visszazáródnak.");

//         Room r1 = new Room("tmp1", 1, false, false, null, null);
//         Room r2 = new Room("tmp2", 1, false, false, null, null);
//         Room r3 = new Room("tmp3", 1, false, false, null, null);
//         Room r4 = new Room("tmp4", 1, false, false, null, null);
//         List<Room> closed = new ArrayList<Room>();
//         closed.add(r1);
//         closed.add(r2);
//         List<Room> open = new ArrayList<Room>();
//         open.add(r3);
//         open.add(r4);

//         System.out.println(
//                 "Létrehozott objektumok: " +
//                         "\nname: r1" +
//                         "\nname: r2" +
//                         "\nname: r3" +
//                         "\nname: r4\n");

//         Room room = new Room("atkozott", 10, true, false, closed, open);

//         System.out.println("name: " + room.getName() + "attribute: closedRooms: {tmp1,tmp2}, openRooms: {tmp3,tmp4}");

//         System.out.println("\nopen doors:");
//         for (Room r : room.getOpenRooms()) {
//             System.out.print(r.getName() + ", ");
//         }
//         System.out.println("\nclosed doors:");
//         for (Room r : room.getClosedRooms()) {
//             System.out.print(r.getName() + ", ");
//         }

//         room.updateDoors();
//         System.out.println("[" + room.getName() + "]: SHUFFLING OPEN DOORS");
//         System.out.println("open doors:");
//         for (Room r : room.getOpenRooms()) {
//             System.out.print(r.getName() + ", ");
//         }
//         System.out.println("closed doors:");
//         for (Room r : room.getClosedRooms()) {
//             System.out.print(r.getName() + ", ");
//         }
//     }

//     /**
//      * Function that runs the 2nd test case
//      * 
//      * A hallgató készletéhez hozzáadásra kerül két tranzisztor,
//      * ezeket összekapcsolja, majd az egyiket lerakja, mozog egy szobát,
//      * aztán visszateleportál a lerakott tranzisztorhoz.
//      */
//     static void test02() {
//         System.out.println(
//                 "Forgatókönyv:\n" +
//                         "A hallgató készletéhez hozzáadásra kerül két tranzisztor, ezeket összekapcsolja, majd az egyiket lerakja, mozog egy szobát, aztán visszateleportál a lerakott tranzisztorhoz.");

//         Labirinth labirinth = new Labirinth();
//         Room room = new Room("temp1", 1, false, false, null, null);
//         Room room2 = new Room("temp2", 1, false, false, null, null);
//         Student student = new Student("student", labirinth);
//         labirinth.getRooms().add(room);
//         labirinth.getRooms().add(room2);
//         room.addStudent(student);
//         Transistor t1 = new Transistor(1, labirinth);
//         Transistor t2 = new Transistor(1, labirinth);

//         System.out.println(
//                 "Létrehozott objektumok: " +
//                         "\nname: room" +
//                         "\nname: student" +
//                         "\nname: t1" +
//                         "\nname: t2" +
//                         "\nname: labirinth");

//         student.pickUpItem(t1);
//         student.pickUpItem(t2);

//         System.out.println("Pairing transistors");
//         student.useItem(ItemTrigger.UseActiveItem, 1);

//         System.out.println("dropping transistor");
//         student.useItem(ItemTrigger.UseActiveItem, 2);

//         System.out.println("Student moving");
//         student.move(room2);

//         System.out.println("Teleporting with transistor");
//         student.useItem(ItemTrigger.UseActiveItem, 1);
//     }

//     /**
//      * Function that runs the 3rd test case
//      * 
//      * A hallgató felhasználja a készletében található Camembert, ezzel gázossá
//      * teszi a szobát.
//      */
//     static void test03() {
//         System.out.println(
//                 "Forgatókönyv:\n" +
//                         "A hallgató felhasználja a készletében található Camembert, ezzel gázossá teszi a szobát.");

//         Labirinth labirinth = new Labirinth();
//         Room r1 = new Room("temp1", 1, false, false, null, null);
//         Room r2 = new Room("temp2", 1, false, false, null, null);
//         Student student = new Student("student", labirinth);
//         Teacher teacher = new Teacher("teacher", labirinth);
//         labirinth.getRooms().add(r1);
//         labirinth.getRooms().add(r2);
//         r1.addStudent(student);
//         r2.addTeacher(teacher);

//         Camembert c1 = new Camembert();
//         Camembert c2 = new Camembert();

//         System.out.println(
//                 "Létrehozott objektumok: " +
//                         "\nname: r1" +
//                         "\nname: r2" +
//                         "\nname: student" +
//                         "\nname: teacher" +
//                         "\nname: c1" +
//                         "\nname: c2" +
//                         "\nname: labirinth");

//         student.move(r1);
//         teacher.move(r2);

//         student.pickUpItem(c1);
//         System.out.println("Student uses Camembert");
//         student.useItem(ItemTrigger.UseActiveItem, 1);

//         teacher.pickUpItem(c2);
//         System.out.println("teacher uses Camembert");
//         teacher.useItem(ItemTrigger.UseActiveItem, 1);

//     }

//     /**
//      * Function that runs the 4th test case
//      * 
//      * A hallgató felhasználja a készletében lévő törlőrongyot, ezzel az adott
//      * szobát bénítóvá téve a tanárok számára.
//      */
//     static void test04() {
//         System.out.println(
//                 "Forgatókönyv:\n" +
//                         "A hallgató felhasználja a készletében lévő törlőrongyot, ezzel az adott szobát bénítóvá téve a tanárok számára.");

//         Labirinth labirinth = new Labirinth();
//         Room r1 = new Room("temp1", 1, false, false, null, null);
//         Student student = new Student("student", labirinth);
//         labirinth.getRooms().add(r1);
//         r1.addStudent(student);
//         student.move(r1);

//         Rag rag = new Rag();

//         System.out.println(
//                 "Létrehozott objektumok: " +
//                         "\nname: r1" +
//                         "\nname: student" +
//                         "\nname: rag" +
//                         "\nname: labirinth");

//         student.pickUpItem(rag);
//         System.out.println("Students uses rag");
//         student.useItem(ItemTrigger.UseActiveItem, 1);
//     }

//     /**
//      * Function that runs the 5th test case
//      * 
//      * A hallgató készletéhez hozzáadásra kerül egy Logarléc, ezzel megnyeri a
//      * játékot és véget is ér.
//      */
//     static void test05() {
//         System.out.println(
//                 "Forgatókönyv:\n" +
//                         "A hallgató készletéhez hozzáadásra kerül egy Logarléc, ezzel megnyeri a játékot és véget is ér.");

//         Labirinth labirinth = new Labirinth();
//         Room r1 = new Room("temp1", 1, false, false, null, null);
//         Student student = new Student("student", labirinth);
//         labirinth.getRooms().add(r1);
//         r1.addStudent(student);
//         student.move(r1);

//         System.out.println(
//                 "Létrehozott objektumok: " +
//                         "\nname: r1" +
//                         "\nname: student" +
//                         "\nname: sr" +
//                         "\nname: labirinth");

//         SlideRule sr = new SlideRule();
//         System.out.println("Student picks up Logarléc");
//         student.pickUpItem(sr);
//         System.out.println("Student uses Logarléc");
//         student.useItem(ItemTrigger.UseActiveItem, 1);
//         System.out.println("Student... wins?...");
//     }

//     /**
//      * Function that runs the 6th test case
//      */
//     static void test06() {
//           System.out.println("\n Forgatókönyv:\n\nA hallgató rendelkezik TVSZ-el.\nA hallgató belép egy szobába, ahol egy tanár van.\nA hallgató nem esik ki a játékból.\nA TVSZ használhatósága eggyel csökken.");

//            System.out.println("\n Létrehozott objektumok:\n\n name: Student\nattribute inventory : List<Item>, TVSZ;\n\n name:Teacher\n\n name:Room\n\n name: TVSZ\nattribute durability : int, 3");

//            Labirinth l = new Labirinth();
//             Student s = new Student("Student", l);
//             Teacher t = new Teacher("Teacher", l);
//             TVSZ tvsz = new TVSZ(3);
//             Room r = new Room("Room", 2, false, false, null, null);
//             s.pickUpItem(tvsz);
//             l.getRooms().add(r);
//             r.addStudent(s);
//             r.addTeacher(t);

//             System.out.println("\n Meghívott metódusok:\n\n name: s.pickUpItem(tvsz) name: s.move(r)\n name: t.move(r)");
    
//             t.move(r);
//             s.move(r);
//     }

//       /**
//       * Function that runs the 7th test case 
//       */
//       static void test07(){
//           System.out.println("\nForgatókönyv:\n\nA hallgató rendelkezik TVSZ-el.\nA tanár belép a szobába, ahol a hallgató van.\nA hallgató nem esik ki a játékból.\nA TVSZ használhatósága eggyel csökken.");

//           System.out.println("\nLétrehozott objektumok:\n\n name: Student\nattribute inventory : List<Item>, TVSZ;\n\n name:Teacher\n name:Room\n\n name: TVSZ\nattribute durability : int, 3");

//           Labirinth l = new Labirinth();
//           Student s = new Student("Student", l);
//           Teacher t = new Teacher("Teacher", l);
//           TVSZ tvsz = new TVSZ(3);
//           Room r = new Room("Room", 2, false, false, null, null);
//           s.pickUpItem(tvsz);
//             l.getRooms().add(r);
//             r.addStudent(s);
//             r.addTeacher(t);

//           System.out.println("\n Meghívott metódusok:\n\n name: s.pickUpItem(tvsz) name: s.move(r)\n name: t.move(r)");
    
//           s.move(r);
//           t.move(r);
//       }
      
//       /**
//       * Function that runs the 8th test case 
//       */
//       static void test08(){
//           System.out.println("\nForgatókönyv:\n\nA hallgató rendelkezik Söröspohárral.\nA hallgató belép egy szobába, ahol egy tanár van.\nA hallgató nem esik ki a játékból.");
      
//           System.out.println("\nLétrehozott objektumok:\n\n name: Student\nattribute inventory : List<Item>, Beer;\n\n name:Teacher\n name:Room\n\n name: Beer\nattribute durability : int, 3");

//             Labirinth l = new Labirinth();
//           Student s = new Student("Student", l);
//           Teacher t = new Teacher("Teacher", l);
//           Beer b = new Beer(3);
//           Room r = new Room("Room", 2, false, false, null, null);
//           s.pickUpItem(b);
//           l.getRooms().add(r);
//             r.addStudent(s);
//             r.addTeacher(t);

//           System.out.println("\n Meghívott metódusok:\n\n name: s.pickUpItem(b)\n name: s.useItem(NewRound, 0) name: s.move(r)\n name: t.move(r)");
    
//           s.useItem(ItemTrigger.NewRound, 0);
//           t.move(r);
//           s.move(r);
//       }
      
//       /**
//       * Function that runs the 9th test case 
//       */
//       static void test09(){
//           System.out.println("\nForgatókönyv:\n\nA hallgató rendelkezik Söröspohárral.\nA tanár belép a szobába, ahol a hallgató van.\nA hallgató nem esik ki a játékból.");

//                 System.out.println("\nLétrehozott objektumok:\n\n name: Student\nattribute inventory : List<Item>, Beer;\n\n name:Teacher\n name:Room\n\n name: Beer\nattribute durability : int, 3");
//         Labirinth l = new Labirinth();
//           Student s = new Student("Student", l);
//           Teacher t = new Teacher("Teacher", l);
//           Beer b = new Beer(3);
//           Room r = new Room("Room", 2, false, false, null, null);
//           l.getRooms().add(r);
//             r.addStudent(s);
//             r.addTeacher(t);
//           s.pickUpItem(b);

//          System.out.println("\n Meghívott metódusok:\n\n name: s.pickUpItem(b)\n name: s.useItem(NewRound, 0) name: s.move(r)\n name: t.move(r)");
    
//           s.useItem(ItemTrigger.NewRound, 0);
//           s.move(r);
//           t.move(r);
//       }
      
//       /**
//       * Function that runs the 10th test case 
//       */
//       static void test10(){
//           System.out.println("\nForgatókönyv:\n\nA karakter gázos szobába lép.\nA karakterre nem hat a gázos szoba hatása.");

//                 System.out.println("\nLétrehozott objektumok:\n\n name: Student\nattribute inventory : List<Item>, Mask;\n\n name:Room\nattribute gassed : boolean, true\n\n name: Mask\nattribute durability : int, 3");
//         Labirinth l = new Labirinth();
//           Student s = new Student("Student", l);
//           Mask m = new Mask();
//           Room r = new Room("Room", 2, false, true, null, null);
//             l.getRooms().add(r);
//             r.addStudent(s);
//           s.pickUpItem(m);

//           System.out.println("\n Meghívott metódusok:\n\n name: s.pickUpItem(m)\n name: s.move(r)");    
//           s.move(r);
//       }
      
//       /**
//       * Function that runs the 11th test case 
//       */
//       static void test11(){
//           System.out.println("\nForgatókönyv:\n\nA szoba, amiben a karakter van, gázos lesz.\nA karakterre nem hat a gázos szoba hatása. ");
          
//            System.out.println("\nLétrehozott objektumok:\n\n name: Student\nattribute inventory : List<Item>, Mask;\n\n name:Room\nattribute gassed : boolean, false\n\n name: Mask\nattribute durability : int, 3");

//            Labirinth l = new Labirinth();
//           Student s = new Student("Student", l);
//           Mask m = new Mask();
//           Room r = new Room("Room", 2, false, false, null, null);
//             l.getRooms().add(r);
//             r.addStudent(s);
//           s.pickUpItem(m);

//          System.out.println("\n Meghívott metódusok:\n\n name: s.pickUpItem(m)\n name: s.move(r)\n name: r.setGassed(true)");

//           s.move(r);
//           r.setGassed(true);
//       }
      
//       /**
//       * Function that runs the 12th test case 
//       */
//       static void test12(){
//           System.out.println("\nForgatókönyv:\n\nVéget ér egy menet.\nA karakterek készletében lévő tárgyak használhatósága csökken.");
            
//           System.out.println("\nLétrehozott objektumok:\n\n name: Student\nattribute inventory : List<Item>, Beer;\n\n name: Beer\nattribute durability : int, 3");

//           Beer b = new Beer(3);
//           Student s = new Student("Student", new Labirinth());
//           s.pickUpItem(b);

//          System.out.println("\n Meghívott metódusok:\n\n name: s.pickUpItem(b)\n name: s.useItem(NewRound)");
    
//           s.useItem(ItemTrigger.NewRound, 0);
//       }
    
//     /**
//      * Function that runs the 13st test case
//      */
//     static void test13() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A hallgató belép egy szobába ahol tanár tartózkodik\n" + 
//                          "A hallgató nincs bevédve és nincs védelmi eszköze.\n" +
//                         "A hallgató kiesik a játékból.\n");
//         Student s = new Student("Student", new Labirinth());
//         Teacher t = new Teacher("Teacher", new Labirinth());
//         Room r = new Room("Room", 2, false, false, null, null);
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name:Teacher\n" +
//                         " name:Room\n\n");
//         r.addTeacher(t);
//         r.addStudent(s);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r.addTeacher(t)\n" +
//                         " name: r.addStudent(s)\n");
//     }

//     /**
//      * Function that runs the 14st test case
//      */
//     static void test14() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A tanár belép egy szobába ahol hallgató tartózkodik\n" + 
//                          "A hallgató nincs bevédve és nincs védelmi eszköze.\n" +
//                         "A hallgató kiesik a játékból.\n");
//         Student s = new Student("Student", new Labirinth());
//         Teacher t = new Teacher("Teacher", new Labirinth());
//         Room r = new Room("Room", 2, false, false, null, null);
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name:Teacher\n" +
//                         " name:Room\n\n");
//         r.addStudent(s);
//         r.addTeacher(t);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r.addStudent(s)\n" +
//                         " name: r.addTeacher(t)\n");
//     }

//     /**
//      * Function that runs the 15st test case
//      */
//     static void test15() {
//         System.err.println("\nForgatókönyv:\n\n" +
//                          "Egy szoba ketté válik.\n" + 
//                          "A kiválasztott szoba létrehoz egy új szobát amivel megosztja a szomszédait, tulajdonságait, ott lévő karaktereket és inventory tartalmát.\n" + 
//                          "A kiválasztott szoba átadja az új szobát akikkel szomszédos lesz.\n" +
//                          "Az új szoba bekerül a labirintus gyüjteményébe\n");
//         Room r1 = new Room("temp1 temp2", 5, false, true, new ArrayList<Room>(), new ArrayList<Room>());
//         Student s = new Student("Student", new Labirinth());
//         Student s2 = new Student("Student2", new Labirinth());
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Room\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name: Student2\n\n" +
//                         "attribute inventory : List<Item>;\n\n");
//         r1.addStudent(s);
//         r1.addStudent(s2);
//         Room r2 = r1.split();
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r1.addStudent(s)\n" +
//                         " name: r1.addStudent(s2)\n" +
//                         " name: r1.split()\n");
//     }

//     /**
//      * Function that runs the 16st test case
//      */
//     static void test16() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "Olyan két szoba választás ami összeolvadhat.\n" + 
//                          "A kiválasztott szoba átveszi a másik szoba szomszédait, tulajdonságait, ott lévő karaktereket és inventory tartalmát. \n" + 
//                          "A másik szoba törlődik a labirintusból és a játékból.\n");
//         Room r1 = new Room("temp1", 5, false, true, new ArrayList<Room>(), new ArrayList<Room>());
//         Room r2 = new Room("temp2", 3, false, true, new ArrayList<Room>(), new ArrayList<Room>());
//         Student s = new Student("Student", new Labirinth());
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Room\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n");
//         r1.addStudent(s);
//         r1.merge(r2);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r1.addStudent(s)\n" +
//                         " name: r1.merge(r2)\n");
//     }

//     /**
//      * Function that runs the 17st test case
//      */
//     static void test17() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A hallgató belép egy gázos szobába, de nincs nála maszk.\n" + 
//                          "Karakter belép egy gázos szobába.\n" + 
//                          " Karakter eldobja az összes tárgyát\n" + 
//                          " Karakter köre véget ér.");
//         Labirinth l = new Labirinth();
//         Student s = new Student("Student", l);
//         Room r = new Room("Room", 2, false, true, null, null);
//         l.getRooms().add(r);
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name: Room\n\n");
//         r.addStudent(s);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r.addStudent(s)\n" +
//                         " name: s.move(r)\n");
//         r.addStudent(s);
//         s.move(r);
//     }

//     /**
//      * Function that runs the 18st test case
//      */
//     static void test18() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A tanár belép egy rongyos szobába.\n" + 
//                          "A tanár eldobja az összes tárgyát\n" + 
//                          "A tanár köre véget ér.");
//         Labirinth l = new Labirinth();
//         Teacher t = new Teacher("Teacher", l);
//         Room r = new Room("Room", 2, false, true, null, null);
//         l.getRooms().add(r);
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Teacher\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name: Room\n\n");
//         r.setRagged(1);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r.setRagged(1)\n" +
//                         " name: r.addTeacher(t)\n");
//         r.addTeacher(t);
//         t.move(r);
//     }

//     /**
//      * Function that runs the 19st test case
//      */
//     static void test19() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A tanuló át tud menni egy másik szobába.\n"+
//                          "Mielőtt átmegy a másik szobába azonban megnézi, hogy van-e még szabad hely abban, ha nincs akkor nem tud átmenni.\n");
//         Labirinth l = new Labirinth();
//         Student s = new Student("Student", l);
//         Room r1 = new Room("Room1", 2, false, false, null, null);
//         Room r2 = new Room("Room2", 2, false, false, null, null);
//         l.getRooms().add(r1);
//         l.getRooms().add(r2);
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name: Room1\n\n" +
//                         " name: Room2\n\n");
//         r1.addStudent(s);
//         s.move(r2);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r1.addStudent(s)\n" +
//                         " name: s.move(r2)\n");
//     }

//     /**
//      * Function that runs the 20st test case
//      */
//     static void test20() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A tanár át tud menni egy másik szobába.\n"+
//                          "Mielőtt átmegy a másik szobába azonban megnézi, hogy van-e még szabad hely abban, ha nincs akkor nem tud átmenni.\n");
//         Labirinth l = new Labirinth();
//         Teacher t = new Teacher("Teacher", l);
//         Room r1 = new Room("Room1", 2, false, false, null, null);
//         Room r2 = new Room("Room2", 2, false, false, null, null);
        
//         l.getRooms().add(r1);
//         l.getRooms().add(r2);
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Teacher\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name: Room1\n\n" +
//                         " name: Room2\n\n");
//         r1.addTeacher(t);
//         t.move(r2);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: r1.addTeacher(t)\n" +
//                         " name: t.move(r2)\n");
//     }

//     /**
//      * Function that runs the 21st test case
//      */
//     static void test21() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A hallgató felvesz egy tárgyat.\n"+
//                          "A tanuló felvesz egy tárgyat abban az esetben, ha annak nincsen tele a kapacitása.\n");
//         Student s = new Student("Student", new Labirinth());
//         Rag r = new Rag();
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name: Rag\n\n");
//         s.pickUpItem(r);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: s.pickUpItem(r)\n");
//     }

//     /**
//      * Function that runs the 22st test case
//      */
//     static void test22() {
//         System.out.println("\nForgatókönyv:\n\n" +
//                          "A hallgató leteszi a tárgyat.\n"+
//                          "A tanuló lerak egy TVSZ tárgyat az egyik szobában.\n");
//         Student s = new Student("Student", new Labirinth());
//         TVSZ tvsz = new TVSZ(3);
//         Room r = new Room("Room", 2, false, false, null, null);
//         System.out.println("\n\n" +
//                         "Létrehozott objektumok:\n\n" +
//                         " name: Student\n" +
//                         "attribute inventory : List<Item>;\n\n" +
//                         " name: Room\n\n" +
//                         " name: TVSZ\n\n");
//         s.pickUpItem(tvsz);
//         s.dropItem(tvsz, r);
//         System.out.println("\n\n" +
//                         "Meghívott metódusok:\n\n" +
//                         " name: s.pickUpItem(tvsz)\n" +
//                         " name: s.dropItem(tvsz, r)\n");
//     }

        static void test23() {
                String gameName = "test-game-status";
                Labirinth labirinth = new Labirinth();

                Student student = new Student("studentName", labirinth);
                Teacher teacher = new Teacher("teacherName", labirinth);
                labirinth.addCharacter(student);
                labirinth.addCharacter(teacher);

                Room closedRoom = new Room("closedRoom", 10, true, false, null, null);
                Room openRoom = new Room("openRoom", 10, true, false, null, null);
                labirinth.addRoom(closedRoom);
                labirinth.addRoom(openRoom);

                Room room = new Room("name", 10, true, false,
                List.of(closedRoom),
                List.of(openRoom));
                room.addCharacter(teacher);
                room.addCharacter(student);
                labirinth.addRoom(room);

                Room room1 = new Room("name1", 10, true, false,
                List.of(closedRoom),
                List.of(room));
                room1.addCharacter(teacher);
                labirinth.addRoom(room1);

                Room room2 = new Room("name2", 10, true, false,
                List.of(room1),
                List.of(room));
                room2.addCharacter(student);
                labirinth.addRoom(room2);

                //Items
                AirFreshener airFreshener = new AirFreshener(1, true);
                Beer beer = new Beer(3);
                Camembert camembert = new Camembert();
                Mask mask = new Mask();
                Rag rag = new Rag();
                SlideRule slideRule = new SlideRule();
                Transistor transistor = new Transistor(4, false, labirinth);
                Transistor transistor1 = new Transistor(5, true, labirinth);
                Transistor transistor2 = new Transistor(6, true, labirinth);
                Transistor transistor3 = new Transistor(7, false, labirinth);

                room.setItems(List.of(airFreshener, beer));
                room.setTransistors(List.of(transistor, transistor1));

                room1.setItems(List.of(camembert, mask));
                room1.setTransistors(List.of(transistor2));

                room2.setItems(List.of(rag, slideRule));
                room2.setTransistors(List.of(transistor3));

                GameStorageUtil.save(gameName, labirinth);
                System.out.println("Game status was SAVED");

                Labirinth loadedLabirinth = GameStorageUtil.load(gameName);
                System.out.println("\nSaved and then loaded game test status:");
                checkResult("labyrinth is not null", loadedLabirinth != null);
                checkResult("number of rooms in labyrinth", loadedLabirinth.getRooms().size() == labirinth.getRooms().size());
                for (int i = 0; i < loadedLabirinth.getRooms().size(); i++) {
        checkResult(String.format("loaded room [%d] is correct", i),
        loadedLabirinth.getRooms().get(i).equals(labirinth.getRooms().get(i)));
        }
        checkResult("number of characters in labyrinth", loadedLabirinth.getCharacters().size() == labirinth.getCharacters().size());
        for (int i = 0; i < loadedLabirinth.getCharacters().size(); i++) {
        checkResult(String.format("loaded character [%d] is correct", i),
        loadedLabirinth.getCharacters().get(i).equals(labirinth.getCharacters().get(i)));
        checkResult(String.format("loaded character [%d] contains labyrinth", i),
        loadedLabirinth.getCharacters().get(i).getLabirinth() == loadedLabirinth);

        }

        checkResult("5th room closed room",
        loadedLabirinth.getRooms().get(4).getClosedRooms().get(0) == loadedLabirinth.getRooms().get(3));
        checkResult("5th room open room",
        loadedLabirinth.getRooms().get(4).getOpenRooms().get(0) == loadedLabirinth.getRooms().get(2));

        checkResult("3rd room 1st character",
        loadedLabirinth.getRooms().get(2).getCharacters().get(0) == loadedLabirinth.getCharacters().get(1));
        checkResult("3rd room 2nd character",
        loadedLabirinth.getRooms().get(2).getCharacters().get(1) == loadedLabirinth.getCharacters().get(0));

        checkResult("3rd room 1st item",
        loadedLabirinth.getRooms().get(2).getItems().get(0).equals(airFreshener));
        checkResult("3rd room 2nd item",
        loadedLabirinth.getRooms().get(2).getItems().get(1).equals(beer));

        checkResult("3rd room 1st transistor",
        loadedLabirinth.getRooms().get(2).getTransistors().get(0).equals(transistor));
        checkResult("3rd room 1st transistor has a labyrinth",
        loadedLabirinth.getRooms().get(2).getTransistors().get(0).getLabirinth() != null);
        checkResult("3rd room 2nd transistor",
        loadedLabirinth.getRooms().get(2).getTransistors().get(1).equals(transistor1));
        checkResult("3rd room 2nd transistor has a labyrinth",
        loadedLabirinth.getRooms().get(2).getTransistors().get(0).getLabirinth() != null);


        GameStorageUtil.deleteRepository();
        }

static void checkResult(String criterion, boolean assertedValue){
        String result = assertedValue? "OK!" : "Not OK!";
        System.out.println(String.format("\t- %s: \t%s", criterion, result));
        }

     /**
      * Function ends the testing
      */
     static void endTest() {
         testCase = 24;
         System.out.print("\nA tesztelést befejezték.");

     }

//     /**
//      * Variable that defines the current test case
//      */
     static int testCase;

//     /**
//      * The main function that runs the testing
//      *
//      * It consists of a while loop that first lists possible test cases,
//      * prompts the user for a number,
//      * and then runs the test with the specified sequence number.
//      * Then lists the tests again and asks for a number.
//      * To finish testing, you must provide the corresponding input.
//      */
     public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);

         while (testCase != 24) {
//             printTests();
             System.out.print("\nVálassz egy tesztesetet: ");
             testCase = scanner.nextInt();

             switch (testCase) {
//                 case 1:
//                     test01();
//                     break;
//                 case 2:
//                     test02();
//                     break;
//                 case 3:
//                     test03();
//                     break;
//                 case 4:
//                     test04();
//                     break;
//                 case 5:
//                     test05();
//                     break;
//                 case 6:
//                     test06();
//                     break;
//                 case 7:
//                     test07();
//                     break;
//                 case 8:
//                     test08();
//                     break;
//                 case 9:
//                     test09();
//                     break;
//                 case 10:
//                     test10();
//                     break;
//                 case 11:
//                     test11();
//                     break;
//                 case 12:
//                     test12();
//                     break;
//                 case 13:
//                     test13();
//                     break;
//                 case 14:
//                     test14();
//                     break;
//                 case 15:
//                     test15();
//                     break;
//                 case 16:
//                     test16();
//                     break;
//                 case 17:
//                     test17();
//                     break;
//                 case 18:
//                     test18();
//                     break;
//                 case 19:
//                     test19();
//                     break;
//                 case 20:
//                     test20();
//                     break;
//                 case 21:
//                     test21();
//                     break;
//                 case 22:
//                     test22();
//                     break;
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
