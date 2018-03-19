/**
 * Created by amalakhov on 30.03.2017.
 */
public class newSukaTest {
    public static void main(String[] args) {
        String s="Гавно";
        if (s.length()>8){
            s.substring(0,8);
        }
        else {
            while (!(s.length()==8)){
                s=s+" ";
            }
        }
        System.out.println(s);
    }
} //ahaha
