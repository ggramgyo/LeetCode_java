class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
                
            int current = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                int value = nums[start] + nums[end] + current;

                if (Math.abs(value - target) < Math.abs(answer - target)) {
                    answer = value;
                }
                if (value < target) {
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                } else {
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    end--;
                }

            }
        }
        return answer;
    }
}