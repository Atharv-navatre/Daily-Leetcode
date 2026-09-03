class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Check every number between min and max
        for (int i = min + 1; i < max; i++) {

            boolean found = false;

            // Search for i in nums
            for (int j = 0; j < nums.length; j++) {

                if (nums[j] == i) {
                    found = true;
                }
            }

            // If i was not found, it is missing
            if (!found) {
                ans.add(i);
            }
        }

        return ans;
    }
}