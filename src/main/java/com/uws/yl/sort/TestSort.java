package com.uws.yl.sort;

import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {
        TestSort testSort = new TestSort();
        testSort.testBubbleFalse();
        testSort.testBubble();
        testSort.selectSort();
        testSort.insertSort();
        testSort.shellSort();

    }

    /**
     * 1、冒泡排序  假的
     *
     *     先拿第1第2个数比较，谁大谁后面，接着第2个跟第3个，还是谁大谁后面，继续第3第4，第4第5。。。这样进行了一轮之后，
     *     你是不是可以很肯定，最后的那个数一定是最大的？接下来混乱的序列就少了一位了对吧？就继续剩下的序列继续上面的一轮。
     *     而你仔细想一想这个过程，12，    23，    34，...有没有种演唱会现场一波波人浪冒出来的感觉？
     *     嗯，没有错，这就是冒泡，像一块软绵绵的地毯，里面有一颗玻璃珠在滚动，滚着滚着这个地毯就有序了。= =嗯，这就是冒泡排序。
     */
    public void testBubbleFalse(){
        int[] arr = {1, 2, 32, 23, 321, 45, 8, 90, 227, 99};
        int temp ;
        for(int i = 0 ; i < arr.length-1; i++){
            for (int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    /**
     * 这个才是标准的冒泡排序
     */
    public void testBubble(){
        int[] arr = {1, 2, 32, 23, 321, 45, 8, 90, 227, 99};
        int temp ;
        for(int i =1 ; i < arr.length; i++){
            for (int j = 0;j<arr.length - i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                //System.out.println(Arrays.toString(arr));
            }
           // System.out.println(Arrays.toString(arr)+"==========");
        }
    }


    /**
     * 2 选择排序
     *
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
     * 以此类推，直到所有元素均排序完毕。
     */
    public void selectSort(){
        int[] arr = {1, 2, 32, 23, 321, 45, 8, 90, 227, 99};
        int temp;

        for(int i = 0 ;  i < arr.length;i++){
            int k = i;
            for(int j = i+1; j< arr.length ; j++){
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
       // System.out.println(Arrays.toString(arr));

        /*for(int i = 0 ; i < arr.length;i++){
            int k = i;
            for(int j = arr.length -1; j >i; j--){
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }*/
    }

    /**
     * 3 插入排序
     *
     *       从第一个元素开始，该元素可以认为已经被排序
     *       取出下一个元素，在已经排序的元素序列中从后向前扫描
     *       如果该元素（已排序）大于新元素，将该元素移到下一位置
     *       重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     *       将新元素插入到该位置中
     *       重复步骤2
     */
    public void  insertSort(){
        int[] arr = {1, 2, 32, 23, 321, 45, 8, 90, 227, 99};
        int temp ;
        int j ;
        for(int i = 0 ; i < arr.length ; i++){
            temp = arr[i];
            //假如temp比前面的值小，则将前面的值后移
            for(j = i ; j > 0 && temp < arr[j-1] ; j --){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    /**希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强
     * 版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     *实现数组从大到小排
     */
    public void shellSort(){
        int[] arr = {1, 2, 32, 23, 321, 45, 8, 90, 227, 99};
        for (int increment=arr.length/2;increment>0;increment/=2){
            for (int i = increment;i<arr.length;i++){
                for (int j =i;j>=increment;j-=increment){
                    if (arr[j]<arr[j-increment]){
                        int temp=arr[j-increment];
                        arr[j-increment]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}