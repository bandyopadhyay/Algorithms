import java.io.File;

public class JLS {

    public static void main(String[] args) {
        File dir = new File("/Users/bandyopadh");
        String childs[] = dir.list();
        for(String child: childs){
            System.out.println(child);
        }
    }
}
