package CC150;

//C1-1.6
public class rotate {
	
	//clockwise or anticlockwise
	public void rotateMatrix(int[][] matrix){
		int n = matrix.length;
		//layer
		for(int k = 0; k < n/2; k++){
			int first = k;
			int last = n-1-k;
			
			for(int i = first; i < last; i++){
				int off = i - first;
				
				int temp = matrix[first][i];
				//left->top
				matrix[first][i] = matrix[last-off][first];
				
				//bottom->left
				matrix[last-off][first] = matrix[last][last-off];
				
				//right->bottom
				matrix[last][last-off] = matrix[i][last];
				
				//top->right
				matrix[i][last] = temp;
			}
		}
	}
	/*
	 * ¡¾solution¡¿
		transpose the image and then reverse the rows
		¡¾time¡¿
		O(N^2) 
		¡¾space¡¿
		O(1)
	 */
	public void rotateMatrix_2(int[][] matrix){
		int n = matrix.length;
		
		//transpose 
		for(int i = 1; i < n; ++i){
			for(int j = n-i; j < n; ++j){
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}
		
		//reverse rows
		for(int i = 0; i< n/2; ++i){
			for(int j = 0; j < n; ++j){
				int t = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][j];
				matrix[n-i-1][j] = t;
			}
		}
	}
}

