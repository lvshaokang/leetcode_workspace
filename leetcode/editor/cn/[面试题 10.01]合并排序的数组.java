//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 排序 👍 135 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 如何遍历两个数组比大小? 用while循环
    /*public void merge(int[] A, int m, int[] B, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] c = new int[m + n];
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                c[k++] = A[i++];
            } else {
                c[k++] = B[j++];
            }
        }
        while (i < m) { // i 剩余
            c[k++] = A[i++];
        }
        while (j < n) {
            c[k++] = B[j++];
        }
        for (int p = 0; p < k; p++) {
            A[p] = c[p];
        }
    }*/

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) { // 末尾放大的
                A[k--] = B[j];
                j--;
            } else { // A[i] > B[j]
                A[k--] = A[i];
                i--;
            }
        }
        while (i >= 0) { // i 剩余
            A[k--] = A[i];
            i--;
        }
        while (j >= 0) { // j 剩余
            A[k--] = B[j];
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
