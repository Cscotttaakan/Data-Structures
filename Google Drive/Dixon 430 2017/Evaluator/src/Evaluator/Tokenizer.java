/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluator;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Tokenizer {
    String infix = "";
    private HashMap values = new HashMap();
    private char[] infixCA;
    private List tokenList = new List();
    //Identifier, operator,function,badToken
    
    Tokenizer()
    {
        
    }
    
    public void storeInfix()
    {
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter(" ");
        System.out.println("Enter your expression: ");
        
        infix = reader.nextLine();
        infix = infix.replaceAll("\\s+","");
        
        //infix = "A = (C+D)*D/E-A*B";
    }
    
    public void initialize()
    {
        if(infix != null)
        infixCA = infix.toCharArray();
    }
    
    public List tokenInfix()
    {
        for(int i = 0; i < infixCA.length; i++)
        {
            if(checkFloat(infixCA[i]))
            {
                i = processFloatIndex(i);
                   
            }
            else if(i+2 < infixCA.length && checkID(infixCA[i]) && checkID(infixCA[i+1]))
            {
                    int counter = 0;
                    int temp = i;
                    while(checkID(infixCA[temp]))
                    {
                        temp++;
                        counter++;
                    }
                    if(checkFunction(new String(infixCA,i,counter)))
                    {
                        processFunction(new String(infixCA,i,counter));
                        i = i+counter-1;
                        
                    }
            }
            
            else if(checkID(infixCA[i]))
            {
                int tempIndex = i;
                for(int x = i; (checkID(infixCA[x]) && !checkFloat(infixCA[x]) && !checkOperator(infixCA[x])) && x < infixCA.length-1; ++x)
                {
                    System.out.println("INfinite loop");
                    tempIndex++;
                }
                
                if(!checkFloat(infixCA[tempIndex]))
                processIdentifier(infixCA[i]);
            }
            
            else if(checkOperator(infixCA[i]))
            {
                
                processOperator(infixCA[i]);
            }
            
            else
            {
            }
            
            tokenList.displayNodes();
        }
        
        return tokenList;
    }
    
    private boolean checkID(char c)
    {
        int a = c;
        return ((a >= 65 && a <= 90) || (a >=97 && a<=122) || (a >= 48 && a<= 57));
    }
    
    private boolean checkOperator(char c)
    {
        int a = c;
        return ((a >=40 && a <= 47) || (a == 61));
    }
    private boolean checkFunction(String c)
    {
        return c.equals("SIN") || c.equals("COS") || c.equals("ABS") || c.equals("SQRT");
    }
    
    private boolean checkFloat(char c)
    {
        
        int a = c;
                return (a == 46);
        
    }
    
    private int processFloatIndex(int index)
    {
        int a = infixCA[index];
        while((a >= 48 && a<= 57))
        {
                    index--;
                    a = infixCA[index];
        }
        index--;
        String decimal = "";
        while(((a >= 48 && a<= 57) || a == 46) && index < infixCA.length)
        {
            decimal += infixCA[index];
            
            a = infixCA[index];
            index++;
        }
        TokenDataItem temp = new TokenDataItem(decimal);
        temp.type = dataType.state.identifier;
        tokenList.insertToTail(temp);
        
            values.put(decimal,Double.parseDouble(decimal));
        return index-1;
        
    }
    
    private void processFunction(String c)
    {
        
        TokenDataItem temp = new TokenDataItem(c);
        temp.type = dataType.state.function;
        tokenList.insertToTail(temp);
        
    }
    
    private void processIdentifier(char c)
    {
        
        
        
        Scanner reader = new Scanner(System.in);
        String value;
        int a = c;
        
        if(((a >= 65 && a <= 90) || (a >=97 && a<=122)) && !values.containsKey(String.valueOf(c)))
        {
        
        System.out.println("Enter value for variable " + c + ":");
        value = reader.nextLine();
        values.put(String.valueOf(c), Double.parseDouble(value));
        }
        else if ((a >= 48 && a<= 57))
        {
            double temp = (double)Character.digit(c, 10);
            values.put(String.valueOf(c),temp);
        }
        TokenDataItem temp = new TokenDataItem(Character.toString(c));
        temp.type = dataType.state.identifier;
        tokenList.insertToTail(temp);
    }
    
    private void processOperator(char c)
    {
        TokenDataItem temp = new TokenDataItem(Character.toString(c));
        temp.type = dataType.state.operator;
        tokenList.insertToTail(temp);
    }
    
    public HashMap getValues()
    {
        return values;
    }
    

}
