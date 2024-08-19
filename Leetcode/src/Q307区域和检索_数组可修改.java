import java.util.Arrays;

public class Q307区域和检索_数组可修改 {
    class NumArray {
        int[] segmentTree;
        int n;
        public NumArray(int[] nums) {
            n = nums.length;
            segmentTree = new int[2<<(32-Integer.numberOfLeadingZeros(n))];

            build(nums,0,n-1,0);
        }

        void build(int[] nums,int left,int right,int node){
            if(left==right){
                segmentTree[node] = nums[left];
                return;
            }
            int mid = (left+right)/2;
            build(nums,left,mid,node*2+1);
            build(nums,mid+1,right,node*2+2);
            maintain(node);
        }

        public void update(int index, int val) {
            change(0,0,n-1,index,val);
        }

        //maintain是表示 通过子节点的改变怎么重新给父节点赋值
        void maintain(int node){
            segmentTree[node] = segmentTree[node*2+1] + segmentTree[node*2+2];
        }

        //left是node表示的left
        void change(int node, int left, int right, int index, int val){
            if(left == right){
                segmentTree[node] = val;
                return;
            }

            int mid = (left+right)/2;
            if(index <= mid){
                change(node*2+1,left,mid,index,val);
            } else {
                change(node*2+2,mid+1,right,index,val);
            }
            maintain(node);
        }

        public int sumRange(int left, int right) {
            return range(0,n-1,0,left,right);
        }

        //left是node表示的left cal_left是要计算的范围的left
        int range(int left,int right,int node,int cal_left,int cal_right){
            // System.out.println("node:"+node);
            // System.out.println("left:"+left);
            // System.out.println("right:"+right);
            // System.out.println("cal_left:"+cal_left);
            // System.out.println("cal_right:"+cal_right);
            // System.out.println();
            if(left == cal_left && right == cal_right){
                return segmentTree[node];
            }

            int mid = (left+right)/2;
            if(mid>=cal_right){
                return range(left,mid,node*2+1,cal_left,cal_right);
            } else if (mid+1 <= cal_left) {
                return range(mid+1,right,node*2+2,cal_left,cal_right);
            } else {
                return range(left,mid,node*2+1,cal_left,mid) + range(mid+1,right,node*2+2,mid+1,cal_right);
            }
        }
    }

    static public void main(String[] args) {
        Q307区域和检索_数组可修改 solution = new Q307区域和检索_数组可修改();

        NumArray numArray = solution.new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0,2));
        numArray.update(1,2);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(Arrays.toString(numArray.segmentTree));
    }
}