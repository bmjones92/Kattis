import java.io.IOException;

/**
 * Solution to the "Hissing Microphone" problem on Kattis.
 * @author Brendan Jones
 */
public class HissingMicrophone {
    
    public static void main(String[] args) throws IOException {
        var lastCh = -1;
        var ch = 0;
        while ((ch = System.in.read()) != -1) {
            if (ch == 's' && lastCh == 's') {
                System.out.println("hiss");
                return;
            }
            lastCh = ch;
        }
        System.out.println("no hiss");
    }

}

