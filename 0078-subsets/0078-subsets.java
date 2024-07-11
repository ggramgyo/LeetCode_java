class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), nums, 0);
        return answer;
    }

    private void backtrack(List<List<Integer>> answer, List<Integer> current, int[] nums, int start) {
        answer.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(answer, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}