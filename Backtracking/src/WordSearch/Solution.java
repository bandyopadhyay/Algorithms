package WordSearch;

public class Solution {

	 public boolean exist(char[][] board, String word) {
		 int row = board.length;
		 int column = board[0].length;
		 boolean[][] visited = new boolean[row][column];
		 for(int i=0; i<row;i++){
			 for(int j=0; j<board[i].length; j++){
				 if(word.charAt(0)==board[i][j]){
					boolean exists = dfs(board, i, j, word,0,visited);		
					if(exists) {
						return true;
					}
				 }
			 }
		 }
		 
		 return false;		 
	 }
	 
	 boolean dfs(char[][] board, int row, int column, String word, int index, boolean[][] visited){
		 
		 if(index == word.length()) return true;
		 
		 if(row < 0 || (row >= board.length)
				 || column < 0 || column >= board[row].length
				 || word.charAt(index) != board[row][column]
				 || visited[row][column]) {
			 return false;
		 }
		 visited[row][column]= true;
		 boolean exists =  
				           dfs(board, row, column-1, word,index+1,visited)
				        || dfs(board, row+1, column, word,index+1,visited) 
				        || dfs(board, row-1, column, word,index+1,visited)
				        || dfs(board, row, column+1, word,index+1,visited);
		 
		 visited[row][column]= false;
		 return exists;		 
	 }
}