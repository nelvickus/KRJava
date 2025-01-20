import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину первого отрезка: ");
        double a = scanner.nextDouble();
        System.out.print("Введите длину второго отрезка: ");
        double b = scanner.nextDouble();
        System.out.print("Введите длину третьего отрезка: ");
        double c = scanner.nextDouble();

        if (F(a, b, c)) {
            System.out.println("Данные отрезки могут образовать треугольник.");
            double maxx = y(a, b, c);
            System.out.printf("Наибольший внешний угол треугольника: %.2f градусов%n", maxx);
        } else {
            System.out.println("Данные отрезки не могут образовать треугольник.");
        }
        
        scanner.close();
    }

    private static boolean F(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    private static double y(double a, double b, double c) {
        double A = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        double B = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        double C = Math.acos((a * a + b * b - c * c) / (2 * a * b));

        double ADeg = Math.toDegrees(A);
        double BDeg = Math.toDegrees(B);
        double CDeg = Math.toDegrees(C);

        double maxx = Math.max(180 - ADeg, Math.max(180 - BDeg, 180 - CDeg));

        return maxx;
    }
}
