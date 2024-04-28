package Java;

import java.util.List;

import Java.Labirinth;
import Java.Room;
import Java.Characters.Student;
import Java.Items.AirFreshener;
import Java.util.GameStorageUtil;

/**
 * Class that contains test fuctions
 * Related to the Items
 */
public class ItemTest {
    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);

    /**
     * Test function to testcase 10
     * Légtisztító használata
     */
    public static void test10(){
        String gameName = "map10";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, true, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        // Items
        AirFreshener airFreshener = new AirFreshener(1, true);
        student.pickUpItem(airFreshener);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands10.txt");
    }
}
