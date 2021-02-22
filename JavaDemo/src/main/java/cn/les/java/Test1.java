package cn.les.java;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2021/1/16 14:52
 */


public  class Test1 {



    public  static  void main(String[] args) {
        short o = 127;
        o += 1;
        //o = (short)(o+1);
        System.out.println(o );

        int di = 1;
        di *= 0.1;
        di++;
        System.out.println(di ); //1
        int i3 = 2_000_000_000; // 加下划线更容易识别
        int i4 = 0xff0000; // 十六进制表示的16711680
        int i5 = 0b1000000000; // 二进制表示的512
        long l = 9000000000000000000L; // long型的结尾需要加L
        System.out.println(l);


        int[] oo1 = new int[3];
        oo1[0] = 1;
        int[] oo2 = new int[]{1,2,3};
        int[] oo3 = {1};
        oo3[0] = 4;
        System.out.println(oo3[0]);
        String str = new String();
        str = "ppp";
        String s  = "dd";

        String [] ss [] = {{"dd"},{"212","323"},{"3"}};


        int i = (int)(Math.random() * (99-10+1) +10);
        System.out.println(Math.random()+"---");
    }
}
