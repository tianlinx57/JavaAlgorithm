public class InitialTest {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}, {9,9,9}};
        System.out.println(arr[0]);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
    }
}

class A {
    static { // ⽗类静态代码块
        System.out.print("A");
    }

    public A() { // ⽗类构造器
        System.out.print("a");
    }
}

class B extends A {
    static { // ⼦类静态代码块
        System.out.print("B");
    }

    public B() { // ⼦类构造器
        System.out.print("b");
    }
}