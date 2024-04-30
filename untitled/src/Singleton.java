public class Singleton {

    private String test;
    private Singleton() {}

    private static class SingletonInstance {//私有静态内部类
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
    public String getTest(){return test;}
    public String setTest(String s){
        test=s;
        return test;
    }
}