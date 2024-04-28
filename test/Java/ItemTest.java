package Java;

import java.util.List;

import Java.Labirinth;
import Java.Room;
import Java.Characters.Student;
import Java.Items.AirFreshener;
import Java.util.GameStorageUtil;

public class ItemTest {

    //Legtisztito
    public static void test10(){
                String gameName = "map21";
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
    }
}
