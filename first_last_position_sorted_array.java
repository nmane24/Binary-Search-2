/*
 * Time Complexity: logn+ logn = 2logn = O(logn)
 * 
 * Space Complexity: O(1)
 * 

Leetcode : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 * 
 * Code Explanation : 
 * We can divide search in two half.
At first, we will find the first occurance of the element then search last 
occurance in between first_occured_index and high index.

 * 
 * We would start with binary search and find the mid element. Check if mid element is eqqal to target 
 * or less than target. IF it is less move the high pointer to left side.
 * To find the first ouccurence check if mid element is equal to target, for it to
 * be the first occurence mid element should be is greater than its previous element. If the previous element is not greater
 * we keep moving to left by moving the high pointer to left. i.e perform binary search on left part of the array.
 * When binary search is performed and mid is calculated again check if mid is equal to target, if it is not lets say it is smaller
 * than target now move to greater side, i.e move low to mid+1.
 * Finally let say afteer one more BS, mid is equal to target and is greater than the previous element, that means it is the first occurence
 * 
 * For high occurence, we point low pointer pointing to first occurence and high pointer at end. Calculate mid by bs, is mid equal to target if no 
 * and mid is greater than target move the high to mid-1. keep on calculating mid and now check if  target is equal to mid, if it equal to mid
 * then check if the mid is smaller than mid+1, if it is not smaller then move towards the right , tht is low = mid+1 as on the right side we will
 * have last occurence.
 *  
 * 
 */

public class first_last_position_sorted_array {
    private int binarySearchFirst(int[]nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid == target){
                //check for 1st occurence
                if(mid== 0 || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid -1; // keep moving left
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }

        }
        return -1;
    }

    private int binarySearchSecond(int []nums, int low, int high, int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(mid == target){
                //check for last occurence if mid is equal to target
                if(mid==high || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else{
                    low = mid+1; // keep moving right
                }
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return  -1;
    }

    public int[] searchRange(int[]nums, int target){
        if(nums==null ||nums.length == 0) return new int[]{1,1};
        int n = nums.length;

        int first =  binarySearchFirst(nums,0, n-1, target);
        if(first == -1){
            return new int []{-1,-1};
        }

        int second = binarySearchSecond(nums, first, n-1, target);

        return new int []{first,second};
    }
}
