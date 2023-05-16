public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return helper(1, n);
    }

    private int helper(int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (isBadVersion(mid)) {
            // if the mid is bad, then first bad is in [lo, mid - 1]
            // if mid is bad but not first bad then we move forward
            if (isBadVersion(mid - 1)) {
                return helper(lo, mid - 1);
            } else {
                return mid;
            }
        } else {
            // if the mid is not bad, then bad is in [mid + 1, hi]
            return helper(mid + 1, hi);
        }
    }
}