import java.util.List;

/*
 *  There are a number of students in a school who wait to be served.
 *  Two types of events, ENTER and SERVED, can take place which are described below.
 *  ENTER: A student with some priority enters the queue to be served.
 *  SERVED: The student with the highest priority is served (removed) from the queue.
 *  A unique id is assigned to each student entering the queue.
 *  The queue serves the students based on the following criteria (priority criteria):
 *
 *  The student having the highest Cumulative Grade Point Average (CGPA) is served first.
 *  Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
 *  Any students having the same CGPA and name will be served in ascending order of the id.
 *  Create the following two classes:
 *
 *  The Student class should implement:
 *  The constructor Student(int id, String name, double cgpa).
 *  The method int getID() to return the id of the student.
 *  The method String getName() to return the name of the student.
 *  The method double getCGPA() to return the CGPA of the student.
 *  The Priorities class should implement the method List<Student> getStudents(List<String> events)
 *  to process all the given events and return all the students yet to be served in the priority order.
 * */
public class PriorityQueueStudentsServed {

    public static void main(String[] args) {
        List<String> events = List.of(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );

        Priorities priorities = new Priorities();
        priorities.getStudents(events).forEach(s -> System.out.println(s.getName())); // Dan
                                                                                      // Ashley
                                                                                      // Shafaet
                                                                                      // Maria
    }
}
