class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] alpha = {
            {},                 
            {},                
            {'a', 'b', 'c'},    
            {'d', 'e', 'f'},    
            {'g', 'h', 'i'},    
            {'j', 'k', 'l'},    
            {'m', 'n', 'o'},    
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},   
            {'w', 'x', 'y', 'z'} 
        };

        List<String> answer = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return answer;
        }

        bt(answer, new StringBuilder(), digits, 0, alpha);
        
        return answer;
    }


    private void bt(List<String> answer, StringBuilder current, String digits, int index, char[][] alpha) {
        //  exit
        if (index == digits.length()) {
            answer.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        int idx = digit - '0';
        char[] letters = alpha[idx];

        for (char letter : letters) {
            current.append(letter);
            bt(answer, current, digits, index + 1, alpha);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}