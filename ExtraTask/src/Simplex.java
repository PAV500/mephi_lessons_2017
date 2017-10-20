/**
 * Created by Александр on 16.10.2017.
 */
import static java.lang.System.*;
import static java.lang.Math.*;

public class Simplex {

    final static int n = 5;
    final static int m = 3;
    final static double M = Double.MAX_VALUE;
    public static void main(String[] args) {

        double[] c = new double[n];
        double[][] a = new double[m][n];
        double[] cB = new double[m];
        int[] bV = new int[m];
        double[] bD = new double[m];

        c[0] = 1;
        c[1] = 2;
        c[2] = 3;
        c[3] = 4;
        c[4] = 5;

        a[0][0] = 1; a[0][1] =-2; a[0][2] = 1; a[0][3] = 0; a[0][4] = 0;
        a[1][0] = 1; a[1][1] =-1; a[1][2] = 0; a[1][3] = 1; a[0][4] = 0;
        a[2][0] = 1; a[2][1] = 1; a[1][2] = 0; a[1][3] = 0; a[0][4] = 1;

        cB[0] = 1;
        cB[1] = 2;
        cB[2] = 3;

        bV[0] = 3;
        bV[1] = 4;
        bV[2] = 5;

        bD[0] = 1;
        bD[1] = 2;
        bD[2] = 1;

        double[] min = simplexMin(c, a, cB, bV, bD);
        printArray(min);

        double[] max = simplexMax(c, a, cB, bV, bD);
        printArray(max);
    }

    //Симплекс-метод. Подсчет минимума.

    static double[] simplexMin(double[] c, double[][] a, double[] cB, int[] bV,
                               double[] bD) {
        double[] delta = new double[n];
        double[] min = new double[m];

        out.println("Поиск минимума");
        int i, j, r = -1, s = -1;
        double[][] tmpA = new double[m][];
        double[] tmpBD = new double[m];

        int k = 0;
        while (true) {
            ++k;

            double deltaMin = Double.POSITIVE_INFINITY;
            r = -1;
            for (j = 0; j < n; ++j) {
                double z = 0;
                for (i = 0; i < m; ++i) {
                    z += cB[i] * a[i][j];
                }
                delta[j] = c[j] - z;
                if (deltaMin > delta[j]) {
                    deltaMin = delta[j];
                    r = j;
                }
            }

            if (deltaMin >= 0 || k > 100) {
                break;
            }

            double minRow = Double.POSITIVE_INFINITY;
            s = -1;
            for (i = 0; i < m; ++i) {
                min[i] = bD[i] / a[i][r];
                if (min[i] < 0) {
                    min[i] = Double.NaN;
                }
                if (minRow > min[i]) {
                    minRow = min[i];
                    s = i;
                }
            }


            double element = a[s][r];

            for (i = 0; i < m; ++i) {
                tmpA[i] = new double[n];
                for (j = 0; j < n; ++j) {
                    tmpA[i][j] = a[i][j];
                }
                tmpBD[i] = bD[i];
            }

            bV[s] = r;
            cB[s] = c[r];
            for (j = 0; j < n; ++j) {
                a[s][j] /= element;
            }
            bD[s] /= element;

            for (i = 0; i < m; ++i) {
                if (i == s) {
                    continue;
                }

                double air = tmpA[i][r];

                for (j = 0; j < n; ++j) {
                    a[i][j] -= (air * tmpA[s][j]) / element;
                }

                bD[i] -= (air * tmpBD[s]) / element;
            }
        }

        return printDecision(bV, bD);
    }

    //Симплекс-метод. Подсчет максимума.

    static double[] simplexMax(double[] c, double[][] a, double[] cB, int[] bV,
                               double[] bD) {
        double[] delta = new double[n];
        double[] min = new double[m];

        out.println("Поиск максимума");
        int i, j, r = -1, s = -1;
        double[][] tmpA = new double[m][];
        double[] tmpBD = new double[m];

        int k = 0;
        while (true) {
            ++k;

            double deltaMax = Double.NEGATIVE_INFINITY;
            r = -1;
            for (j = 0; j < n; ++j) {
                double z = 0;
                for (i = 0; i < m; ++i) {
                    z += cB[i] * a[i][j];
                }
                delta[j] = c[j] - z;
                if (deltaMax < delta[j]) {
                    deltaMax = delta[j];
                    r = j;
                }
            }

            if (deltaMax <= 0 || k > 100) {
                break;
            }

            double minRow = Double.POSITIVE_INFINITY;
            s = -1;
            for (i = 0; i < m; ++i) {
                min[i] = bD[i] / a[i][r];
                if (min[i] < 0) {
                    min[i] = Double.NaN;
                }
                if (minRow > min[i]) {
                    minRow = min[i];
                    s = i;
                }
            }

            double element = a[s][r];

            for (i = 0; i < m; ++i) {
                tmpA[i] = new double[n];
                for (j = 0; j < n; ++j) {
                    tmpA[i][j] = a[i][j];
                }
                tmpBD[i] = bD[i];
            }

            bV[s] = r;
            cB[s] = c[r];
            for (j = 0; j < n; ++j) {
                a[s][j] /= element;
            }
            bD[s] /= element;

            for (i = 0; i < m; ++i) {
                if (i == s) {
                    continue;
                }

                double air = tmpA[i][r];

                for (j = 0; j < n; ++j) {
                    a[i][j] -= (air * tmpA[s][j]) / element;
                }

                bD[i] -= (air * tmpBD[s]) / element;
            }
        }
        return printDecision(bV, bD);
    }

    //Решение

    static double[] printDecision(int[] bV, double[] bD) {
        int i, j;
        out.print("Решение x = (");
        double[] res = new double[m];
        boolean f;
        for (j = 0; j < n; ++j) {
            f = false;
            for (i = 0; i < m; ++i) {
                if (bV[i] == j) {
                    if (j < m) {
                        res[j] = bD[i];
                    }
                    out.print(round(bD[i], 2));
                    f = true;
                    break;
                }
            }
            if (!f) {
                out.print("0");
            }
            if (j < n - 1) {
                out.print(", ");
            }
        }
        out.print(")");
        return res;
    }

    static void printArray(double[] ar)
    {
        out.println();
        for (int i = 0; i < ar.length; ++i) {
            out.println("\t[" + i + "] = " + ar[i]);
        }
        out.println();
    }

    static String round(double n, int p) {
        if (Double.isNaN(n)) {
            return "NaN";
        }
        if (Double.isInfinite(n)) {
            return "\u221E";
        }
        double d = pow(10, p);
        return (Math.round(n * d) / d) + "";
    }
}