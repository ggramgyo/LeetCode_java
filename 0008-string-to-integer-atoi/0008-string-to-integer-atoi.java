class Solution {
    public int myAtoi(String s) {
        boolean isNegative = false;
        long value = 0;
        int i = 0;
        // 왼쪽 공백 지우고 시작
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            isNegative = (s.charAt(i) == '-');
            i++;
        }
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                value = value * 10 + (c - '0');
                
                if (value > Integer.MAX_VALUE) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
            
            i++;
        }
        
        value = isNegative ? -value : value;
        return (int) value;
    }
}
