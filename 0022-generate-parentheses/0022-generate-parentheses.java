class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        bt(sb, arr, 0, 0, n);
        return arr;
    }

    private void bt(StringBuilder current, List<String> arr, int open, int close, int n) {

        if (current.length() == n * 2) {
            arr.add(current.toString());
            return;
        }
        
        if (open < n) {
            current.append('(');
            bt(current, arr, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); 
        }
        
        if (close < open) {
            current.append(')');
            bt(current, arr, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); 
        }
    }


}