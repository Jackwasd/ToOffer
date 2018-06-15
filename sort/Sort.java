import java.util.Random;

public class Sort {

    private void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(int i, int j){
        if(i > j){
            return true;
        }
        return false;
    }

    /**
     * 冒泡排序,两两比较相邻的记录，反序则交换，直到没有反序，这是基本的
     * 30614
     * @param array
     */
    public void sortBubble(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(less(array[i], array[j])){
                    exch(array, i, j);
                }
            }
        }
    }

    /**
     * 改进的冒泡排序：真正的冒泡排序<是一种交换排序>
     * 思想就是从后向前进行两两的比较，较小的数会浮上来，就像冒泡一样
     * 这里有一个改进，就是加上一个标志，如果在某一次循环中没有交换，
     * 说明已经排好了，后面的交换也无需进行了
     * 时间复杂度分析：最好的情况，排序表本身是有序的，需要比较n-1次，时间复杂度O(n)
     *               最坏的情况，逆序，需要1+2+3+4+...+(n-1)=n(n-1)/2,时间复杂度O(n*n)
     * 18577
     * @param array
     */
    public void sortBubbleUpdate(int[] array){
        boolean flag = true;
        for(int i = 0; i < array.length && flag; i++){
            flag = false;
            for(int j = array.length-1; j > i; j--){
                if(less(array[j-1], array[j])){
                    exch(array, j-1, j);
                    flag = true;
                }
            }
        }
    }

    /**
     * 简单选择排序
     * 基本思想：先选定一个数的下标为min，然后逐个对后面的数与其相比较，小的话就赋值给min，并不交换数
     *          知道这一轮比较完成才交换，也就是一轮最多交换一次
     * 时间复杂度：最好的情况顺序，交换0次，最差的是逆序交换n-1次，但是比较的次数永远是1+2+3+4+...+(n-1)=n(n-1)/2
     *            所以总的时间复杂度是交换加上比较的和，也就是o(n*n)
     * 26537
     * @param array
     */
    public void sortSimpleSelect(int[] array){
        for(int i = 0; i < array.length-1; i++){
            int min = i;
            for(int j = i+1; j < array.length; j++){
                if(less(array[min], array[j])){
                    min = j;
                }
            }
            if(min != i){
                exch(array, min, i);
            }
        }
    }

    /**
     * 直接插入排序
     * 思想：将一个记录插入到已经排好序的有序表中，得到一个新的，记录数加一的有序表
     * 要点：每次都需要设置一个哨兵，也就是准备插入的那个数,然后依次对哨兵值和插入数前面的有序表对比
     * 有序表中的数大于哨兵的话就后移一位，直到数字比那个哨兵小或者到0的位置，这时候会空出一个位置，把哨兵插进去
     * 时间复杂度分析：最好的情况就是顺序排列的，此时比较了n-1次，为O(n),最差的情况为逆序，比较和移动大概是n*n/4，为O(n*n)
     * 1107
     * @param array
     */
    public void sortDirectInsert(int[] array){
        int j = 0;
        for(int i = 1; i < array.length; i++){
            if(less(array[i-1], array[i])){
                int temp = array[i];
                for(j = i-1; j>=0 && array[j] > temp; j--){
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
    }


    /**
     * 希尔排序(一种改进的插入排序)
     * 思想：将间隔为h的两个数据排成有序的，调整h的值，使得整体有序，最后再排列一下
     * 这里的话直接交换即可，而直接插入设置哨兵可以减少交换的次数
     * 时间复杂度：O(n的二分之三次方)
     * 17
     * @param array
     */
    public void sortShell(int[] array){
        int n = array.length;
        int h = 1;
        while(h < n/3){
            h = 3*h + 1;
        }
        while(h >= 1){
            for(int i = h; i < n; i++){
                for(int j = i; j >= h && less(array[j-h], array[j]); j-=h){
                    exch(array, j, j-h);
                }
            }
            h = h/3;
        }
    }

    /**
     * 希尔排序，哨兵法
     * 27
     * @param array
     */
    public void sortShellNew(int[] array){
        int n = array.length;
        int h = 1;
        int j = 0;
        while(h < n/3){
            h = 3*h + 1;
        }
        while(h >= 1){
            for(int i = h; i < n; i++){
                if(less(array[i-h], array[i])){
                    int temp = array[i];                //设置哨兵
                    for(j = i-h; j >=0 && less(array[j], temp); j-=h){
                        array[j+h] = array[j];
                    }
                    array[j+h] = temp;
                }
            }
            h = h/3;
        }
    }

    /**
     * 归并排序
     * 分治思想：将两个或两个以上的有序表合成一个新的有序表
     * 缺点是所需的辅助空间和排序的数组的长度N成正比
     * 算法的时间复杂度是:nlogn
     * 是一个自顶向下的1820
     * @param array
     */
    public void sortMerge(int[] array){
        temp = new int[array.length];
        sort(array, 0, array.length-1);
    }

    private void sort(int[] a, int lo, int hi){
        if(lo>=hi){return;}
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    private int[] temp;
    private void merge(int[] array, int lo, int mid, int hi){
        //将array[lo..hi]复制到temp[lo..hi]
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++){
            temp[k] = array[k];
        }
        //将两者归并
        for(int k = lo; k <= hi; k++){
            if(i > mid){
                array[k] = temp[j++];
            }else if(j > hi){
                array[k] = temp[i++];
            }else if(less(temp[i], temp[j])){
                array[k] = temp[j++];
            }else{
                array[k] = temp[i++];
            }
        }
    }

    public void sortMergeEndToUp(int[] array){
        int n = array.length;
        temp = new int[n];
        for(int size = 1; size < n; size *= 2){
            for(int lo = 0; lo < n - size; lo += (size+size)){
                merge(array, lo, lo+size-1, Math.min(lo+size+size-1, n-1));//意思就是当最后的索引超过数组的界限的时候，选择小的
            }
        }
    }

    /**
     * 快速排序
     * 原理：也是一种分治的排序，把数组分成两个子数组，将两部分独立的排序
     * 当两个子数组都有序的时候，整个数组也就有序了
     * 14641
     * @param array
     */
    public void sortQuick(int[] array){
        sortQ(array, 0, array.length-1);
    }
    private void sortQ(int[] a, int lo, int hi){
        if(hi <= lo){return;}
        int temp = partition(a, lo, hi);
        sortQ(a, lo, temp-1);
        sortQ(a, temp+1, hi);
    }
    private int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;

        int temp = a[lo];

        while(true){
            while(less(temp, a[++i])){
                if (i == hi){break;}
            }
            while(less(a[--j], temp)){
                if(j == lo){break;}
            }
            if(i >= j){break;}
            exch(a, i, j);
        }
        return j;
    }

    public void sortThree(int[] a, int lo, int hi){
        if(hi <= lo)return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int temp = a[lo];
        while(i <= gt){
            if(temp > a[i]){
                exch(a, lt++, i++);
            }else if(temp < a[i]){
                exch(a, i, gt--);
            }else{
                i++;
            }
        }
        sortQ(a, lo, lt-1);
        sortQ(a, gt+1, hi);

    }
    public static void main(String[] args) {
        Sort sort = new Sort();
        Random random = new Random();
        int[] array = new int[100000000];
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(array.length);
        }
        long startTime = System.currentTimeMillis();
        sort.sortThree(array, 0, array.length-1);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("时间是" + (endTime - startTime));
    }
}
