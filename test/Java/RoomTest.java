package Java;

import Java.Characters.Cleaner;
import Java.Characters.Student;
import Java.Characters.Teacher;
import Java.Items.*;
import Java.util.GameStorageUtil;

import java.lang.ref.Cleaner.Cleanable;
import java.util.List;

import java.util.List;

import Java.Labirinth;
import Java.Room;
import Java.Characters.Student;
import Java.Characters.Teacher;
import Java.util.GameStorageUtil;

public class RoomTest {

    //Ragacsos szoba működése
    public static void test19(){
        String gameName = "map19";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);


        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        Rag rag = new Rag(1, false);

        room.setStickyness(6);
        room.getItems().add(rag);

        GameStorageUtil.save(gameName, labirinth);
    }

    //Ragacsos szoba takarítása
    public static void test20(){ 
        String gameName = "map20";
        Labirinth labirinth = new Labirinth();
    
        Cleaner cleaner = new Cleaner("c1", labirinth);
        labirinth.addCharacter(cleaner);
    
        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(cleaner);
    
        r2.setStickyness(6);
    
         GameStorageUtil.save(gameName, labirinth);
    
    }

    //Szoba ragacsossá válik
    public static void test21(){ 
        String gameName = "map21";
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
    
        r2.setStickyness(4);
    
        GameStorageUtil.save(gameName, labirinth);
    
    }

    //Egy tanár találkozik több hallgatóval(egyik védve, másik nem)
    public static void test22(){ 
        String gameName = "map22";
        Labirinth labirinth = new Labirinth();
    
        Student student = new Student("s1", labirinth);
        Student student2 = new Student("s2", labirinth);
        Teacher teacher= new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(student2);
        labirinth.addCharacter(teacher);
    
        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(student);
        r1.getCharacters().add(student2);
        r2.getCharacters().add(teacher);
        TVSZ tvsz = new TVSZ(3,false);
        student.getInventory().add(tvsz);

    
        GameStorageUtil.save(gameName, labirinth);
    
    }

    //Egy tanár találkozik több hallgatóval(egyik védve, másik nem)
    public static void test23(){ 
        String gameName = "map23";
        Labirinth labirinth = new Labirinth();
    
        Student student = new Student("s1", labirinth);
        Teacher teacher= new Teacher("t1", labirinth);
        Teacher teacher2= new Teacher("t2", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);
        labirinth.addCharacter(teacher2);
    
        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(student);
        r2.getCharacters().add(teacher);
        r2.getCharacters().add(teacher2);
        TVSZ tvsz = new TVSZ(3,false);
        student.getInventory().add(tvsz);

    
        GameStorageUtil.save(gameName, labirinth);
    
    }

}
