public class CheckLineIntersection {
    public static void main(String[] args) {
        // int[] p1 = {5, -2};
        // int[] q1 = {13, 2};
        // int[] p2 = {2, -3};
        // int[] q2 = {3, 0};
        int[] p1 = {-927840, -884847};
        int[] q1 = {922043, 574938};
        int[] p2 = {742855, 69854};
        int[] q2 = {-900866, -512854};


        Solution obj = new Solution();
        System.out.println(obj.doIntersect(p1, q1, p2, q2));
    }
}

class Solution {
    // Function to check if two line segments intersect
    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {
        int[] orientationArr = new int[4];
        
        // Calculate orientations for the triplets
        orientationArr[0] = orientation(p1, q1, p2);
        orientationArr[1] = orientation(p1, q1, q2);
        orientationArr[2] = orientation(p2, q2, p1);
        orientationArr[3] = orientation(p2, q2, q1);

        // Check general case
        if (orientationArr[0] != orientationArr[1] && orientationArr[2] != orientationArr[3]) {
            return "true";
        }

        // Special cases for collinear points
        if (orientationArr[0] == 0 && onSegment(p1, p2, q1)) return "true";
        if (orientationArr[1] == 0 && onSegment(p1, q2, q1)) return "true";
        if (orientationArr[2] == 0 && onSegment(p2, p1, q2)) return "true";
        if (orientationArr[3] == 0 && onSegment(p2, q1, q2)) return "true";

        // Otherwise, the line segments do not intersect
        return "false";
    }

    // Function to calculate the orientation of the triplet (p, q, r)
    static int orientation(int p[], int q[], int r[]) {
        long val = (long) (q[1] - p[1]) * (r[0] - q[0]) - (long) (q[0] - p[0]) * (r[1] - q[1]);
        if (val == 0) return 0; // Collinear
        return (val > 0) ? 1 : 2; // Clockwise or counterclockwise
    }

    // Function to check if point q lies on segment pr
    public static boolean onSegment(int[] p, int[] q, int[] r) {
        if (q[0] <= Math.max(p[0], r[0]) && q[0] >= Math.min(p[0], r[0]) &&
            q[1] <= Math.max(p[1], r[1]) && q[1] >= Math.min(p[1], r[1])) {
            return true;
        }
        return false;
    }
}