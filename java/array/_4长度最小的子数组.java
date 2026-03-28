package array;

import java.util.Scanner;
import java.util.Arrays;

public class _4长度最小的子数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        sc.nextLine();
        String[] numsStr = sc.nextLine().split(",");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        minSubArrayLenSolution3 solution = new minSubArrayLenSolution3();
        int res = solution.minSubArrayLen(target, nums);
        System.out.println(res);
        sc.close();
    }
}

// 我去，理解错了，要的是数组的连续子数组，不能先进行排序后计算
// 时间复杂度---O(nlogn)
class minSubArrayLenSolution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = 0;
        int minLen = 0;
        // 时间复杂度---O(nlogn)
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (res >= target) {
                break;
            } else {
                res += nums[i];
                minLen++;
                if (minLen == nums.length && res < target) {
                    minLen = 0;
                }
            }
        }
        return minLen;
    }
}

// 时间复杂度---O(n^2) 服了，写个暴力算法，写了一个多小时，最后好些超时，红红火火恍恍惚惚
class minSubArrayLenSolution1 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        if (nums.length == 0 && nums.length == 1) {
            return 0;
        }
        if (nums.length == 1 && nums[0] < target) {
            return 0;
        }
        if (nums[nums.length - 1] >= target) {
            res = 1;
            return res;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int total = nums[i];
            int minLen = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (total >= target) {
                    break;
                } else {
                    total += nums[j];
                    minLen++;
                    if (minLen < nums.length && j == nums.length - 1 && total < target) {
                        minLen = Integer.MAX_VALUE;
                    }
                    if (minLen == nums.length && total < target) {
                        minLen = 0;
                    }
                    // 不能使用if，因为当满足前一个if时，minLen会被赋值为0，导致也满足第二个if，从而导致错误的结果Integer.MAX_VALUE
                    // if(minLen < nums.length && j == nums.length-1 && total < target){
                    // minLen = Integer.MAX_VALUE;
                    // }
                }
            }
            if (res > minLen) {
                res = minLen;
            }
        }
        return res;
    }
}

// 时间复杂度---O(n^2) 想错了----这个跟暴力算法没有区别
class minSubArrayLenSolution2 {
    public int minSubArrayLen(int target, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
        }
        for (int i = 2; i <= nums.length; i++) {
            for (int j = 0; j < nums.length - i + 1; j++) {
                int total = 0;
                for (int k = 0; k < i; k++) {
                    total += nums[j + k];
                }
                if (total >= target) {
                    return i;
                }
            }

        }
        return 0;
    }
}

// 滑窗法---时间复杂度---O(n)
class minSubArrayLenSolution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int total = 0;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            // 我本来以为是if，结果是while，
            while (total >= target) {
                res = Math.min(res, right - left + 1);
                total -= nums[left++];
            }
        }
        //当全部数组的和都小于target时，此时res值为Integer.MAX_VALUE，返回0
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
