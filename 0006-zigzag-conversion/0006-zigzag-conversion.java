class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbArr[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            int mod = i % (2 * (numRows - 1));
            int idx = (mod < numRows) ? mod : 2 * (numRows - 1) - mod;
            sbArr[idx].append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbArr) {
            result.append(sb);
        }

        return result.toString();
    }
}
