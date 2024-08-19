public class Q3165不包含相邻元素的子序列的最大和 {
    //线段树
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        SegmentTree segmentTree = new SegmentTree(nums);
        int n = queries.length;
        int m = nums.length;
        long ans = 0;
        int mod = 1_000_000_007;
        for(int i=0;i<n;i++){
            segmentTree.update(0,0,m-1,queries[i][0],queries[i][1]);
            ans += segmentTree.segmentTree[0][3];
        }
        return (int)(ans%mod);
    }

    class SegmentTree{
        long[][] segmentTree;
        int n;

        SegmentTree(int[] nums){
            n = nums.length;
            segmentTree = new long[2<<(32-Integer.numberOfLeadingZeros(n))][4];

            build(0,0,n-1,nums);
        }

        void build(int node,int left,int right,int[] nums){
            if(left == right){
                segmentTree[node][3] = Math.max(0,nums[left]);
                return;
            }

            int mid = (left+right)/2;
            build(node*2+1,left,mid,nums);
            build(node*2+2,mid+1,right,nums);

            maintain(node);
        }

        void update(int node,int left,int right,int index,int val){
            if(right==left){
                segmentTree[node][3] = Math.max(0,val);
                return;
            }

            int mid = (left+right)/2;
            if(index<=mid){
                update(node*2+1,left,mid,index,val);
            }else {
                update(node*2+2,mid+1,right,index,val);
            }
            maintain(node);
        }

        void maintain(int node){
            long[] leftChild = segmentTree[node*2+1];
            long[] rightChild = segmentTree[node*2+2];
            segmentTree[node][0] = Math.max(leftChild[1]+rightChild[0],leftChild[0]+rightChild[2]);
            segmentTree[node][1] = Math.max(leftChild[0]+rightChild[3],leftChild[1]+rightChild[1]);
            segmentTree[node][2] = Math.max(leftChild[2]+rightChild[2],leftChild[3]+rightChild[0]);
            segmentTree[node][3] = Math.max(leftChild[2]+rightChild[3],leftChild[3]+rightChild[1]);
        }
    }

    public static void main(String[] args) {
        Q3165不包含相邻元素的子序列的最大和 solution = new Q3165不包含相邻元素的子序列的最大和();

        System.out.println(solution.maximumSumSubsequence(new int[]{3,5,9},new int[][]{{1,-2},{0,-3}}));
    }
}