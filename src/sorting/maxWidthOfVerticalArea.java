package sorting;

import java.util.Arrays;

// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/
public class maxWidthOfVerticalArea {
	public static int maxWidthOfVerticalArea(int[][] points) {

		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

		int maxWidth = 0;

		for (int i = 1; i < points.length; i++) {
			int width = points[i][0] - points[i - 1][0];

			maxWidth = Math.max(maxWidth, width);
		}

		return maxWidth;
	}
}
