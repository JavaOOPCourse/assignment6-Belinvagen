import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        HashMap<String, Student> students = new HashMap<>();

        Student belek = new Student("Belek", 3.6, 18);
        Student roman = new Student("Roman", 3.6, 45);
        Student erbol = new Student("Erbol", 3.8, 19);
        Student nurdan = new Student("Nurdan", 2.2, 18);
        Student adel = new Student("Adel", 2.9, 18);

        students.put("belek", belek);
        students.put("roman", roman);
        students.put("erbol", erbol);
        students.put("nurdan", nurdan);
        students.put("adel", adel);

        for (String key : students.keySet()) {
            System.out.print("ID: " + key + " | ");
            System.out.println(students.get(key));
        }

        System.out.println(students.get("belek"));

        students.remove("belek");

        students.get("roman").setGpa(3.8);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> studentsList = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(studentsList);
        System.out.println(studentsList);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        Comparator<Student> comparator = Comparator.comparing(Student::getName);
        studentsList.sort(comparator);
        System.out.println(studentsList);

        // ====================== TASK 2 ======================
        ArrayList<Student> studentsList2 = new ArrayList<>(students.values());
        Comparator<Student> comparator2 = Comparator.comparing(Student::getGpa);
        Collections.sort(studentsList2, Collections.reverseOrder(comparator2));
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        for (Student student : studentsList2.subList(0, 3)) {
            System.out.println(student);
        }

        // ====================== TASK 3 ======================
        HashMap<Double, Integer> gradeGroups = new HashMap<>();
        studentsList2.add(belek);
        for (Student student : studentsList2) {
            if (gradeGroups.containsKey(student.getGpa())) {
                gradeGroups.put(student.getGpa(), gradeGroups.get(student.getGpa()) + 1);
            } else {
                gradeGroups.put(student.getGpa(), 1);
            }
        }
        System.out.println("\n=== Task 3: Students with same GPA ===");
        for (Double gpa :  gradeGroups.keySet()) {
            if (gradeGroups.get(gpa) > 1) {
                System.out.println(gpa + ": " + gradeGroups.get(gpa));
            }
        }


        // ====================== TASK 4 ======================
        HashMap<Course, List<Student>> courseMap = new HashMap<>();

        Course math =  new Course("Math");
        Course english = new Course("English");
        Course pl =  new Course("PL");

        courseMap.put(math, new ArrayList<>());
        courseMap.put(english, new ArrayList<>());
        courseMap.put(pl, new ArrayList<>());

        courseMap.get(math).add(belek);
        courseMap.get(math).add(roman);
        courseMap.get(english).add(roman);
        courseMap.get(english).add(nurdan);
        courseMap.get(pl).add(nurdan);
        courseMap.get(pl).add(erbol);

        System.out.println("\n=== Task 4: Courses ===");
        for (Course course : courseMap.keySet()) {
            System.out.println(course);
            for (Student student : courseMap.get(course)) {
                System.out.println(student);
            }
        }


        // ====================== TASK 5 ======================
        Comparator<Student> comparator3 = (s1, s2) -> {
            int gpaCompare = Double.compare(s2.getGpa(), s1.getGpa());

            if (gpaCompare != 0) {
                return gpaCompare;
            }

            return s1.getName().compareTo(s2.getName());
        };

        studentsList2.sort(comparator3);

        System.out.println("\n=== Task 5: GPA desc + Name ===");
        for (Student student : studentsList2) {
            System.out.println(student);
        }


    }
}
