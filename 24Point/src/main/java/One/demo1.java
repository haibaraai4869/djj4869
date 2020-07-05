package One;

import domain.nums;

import java.util.*;

public class demo1 {

    private static Map<Integer,String> symbol = new HashMap<Integer, String>();
    private static List<String> operator = new ArrayList<String>();
    public static String calculate(nums nums) {
        String formula=null;
        long startTime = System.currentTimeMillis();
       //System.out.println("My first git Project");
        symbol.put(0,"+");
        symbol.put(1,"-");
        symbol.put(2,"*");
        symbol.put(3,"/");
        String A, B, C, D;
        A = nums.getA();
        B = nums.getB();
        C = nums.getC();
        D = nums.getD();
        int j,k;
        boolean found=false;

        for (int i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                for (k = 0; k < 4; k++) {
                    operatorCreat(A,B,C,D);
                    operator.add(symbol.get(i));
                    operator.add(symbol.get(j));
                    operator.add(symbol.get(k));
                        //System.out.println(operator);
                        try {
                            if(balance(operator)) {
                                System.out.println("found!!");
                                System.out.println(operator);
                               formula=operator.toString();
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
                k=0;
                }
            if (found)break;
            j=0;
            }
        //operator.add("+");
        long endTime = System.currentTimeMillis();    //获取结束时间
        if(!found) formula="No Answer!!!";
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println(formula.toString());
        return formula;
    }

    private static void operatorCreat( String A, String B, String C, String D) {
        operator.add(A);
        operator.add(B);
        operator.add(C);
        operator.add(D);
    }


    private static boolean balance(List<String> operator) {
        int count=0;
        boolean found=false;

            while(true) {
                count++;
                try {
                Collections.shuffle(operator);
               // System.out.println(operator);
                Stack<Integer> num_Stack = new Stack<>();
                for (String s : operator) {
                    try {
                        int num = Integer.parseInt(s);
                        num_Stack.push(num);
                    } catch (NumberFormatException e) {
                        Integer num1 = num_Stack.pop();
                        Integer num2 = num_Stack.pop();
                        if (s.equals("+")) {
                            int num3 = num2 + num1;
                            num_Stack.push(num3);
                        }
                        if (s.equals("-")) {
                            int num3 = num2 - num1;
                            num_Stack.push(num3);
                        }
                        if (s.equals("*")) {
                            int num3 = num2 * num1;
                            num_Stack.push(num3);
                        }
                        if (s.equals("/")) {
                            int num3 = num2 / num1;
                            num_Stack.push(num3);
                        }
                    }
                }
                if(num_Stack.pop()==24) {
                    found=true;
                }

            }catch (Exception e) {
            }
                if(count>1000)
                    break;
                if(found)break;
        }
       /* System.out.println(found);
        System.out.println(count);*/
        return found;
    }

}
