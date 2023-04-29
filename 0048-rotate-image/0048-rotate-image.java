class Solution {
    public void transpose(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    public void reverse(int arr[][]){
        for(int r=0; r<arr.length; r++){
            int left =0;
            int right = arr.length-1;
            while(left<right){
                int temp = arr[r][left];
                arr[r][left] = arr[r][right];
                arr[r][right] = temp;
                left++;
                right--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}