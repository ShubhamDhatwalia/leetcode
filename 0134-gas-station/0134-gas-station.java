class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        for(int g : gas){
            totalGas+= g;
        }
        int totalCost =0;
        for(int c : cost){
            totalCost+= c;
        }
        if(totalGas < totalCost){
            return -1;
        }
        int start =0;
        int remainingGas =0;
        for(int i=0; i< cost.length; i++){
            remainingGas+= gas[i];
            
            if(remainingGas >= cost[i]){
                remainingGas-= cost[i];
            }else{
                start = i+1;
                remainingGas =0;
            }
        }
        return start;
    }
}