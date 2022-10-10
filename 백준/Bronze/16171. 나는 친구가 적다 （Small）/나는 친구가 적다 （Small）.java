// 16171 브론즈1 나는 친구가 적다 (small)

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String allStr = br.readLine();
        String str = br.readLine();

        allStr = allStr.replaceAll("[0-9]", "");

        if (allStr.contains(str)) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}
