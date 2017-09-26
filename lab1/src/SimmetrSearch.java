/**
 * Created by Александр on 24.09.2017.
 */
import java.util.Scanner;

public class SimmetrSearch {

    final double CONST = 0.001;
    final double FI = (1 + Math.sqrt(5)) / 2;

        double function(double x, int in){
            switch (in) {
                case 1:  return Math.pow(x + 1, 3) - 5 * x;
                case 2:  return Math.pow(x + 1, 3) + 5 * Math.pow(x, 2);
                case 3:  return Math.pow(x - 2, 3) - Math.pow(x, 2);
                case 4:  return Math.pow(3 - x, 3) + 2 * Math.pow(x + 1, 2);
                case 5:  return Math.pow(x, 5) - 10 * Math.pow(x, 2);
                case 6:  return Math.exp(x) - Math.pow(x, 5) + 8 * Math.pow(x, 2);
                case 7:  return Math.pow(x, 3) - 3 * x;
                case 8:  return Math.sin(x + 1);
                case 9:  return Math.cos(Math.exp(0.4 * x));
                case 10: return Math.abs(Math.abs(x + 3) - 2);
                case 11: return Math.pow(x, Math.PI) - 0.8 * Math.pow(Math.PI, x);
                case 12: return Math.pow(x, Math.E) - Math.pow(Math.E, x);
                case 13: return Math.sin(Math.pow(Math.PI, 0.008 * Math.pow(x, Math.E)));
                case 14: return Math.sin(Math.cos(Math.log(4 * x)));
                case 15: return Math.pow(x, Math.sin(x));

                default: return Math.pow(x - 1, 3) - 5 * x; // Здесь можно задать собственную функцию (функцию по умолчанию)
            }
        }

        double MinBin(double a, double b, double e, int i){
            double x1, x2, c;
            while (true){
                c = (a + b) / 2;
                x1 = c - CONST;
                x2 = c + CONST;
                if (function(x1, i) >= function(x2, i))
                    a = c;
                else
                    b = c;
                if (Math.abs(b - a) < e)
                    break;
            }
            return (a + b) / 2;
        }

        double MaxBin(double a, double b, double e, int i){
            double x1, x2, c;
            while (true){
                c = (a + b) / 2;
                x1 = c - CONST;
                x2 = c + CONST;
                if (function(x1, i) <= function(x2, i))
                    a = c;
                else
                    b = c;
                if (Math.abs(b - a) < e)
                    break;
            }
            return (a + b) / 2;
        }

        double MinGold(double a, double b, double e, int i){
            double x1, x2;
            while (true){
                x1 = b - (b - a) / FI;
                x2 = a + (b - a) / FI;
                if (function(x1, i) >= function(x2, i))
                    a = x1;
                else
                    b = x2;
                if (Math.abs(b - a) < e)
                    break;
            }
            return (a + b) / 2;
        }

        double MaxGold(double a, double b, double e, int i){
            double x1, x2;
            while (true){
                x1 = b - (b - a) / FI;
                x2 = a + (b - a) / FI;
                if (function(x1, i) <= function(x2, i))
                    a = x1;
                else
                    b = x2;
                if (Math.abs(b - a) < e)
                    break;
            }
            return (a + b) / 2;
        }

    public static void main(String[] args) {
        SimmetrSearch SS = new SimmetrSearch();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите  цифру 0 для работы с функцией по умолчанию или число от 1 до 15 для работы с заданными функциями:");
        int i = in.nextInt();
        System.out.println("Что будем искать (введите необходимую цифру):");
        System.out.println("1 - минимум");
        System.out.println("2 - максимум");
        System.out.println("3 - минимум и максимум");
        int var = in.nextInt();
        switch (var) {
            case 1:
                System.out.println("Введите левую границу отрезка для поиска минимума:");
                double a1 = in.nextDouble();
                System.out.println("Введите правую границу отрезка для поиска минимума:");
                double b1 = in.nextDouble();
                System.out.println("Введите точность:");
                double e1 = in.nextDouble();
                System.out.println("Минимум по принципу деления пополам: " + SS.MinBin(a1, b1, e1, i));
                System.out.println("Минимум по принципу золотого сечения: " + SS.MinGold(a1, b1, e1, i));
                break;
            case 2:
                System.out.println("Введите левую границу отрезка для поиска максимума:");
                double a2 = in.nextDouble();
                System.out.println("Введите правую границу отрезка для поиска максимума:");
                double b2 = in.nextDouble();
                System.out.println("Введите точность:");
                double e2 = in.nextDouble();
                System.out.println("Максимум по принципу деления пополам: " + SS.MaxBin(a2, b2, e2, i));
                System.out.println("Максимум по принципу золотого сечения: " + SS.MaxGold(a2, b2, e2, i));
                break;
            case 3:
                System.out.println("Введите левую границу отрезка для поиска минимума:");
                double a3 = in.nextDouble();
                System.out.println("Введите правую границу отрезка для поиска минимума:");
                double b3 = in.nextDouble();
                System.out.println("Введите левую границу отрезка для поиска максимума:");
                double a4 = in.nextDouble();
                System.out.println("Введите правую границу отрезка для поиска максимума:");
                double b4 = in.nextDouble();
                System.out.println("Введите точность:");
                double e3 = in.nextDouble();
                System.out.println("Минимум по принципу деления пополам: " + SS.MinBin(a3, b3, e3, i));
                System.out.println("Минимум по принципу золотого сечения: " + SS.MinGold(a3, b3, e3, i));
                System.out.println("Максимум по принципу деления пополам: " + SS.MaxBin(a4, b4, e3, i));
                System.out.println("Максимум по принципу золотого сечения: " + SS.MaxGold(a4, b4, e3, i));
                break;
        }
    }
}
