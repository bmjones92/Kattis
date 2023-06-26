import java.io.IOException;

/**
 * Solution to the "Yin and Yang Stones" problem on Kattis.
 * @author Brendan Jones
 */
public class YinYangStones {

    public static void main(String[] args) throws IOException {
        var numBlack = 0;
        var numWhite = 0;

        int input;
        while ((input = System.in.read()) != -1) {
            if (input == 'W') {
                ++numWhite;
            } else if(input == 'B') {
                ++numBlack;
            }
        }

        System.out.println(numWhite == numBlack ? 1 : 0);

    }

}

