package hello.core.singleton;

public class SingletonService {

    private static final SingletonService SINGLETON_SERVICE = new SingletonService();

    public static SingletonService getInstance() {
        return SINGLETON_SERVICE;
    }

    private SingletonService() {
    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
