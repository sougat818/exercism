import static java.util.Objects.isNull;

public class Twofer {
    public String twofer(String name) {
        name = isNull(name) ? "you" : name;
        return "One for " + name + ", one for me.";
    }
}
