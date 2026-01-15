// Time Complexity O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : As the logic is based on the last input character at each step, we make use of stacks. We use two stacks one for capturing last
// encountered char and another for it's corresponding count. If the count reaches k, it means we found k adjacent chars so we pop the char
// and count from the stacks. We continue this step for the complete string and construct the result with the left over characters in the stack.

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> chStack = new Stack<>();//stack for character
        Stack<Integer> countSt = new Stack<>();//stack for charcater's count
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(chStack.isEmpty() || chStack.peek() != ch){ //if incoming char is new
                chStack.push(ch);
                countSt.push(1);
            } else{
                countSt.push(countSt.pop()+1); //increment the count
                if(countSt.peek() == k){ //k adjacent chars are found
                    chStack.pop();
                    countSt.pop();
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while(!chStack.isEmpty()){ //build the result string
            for(int i = 0;i<countSt.peek();i++){
                result.append(chStack.peek());
            }
            chStack.pop();
            countSt.pop();
        }
        return result.reverse().toString();
    }
}