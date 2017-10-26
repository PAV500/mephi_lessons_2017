import java.util.ArrayList;

/**
 * Created by Александр on 25.10.2017.
 */

public class Poker {

    public long C(long k, long n)
    {
        long k1=1;
        long l1=1;
        long n1=1;
        for (long i=1; i<=k; i++)
        {
            n1*=n;
            n--;
            k1*=l1;
            l1++;
        }
        return n1/k1;
    }

    public double[][] flash_preflop()
    {
        double[][] matrix;
        matrix = new double[2][3];
        matrix[0][0] =C(2,13)*C(1,4);
        matrix[0][1] =matrix[0][0]/C(2,52);
        matrix[0][2] =100*(double)(C(1,3)*C(5,13)+C(3,11)*C(2,47))/C(5,50);
        matrix[1][0] =C(2,52)-matrix[0][0];
        matrix[1][1] =matrix[1][0]/C(2,52);
        matrix[1][2] =100* (double)(C(1,2)*C(5,13)+C(1,2)*C(4,12)*C(1,46))/C(5,50);
        return matrix;
    }

    public double[][] flash_flop()
    {
        double[][] matrix;
        matrix = new double[4][3];
        matrix[0][0] =C(1,4)*C(5,13);
        matrix[0][1] =matrix[0][0]/C(5,52);
        matrix[0][2] =100;
        matrix[1][0] =C(1,4)*C(4,13)*C(1,39);
        matrix[1][1] =matrix[1][0]/C(5,52);
        matrix[1][2] =100* (double)(C(1,9)*C(1,46))/C(2,47);
        matrix[2][0] =C(1,4)*C(3,13)*C(2,39);
        matrix[2][1] =matrix[2][0]/C(5,52);
        matrix[2][2] =100* (double)C(2,10)/C(2,47);
        matrix[3][0] =C(5,52)-matrix[2][0]-matrix[1][0]-matrix[0][0];
        matrix[3][1] =matrix[3][0]/C(5,52);
        matrix[3][2] =0;
        return matrix;
    }

    public double[][] flash_tern()
    {
        double[][] matrix;
        matrix = new double[3][3];
        matrix[0][0] =C(1,4)*C(5,13)*C(1,47);
        matrix[0][1] =matrix[0][0]/C(6,52);
        matrix[0][2] =100;
        matrix[1][0] =C(1,4)*C(4,13)*C(2,39);
        matrix[1][1] =matrix[1][0]/C(6,52);
        matrix[1][2] =100* (double)C(1,9)/C(1,46);
        matrix[2][0] =C(6,52)-matrix[1][0]-matrix[0][0];
        matrix[2][1] =matrix[2][0]/C(6,52);
        matrix[2][2] =0;
        return matrix;
    }

    public double[][] full_house_preflop()
    {
        double[][] matrix;
        matrix = new double[2][3];
        matrix[0][0] =C(1,13)*C(2,4);
        matrix[0][1] =matrix[0][0]/C(2,52);
        matrix[0][2] =100*(double)(C(1,12)*C(3,4)*C(2,45)+C(1,2)*C(1,12)*C(2,4)*C(2,47))/C(5,50);
        matrix[1][0] =C(2,52)-matrix[0][0];
        matrix[1][1] =matrix[1][0]/C(2,52);
        matrix[1][2] =100* (double)(C(2,4)*C(2,4)*C(1,46)+C(1,2)*C(2,4)*C(1,4)*C(2,44)+C(1,11)*C(3,4)*C(1,2)*C(1,3)*C(1,43)+C(1,11)*C(3,4)*C(1,10)*C(2,4))/C(5,50);
        return matrix;
    }

    public double[][] full_house_flop()
    {
        double[][] matrix;
        matrix = new double[6][3];
        matrix[0][0] =C(1,13)*C(3,4)*C(1,12)*C(2,4);
        matrix[0][1] =matrix[0][0]/C(5,52);
        matrix[0][2] =100;
        matrix[1][0] =C(1,13)*C(3,4)*(C(2,48)-C(1,12)*C(2,4));
        matrix[1][1] =matrix[1][0]/C(5,52);
        matrix[1][2] =100* (double)(C(1,2)*C(1,3)*C(1,43)+C(1,10)*C(2,4))/C(2,47);
        matrix[2][0] =C(1,13)*C(1,48);
        matrix[2][1] =matrix[2][0]/C(5,52);
        matrix[2][2] =100* (double)(C(1,3)*C(1,46)+C(1,11)*C(2,4))/C(2,47);
        matrix[3][0] =C(2,13)*C(2,4)*C(2,4)*C(1,44);
        matrix[3][1] =matrix[3][0]/C(5,52);
        matrix[3][2] =100* (double)(C(1,2)*C(1,2)*C(1,44)+C(1,2)*C(1,2)*C(2,3))/C(2,47);
        matrix[4][0] =C(1,13)*C(2,4)*(C(3,48)-C(1,12)*C(3,4)-C(1,12)*C(2,4)*C(1,44));
        matrix[4][1] =matrix[4][0]/C(5,52);
        matrix[4][2] =100* (double)(C(1,2)*C(1,3)*C(1,3))/C(2,47);
        matrix[5][0] =C(5,52)-matrix[4][0]-matrix[3][0]-matrix[2][0]-matrix[1][0]-matrix[0][0];
        matrix[5][1] =matrix[5][0]/C(5,52);
        matrix[5][2] =0;
        return matrix;
    }

    public double[][] full_house_tern()
    {
        double[][] matrix;
        matrix = new double[6][3];
        matrix[0][0] =C(2,13)*C(3,4)*C(3,4)+C(1,13)*C(3,4)*C(1,12)*C(2,4)*C(1,45);
        matrix[0][1] =matrix[0][0]/C(6,52);
        matrix[0][2] =100;
        matrix[1][0] =C(1,13)*C(3,4)*(C(3,48)-C(1,12)*C(3,4)-C(1,12)*C(2,4)*C(1,44));
        matrix[1][1] =matrix[1][0]/C(6,52);
        matrix[1][2] =100* (double)(C(1,3)*C(1,3))/C(1,46);
        matrix[2][0] =C(1,13)*(C(2,48)-C(1,12)*C(2,4));
        matrix[2][1] =matrix[2][0]/C(6,52);
        matrix[2][2] =100* (double)(C(1,2)*C(1,3))/C(1,46);
        matrix[3][0] =C(3,13)*C(2,4)*C(2,4)*C(2,4);
        matrix[3][1] =matrix[3][0]/C(6,52);
        matrix[3][2] =100* (double)(C(1,3)*C(1,2))/C(1,46);
        matrix[4][0] =C(2,13)*C(2,4)*C(2,4)*(C(2,44)-C(1,11)*C(2,4));
        matrix[4][1] =matrix[4][0]/C(6,52);
        matrix[4][2] =100* (double)(C(1,2)*C(1,2))/C(1,46);
        matrix[5][0] =C(6,52)-matrix[4][0]-matrix[3][0]-matrix[2][0]-matrix[1][0]-matrix[0][0];
        matrix[5][1] =matrix[5][0]/C(6,52);
        matrix[5][2] =0;
        return matrix;
    }

    public double[][] quads_preflop()
    {
        double[][] matrix;
        matrix = new double[2][3];
        matrix[0][0] =C(1,13)*C(2,4);
        matrix[0][1] =matrix[0][0]/C(2,52);
        matrix[0][2] =100*(double)(C(3,48)+C(1,12)*C(1,46))/C(5,50);
        matrix[1][0] =C(2,52)-matrix[0][0];
        matrix[1][1] =matrix[1][0]/C(2,52);
        matrix[1][2] =100* (double)(C(1,2)*C(2,48)+C(1,11)*C(1,46))/C(5,50);
        return matrix;
    }

    public double[][] quads_flop()
    {
        double[][] matrix;
        matrix = new double[6][3];
        matrix[0][0] =C(1,13)*C(1,48);
        matrix[0][1] =matrix[0][0]/C(5,52);
        matrix[0][2] =100;
        matrix[1][0] =C(1,13)*C(3,4)*C(1,12)*C(2,4);
        matrix[1][1] =matrix[1][0]/C(5,52);
        matrix[1][2] =100* (double)(C(1,46)+C(2,2))/C(2,47);
        matrix[2][0] =C(1,13)*C(3,4)*(C(2,48)-C(1,12)*C(2,4));
        matrix[2][1] =matrix[2][0]/C(5,52);
        matrix[2][2] =100* (double)C(1,46)/C(2,47);
        matrix[3][0] =C(2,13)*C(2,4)*C(2,4)*C(1,44);
        matrix[3][1] =matrix[3][0]/C(5,52);
        matrix[3][2] =100* (double)C(1,2)/C(2,47);
        matrix[4][0] =C(1,13)*C(2,4)*(C(3,48)-C(1,12)*C(3,4)-C(1,12)*C(2,4)*C(1,44));
        matrix[4][1] =matrix[4][0]/C(5,52);
        matrix[4][2] =100* (double)C(2,2)/C(2,47);
        matrix[5][0] =C(5,52)-matrix[4][0]-matrix[3][0]-matrix[2][0]-matrix[1][0]-matrix[0][0];
        matrix[5][1] =matrix[5][0]/C(5,52);
        matrix[5][2] =0;
        return matrix;
    }

    public double[][] quads_tern()
    {
        double[][] matrix;
        matrix = new double[4][3];
        matrix[0][0] =C(1,13)*C(2,48);
        matrix[0][1] =matrix[0][0]/C(6,52);
        matrix[0][2] =100;
        matrix[1][0] =C(2,13)*C(3,4)*C(3,4);
        matrix[1][1] =matrix[1][0]/C(6,52);
        matrix[1][2] =100* (double)C(1,2)/C(1,46);
        matrix[2][0] =C(1,13)*C(3,4)*(C(3,48)-C(1,12)*C(3,4));
        matrix[2][1] =matrix[2][0]/C(6,52);
        matrix[2][2] =100* (double)C(1,1)/C(1,46);
        matrix[3][0] =C(6,52)-matrix[2][0]-matrix[1][0]-matrix[0][0];
        matrix[3][1] =matrix[3][0]/C(6,52);
        matrix[3][2] =0;
        return matrix;
    }


    public static void main(String[] args) {
        Poker poker = new Poker();
        double flash_preflop[][] = poker.flash_preflop();
        System.out.println("Флеш префлоп:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(flash_preflop[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double flash_flop[][] = poker.flash_flop();
        System.out.println("Флеш флоп:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(flash_flop[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double flash_tern[][] = poker.flash_tern();
        System.out.println("Флеш терн:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(flash_tern[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double full_house_preflop[][] = poker.full_house_preflop();
        System.out.println("Фулл-хаус префлоп:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(full_house_preflop[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double full_house_flop[][] = poker.full_house_flop();
        System.out.println("Фулл-хаус флоп:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(full_house_flop[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double full_house_tern[][] = poker.full_house_tern();
        System.out.println("Фулл-хаус терн:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(full_house_tern[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double quads_preflop[][] = poker.quads_preflop();
        System.out.println("Каре префлоп:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(quads_preflop[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double quads_flop[][] = poker.quads_flop();
        System.out.println("Каре флоп:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(quads_flop[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        double quads_tern[][] = poker.quads_tern();
        System.out.println("Каре терн:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(quads_tern[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
