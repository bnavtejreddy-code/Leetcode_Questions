class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i =0;
        //whitespace
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        //sign
        int sign = 1;
        if(i<n && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if (i<n && s.charAt(i) == '+'){
            i++;
        }
        int number =0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            
            if (number > Integer.MAX_VALUE / 10 ||
               (number == Integer.MAX_VALUE / 10 && digit > 7)){
                if(sign ==1){
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
               }
               number = (number * 10) +digit;
               i++;
        }
        return sign * number;
    }
}