public class HelloWorld {

    public static native String stringFromJNI();

    static {
        try {
            System.load("/mnt/hgfs/raywang/libnative-lib.so");
        } catch (UnsatisfiedLinkError e) {
          System.err.println("Native code library failed to load.\n" + e);
          System.exit(1);
        }
      }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        System.out.println(stringFromJNI());
    }
}
