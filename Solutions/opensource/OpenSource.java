import java.util.*;

/**
 * Solution to the "Open Source" problem on Kattis.
 * @author Brendan Jones
 */
public class OpenSource {

    private static class Project {

        /**
         * The name of the project.
         */
        private final String name;

        /**
         * The set of students registered to this project.
         */
        private final Set<String> students = new HashSet<>();

        /**
         * Creates a new Project.
         */
        private Project(String name) {
            this.name = name;
        }

        /**
         * Gets the project name.
         * @return The project name.
         */
        private String name() {
            return name;
        }

        /**
         * Gets the number of students that registered for this project.
         * @return The number of registered students.
         */
        private int size() {
            return students.size();
        }

        @Override
        public String toString() {
            return name() + " " + size();
        }

    }

    private static boolean processTestCase(Scanner sc) {
        // Maps project names to the project.
        final var projects = new HashMap<String, Project>();
        // Maps student ids to the name of they first signed up for.
        final var registrations = new HashMap<String, String>();
        // Set of students that registered for more than one project.
        final var invalidStudents = new HashSet<String>();

        Project currentProject = null;

        var hasAnotherTestCase = false;

        while (sc.hasNextLine()) {
            final var line = sc.nextLine();

            // Test cases end with either `0` or `1`. A value of 0 indicates no test case follows.
            if (line.equals("0") || line.equals("1")) {
                hasAnotherTestCase = line.equals("1");
                break;
            }

            // Project names are written in uppercase letters, and student ids are written in lowercase letters.
            if (Character.isUpperCase(line.charAt(0))) {
                // Line is the name of a new project.
                currentProject = new Project(line);
                projects.put(line, currentProject);
            } else {
                // Line is the id of a student that registered for the project.
                final var fcp = currentProject;
                final var registeredTo = registrations.computeIfAbsent(line, k -> fcp.name);
                if (registeredTo.equals(currentProject.name)) {
                    // Student is not already registered to another project, so invalidate it.
                    currentProject.students.add(line);
                } else {
                    // Student is already registered to a different project, so invalidate them.
                    invalidStudents.add(line);
                }
            }
        }

        // Build up the result set.
        final var res = new TreeSet<>(Comparator.comparingInt(Project::size).reversed().thenComparing(Project::name));
        projects.forEach((name, p) -> {
            p.students.removeAll(invalidStudents);
            res.add(p);
        });
        res.forEach(System.out::println);

        return hasAnotherTestCase;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}
