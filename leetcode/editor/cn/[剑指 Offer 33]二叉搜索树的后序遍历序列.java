//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 421 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * BST的中序遍历结果是有序的(利用root节点值>左子树节点值定位子树)
     *
     * 左子树是BST
     * 右子树是BST
     * root节点值都大于左子树节点值，小于右子树节点值
     *  二叉树是BST
     */
    public boolean verifyPostorder(int[] postorder) {
        return doVerifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean doVerifyPostorder(int[] postorder, int i, int j) {
        if (i >= j) return true;

        // postorder[j]是根节点,先分离出左子树[i, j-1]
        int k = i;
        while (k < j && postorder[k] < postorder[j]) {
            k++;
        }
        // 验证[k, j-1]满足右子树的要求,都大于postorder[j]
        int p = k;
        while (p < j) {
            if (postorder[p] < postorder[j]) {
                return false;
            }
            p++;
        }
        // 递归验证左右子树是否满足BST的要求
        boolean leftValid = doVerifyPostorder(postorder, i, k - 1);
        if (leftValid == false) return false;
        boolean rightValid = doVerifyPostorder(postorder, k, j - 1);
        return rightValid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
