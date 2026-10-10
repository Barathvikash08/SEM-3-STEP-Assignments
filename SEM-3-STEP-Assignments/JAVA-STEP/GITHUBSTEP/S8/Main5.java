import java.util.Scanner;
import java.time.LocalDate;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class Basic extends Subscription {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 365;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Subscription s;

            switch (type) {
                case "BASIC":
                    s = new Basic(name, date);
                    break;
                case "STANDARD":
                    s = new Standard(name, date);
                    break;
                default:
                    s = new Premium(name, date);
            }

            System.out.println(name + ": " + s.getRenewalDate());
        }

        sc.close();
    }
}