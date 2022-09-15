import java.util.ArrayList;
import java.util.List;

/*
 * In mathematics, the factorial of integer n is written as n!.
 * It is equal to the product of n and every integer preceding it. For example: 5! = 1 x 2 x 3 x 4 x 5 = 120
 * Your mission is simple: write a function that takes an integer n and returns the value of n!.
 * You are guaranteed an integer argument. For any values outside the non-negative range, return null.
 * For non-negative numbers a full length number is expected for example,
 * return 25! =  "15511210043330985984000000"  as a string.
 * NOTES:
 * Don't use BigInteger, this requires a complex solution
 *  */
public class LargeFactorial {

    public static void main(String[] args) {
        System.out.println(Factorial(1000));
//        System.out.println(factorialSecondSolutionNotRecommended(1000));
    }

    /*
    *  First solution factorial without Biginteger
    * */
    public static String Factorial(int n) {
        String factorial = "1";
        for (int i = 1; i <=n ; i++) {
            factorial = calculate(factorial,i);
        }
        return factorial;
    }

    public static String calculate(String numb1, int numb2){
        StringBuilder sb = new StringBuilder();
        int d=0;
        for (int i = numb1.length()-1; i >=0 ; i--) {
            int c = Character.getNumericValue(numb1.charAt(i));
            int m = c*numb2+d;
            sb.append(m%10);
            d=m/10;
        }
        if(d!=0){
            StringBuilder tmp = new StringBuilder();
            tmp.append(d).reverse();
            sb.append(tmp);
        }
        return sb.reverse().toString();
    }


    /*
    *  Second Solution not recommended my own idea
    * */
    public static String factorialSecondSolutionNotRecommended(int n) { // TODO: replace all substring with Character.getNumericValue
        List<String> values = new ArrayList<>();
        if (n == 1) return "1";
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                values.add(String.valueOf((n - i) * (i + 1)));
            }
        }else {
            for (int i = 0; i < (n - 1)  / 2; i++) {
                values.add(String.valueOf((n - 1 - i) * (i + 1)));
            }
            String result =  multiply(values);
            values.clear();
            values.add(result);
            values.add(String.valueOf(n));
        }
        return multiply(values);
    }

    private static String multiply(List<String> list) {
        if (list.size() <= 1) {
            return list.get(0);
        }

        String[] fn = list.get(0).split("");
        String[] sn = list.get(1).split("");

        List<String> multiplyList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (j < sn.length) {
            int m = 0;
            StringBuilder str = new StringBuilder();
            while (i < fn.length) {
                int sum = Integer.parseInt(fn[fn.length - i - 1] ) * Integer.parseInt(sn[sn.length - j - 1]);
                int first = (m + sum) / 10;
                int second = (m + sum) % 10;
                m = first;

                str.append(second);
                i++;
            }
            if (m > 0) {
                str.append(m);
            }
            multiplyList.add(str.reverse().toString());
            j++;
            i = 0;
        }

        String resultAdd = add(multiplyList);

        list.remove(0);
        list.remove(0);
        list.add(0, resultAdd);

        return multiply(list);
    }

    private static String add(List<String> list) {
       String[][] matrix = new String[list.size()][list.get(0).length() + 10];

        for (int i = 0; i < list.size(); i++) {
            String[] currentNumber = list.get(i).split("");
            for (int j = currentNumber.length - 1; j >= 0 ; j--) {
                String lastNumber = currentNumber[currentNumber.length - 1 - j];
                matrix[i][matrix[i].length - 1 - j - i] = lastNumber;
            }
        }

        int m = 0;
        StringBuilder res = new StringBuilder();
        for (int i = matrix[0].length - 1; i >= 0 ; i--) {
            int sum = 0;
            for (String[] strings : matrix) {
                if (!(strings[i] == null)) {
                    int num = Integer.parseInt(strings[i]);
                    sum += num;
                }
            }

            int first = (m + sum) / 10;
            int second = (m + sum) % 10;
            m = first;
            res.append(second);
        }

        res.append(m);
        res.reverse();
        while (res.substring(0, 1).equals("0")) {
            res = new StringBuilder(res.substring(1));
        }

        return res.toString();
    }
}
