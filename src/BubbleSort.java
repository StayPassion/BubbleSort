
public class BubbleSort {

    public static void bubblySort_1(int []num){
        for (int i=0;i<num.length;i++){//表示遍历次数减1
            for (int j=1;j<num.length-i;j++){//依次与后面的相比较
                if (num[j-1]>num[j]){//如果前面的比后面的大，交换变量
                    int temp;//设置中间交换变量
                    temp=num[j-1];
                    num[j-1]=num[j];
                    num[j]=temp;
                }
            }
        }
    }

    public static void bubbleSort_2(int [] num){
        int n=num.length;
        boolean flag = true;//发生了交换就为true
        while (flag){
            flag=false;//每次开始排序前，重置
            for(int j=1; j<n; j++){
                if(num[j-1] > num[j]){
                    int temp;
                    temp = num[j-1];
                    num[j-1] = num[j];
                    num[j]=temp;

                    //表示交换过数据;
                    flag = true;
                }
            }
            n--;//减少一次排序
        }
    }

    public static void bubbleSort_3(int [] num){
        int k;
        int flag = num.length ;//flag来记录最后交换的位置，也就是排序的尾边界

        while (flag > 0){//排序未结束标志
            k = flag; //k 来记录遍历的尾边界
            flag = 0;

            for(int j=1; j<k; j++){
                if(num[j-1] > num[j]){
                    int temp;
                    temp = num[j-1];
                    num[j-1] = num[j];
                    num[j]=temp;

                    flag = j;//记录最新的尾边界.
                }
            }
        }
    }


    public static void bubbleSort_4(int[] num) {
        int len = num.length;
        int left = 0, right = len -1;

        while (left<right){
            //最坏的情况下也至少为1个数
            int flagLeft = left + 1;
            int flagRight = right - 1;

            //从左往右找出最大的数
            for (int j = left;j<right;j++){
                if (num[j]>num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;

                    //记录下最后交换的位置，flagRight后面的数表示已经完成排序（也有可能是最后的一个数）
                    // 右排序完成一次，后面的左排序只需要排这个flagRight之前的
                    //flagRight之后的数已经完成好了排序
                    flagRight = j;
                }
            }
            right = flagRight;


            for (int j = right;j>left;j--) {
                if (num[j] < num[j - 1]) {
                    int temp = num[j-1];
                    num[j - 1] = num[j];
                    num[j] = temp;

                    //记录下最后交换的位置，flagLight前面的数表示已经完成排序（也有可能是第一个数）
                    // 左排序完成一次，下一次的排序只需要从flagLight之后开始排序
                    //flagLight之后的数已经完成好了排序
                    flagLeft = j;
                }
            }

            left = flagLeft;
        }

    }

    public static void main(String[] args) {
        int [] num = new int[10];
        for (int i = 0;i< 10;i++){
            num[i] = (int)(Math.random()*100);
        }
        bubblySort_1(num);
        //bubbleSort_2(num);
        //bubbleSort_3(num);
        //bubbleSort_4(num);
        for(int i:num){
            System.out.print(i+" ");
        }
    }
}