'''
    The isBadVersion API is already defined for you.
    def isBadVersion(version: int) -> bool:

    Python submission is accepted whereas Java submission is not (time limit exceed)
'''

public class Solution {

    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mid;

        while (true) {
            mid = (lo + hi) / 2;
            if (isBadVersion(mid)) {
                // if mid is bad version, then first bad is in [1, mid - 1]
                // if mid is bad but not first bad, then we move forward
                if (isBadVersion(mid - 1)) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            } else {
                // if mid is not bad, then first bad is in [mid + 1, hi]
                lo = mid + 1;
            }
        }
    }

    private boolean isBadVersion(int i) {
        return (i >= 73);
    }
}