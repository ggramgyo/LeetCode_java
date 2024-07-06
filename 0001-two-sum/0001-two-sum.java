class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> idxNums = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){

            if(idxNums.containsKey(target - nums[i])){
                return new int[]{idxNums.get(target - nums[i]), i};
            }
            idxNums.put(nums[i], i);
        }
        return null;
    }
}
