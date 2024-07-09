class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, h = 0;
        int s = 0, e = height.length-1;
        while(s < e){
            h = Math.min(height[s], height[e]);

            maxArea = Math.max(maxArea, h*(e-s));

            while(height[s]<=h && s<e) s++;
            while(height[e]<=h && s<e) e--;
        }
        return maxArea;
    }
}