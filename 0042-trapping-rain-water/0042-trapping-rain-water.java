//  Approach 1 ::::::    TC:O(3N) = O(N)  SC:O(N)


class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        
        int lmax [] = new int[n];
		lmax[0] = arr[0];
        
		for(int i=1; i<n; i++){
			lmax[i] = Math.max(lmax[i-1], arr[i]);
		}
		int rmax [] = new int[n];
		rmax[n-1] = arr[n-1];
        
		for(int i=n-2; i>=0; i--){
			rmax[i] = Math.max(rmax[i+1], arr[i]);
		}
        int totalwater = 0;
		
		for(int i=0; i<n; i++){
			int maxheight = Math.min(lmax[i], rmax[i]);
			int waterheight = maxheight - arr[i];
			int currUnitOfWater = waterheight * 1;
			totalwater += currUnitOfWater; 
		}
        return totalwater;
    }
}



//  Approach 2::   TC:O(N)  SC:O(N)

// class Solution {
//     public int trap(int[] arr) {
//         int n = arr.length;
//         Stack<Integer> st = new Stack<>();
//         int totalWater =0;
//         for(int i=0; i<n; i++){
//             while(st.size() >0 && arr[i] > arr[st.peek()]){
//                 int r = i;
//                 int currval = arr[st.pop()];

//                 if(st.size() == 0){
//                     break;
//                 }
//                 int l = st.peek();
//                 int width = r-l-1;
//                 int totalheight = Math.min(arr[l], arr[r]);
//                 int waterheight = totalheight - currval;
//                 totalWater += (width * waterheight);
//             }
//             st.push(i);
//         }
//         return totalWater;
//     }
// }


// Approach 3 ::::      TC:O(N)   SC:O(1)

// class Solution {
//     public int trap(int[] arr) {
//         int n = arr.length;
//         int lb = arr[0];
//         int rb = arr[n-1];
//         int l =1;
//         int r = n-2;
//         int totalWater =0;

//         while(l<=r){
//             if(lb<=rb){
//                 if(lb < arr[l]){
//                     lb = arr[l];
//                 }else{
//                     totalWater += lb-arr[l];
//                 }
//                 l++;
//             }
//             else{
//                 if(rb < arr[r]){
//                     rb = arr[r];
//                 }else{
//                     totalWater += rb-arr[r];
//                 }
//                 r--;
//             }
//         }
//         return totalWater;
//     }
// }