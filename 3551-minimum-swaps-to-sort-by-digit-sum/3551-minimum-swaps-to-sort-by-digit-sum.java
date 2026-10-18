class Solution {
    private int digSum(int n){
        int sum=0;
        while(n>0){
            int r=n%10;
            sum+=r;
            n/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;
       
        int[][] arr=new int[n][2];
        //2D array put value and its indx
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }

        //arr sorting
        Arrays.sort(arr, (a,b)->{
            int sumA=digSum(a[0]);
            int sumB=digSum(b[0]);
            if(sumA!=sumB){
                return Integer.compare(sumA,sumB);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean[] vis=new boolean[n];
        int swaps=0;

        for(int i=0;i<n;i++){

            if(vis[i] || arr[i][1]==i) continue;

            int curr=i;
            int cycleSz=0;

            while(!vis[curr]){
                vis[curr]=true;
                curr=arr[curr][1];
                cycleSz++;
            }
            if(cycleSz>1) swaps+=cycleSz-1;
        }
        return swaps;

    }
}