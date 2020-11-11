package practice.ds.algo;

//Valid Square
/*
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
 */
public class ValidSquare {

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int dis1 = calDistanceSquare(p1, p2);
		int dis2 = calDistanceSquare(p1, p3);
		int dis3 = calDistanceSquare(p1, p4);
		if (dis1 == 0 || dis2 == 0 || dis3 == 0)
			return false;

		System.out.println("dis1:" + dis1);
		System.out.println("dis2:" + dis2);
		System.out.println("dis3:" + dis3);
		if (dis1 == dis2 && (dis1 + dis2) == dis3) {
			System.out.println("here1");
			int dis4 = calDistanceSquare(p4, p3);
			int dis5 = calDistanceSquare(p4, p2);
			int dis6 = calDistanceSquare(p2, p3);
			if (dis4 == dis5 && (dis4 + dis5) == dis6)
				return true;
		}

		if (dis3 == dis2 && (dis3 + dis2) == dis1) {
			System.out.println("here2");
			int dis4 = calDistanceSquare(p2, p3);
			int dis5 = calDistanceSquare(p2, p4);
			int dis6 = calDistanceSquare(p3, p4);
			if (dis4 == dis5 && (dis4 + dis5) == dis6)
				return true;
		}

		if (dis3 == dis1 && (dis3 + dis1) == dis2) {
			System.out.println("here3");
			int dis4 = calDistanceSquare(p3, p2);
			int dis5 = calDistanceSquare(p4, p3);
			int dis6 = calDistanceSquare(p2, p4);
			if (dis4 == dis5 && (dis4 + dis5) == dis6)
				return true;
		}

		return false;

	}

	int calDistanceSquare(int[] p1, int[] p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}

}
