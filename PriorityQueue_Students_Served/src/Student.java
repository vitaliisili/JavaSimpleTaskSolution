public class Student implements Comparable<Student>{

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
        if(cgpa == o.cgpa) {
            if(name.equals(o.name)) {
                return id - o.id;
            }else {
                return name.compareTo(o.name);
            }
        }else {
            return Double.compare(o.cgpa, cgpa);
        }
    }

}
