package CTCI.CTCILibrary;

public class AssortedMethods {
	
	public static int randomInt(int n){
		return (int)(Math.random() * n);
	}
	
	public static int randomIntInRange(int min, int max){
		return randomInt(max + 1- min) + min;
	}
	
	public static int[][] randomMatrix(int M, int N, int min, int max){
		int[][] matrix = new int[M][N];
		for(int i = 0; i < M; ++i){
			for (int j = 0; j < N; ++j){
				matrix[i][j] = randomIntInRange(min,max);
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static ListNode randomLinkedList(int N, int min, int max){
		ListNode root = new ListNode(randomIntInRange(min, max), null, null);
		ListNode prev = root;
		for(int i = 1; i < N; ++i){
			int data = randomIntInRange(min, max);
			ListNode next = new ListNode(data, null, null);
			prev.setNext(next);
			prev = next;
		}
		return root;
	}
	
}
