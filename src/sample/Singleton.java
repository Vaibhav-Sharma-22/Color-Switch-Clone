package sample;

public class Singleton {
    private static Singleton obj = new Singleton();
    private Singleton(){

    }
    static Singleton getInstance() {
        return obj;
    }
}
