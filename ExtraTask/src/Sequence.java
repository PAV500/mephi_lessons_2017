/**
 * Created by Александр on 16.10.2017.
 */

import java.util.*;
import java.math.*;

public class Sequence {

    private BigInteger BInt;
    private String Str;
    private int Len;

    private LinkedList<String> seqNumList = new LinkedList<String>();

    private int Offset;

    public BigInteger indexOf(String pattern) throws NumberFormatException {
        if (pattern.startsWith("0")) {
            throw new NumberFormatException();
        }
        BInt = new BigInteger(pattern);
        Str = pattern;
        Len = pattern.length();

        BigInteger result = null;
        LinkedList<String> tempNumList = new LinkedList<String>();

        for (int exp = 1; exp <= Len; exp++) {
            for (int offset = 0; offset < exp; offset++) {
                tempNumList.clear();
                BigInteger curPos = checkNumSequence(exp, offset, tempNumList);
                if ((curPos != null) && (result == null ||
                        result != null && result.compareTo(curPos) > 0)) {
                    result = curPos;
                    seqNumList.clear();
                    seqNumList.addAll(tempNumList);
                    Offset = offset;
                }
            }
            if (result != null) break;
        }
        return result;
    }

    private BigInteger getSequenceItemPos(BigInteger item) {
        BigInteger startPos = BigInteger.ZERO;
        int itemLen = item.toString().length();
        for (int i = 1; i < itemLen; i++) {
            startPos = startPos.add(
                    bint(i * 9).multiply(pow10BI(i - 1)));
        }
        BigInteger offset = item.subtract(pow10BI(itemLen - 1));
        return startPos.add(offset.multiply(bint(itemLen))).add(bint(1));
    }

    private BigInteger completeLastNum(String unCmplNumStr,
                                       String prevNumLastDgts) {
        BigInteger pow10 = pow10BI(prevNumLastDgts.length());
        BigInteger unCmplNum = new BigInteger(unCmplNumStr);
        BigInteger lastDgts = new BigInteger(prevNumLastDgts);
        return lastDgts.compareTo(pow10.subtract(BigInteger.ONE)) == -1 ?
                unCmplNum.multiply(pow10).add(lastDgts.add(BigInteger.ONE)) :
                unCmplNum.multiply(pow10);
    }

    private BigInteger checkNumSequence(int numExp, int offset,
                                        LinkedList<String> numStrList) {
        String seqOf9 = repeatStr("9", numExp);
        String curNumStr = null;
        BigInteger curNum = null;
        BigInteger prevNum = null;
        BigInteger firstNum = null;

        int i = offset;
        while(i < Len) {
            prevNum = curNum;
            if (i + numExp <= Len) {
                curNumStr = Str.substring(i, i + numExp);
                if (curNumStr.startsWith("0")) {
                    return null;
                }
                curNum = new BigInteger(curNumStr);
            } else {
                int unkDgtCount = i + numExp - Len;
                String lastNumStr =
                        Str.substring(i, i + numExp - unkDgtCount);
                if (lastNumStr.startsWith("0")) {
                    return null;
                }
                if (i > offset) {
                    curNum = completeLastNum(lastNumStr,
                            curNumStr.substring(curNumStr.length() - unkDgtCount,
                                    curNumStr.length()));
                } else {
                    curNum = completeLastNum(lastNumStr,
                            Str.substring(offset - unkDgtCount, offset));
                }
                curNumStr = String.valueOf(curNum);
            }

            numStrList.add(curNumStr);

            if (i > offset && curNum.subtract(prevNum).intValue() != 1) {
                return null;
            }

            if (i == offset) {
                firstNum = curNum;
                if (offset > 0) {
                    String offsetDgts = Str.substring(0, offset);
                    String testNumStr = curNum.subtract(BigInteger.ONE).toString();
                    int lastDgtsStart = testNumStr.length() - offsetDgts.length();
                    if (! offsetDgts.equals(testNumStr.substring(
                            lastDgtsStart < 0 ? 0 : lastDgtsStart,
                            testNumStr.length()))) {
                        return null;
                    }
                    numStrList.addFirst(testNumStr);
                }
            }

            i += numExp;
            if (curNumStr.equals(seqOf9)) {
                numExp++;
                seqOf9 += "9";
            }
        }

        return getSequenceItemPos(firstNum).subtract(bint(offset));
    }

    private static BigInteger pow10BI(int pow) {
        BigInteger biPow = BigInteger.TEN;
        return biPow.pow(pow);
    }

    private static BigInteger bint(long value) {
        return BigInteger.valueOf(value);
    }

    private static String repeatStr(String s, int n) {
        String result = s;
        for (int i = 1; i < n; i++) {
            result += s;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner num = new Scanner(System.in);
        System.out.println("Введите последовательность");
        String numStr = num.next();
        long from = System.nanoTime();
        Sequence infSeq = new Sequence();
        System.out.println("Последовательность: " + numStr);
        System.out.println("Индекс начала последовательности в бесконечном ряде: " + infSeq.indexOf(numStr));
        long until = System.nanoTime();
        System.out.println("время (нс) - " + (until - from));
    }
}