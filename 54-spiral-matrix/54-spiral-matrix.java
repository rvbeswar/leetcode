class Solution {
    
    public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static int[][] visited;
	public static int m = 0;
	public static int n = 0;
	public static int x = 0;
	public static int y = 0;

	public static List<Integer> spiralOrder(int[][] array) {
		reset();
		m = array.length;
		n = array[0].length;
		visited = new int[m][n];
		list.add(array[0][0]);
		visited[0][0] = 1;
		move(0, 0, array);

		return list;
	}

	private static void reset() {
		x = 0;
		y = 0;
		list = new ArrayList<Integer>();

	}

	public static boolean moved = false;

	private static void move(int i, int j, int[][] array) {
		moved = false;

		while (moveDirection(x, y + 1, array))
			;
		while (moveDirection(x - 1, y, array))
			;
		while (moveDirection(x + 1, y, array))
			;
		while (moveDirection(x, y - 1, array))
			;

		if (moved) {
			move(x, y, array);
		}
	}

	private static boolean moveDirection(int i, int j, int[][] array) {
		if (i < 0 || i == m || j == n || j < 0) {
			return false;
		} else if (visited[i][j] == 1) {
			return false;
		} else {
			x=i;
			y=j;
			moved = true;
			list.add(array[i][j]);
			visited[i][j] = 1;
			return true;
		}

	}
}