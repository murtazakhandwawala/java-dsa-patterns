class Solution {
    public boolean isValid(String s) {

     // we will have to use Stack
     //when you find incoming opening char - you push
     // when is closing charatecter we pop
     //or retunr false not vaid string.

     Stack<Character> charStack = new Stack<>();
        for(int i =0;i<s.length();i++){

            char item = s.charAt(i);

            if(incomingBrace(item)){
                charStack.push(item);
            } 
            
            else if(outgoingBrace(item) && !charStack.isEmpty()){

                if(item == ')' && charStack.peek() == '('){
                    charStack.pop();
                }
                else if(item == '}' && charStack.peek() == '{')
                {
                    charStack.pop();
                }else if(item == ']' && charStack.peek() == '['){
                    charStack.pop();
                }
                else{
                    return false;
                }
            }
            else
            return false;



        }

        if(charStack.isEmpty())
            return true;
        else
            return false;
    }

    private boolean incomingBrace(char a)
        {
            if(a == '(' || a == '{' || a == '['){
                return true;
            }

            return false;
        }

        private boolean outgoingBrace(char a)
        {
            if(a == ')' || a == '}' || a == ']'){
                return true;
            }

            return false;
        }
}
