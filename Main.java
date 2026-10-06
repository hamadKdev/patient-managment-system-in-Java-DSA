public class Main {

    class Patient {
        String id;
        String name;
        int priority;
        Patient next;

        Patient(String id, String name, int priority) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.next = null;
        }
    }

    Patient head = null;

    // Add patient according to priority
    void addPatient(String id, String name, int priority) {

        Patient newPatient = new Patient(id, name, priority);

        if (head == null) {
            head = newPatient;
            return;
        }

        if (priority < head.priority) {
            newPatient.next = head;
            head = newPatient;
            return;
        }

        Patient current = head;

        while (current.next != null &&
               current.next.priority <= priority) {

            current = current.next;
        }

        newPatient.next = current.next;
        current.next = newPatient;
    }

    // Remove patient by ID
    void removePatient(String id) {

        if (head == null) {
            System.out.println("Waiting list is empty.");
            return;
        }

        if (head.id.equals(id)) {
            head = head.next;
            System.out.println("Patient removed.");
            return;
        }

        Patient current = head;

        while (current.next != null) {

            if (current.next.id.equals(id)) {
                current.next = current.next.next;
                System.out.println("Patient removed.");
                return;
            }

            current = current.next;
        }

        System.out.println("Patient not found.");
    }

    // Search patient by ID
    void searchPatient(String id) {

        Patient current = head;

        while (current != null) {

            if (current.id.equals(id)) {
                System.out.println("Patient Found");
                System.out.println("ID: " + current.id);
                System.out.println("Name: " + current.name);
                System.out.println("Priority: " + current.priority);
                return;
            }

            current = current.next;
        }

        System.out.println("Patient not found.");
    }

    // Change patient priority
    void changePriority(String id, int newPriority) {

        Patient current = head;

        while (current != null && !current.id.equals(id)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Patient not found.");
            return;
        }

        String name = current.name;

        removePatient(id);
        addPatient(id, name, newPriority);

        System.out.println("Priority changed successfully.");
    }

    // Count patients
    int countPatients() {

        int count = 0;
        Patient current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // Serve next patient
    void serveNextPatient() {

        if (head == null) {
            System.out.println("No patients waiting.");
            return;
        }

        System.out.println("Serving Patient");
        System.out.println("ID: " + head.id);
        System.out.println("Name: " + head.name);
        System.out.println("Priority: " + head.priority);

        head = head.next;
    }

    // Display patients by priority
    void displayByPriority(int priority) {

        Patient current = head;
        boolean found = false;

        while (current != null) {

            if (current.priority == priority) {

                System.out.println(
                    current.id + " | " +
                    current.name + " | Priority: " +
                    current.priority
                );

                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No patient with this priority.");
        }
    }

    // Display complete waiting list
    void displayWaitingList() {

        if (head == null) {
            System.out.println("Waiting list is empty.");
            return;
        }

        Patient current = head;

        System.out.println("===== Waiting List =====");

        while (current != null) {

            System.out.println(
                current.id + " | " +
                current.name + " | Priority: " +
                current.priority
            );

            current = current.next;
        }
    }

    public static void main(String[] args) {

        Main hospital = new Main();

        hospital.addPatient("P12", "Ayesha", 1);
        hospital.addPatient("P18", "Hamza", 2);
        hospital.addPatient("P07", "Bilal", 4);
        hospital.addPatient("P20", "Ali", 2);
        hospital.addPatient("P25", "Sara", 1);

        System.out.println("Waiting List:");
        hospital.displayWaitingList();

        System.out.println("\nSearch Patient:");
        hospital.searchPatient("P18");

        System.out.println("\nTotal Patients: "
                + hospital.countPatients());

        System.out.println("\nPriority 2 Patients:");
        hospital.displayByPriority(2);

        System.out.println("\nChanging Priority:");
        hospital.changePriority("P07", 1);
        hospital.displayWaitingList();

        System.out.println("\nRemoving Patient:");
        hospital.removePatient("P18");
        hospital.displayWaitingList();

        System.out.println("\nServing Next Patient:");
        hospital.serveNextPatient();

        System.out.println("\nFinal Waiting List:");
        hospital.displayWaitingList();
    }
}