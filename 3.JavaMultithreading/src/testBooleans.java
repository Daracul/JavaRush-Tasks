import java.util.Date;

/**
 * Created by amalakhov on 14.04.2017.
 */
public class testBooleans {
    String string;

    public testBooleans(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        testBooleans that = (testBooleans) o;

        if  (string != null ? !string.equals(that.string) : that.string != null) return false;
        boolean c ;
        if (string!=null){
            System.out.println("c="+(c=!string.equals(that.string)));
        }
        else {
            System.out.println("c="+(c=that.string!=null));

        }
        if (c) return false;

        return true;

    }

    @Override
    public int hashCode() {
        int result = string != null ? string.hashCode() : 0;
        return result;
    }

    public static void main(String[] args) {
        testBooleans test = new testBooleans("2");
        System.out.println(new testBooleans("1").equals(test));

    }
}
