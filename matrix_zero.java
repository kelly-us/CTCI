package CC150;

//C1-1.7
public class matrix_zero {

	/*
	 * 
	[solution]
	1. use two bool arrays, one to indicate whether a row should be set to zero, another to indicate whether a col should be set to zero.
	2. first scan of the matrix to update the two bool arrays.
	3. second scan of the matrix to set the correspond elements.
	[time]
	O(mn)
	[space]
	O(m+n)
	 */
	public void set_zero(int[][] matrix){
		if(matrix == null) return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];
		
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		
		//do a second pass
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++){
				if(row[i] || col[j]){
					matrix[i][j] = 0;
				}
			}
	}
}
