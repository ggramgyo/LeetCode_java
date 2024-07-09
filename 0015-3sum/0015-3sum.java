import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int value = nums[start] + nums[end];
                if (value == target) {
                    answer.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // 중복된 값 건너뛰기
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }

                    start++;
                    end--;
                } else if (value < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return answer;
    }


}
