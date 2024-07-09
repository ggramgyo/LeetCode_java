class Solution {
    public String longestPalindrome(String s) {

        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int oddLp = lp(s, i, i);
            int evenLp = lp(s, i, i + 1);
            int maxLength = Math.max(oddLp, evenLp);

            // 최장 길이 업데이트
            if(maxLength > end - start){
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int lp(String s, int l, int r){
        while(l >= 0 && r <s.length() && s.charAt(l)== s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

}