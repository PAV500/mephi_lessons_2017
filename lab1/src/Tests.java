/**
 * Created by Александр on 26.09.2017.
 */
public class Tests {
    public static void main(String[] args) {
        SimmetrSearch SS = new SimmetrSearch();
        double e = 0.001;
        if (Math.abs(SS.MinBin(-2, 2, e, 1)-0.290) >0.01) System.out.println("Ошибка 1 MinBin"); //1
        if (Math.abs(SS.MinGold(-2, 2, e, 1)-0.290)>0.01) System.out.println("Ошибка 1 MinGold");
        if (Math.abs(SS.MaxBin(-4, 0, e, 1)+2.290)>0.01) System.out.println("Ошибка 1 MaxBin");
        if (Math.abs(SS.MaxGold(-4, 0, e, 1)+2.290)>0.01) System.out.println("Ошибка 1 MaxGold");

        if (Math.abs(SS.MinBin(-2, 2, e, 2)+0.195) >0.01) System.out.println("Ошибка 2 MinBin"); //2
        if (Math.abs(SS.MinGold(-2, 2, e, 2)+0.195)>0.01) System.out.println("Ошибка 2 MinGold");
        if (Math.abs(SS.MaxBin(-8, 0, e, 2)+5.139)>0.01) System.out.println("Ошибка 2 MaxBin");
        if (Math.abs(SS.MaxGold(-8, 0, e, 2)+5.139)>0.01) System.out.println("Ошибка 2 MaxGold");

        if (Math.abs(SS.MinBin(2, 6, e, 3)-3.535) >0.01) System.out.println("Ошибка 3 MinBin"); //3
        if (Math.abs(SS.MinGold(2, 6, e, 3)-3.535)>0.01) System.out.println("Ошибка 3 MinGold");
        if (Math.abs(SS.MaxBin(-2, 2, e, 3)-1.131)>0.01) System.out.println("Ошибка 3 MaxBin");
        if (Math.abs(SS.MaxGold(-2, 2, e, 3)-1.131)>0.01) System.out.println("Ошибка 3 MaxGold");

        if (Math.abs(SS.MinBin(-1, 3, e, 4)-1.263) >0.01) System.out.println("Ошибка 4 MinBin"); //4
        if (Math.abs(SS.MinGold(-1, 3, e, 4)-1.263)>0.01) System.out.println("Ошибка 4 MinGold");
        if (Math.abs(SS.MaxBin(4, 8, e, 4)-6.070)>0.01) System.out.println("Ошибка 4 MaxBin");
        if (Math.abs(SS.MaxGold(4, 8, e, 4)-6.070)>0.01) System.out.println("Ошибка 4 MaxGold");

        if (Math.abs(SS.MinBin(1, 3, e, 5)-1.587) >0.01) System.out.println("Ошибка 5 MinBin"); //5
        if (Math.abs(SS.MinGold(1, 3, e, 5)-1.587)>0.01) System.out.println("Ошибка 5 MinGold");
        if (Math.abs(SS.MaxBin(-1, 1, e, 5)+0)>0.01) System.out.println("Ошибка 5 MaxBin");
        if (Math.abs(SS.MaxGold(-1, 1, e, 5)+0)>0.01) System.out.println("Ошибка 5 MaxGold");

        if (Math.abs(SS.MinBin(-2, 1, e, 6)+0.059) >0.01) System.out.println("Ошибка 6 MinBin"); //6
        if (Math.abs(SS.MinGold(-2, 1, e, 6)+0.059)>0.01) System.out.println("Ошибка 6 MinGold");
        if (Math.abs(SS.MaxBin(0, 3, e, 6)-1.562)>0.01) System.out.println("Ошибка 6 MaxBin");
        if (Math.abs(SS.MaxGold(0, 3, e, 6)-1.562)>0.01) System.out.println("Ошибка 6 MaxGold");

        if (Math.abs(SS.MinBin(0, 2, e, 7)-1) >0.01) System.out.println("Ошибка 7 MinBin"); //7
        if (Math.abs(SS.MinGold(0, 2, e, 7)-1)>0.01) System.out.println("Ошибка 7 MinGold");
        if (Math.abs(SS.MaxBin(-2, 0, e, 7)+1)>0.01) System.out.println("Ошибка 7 MaxBin");
        if (Math.abs(SS.MaxGold(-2, 0, e, 7)+1)>0.01) System.out.println("Ошибка 7 MaxGold");

        if (Math.abs(SS.MinBin(-4, -1, e, 8)+2.571) >0.01) System.out.println("Ошибка 8 MinBin"); //8
        if (Math.abs(SS.MinGold(-4, -1, e, 8)+2.571)>0.01) System.out.println("Ошибка 8 MinGold");
        if (Math.abs(SS.MaxBin(0, 3, e, 8)-0.571)>0.01) System.out.println("Ошибка 8 MaxBin");
        if (Math.abs(SS.MaxGold(0, 3, e, 8)-0.571)>0.01) System.out.println("Ошибка 8 MaxGold");

        if (Math.abs(SS.MinBin(2, 4, e, 9)-2.862) >0.01) System.out.println("Ошибка 9 MinBin"); //9
        if (Math.abs(SS.MinGold(2, 4, e, 9)-2.862)>0.01) System.out.println("Ошибка 9 MinGold");
        if (Math.abs(SS.MaxBin(4, 5, e, 9)-4.595)>0.01) System.out.println("Ошибка 9 MaxBin");
        if (Math.abs(SS.MaxGold(4, 5, e, 9)-4.595)>0.01) System.out.println("Ошибка 9 MaxGold");

        if (Math.abs(SS.MinBin(-2, 3, e, 10)+1) >0.01) System.out.println("Ошибка 10 MinBin"); //10
        if (Math.abs(SS.MinGold(-2, 3, e, 10)+1)>0.01) System.out.println("Ошибка 10 MinGold");
        if (Math.abs(SS.MaxBin(-5, -2, e, 10)+3)>0.01) System.out.println("Ошибка 10 MaxBin");
        if (Math.abs(SS.MaxGold(-5, -2, e, 10)+3)>0.01) System.out.println("Ошибка 10 MaxGold");

        if (Math.abs(SS.MinBin(0.5, 2.5, e, 11)-0.919) >0.01) System.out.println("Ошибка 11 MinBin"); //11
        if (Math.abs(SS.MinGold(0.5, 2.5, e, 11)-0.919)>0.01) System.out.println("Ошибка 11 MinGold");
        if (Math.abs(SS.MaxBin(2.5, 4.5, e, 11)-3.324)>0.01) System.out.println("Ошибка 11 MaxBin");
        if (Math.abs(SS.MaxGold(2.5, 4.5, e, 11)-3.324)>0.01) System.out.println("Ошибка 11 MaxGold");

        if (Math.abs(SS.MinBin(0, 2, e, 12)-1) >0.01) System.out.println("Ошибка 12 MinBin"); //12
        if (Math.abs(SS.MinGold(0, 2, e, 12)-1)>0.01) System.out.println("Ошибка 12 MinGold");
        if (Math.abs(SS.MaxBin(2, 4, e, 12)-2.719)>0.01) System.out.println("Ошибка 12 MaxBin");
        if (Math.abs(SS.MaxGold(2, 4, e, 12)-2.719)>0.01) System.out.println("Ошибка 12 MaxGold");

        if (Math.abs(SS.MinBin(5, 7, e, 13)-6.605) >0.01) System.out.println("Ошибка 13 MinBin"); //13
        if (Math.abs(SS.MinGold(5, 7, e, 13)-6.605)>0.01) System.out.println("Ошибка 13 MinGold");
        if (Math.abs(SS.MaxBin(3, 5, e, 13)-4.195)>0.01) System.out.println("Ошибка 13 MaxBin");
        if (Math.abs(SS.MaxGold(3, 5, e, 13)-4.195)>0.01) System.out.println("Ошибка 13 MaxGold");

        if (Math.abs(SS.MinBin(2, 9, e, 14)-5.785) >0.01) System.out.println("Ошибка 14 MinBin"); //14
        if (Math.abs(SS.MinGold(2, 9, e, 14)-5.785)>0.01) System.out.println("Ошибка 14 MinGold");
        if (Math.abs(SS.MaxBin(0.15, 2, e, 14)-0.250)>0.01) System.out.println("Ошибка 14 MaxBin");
        if (Math.abs(SS.MaxGold(0.15, 2, e, 14)-0.250)>0.01) System.out.println("Ошибка 14 MaxGold");

        if (Math.abs(SS.MinBin(0, 1, e, 15)-0.352) >0.01) System.out.println("Ошибка 15 MinBin"); //15
        if (Math.abs(SS.MinGold(0, 1, e, 15)-0.352)>0.01) System.out.println("Ошибка 15 MinGold");
        if (Math.abs(SS.MaxBin(1, 3, e, 15)-2.127)>0.01) System.out.println("Ошибка 15 MaxBin");
        if (Math.abs(SS.MaxGold(1, 3, e, 15)-2.127)>0.01) System.out.println("Ошибка 15 MaxGold");

        System.out.println("Все ОК");
    }
}
