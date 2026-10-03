class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int min = nums[0], max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        int n = nums.length;
        int gap = (int) Math.ceil((double) (max - min) / (n - 1));

        int[] minBucket = new int[n];
        int[] maxBucket = new int[n];
        boolean[] used = new boolean[n];

        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            int index = (num - min) / gap;
            minBucket[index] = Math.min(minBucket[index], num);
            maxBucket[index] = Math.max(maxBucket[index], num);
            used[index] = true;
        }

        int ans = 0;
        int prev = min;

        for (int i = 0; i < n; i++) {
            if (!used[i]) continue;

            ans = Math.max(ans, minBucket[i] - prev);
            prev = maxBucket[i];
        }

        return ans;
    }
}