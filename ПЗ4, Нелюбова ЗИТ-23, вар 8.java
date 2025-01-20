import java.util.*;

public class UniqueNumberSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите значение x: ");
        int x = scanner.nextInt();

        Set<Integer> u = new TreeSet<>(); 
        u.add(1); 

        int numbersToGenerate = 30; 

        for (int i = 1; i < numbersToGenerate; i++) {
            int y = 2 * x + 1;
            int z = 3 * x + 1;
            u.add(y);
            u.add(z);
            x++; 
        }

        System.out.println("Ряд чисел u без дубликатов: " + u);
        
        scanner.close();
    }
}
