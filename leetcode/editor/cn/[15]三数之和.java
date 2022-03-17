//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4464 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * a + b + c = 0
     * b + c = -a
     * nums[p] + nums[q] = -nums[i]
     * 重复值跳过计算
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1]) // 避免 a 重复
                continue;
            int p = i + 1;
            int q = n - 1;
            while (p < q) {
                if (p >= i + 2 && nums[p] == nums[p-1]) { // 避免 b 重复
                    p++;
                    continue;
                }
                if (q <= n - 2 && nums[q] == nums[q+1]) { // 避免 c 重复
                    q--;
                    continue;
                }
                int sum = nums[p] + nums[q];
                if (sum + nums[i] == 0) {
                    List<Integer> items = new ArrayList<>();
                    items.add(nums[i]);
                    items.add(nums[p]);
                    items.add(nums[q]);
                    result.add(items);
                    p++;
                    q--;
                } else if (sum < -nums[i]) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
