/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerset;

import java.util.*;

/**
 *
 * @author well come
 */
public class PowerSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n----------------INSTRUCTIONS----------------\n\n1.Program can handle input of a set in comma seperated format with surrounded by Curly Brackets.\n"+
                "\nE.g : {5,6,37,12,45} OR  {a,bc,d}\n\n"+
                "3.No other Brackets are allowed except These Curly Braces.\n\n");
        System.out.print("Enter a set: ");
        String in = input.nextLine();
        if(checkValidity(in)){
            in = in.replaceAll(" ", "");
        in=in.replaceAll("\\{", "").replaceAll("\\}","");
        String [] set = in.split(",");
        System.out.println(Arrays.toString(set));
        System.out.println("");
        PowerSet(set, set.length);
        System.out.println("\n\nPower Set Generated Successfully.\n\nProgram Ended Gracefully.\n\n");
        }
        
        else{
            System.out.println("\n\nInvalid Input.\n\nProgram Ended Gracefully.\n\n");
        }
        
    }
    public static void PowerSet(String[] set, int set_size){
        if (set_size == 0){
            System.out.println(" { { } }");
            return;
        }
        int power = (int) Math.pow(2, set_size);
        int i, j;
        System.out.print("{ ");
        for(i = 0; i < power; i++){
            System.out.print("{ ");
            for(j = 0; j < set_size; j++){
                if((i & (1 << j)) != 0){
                    System.out.print(set[j] + " ");
                }
            }
            if(i==power-1){
                System.out.print("} ");
            }
            else{
                System.out.print("} , ");
            }
        }
        System.out.print(" }");
        System.out.println("");
    }
    public static boolean checkValidity(String exp){
        int i,tag=0;
        char ch;
        Stack <Character>st=new Stack<>();
                for(i=0;i<exp.length();i++){
                    ch=exp.charAt(i);
                    if(isOpeningParanthesis(ch)){
                        st.push(ch);
                    }
                    else{
                        if(isClosingParanthesis(ch)){
                            if(st.isEmpty()){
                                tag=1;
                                break;
                            }
                            else{
                                if(ch=='}' && st.peek()=='{'){  
                                    st.pop();
                                }
                                else{
                                    tag=1;
                                    break;
                                }
                               
                            }
                        }
                    }
                }
        return tag==0 && st.isEmpty()==true;
    }
    public static boolean isOpeningParanthesis(char ch){
        return (ch=='(' || ch=='{' || ch=='[');
    }
    public static boolean isClosingParanthesis(char ch){
        return (ch==')'|| ch=='}' || ch==']');
    }
}
