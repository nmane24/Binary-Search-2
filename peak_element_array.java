/*
/*
Time Complexity : O(log n)

Space Complexity : O(1)

Leetcode : https://leetcode.com/problems/find-peak-element/
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

xs

Brute Force way - linear search for an element by checking element by element and comparing it with previous and right one.
Time Complexity : O(n)


Code Explanation : We are checking if mid is higher than its neighboring elements, if so return the index mid as the peek element
IF not, then we now check which neighboring element to mid is higher and move to that side in array as that has the higher
probabilyt of finding the peek.


if ((mid == 0 || nums[mid] > nums[mid-1]) &&
    (mid == size || nums[mid] > nums[mid+1]))

in above condition, if mid == 0 then next condition will not be checked i.e. nums[mid] > nums[mid-1]
therefore, we will not face issue of accessing element out of bound.

*/


public class peak_element_array {

    public int findPeek(int[] nums){
        int low =0, n = nums.length;
        int high = n -1;
        while(low <=high){
            int mid = low +(high-low)/2;
            //check if the mid element itself is peek
            if((mid ==0 || nums[mid] > nums[mid-1]) &&(mid == n-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if(mid!=0 && nums[mid -1] > nums[mid]){
                    high = mid -1; // if left side is greater then move to left
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    
}
