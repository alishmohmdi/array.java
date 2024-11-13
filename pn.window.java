import java.util.Scanner;

public class pn {

    public static char generate(int r, int i) {
        if (r == 0) {
            return 'P';
        }
        int halfLength = (int) Math.pow(2, r - 1);

        if (i <= halfLength) {
            return generate(r - 1, i);
        } else {
            return generate(r - 1, i - halfLength) == 'P' ? 'N' : 'P';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 

        for (int j = 0; j < n; j++) {
            int r = scanner.nextInt(); 
            int i = scanner.nextInt(); 
            System.out.println(generate(r, i));
        }

        scanner.close();
    }
}

