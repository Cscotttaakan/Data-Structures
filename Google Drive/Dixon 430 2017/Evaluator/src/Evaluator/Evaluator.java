/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluator;

import java.util.HashMap;

/**
 *
 * @author Krag
 */
public class Evaluator {
    private Tokenizer parser = new Tokenizer();
    private HashMap values = new HashMap();
    private List infix;
    private Stack s1 = new Stack();
    private Stack s2 = new Stack();
    Evaluator()
    {
        infix = new List();
    }
    
    public void runTokenizer()
    {
        parser.storeInfix();
        parser.initialize();
        
        infix = parser.tokenInfix();
        values = parser.getValues();
    }
    
    public void parser()
    {
        infix.iteratorInitialize();
        do
        {
            TokenDataItem temp = (TokenDataItem) infix.indexNode.getData();
            //System.out.println("Token being processed: " + temp.Token);
           
            switch(temp.type)
            {
                case identifier://S1
                    s1.push(temp);//S1
                    break;
                
                case operator:
                    switch(temp.Token)
                    {
                        case "=":
                            if(s2.getCounter() == 0)
                                S1(temp);
                            else
                                System.out.println("Error");
                            break;
                        case "+":
                                if(s2.showTop() != null)
                                {
                                TokenDataItem s2Temp = (TokenDataItem) s2.showTop();
                                while(checkAddSub(s2Temp)|| checkFunction(s2Temp))
                                {
                                    s2Temp = U1();
                                }
                                S2(temp);
                                }
                                
                            break;
                        case "-":
                            if(s2.showTop() != null)
                                {
                                TokenDataItem s2Temp = (TokenDataItem) s2.showTop();
                                while(checkAddSub(s2Temp) || checkFunction(s2Temp))
                                {
                                    s2Temp = U1();
                                }
                                S2(temp);
                                }
                            break;
                            
                        case "*":
                            if(s2.showTop() != null)
                                {
                                TokenDataItem s2Temp = (TokenDataItem) s2.showTop();
                                while(checkMulDiv(s2Temp)|| checkFunction(s2Temp))
                                {
                                    s2Temp = U1();
                                }
                                S2(temp);
                                }
                            break;
                        case "/":
    
                            if(s2.showTop() != null)
                                {
                                TokenDataItem s2Temp = (TokenDataItem) s2.showTop();
                                while(checkMulDiv(s2Temp)|| checkFunction(s2Temp))
                                {
                                    s2Temp = U1();
                                }
                                S2(temp);
                                }
                            
                            break;
                        case "(":
                            if(s2.showTop() != null)
                                {
                                S2(temp);
                                }
                            break;
                        case ")":
                            Uc();
                            break;
                        
                            
                           
                    }
                    break;
                    
                case function:
                    switch(temp.Token){
                case "SIN":
                            TokenDataItem s2Temp = (TokenDataItem) s2.showTop();
                            if(s2.showTop() != null)
                                {
                                
                                while( checkFunction(s2Temp))
                                {
                                    s2Temp = U1();
                                }
                                S2(temp);
                                }
                            break;
                        case "COS":
                            if(s2.showTop() != null)
                                {
                                s2Temp = (TokenDataItem) s2.showTop();
                                while( checkFunction(s2Temp))
                                {
                                    s2Temp = U1();
                                }
                                S2(temp);
                                }
                            break;
                        case "ABS":
                            if(s2.showTop() != null)
                                {
                                s2Temp = (TokenDataItem) s2.showTop();
                                while( checkFunction(s2Temp))
                                {
                                    s2Temp = U1();
                                }
                                S2(temp);
                                }
                            break;
                        case "SQRT":
                            if(s2.showTop() != null)
                                {
                                s2Temp = (TokenDataItem) s2.showTop();
                                while( checkFunction(s2Temp))
                                {
                                    
                                    s2Temp = U1();
                                    
                                }
                                S2(temp);
                                }
                            break;
                    }
                break;
                    
            }
          infix.iteratorNext();
         /*System.out.println("S2 : ");
         s2.displayNodes();
         System.out.println("S1 : ");
         s1.displayNodes();
         System.out.println("_____________");*/
         //infix.displayNodes();
        }
        while(infix.iIndex < infix.getCounter());
        
        U2();
    }
    
    public void evaluatePostfix()
    {
        
        while(s1.getCounter() > 0)
        {
            s2.push(s1.pop());
        }
        //s2.displayNodes();
        
        while(s2.getCounter() > 0)
        {
            TokenDataItem temp = (TokenDataItem) s2.showTop();
            if(temp.type == dataType.state.operator && s2.getCounter() >0)
            {
                s1.push(s2.pop());
                TokenDataItem operator = (TokenDataItem) s1.pop();
                TokenDataItem a = (TokenDataItem) s1.pop();
                TokenDataItem b = (TokenDataItem) s1.pop();
                
                s2.push(evaluate(operator,a,b));
                
            }
            else if (temp.type == dataType.state.function && s2.getCounter() > 0)
            {
                s1.push(s2.pop());
                TokenDataItem function = (TokenDataItem) s1.pop();
                TokenDataItem operand = (TokenDataItem) s1.pop();
                
                s2.push(evalFunction(function,operand));
            }
            else
            {
                s1.push(s2.pop());
            }
            //s2.displayNodes();
        }
        s1.displayNodes();
        
    }
    
    private TokenDataItem evaluate(TokenDataItem operator,TokenDataItem first,TokenDataItem second)
    {
        TokenDataItem returnVal = new TokenDataItem();
        double a;
        switch(operator.Token)
        {
            
            case "=":
                returnVal = new TokenDataItem(second.Token + " = " + first.Token,dataType.state.identifier);
                break;
            case "+":
                a = (double)values.get(first.Token) + (double)values.get(second.Token);
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                break;
            case "-":
                a =  (double)values.get(second.Token)-(double)values.get(first.Token);
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                break;
            case "*":
                a = (double)values.get(first.Token) * (double)values.get(second.Token);
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                break;
            case "/":
                if((double)values.get(first.Token) != 0){
                a =  (double)values.get(second.Token) / (double)values.get(first.Token);
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                }
                else
                {
                    System.out.println("Cannot divide by 0!");
                    returnVal = new TokenDataItem("Invalid operations - Divide by 0",dataType.state.identifier);
                }
                break;
        }
        
        return returnVal;
    }
    
    private TokenDataItem evalFunction(TokenDataItem function, TokenDataItem operand)
    {
        TokenDataItem returnVal = new TokenDataItem();
        double a;
        switch(function.Token)
        {
            
            case "SIN":
                a = Math.sin((double)values.get(operand.Token));
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                break;
            case "COS":
                a = Math.cos((double)values.get(operand.Token));
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                break;
            case "ABS":
                a = Math.abs((double)values.get(operand.Token));
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                break;
            case "SQRT":
                a = Math.sqrt((double)values.get(operand.Token));
                returnVal = new TokenDataItem(Double.toString(a),dataType.state.identifier);
                values.put(returnVal.Token, Double.parseDouble(returnVal.Token));
                break;
            
        }
        
        return returnVal;
    }
    
    public void printState()
    {
        System.out.println (parser.infix);
    }
    
    private boolean checkFunction(TokenDataItem a)
    {
        return a.Token.equals("SIN") || a.Token.equals("COS") || a.Token.equals("ABS") || a.Token.equals("SQRT");
    }
    
    private boolean checkAddSub(TokenDataItem a)
    {
        return a.Token.equals("*") || a.Token.equals("/") || a.Token.equals("+") || a.Token.equals("-");
    }
    
    private boolean checkMulDiv(TokenDataItem a)
    {
        return a.Token.equals("*") || a.Token.equals("/");
    }
    
    
    
    //Parse operations
    private TokenDataItem U1()
    {
        s1.push(s2.pop());
        return (TokenDataItem) s2.showTop();
    }
    
    private void S1(TokenDataItem a)
    {
        s1.push(a);
    }
    private void S2(TokenDataItem a)
    {
        s2.push(a);
    }
    
    private void Uc()
    {
        TokenDataItem s2Temp = (TokenDataItem) s2.showTop();
                            if(s2.showTop() != null){
                            if(s2Temp.Token.equals("("))
                            {
                                s2.pop();
                            }
                            else if(!"=".equals(s2Temp.Token))
                                {
                                
                                    for(int i = 0; i < s2.getCounter(); i++)
                                    {
                                        s2Temp = (TokenDataItem) s2.showTop();
                                        //System.out.println(s2Temp.Token);
                                        if(!"(".equals(s2Temp.Token))
                                            s1.push(s2.pop());
                                        else
                                        {
                                            s2.remove(i-1);
                                            i = s2.getCounter();
                                        }
                                    }
                                }
                            }
    }
    
    private void U2()
    {
        while(s2.getCounter() != 0)
        {
            s1.push(s2.pop());
        }
    }
    //Parse operations
}
