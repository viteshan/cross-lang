
public class JnaMath {

    public static void main(String[] args) {
        MathLib.Lib math = MathLib.LoadMathLib();
        System.out.println(math.Multiply(2, 7));
        System.out.println(math.Hello("viteshan"));
    }
}
