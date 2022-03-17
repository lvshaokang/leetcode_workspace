//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 双指针 计数 排序 👍 32 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 数对 -> 指针
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) return results;
        Arrays.sort(nums); // 排序
        int i = 0;
        int j = nums.length - 1;
        while (i < j) { // i j 相加,等于target,记录数对
            if (nums[i] + nums[j] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(nums[j]);
                results.add(result);
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) { // i j 相加,小于target,因为是有序的,为了使值变大,i指针要后移
                i++;
            } else {
                j--;
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
