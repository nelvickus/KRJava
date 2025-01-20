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

        if (T(a, b, c)) {
            System.out.println("Из этих отрезков можно составить треугольник.");

            double A = Math.acos((b * b + c * c - a * a) / (2 * b * c));
            double B = Math.acos((a * a + c * c - b * b) / (2 * a * c));
            double C = Math.acos((a * a + b * b - c * c) / (2 * a * b));

            A = Math.toDegrees(A);
            B = Math.toDegrees(B);
            C = Math.toDegrees(C);

            double F = Math.max(180 - A, Math.max(180 - B, 180 - C));
            System.out.printf("Наибольший внешний угол треугольника: %.2f градусов%n", F);
        } else {
            System.out.println("Из этих отрезков нельзя составить треугольник.");
        }

        scanner.close();
    }

    public static boolean T(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
