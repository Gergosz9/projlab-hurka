package Java;

import java.util.List;

import Java.Labirinth;
import Java.Room;
import Java.Characters.Cleaner;
import Java.Characters.Student;
import Java.Characters.Teacher;
import Java.Items.AirFreshener;
import Java.Items.Beer;
import Java.Items.Camembert;
import Java.Items.Mask;
import Java.Items.Rag;
import Java.Items.SlideRule;
import Java.Items.TVSZ;
import Java.Items.Transistor;
import Java.util.GameStorageUtil;

/**
 * Class that contains test functions
 * Related to the Characters
 */
public class CharacterTest {

    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);

    /**
     * Test function to testcase 11
     *Tanár összefut hallgatóval
     */
    public static void test11(){
        String gameName = "map11";
        Labirinth labirinth = new Labirinth();

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
        r1.getCharacters().add(student);
        r2.getCharacters().add(teacher);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands11.txt");

    }

    /**
     * Test function to testcase 12
     * Hallgató összefut tanárral
     */
    public static void test12(){
        String gameName = "map12";
        Labirinth labirinth = new Labirinth();

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
        r1.getCharacters().add(student);
        r2.getCharacters().add(teacher);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands12.txt");

    }

    /**
     * Test function to testcase 13
     * Gázos szoba maszk nélkül
     */
    public static void test13(){
        String gameName = "map13";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(student);
        TVSZ tvsz=new TVSZ(3,false);
        r1.getItems().add(tvsz);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands13.txt");

    }

    /**
     * Test function to testcase 14
     * Tanár rongyos szobába lép
     */
    public static void test14(){
        String gameName = "map14";
        Labirinth labirinth = new Labirinth();

        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(teacher);
        r2.setRagged(3);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands14.txt");

    }

    /**
     * Test function to testcase 15
     * Karakter átlép egy másik szobába
     */
    public static void test15(){
        String gameName = "map15";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(student);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands15.txt");

    }

    /**
     * Test function to testcase 16
     * Targy felvetele
     */
    public static void test16(){
        String gameName = "map16";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        Rag rag = new Rag(1, true);
        room.getItems().add(rag);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands16.txt");
    }

    /**
     * Test function to testcase 17
     * Targy letelete
     */
    public static void test17(){
        String gameName = "map17";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        // Items
        Rag rag = new Rag(1, true);
        student.getInventory().add(rag);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands17.txt");
    }

    /**
     * Test function to testcase 18
     * Kitessekeles
     */
    public static void test18(){
        String gameName = "map18";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        Cleaner cleaner = new Cleaner("c1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(cleaner);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(cleaner);
        r2.getCharacters().add(student);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands18.txt");

    }
}
