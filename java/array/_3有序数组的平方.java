package array;

import java.util.Scanner;
public class _3有序数组的平方{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] numsStr = sc.nextLine().split(",");
        int[] nums = new int[numsStr.length];
        for(int i = 0;i<numsStr.length;i++){
            nums[i] = Integer.parseInt(numsStr[i]);
        }
    
        sortedSquaresSolution solution = new sortedSquaresSolution();
        int[] res = solution.sortedSquares(nums);
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i]);
            System.out.print(",");
        }

        sc.close();
    }
}
//之前使用了冒泡法进行排序，时间复杂度O(n^2)，直接击败5%的用户，哈哈哈哈

//最简单的方法，直接使用Arrays.sort()方法进行排序,时间复杂度O(nlogn)，空间复杂度O(1)
//不过我学习就不使用了

//双指针法----时间复杂度O(n)----空间复杂度O(n)
class sortedSquaresSolution {
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int index = nums.length - 1;
        int[] resNums = new int[nums.length];
        while(left <= right){
            if(left==right){
                resNums[index] = nums[left] * nums[left];
                break;
            }
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                resNums[index] = nums[right] * nums[right];
                right--;
                index--;
            }else{
                resNums[index] = nums[left] * nums[left];
                left++;
                index--;
            }
        }
        return resNums;
    }
}