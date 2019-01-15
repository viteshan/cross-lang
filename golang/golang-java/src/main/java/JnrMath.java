import jnr.ffi.LibraryLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class JnrMath {

    private static final MathLib MATH_LIB;


    private final static void  loadFromStream( InputStream is) throws IOException {
        FileOutputStream os = null;
        File dstFile;
        try {
            dstFile = File.createTempFile("jni", "." + "native");
        } catch (IOException ex) {
            throw new IOException("Failed to create temporary file:." + "dylib");
        }
        try {
            dstFile.deleteOnExit();
            os = new FileOutputStream(dstFile);
            ReadableByteChannel srcChannel = Channels.newChannel(is);

            for (long pos = 0; is.available() > 0; ) {
                pos += os.getChannel().transferFrom(srcChannel, pos, Math.max(4096, is.available()));
            }

            os.close();
            os = null;

            System.load(dstFile.getAbsolutePath());
            dstFile.delete();
        } catch (IOException ex) {
            throw new UnsatisfiedLinkError(ex.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            is.close();
        }
    }

    static {
        String mathLib = "math";
        InputStream is = MathLib.class.getClassLoader().getResourceAsStream(System.mapLibraryName(mathLib));
        try {
            loadFromStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MATH_LIB = LibraryLoader.create(MathLib.class).library(mathLib).load();
    }
    public static void main(String[] args) {
        System.out.println(MATH_LIB.Multiply(2, 4));
    }
}
