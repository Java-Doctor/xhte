package top.xhte.dsa.array;

/**
 * 稀疏数组
 *
 * @author XHTE
 * @create 2024-04-08 22:31
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个 11*11 的二维数组作为五子棋的棋盘 0 代表没有棋子 1 代表黑棋 2 代表白棋
        int[][] originalArray = new int[11][11];
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;
        System.out.println("====================> 需要保存的二维数组的棋盘");
        for (int[] outArray : originalArray) {
            for (int inArray : outArray) {
                System.out.print("  " + inArray + "  ");
            }
            System.out.println();
        }
        // 二维数组的棋盘保存成稀疏数组
        // 初始化非 0 的个数
        int sum = 0;
        // 遍历原始数组得到非 0 的个数
        for (int[] outArray : originalArray) {
            for (int inArray : outArray) {
                if (inArray != 0) {
                    sum++;
                }
            }
        }
        // 创建初始的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = originalArray.length;
        sparseArray[0][1] = originalArray[0].length;
        sparseArray[0][2] = sum;
        // 初始化不为 0 的数量
        int count = 0;
        // 循环遍历原始数组
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                if (originalArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originalArray[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("====================>  得到稀疏数组");
        // 打印稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
        System.out.println();
        System.out.println("====================> 稀疏数组转换成原始数组");
        // 稀疏数组转换成原始数组
        int[][] newOriginalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            newOriginalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] outArray : newOriginalArray) {
            for (int inArray : outArray) {
                System.out.print("  " + inArray + "  ");
            }
            System.out.println();
        }
    }

}
