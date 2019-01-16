import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.IOException;
import java.io.InputStream;

public class MathLib {
    private static String LIB_NAME = "math";
    static {
        InputStream is = MathLib.class.getClassLoader().getResourceAsStream(System.mapLibraryName(LIB_NAME));
        try {
            Loader.loadFromStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Lib LoadMathLib(){
        MathLib.Lib math = Native.load(LIB_NAME, MathLib.Lib.class);
        return math;
    }
    public interface Lib extends Library {
        long Multiply(long x, long y);

        String Hello(String name);
    }
}
