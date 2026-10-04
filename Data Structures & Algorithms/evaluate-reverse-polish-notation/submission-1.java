class Solution {
    public int evalRPN(String[] tokens) {

        // here we would use stack 
        // push the incoming elements on Stack
        // as soon you encounter a operator - pop the elements perform the action
        // save the result in a seperate variable

        int result = 0;
        Stack<Integer> opr = new Stack<>();

        for(String tkn : tokens){

            if((tkn.equals("-") || tkn.equals("*") || tkn.equals("/") || tkn.equals("+")) && !opr.isEmpty()){

                int val = opr.pop();

                switch(tkn){
                    case "+" : result = add(val,opr.pop());
                    break;
                    case "-" : result = sub(opr.pop(),val);
                    break;
                    case "*" : result = mul(val,opr.pop());
                    break;
                    case "/" : result = div(opr.pop(),val);
                    break;

                    
                }
                opr.push(result);

            }
            else {
                opr.push(Integer.parseInt(tkn));
            }

        }

        return opr.pop();
        
    }

    private int add(int a, int b){
        return (a + b);
    }

    private int mul(int a, int b){
        return (a * b);
    }

    private int div(int a, int b){
        return (a / b);
    }

    private int sub(int a, int b){
        return (a - b);
    }
}
