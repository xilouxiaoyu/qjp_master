package cn.itcast.gjp.service;

public class search {



    public static int specialBinarySearch(int [] a,int start,int end,int target) {  //a数组为先递增后递减

        if(start <= end) {
            int mid = start + (end - start) / 2;
            if(a[mid] == target)
                return mid;
            int status = -1;
            status = checkStatus(a,start,end);  //判断中位数是以上哪种情况
            if(a[mid] > target) {
                if(status == 3) {
                    // 在a[mid] > target中，如果是第三种情况，
                    //只需要将左半边正常二分查找（升序）,右半边正常二分查找（降序）即可
                    int index = -1;
                    index = binarySearchAscend(a,start,mid-1,target); //二分查找（升序）
                    if(index != -1)
                        return index;
                    return binarySearchDescend(a,mid+1,end,target);//二分查找（降序）
                }
                else if(status == 2) {
                    //在a[mid] > target中，如果是第二种情况,
                    //只需要将左半边特殊二分查找,右半边正常二分查找（降序）即可
                    int index = -1;
                    index = specialBinarySearch(a,start,mid-1,target);
                    if(index != -1)
                        return index;
                    return binarySearchDescend(a,mid+1,end,target);
                }
                else if(status == 1) {
                    //在a[mid] > target中，如果是第一种情况，
                    //只需要将左半边正常二分查找（升序）,右半边特殊二分查找即可
                    int index = -1;
                    index = binarySearchAscend(a,start,mid-1,target);
                    if(index != -1)
                        return index;
                    return specialBinarySearch(a,mid+1,end,target);
                }
                else
                    return -1;
            }
            else {
                if(status == 3)
                    //在a[mid] < target中，如果是第三种情况，
                    //要查找的元素比最大值还要大，说明该数组没有要查找的元素，return -1即可
                    return -1;
                else if(status == 2)
                    //在a[mid] < target中，如果是第二种情况
                    //只需要将左半边特殊二分查找即可
                    return specialBinarySearch(a,start,mid-1,target);
                else if(status == 1)
                    //在a[mid] < target中，如果是第一种情况
                    //只需要将右半边特殊二分查找即可
                    return specialBinarySearch(a,mid+1,end,target);
                else
                    return -1;
            }
        }
        return -1;
    }



    //判断中位数情况
    public static int checkStatus(int [] a,int start,int end) {
        int index = start + (end - start) / 2;
        if(a[index-1] < a[index] && a[index] > a[index+1])
            return 3;
        else if(a[index-1] > a[index] && a[index] > a[index+1])
            return 2;
        else if(a[index-1] < a[index] && a[index] <a[index+1])
            return 1;
        else
            return -1;
    }


    //二分查找（升序）
    public static int binarySearchAscend(int [] a,int start,int end,int target) {
        if(start <= end) {
            int mid = start + (end - start) / 2;
            if(a[mid] == target)
                return mid;
            else if(a[mid] > target)
                return binarySearchAscend(a,start,mid-1,target);
            return binarySearchAscend(a,mid+1,end,target);
        }
        return -1;
    }


    //二分查找降序
    public static int binarySearchDescend(int [] a,int start,int end,int target) {
        if(start <= end) {
            int mid = start + (end - start) / 2;
            if(a[mid] == target)
                return mid;
            else if(a[mid] > target)
                return binarySearchDescend(a,mid+1,end,target);
            return binarySearchDescend(a,start,mid-1,target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,4,7,9};

        System.out.println(specialBinarySearch(a, 0, 3, 4));

    }
}
