package Java;

<<<<<<< HEAD
import Java.Characters.Student;
import Java.Characters.Teacher;
import Java.Items.*;
import Java.util.GameStorageUtil;

import java.util.List;

=======
import java.util.List;

import Java.Labirinth;
import Java.Room;
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

public class RoomTest {
    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);


    static void test19() {
        System.out.println("\nRagacsos szoba működése\n");
        //initialize_test19();
        testhandler.processCommandFile("commands19.txt");
    }



}
