package testpac;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name FinalTest
 * @description
 * @date 2018-10-08
 */
public class FinalTest {

    private Integer a;

    private FinalTest() {
        this.a = 1;
    }

    static class SingletonHolder {
        private static final FinalTest instance = new FinalTest();
    }

    public static FinalTest getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        FinalTest instance = FinalTest.getInstance();
        System.out.println(instance.a);
        instance.a = 2;
        System.out.println(instance.a);
        System.out.println(instance);
        System.out.println(FinalTest.getInstance());
    }

}
