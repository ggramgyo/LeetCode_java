class Solution {
    private static final int[] values = {1000, 500, 100, 50, 10, 5, 1};
    private static final char[] chars = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    
    public int romanToInt(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            int next = (i + 1 < s.length()) ? getValue(s.charAt(i + 1)) : 0;

            if (current < next) {
                value -= current;
            } else {
                value += current;
            }
        }
        return value;
    }

    private int getValue(char c) {
        for (int j = 0; j < chars.length; j++) {
            if (c == chars[j]) {
                return values[j];
            }
        }
        return 0;
    }

}
