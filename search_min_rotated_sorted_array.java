/*
 * Brute Force  - Start with 1st element and compare with each element in rotated sorted array, untill a new low is encountered 
 * keep on checking and once found update that as low. Repat again. So we are performing linear search.
 * Time complexity : O(n)
 * 
 * 
 * 

/*
Leetcode : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.


 * Code Explanation:
 * Binary search will help to reduce the data by haf in each iteration.
 *  If the low index is less than high that means it is a sorted array and we return low as being the min.
 * WE check if mid is the smallest number after performing binary search. We check this 
 *  both sides of mid if mid is smallest number or mid+1 is smallest number 
 * 
 * In rotated array, it is more likely to find the min in the non-sorted part of array after finding the mid.
 * 
 */
public class search_min_rotated_sorted_array {
    
    public int findMin(int []nums){
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length-1;

        while(low <=high){
            // it is a sorted array then 0th index will be the minimum element.
            if(nums[low]<= nums[high]) return nums[low];
            int mid = low +(high -low)/2;
            //check if mid is min or not
            // if the mid element is smaller than its previous element then mid element is the smallest
            if(mid!=0 && nums[mid] < nums[mid -1]){
                return nums[mid];
            }
            // if the mid element is greater than its next element then mid+1 element is the smallest
            if(mid< high  && nums[mid]> nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[low]<= nums[mid]){//which means left sorted move to right side to find min
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
