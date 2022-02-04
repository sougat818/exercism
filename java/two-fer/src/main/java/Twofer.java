import static java.util.Objects.isNull;

public class Twofer {
    public String twofer(String name) {
        if(isNull(name)){
            name = "you";;
        }
        return "One for " + name + ", one for me.";
    }
}
