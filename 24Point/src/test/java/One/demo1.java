package One;

import java.util.*;

public class demo1 {

    private static Map<Integer,String> symbol = new HashMap<Integer, String>();
    private static List<String> operator = new ArrayList<String>();
    public static void main(String[] args) {
       //System.out.println("My first git Project");
        symbol.put(0,"+");
        symbol.put(1,"-");
        symbol.put(2,"*");
        symbol.put(3,"/");
        String A, B, C, D;
        A = "1";
        B = "5";
        C = "5";
        D = "3";
        int j,k;
        boolean found=false;
        while(true){
        for (int i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                for (k = 0; k < 4; k++) {
                    operatorCreat(A,B,C,D);
                    operator.add(symbol.get(i));
                    operator.add(symbol.get(j));
                    operator.add(symbol.get(k));
                        //System.out.println(operator);
                        try {
                            Collections.shuffle(operator);
                            if(balance(operator)==24) {
                                System.out.println("found!!");
                                System.out.println(operator);
                                found=true;
                                break;
                            }
                        } catch (Exception e) {
                        }
                        finally {
                            operator.clear();
                        }
                    }
                if(found)break;
                }
                k=0;
            if (found)break;
            }
            j=0;
        if(found)break;
        else{
            System.out.println("没有答案！");
            break;
        }
        }
        //operator.add("+");



    }

    private static void operatorCreat( String A, String B, String C, String D) {
        operator.add(A);
        operator.add(B);
        operator.add(C);
        operator.add(D);
    }


    private static int balance(List<String> operator) {
        Stack<Integer> num_Stack = new Stack<>();
        for (String s : operator) {
            try {
               int num = Integer.parseInt(s);
               num_Stack.push(num);
            } catch (NumberFormatException e) {
                Integer num1 = num_Stack.pop();
                Integer num2 = num_Stack.pop();
                if(s.equals("+")){
                    int num3 = num2 + num1;
                    num_Stack.push(num3);
                }
                if(s.equals("-")){
                    int num3 = num2 - num1;
                    num_Stack.push(num3);
                }
                if(s.equals("*")){
                    int num3 = num2 * num1;
                    num_Stack.push(num3);
                }
                if(s.equals("/")){
                    int num3 = num2 / num1;
                    num_Stack.push(num3);
                }
            }
        }
        return num_Stack.pop();
    }

}
