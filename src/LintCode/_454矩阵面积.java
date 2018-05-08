package LintCode;

/**
 * https://www.lintcode.com/problem/rectangle-area
 * 454. 矩阵面积
 * 描述
 * 实现一个矩阵类Rectangle，包含如下的一些成员变量与函数：
 * 两个共有的成员变量 width 和 height 分别代表宽度和高度。
 * 一个构造函数，接受2个参数 width 和 height 来设定矩阵的宽度和高度。
 * 一个成员函数 getArea，返回这个矩阵的面积。
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * Java:
 * Rectangle rec = new Rectangle(3, 4);
 * rec.getArea(); // should get 12
 */
public class _454矩阵面积 {

    public class Rectangle {
        /*
         * Define two public attributes width and height of type int.
         */
        // write your code here
        int width, height;

        /*
         * Define a constructor which expects two parameters width and height here.
         */
        // write your code here
        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }


        /*
         * Define a public method `getArea` which can calculate the area of the
         * rectangle and return.
         */
        // write your code here
        public long getArea(){
            return width*height;
        }
    }
}
