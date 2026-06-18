class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find the maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                ans = mid;
                high = mid - 1;   // Try smaller speed
            } else {
                low = mid + 1;    // Increase speed
            }
        }

        return ans;
    }

    public boolean canFinish(int[] piles, int h, int speed) {

        long hours = 0;   // Use long to avoid overflow

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;   // Ceiling division
        }

        return hours <= h;
    }
}