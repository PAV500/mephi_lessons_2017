/**
 * Created by Александр on 20.10.2017.
 */
public class Integr {

    double f(double x, int in)
    {
        switch (in)
        {
            case 1: return Math.pow(x, 3);
            case 2: return Math.cos(x-1);
            case 3: return Math.pow(x,-1);
            case 4: return Math.log(x);
            case 5: return Math.sqrt(x);
            case 6: return x+1;
            case 7: return 5;
            case 8: return Math.pow(Math.E,x);
            case 9: return Math.pow(x,Math.PI);
            case 10: return Math.pow(x,x);

            default:return Math.pow(x, 2)-1;
        }
    }

    public double Prymougolnik(double a, double b, int n, int k )
    {

        double result = 0;
        double h = (b - a) / n;

        for(int i = 0; i < n; i++)
        {
            result += f(a + h*(i + 0.5), k);
        }
        result *= h;
        return result;
    }

    public double Trapec(double a, double b, int n, int k)         {
        double x = 0;
        double sum = 0;
        double result = 0;
        double h = (b - a) / n;

        for(int i = 1; i < n; i++)
        {
            x = a + i * h;
            sum += f(x, k);
        }
        result = h*((f(a, k)+f(b, k))/2 + sum);
        return result;
    }

    public double Simpson(double a, double b, int n, int k) {
        double sum = 0, sum2 = 0;
        double[] x = new double[n];
        double h = (b - a) / n;
        for (int i = 0; i < n; i++) {
            x[i] = a + i * h;
        }
        for (int i = 1; i < n; i++) {
            sum += f(x[i], k);
            sum2 += f((x[i - 1] + x[i]) / 2, k);
        }
        return h / 6 * (f(a, k) + f(b, k) + 2 * sum + 4 * (sum2 + b));
    }
    public static void main(String[] args) throws Exception
    {
        Integr integr = new Integr();
        System.out.println("Интеграл по методу прямоугольника: " + integr.Prymougolnik(2, 5, 1000, 0));
        System.out.println("Интеграл по методу трапеции: " + integr.Trapec(2, 5, 1000,0));
        System.out.println("Интеграл по методу Симпсона: " + integr.Simpson(2, 5, 1000,0));
        System.out.println("Разница с реальным значением по методу прямоугольника: " + Math.abs(integr.Prymougolnik(2, 5, 1000,0)-36));
        System.out.println("Разница с реальным значением по методу трапеции: " + Math.abs(integr.Trapec(2, 5, 1000,0)-36));
        System.out.println("Разница с реальным значением по методу Симпсона: " + Math.abs(integr.Simpson(2, 5, 1000,0)-36));
    }
}
