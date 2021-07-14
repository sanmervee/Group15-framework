public class Hello {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("Hello from Rau!");
        System.out.println("let's do it!");
        System.out.println("wooden spoon");
        System.out.println("Hi from Kady");
        System.out.println("hello from suheyla");
        swapNum(10,20);
    }

    /**
     * Interview Question - Swapping number with method
     * @param a
     * @param b
     */
    public static void swapNum(int a, int b){
        a = a - b;   //a=-10
        b = a + b;   // b=10
        a = b - a; // a=20
        System.out.print("a = " + a+ "b = " + b);
    }


}
