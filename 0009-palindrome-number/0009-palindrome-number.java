class Solution {
    public boolean isPalindrome(int x) {
        // 음수 or 숫자의 끝이 0이지만 시작이 0이 아닌 경우
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
            // System.out.println(reversed);
            // System.out.println(x);
        }
        // 숫자가 홀수, 중간 숫자를 제외 /10
        return x == reversed || x == reversed / 10;
    }
}