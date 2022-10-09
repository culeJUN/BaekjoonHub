// 20291 실버3 파일 정리

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        String[] splitStr;
        String[] fileType = new String[N];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            splitStr = str.split("\\.");
            fileType[i] = splitStr[1];
        }

        HashMap<String, Integer> typeMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            // 처음 본거
            if (!typeMap.containsKey(fileType[i])) {
                typeMap.put(fileType[i], 1);
            }
            // 전에 본거
            else if (typeMap.containsKey(fileType[i])) {
                typeMap.put(fileType[i], typeMap.get(fileType[i]) + 1);
            }
        }

        List<String> mapList = new ArrayList<>(typeMap.keySet());
        mapList.sort((s1, s2) -> s1.compareTo(s2));

        for (String key : mapList) {
            System.out.println(key + " " + typeMap.get(key));
        }
    }
}