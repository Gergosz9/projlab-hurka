package Java;

import java.util.*;

import Java.Characters.Student;
import Java.Characters.Teacher;

public class Labirinth {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Room> rooms;

    public Labirinth() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        rooms = new ArrayList<>();
    }
    /**
     * TBD
     * Cycles through players to let them perform their round
     */
    public void doStudentRound() {
        for (Student student : students) {
            // do student's round
        }
    }

    /**
     * TBD
     * Cycles through teachers, performs their round
     */
    public void doTeacherRound() {
        for (Teacher teacher : teachers) {
            // do teacher's round
        }
    }

    /*
     * Updates state of rooms
     */
    public void updateRooms() {
        // Prevents change in number of rooms
        int numberOfRooms = rooms.size();
        split();
        if (numberOfRooms != rooms.size()) {
            merge();
        }

        for (Room room : rooms) {
            room.updateDoors();
            room.updateItems();
        }
    }

    /**
     * Shuffles rooms randomly,
     * selects one room to split into two, then places both in rooms
     */
    private void split() {
        Collections.shuffle(rooms);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getOpenRooms().size() >= 2) {
                rooms.add(rooms.get(i).split());
                break;
            }
        }
    }

    /**
     * Shuffles rooms randomly,
     * selects two rooms to merge into one ()
     */
    private void merge() {
        Random random = new Random();
        Collections.shuffle(rooms);
        rooms.get(0).merge(rooms.get(0).getOpenRooms().get(random.nextInt(rooms.get(0).getOpenRooms().size())));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
