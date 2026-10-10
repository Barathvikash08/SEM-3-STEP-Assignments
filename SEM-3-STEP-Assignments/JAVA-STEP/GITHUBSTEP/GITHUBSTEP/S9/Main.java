import java.util.Scanner;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20;

    abstract double getPrice();

    double calculateAmount(int count) {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class Regular extends Ticket {
    double getPrice() {
        return 150;
    }
}

class Premium extends Ticket {
    double getPrice() {
        return 250;
    }
}

class Recliner extends Ticket {
    double getPrice() {
        return 400;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket t;

            switch (type) {
                case "REGULAR":
                    t = new Regular();
                    break;
                case "PREMIUM":
                    t = new Premium();
                    break;
                default:
                    t = new Recliner();
            }

            double amount = t.calculateAmount(count);
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}