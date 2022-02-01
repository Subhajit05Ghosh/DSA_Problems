package arrayMisc;

public class MiddleIndexArr {
	public static void main(String[] args) {
		int[] nums = { 2, 3, -1, 8, 4 };
		int pos = findMiddleIndex(nums);
		System.out.println("Position of middle index " + pos);
		int postn = findMiddleIndexArr(nums);
		System.out.println("Position of middle index " + postn);
	}

	private static int findMiddleIndex(int[] nums) {
		int l = 0, r = 0;
		for (int num : nums) {
			r += num;
		}
		for (int i = 0; i < nums.length; i++) {
			r = r - nums[i];
			if (r == l) {
				return i;
			} else {
				l = l + nums[i];
			}
		}
		return -1;
	}

	private static int findMiddleIndexArr(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int r = 0, l = 0;
			for (int j = i - 1; j >= 0; j--)
				l = l + nums[j];
			for (int j = i + 1; j < nums.length; j++)
				r = r + nums[j];
			if (l == r) {
				return i;
			}
		}
		return -1;
	}

}
