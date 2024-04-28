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

public class ItemTest {

    //Tranzisztor használata
    public static void test01(){ 
        String gameName = "map01";
        Labirinth labirinth = new Labirinth();
    
        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);
    
        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(student);
    
        Transistor t1= new Transistor(labirinth);
        Transistor t2= new Transistor(labirinth);

        r1.getItems().add(t1);
        r1.getItems().add(t2);
    
        GameStorageUtil.save(gameName, labirinth);
    
    }


    //Camembert
    public static void test02(){
        String gameName = "map02";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, true, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        Mask mask= new Mask(3,false);
        Camembert camembert=new Camembert(1,false);
        student.getInventory().add(camembert);
        student.getInventory().add(mask);

        student.setGasResist(true);
        GameStorageUtil.save(gameName, labirinth);
    }
    //Törlőrongy használata
    public static void test03(){
        String gameName = "map03";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, true, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        Rag rag= new Rag(1,false);
        student.getInventory().add(rag);

        GameStorageUtil.save(gameName, labirinth);
    }

    //Logarléc megszerzése
    public static void test04(){
                String gameName = "map04";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, true, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        SlideRule slideRule = new SlideRule(1, false);
        room.getItems().add(slideRule);

        GameStorageUtil.save(gameName, labirinth);
    }

    //TVSZ használata 1
    public static void test05(){
        String gameName = "map05";
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

        TVSZ tvsz = new TVSZ(3,false);
        student.getInventory().add(tvsz);
        student.setTeacherResist(true);

        GameStorageUtil.save(gameName, labirinth);

    }

    //TVSZ használata 2
    public static void test06(){
        String gameName = "map06";
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

        TVSZ tvsz = new TVSZ(3,false);
        student.getInventory().add(tvsz);
        student.setTeacherResist(false);

        GameStorageUtil.save(gameName, labirinth);

    }

    //Söröspohár használata 1
    public static void test07(){
        String gameName = "map07";
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
    
        Beer beer = new Beer(3,false);
        student.getInventory().add(beer);
        student.setTeacherResist(true);
    
        GameStorageUtil.save(gameName, labirinth);
    
    }
    //Söröspohár használata 2
    public static void test08(){
        String gameName = "map08";
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
    
        Beer beer = new Beer(3,false);
        student.getInventory().add(beer);
        student.setTeacherResist(true);
    
         GameStorageUtil.save(gameName, labirinth);
    
    }

    //Maszk használata
    public static void test09(){ 
        String gameName = "map09";
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
    
        Mask mask = new Mask(3,false);
        student.getInventory().add(mask);
        student.setTeacherResist(true);
    
         GameStorageUtil.save(gameName, labirinth);
    
    }

    //Legtisztito
    public static void test10(){
                String gameName = "map21";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, true, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        AirFreshener airFreshener = new AirFreshener(1, false);
        student.getInventory().add(airFreshener);

        GameStorageUtil.save(gameName, labirinth);
    }
}
