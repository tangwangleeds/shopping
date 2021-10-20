package com.example.test;

import java.util.*;

public class TestList {


    class ListNode{
        public int val ; // 节点的保存的内容
        public ListNode next = null;
        public ListNode(int val)
        {
            this.val = val;
        }
    }





    public  void test1(){
        List<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        int max= list.size();
        Integer []data =new Integer[max];
        int j=0;
        for (int i=max-1;i>=0;i--){
            data[j]=list.get(i);
            j++;
        }
        System.out.println(list);

        System.out.println(data[0]+","+data[1]+","+data[2]);
    }


    public  static List<Integer> test2(int n,int k){
        List<Integer> list=new LinkedList<Integer>();

        if(n<k){
            return list;
        }
        for(int i=0;i<n;i++){
            list.add(i);
        }

        return  list.subList(k-1,n-1);

    }


    /**
     * 反转链表的2个方法 一个是使用临时值替换  一个倒叙插入
     * @param n
     * @return
     */
    public  static List<Integer> test3(int n){
        List<Integer> list=new LinkedList<Integer>();
        List<Integer> list1=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
        }

        int k=n;
        for(int i=0;i<n;i++){
            list1.add(k);
            k--;
        }

        return  list1;

    }


    /**
     * list.indexOf(value):获取下标
     *   通过临时的值
     * @return
     */
    public  static List<Integer> test4(int n){
        List<Integer> list=new LinkedList<Integer>();
        List<Integer> list1=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
        }

        int temp=0;

        for (int k=0;k<n/2;k++){
            temp= list.get(k);
            int end=n-k-1;
            list.set(k,list.get(end));
            list.set(end,temp);
        }

        System.out.println(list);
        return  list1;

    }



    /**
     * list.indexOf(value):获取下标
     *   通过临时的值
     * @return
     */
    public  static List<Integer> test5(){
        List<Integer> list2=new LinkedList<Integer>();

        List<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(-1);
        list.add(3);
        list.add(4);
        List<Integer> list1=new LinkedList<Integer>();
        list1.add(2);
        list1.add(-2);
        list1.add(33);
        list1.add(40);

       int count=  list.size();
        int count1=  list1.size();
        int  sum=count;
        if(count1>sum){
            sum=count1;
        }

        int temp=0;

       for (int k=0;k<sum;k++){
           int a=0;
           if(k<=count){
                a=list.get(k);
           }
             int b=list1.get(k);

       }
        return  list1;

    }


    //链表反转
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        if(head == null){
            return null;
        }
        while(cur != null) {
            ListNode tem = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tem;
        }
        return prev;
    }




    public  static List<Integer> test6(int n){
        List<Integer> list=new LinkedList<Integer>();
        List<Integer> list1=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
            list.add(i);
        }

        Set<Integer> s=new HashSet<Integer>();
        for (int i=0;i<n;i++){
            s.add(i);
        }

        Iterator iterator= s.iterator();
        list.clear();
        while (iterator.hasNext()){
            Integer a=(Integer)iterator.next();
            list.add(a);
        }


        System.out.println(list);
        return  list1;

    }





    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            System.out.println("mid:"+mid);
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }



    public static boolean  dance(String  val){

        List<String>   list= new LinkedList<String>();
        list.add("I");
        list.add("love");
        list.add("byte");
        list.add("bytedance");
        int count=list.size()-1;
        for (int i=count;i>=0;i--){
            String  a=list.get(i);
            if ( val.contains(a)){
                val= val.replaceAll(a,"");
            }

        }


        System.out.println("----------------"+val);
        if("".equals(val)){
            return  true;
        }
        return  false;

    }


    public static void main(String[] args) {


        System.out.println(dance("loveIlove"));
        System.out.println(dance("byteabytedance"));
        System.out.println(dance("loveIbytedance"));
        System.out.println(dance("lovealove"));
        System.out.println(dance("lovedance"));
        System.out.println(dance("bytedancebytedancedancebyted"));

        //System.out.println(test2(10,11));
        //System.out.println(test3(10));

        //test4(10);
        //test5();
        //test6(5);

       // int []nums={2,3,4,5,6,9,10,11,12,22,34,55,65};
        //System.out.println("索引值："+binarySearch(nums,2)); ;

    }

}
