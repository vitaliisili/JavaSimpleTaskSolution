import java.util.*;
import java.util.stream.Collectors;

public class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> q = new PriorityQueue<>();

        for (String event : events) {
            if (event.contains("ENTER")) {
                String[] student = event.split(" ");
                Student s = new Student(
                        Integer.parseInt(student[3]),
                        student[1],
                        Double.parseDouble(student[2])
                        );
                q.add(s);
            }

            if (event.contains("SERVED")) {
                if (q.size() > 0) {
                    q.poll();
                }
            }
        }

        // The PriorityQueue sort elements incorrect that why we return sorted List
        return q.stream().sorted().collect(Collectors.toList());
    }
}
