import java.text.SimpleDateFormat;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal(){
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
        };
        dateFormatThreadLocal.get();
        ThreadLocal<SimpleDateFormat> dateFormatThreadLoca2 = new ThreadLocal(){
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
        };
        System.out.println(dateFormatThreadLoca2.get());

    }
}
