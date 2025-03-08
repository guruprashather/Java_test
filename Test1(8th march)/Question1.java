enum Category {
    SOFTWARE, HARDWARE;
}
class Employee {
    String fullName;
    int pointLevel;
    Category assignedCategory;

    public Employee(String fullName, int pointLevel, Category assignedCategory) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategory = assignedCategory;
    }
}
class Ticket {
    int id,point;
    String name;
    Category category;
    boolean isCompleted = false;

    public Ticket(int id, String name, Category category, int point) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.point = point;
    }
}

class HelpDesk {
    Employee[] employees = new Employee[2];
    Ticket[] tickets = new Ticket[5];

    public void addEmployee(Employee e, int pos) {
        if (pos >= 1 && pos <= 2) {
            employees[pos - 1] = e;
        }
    }

    public void addTicket(Ticket t, int pos) {
        if (pos >= 1 && pos <= 5) {
            tickets[pos - 1] = t;
        }
    }

    public void completeTicket(String employeeName, int ticketId) {
        Employee employee = findEmployeeByName(employeeName);
        Ticket ticket = findTicketById(ticketId);

        if (employee == null || ticket == null || ticket.isCompleted) {
            System.out.println("Ticket " + ticketId + " cannot be completed.");
            return;
        }

        if (employee.pointLevel >= ticket.point) {
            ticket.isCompleted = true;
            System.out.println("Ticket " + ticketId + " marked as completed by " + employeeName + ".");
        } else {
            System.out.println("Ticket " + ticketId + " cannot be completed by " + employeeName + " (Insufficient points).");
        }
    }

    private Employee findEmployeeByName(String name) {
        for (Employee e : employees) {
            if (e != null && e.fullName.equals(name)) return e;
        }
        return null;
    }

    private Ticket findTicketById(int id) {
        for (Ticket t : tickets) {
            if (t != null && t.id == id) return t;
        }
        return null;
    }

    public int getWaitingTicketCount() {
        int count = 0;
        for (Ticket t : tickets) {
            if (t != null && !t.isCompleted) count++;
        }
        return count;
    }

    public int getCompletedTicketsTotalPoint() {
        int total = 0;
        for (Ticket t : tickets) {
            if (t != null && t.isCompleted) total =total+ t.point;
        }
        return total;
    }
}

public class Question1 {
    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();

        Employee alice = new Employee("Alice Brown", 5, Category.SOFTWARE);
        Employee bob = new Employee("Bob Smith", 8, Category.HARDWARE);
        helpDesk.addEmployee(alice, 1);
        helpDesk.addEmployee(bob, 2);

        Ticket t1 = new Ticket(101, "Software Bug", Category.SOFTWARE, 4);
        Ticket t2 = new Ticket(102, "Network Issue", Category.HARDWARE, 7);
        Ticket t3 = new Ticket(103, "System Crash", Category.HARDWARE, 10);
        Ticket t4 = new Ticket(104, "Printer Not Working", Category.HARDWARE, 3);
        Ticket t5 = new Ticket(105, "UI Bug", Category.SOFTWARE, 2);

        helpDesk.addTicket(t1, 1);
        helpDesk.addTicket(t2, 2);
        helpDesk.addTicket(t3, 3);
        helpDesk.addTicket(t4, 4);
        helpDesk.addTicket(t5, 5);

        helpDesk.completeTicket("Alice Brown", 101);
        helpDesk.completeTicket("Bob Smith", 102);
        helpDesk.completeTicket("Alice Brown", 103);
        helpDesk.completeTicket("Bob Smith", 104);
        helpDesk.completeTicket("Alice Brown", 105);

        System.out.println(helpDesk.getWaitingTicketCount());
        System.out.println( helpDesk.getCompletedTicketsTotalPoint());
    }
}
