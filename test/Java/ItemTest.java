package Java;

import java.util.List;

import Java.Characters.*;
import Java.Items.*;

/**
 * Class that contains test fuctions
 * Related to the Items
 */
public class ItemTest {

    /**
     * Test function to testcase
     * Tranzisztor használata
     */
    public static void test01() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);

        Transistor t1 = new Transistor(labirinth);
        Transistor t2 = new Transistor(labirinth);

        r1.addItem(t1);
        r1.addItem(t2);

        student.setActionCount(100);

        testhandler.processCommandFile("rsrc/command_resources/commands01.txt");
    }

    /**
     * Test function to testcase 02
     * Camembert használata
     */
    public static void test02() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        // Items
        Mask mask = new Mask(3, false);
        Camembert camembert = new Camembert(1, false);
        student.pickUpItem(camembert);
        student.pickUpItem(mask);

        student.setActionCount(100);

        student.setGasResist(true);
        testhandler.processCommandFile("rsrc/command_resources/commands02.txt");
    }
    //

    /**
     * Test function to testcase 03
     * Törlőrongy használata
     */
    public static void test03() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        student.setActionCount(100);

        // Items
        Rag rag = new Rag(1, false);
        student.pickUpItem(rag);
        student.useItem(0);

        testhandler.processCommandFile("rsrc/command_resources/commands03.txt");
    }

    /**
     * Test function to testcase 04
     * Logarléc megszerzése
     */
    public static void test04() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        student.setActionCount(100);

        // Items
        SlideRule slideRule = new SlideRule(1, false);
        room.addItem(slideRule);

        testhandler.processCommandFile("rsrc/command_resources/commands04.txt");
    }

    /**
     * Test function to testcase 05
     * TVSZ használata 1
     */
    public static void test05() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r2.addCharacter(teacher);

        student.setActionCount(100);
        teacher.setActionCount(100);

        TVSZ tvsz = new TVSZ(3, false);
        student.pickUpItem(tvsz);
        student.setTeacherResist(true);

        testhandler.processCommandFile("rsrc/command_resources/commands05.txt");
    }

    /**
     * Test function to testcase 06
     * TVSZ használata 2
     */
    public static void test06() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r2.addCharacter(teacher);

        student.setActionCount(100);
        teacher.setActionCount(100);

        TVSZ tvsz = new TVSZ(3, false);
        student.pickUpItem(tvsz);
        student.setTeacherResist(false);

        testhandler.processCommandFile("rsrc/command_resources/commands06.txt");
    }

    /**
     * Test function to testcase 07
     * Söröspohár használata 1
     */
    public static void test07() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r2.addCharacter(teacher);

        student.setActionCount(100);
        teacher.setActionCount(100);

        Beer beer = new Beer(3, false);
        student.pickUpItem(beer);
        student.setTeacherResist(true);

        testhandler.processCommandFile("rsrc/command_resources/commands07.txt");
    }

    /**
     * Test function to testcase 08
     * Söröspohár használata 2
     */
    public static void test08() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r2.addCharacter(teacher);

        student.setActionCount(100);
        teacher.setActionCount(100);

        Beer beer = new Beer(3, false);
        student.pickUpItem(beer);
        student.setTeacherResist(true);

        testhandler.processCommandFile("rsrc/command_resources/commands08.txt");
    }

    //
    /**
     * Test function to testcase 09
     * Maszk használata
     */
    public static void test09() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);

        student.setActionCount(100);

        Mask mask = new Mask(3, false);
        student.pickUpItem(mask);
        student.setTeacherResist(true);

        testhandler.processCommandFile("rsrc/command_resources/commands09.txt");
    }

    /**
     * Test function to testcase 10
     * Légtisztító használata
     */
    public static void test10() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, true,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        student.setActionCount(100);

        // Items
        AirFreshener airFreshener = new AirFreshener(1, false);
        student.pickUpItem(airFreshener);

        testhandler.processCommandFile("rsrc/command_resources/commands10.txt");
    }
}
