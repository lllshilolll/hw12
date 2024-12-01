package org.example;


import lombok.SneakyThrows;

import java.io.*;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/problemset/problem/1324/C
     */
    @SneakyThrows
    public void frogSteps(InputStream in, OutputStream out) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            int size = Integer.parseInt(reader.readLine());
            for (int k = 0; k < size; k++) {
                int count = 0;
                int ans = 0;
                boolean L = true;
                boolean R = true;
                char[] destination = reader.readLine().toCharArray();
                char[] arr = new char[destination.length + 2];
                for (int i = 0; i < destination.length; i++) {
                    if (destination[i] == 'R') {
                        L = false;
                        arr[i + 1] = 1;
                    } else R = false;
                }
                if (L) {
                    writer.write(destination.length + 1 + "\n");
                    continue;
                }
                if (R) {
                    writer.write(1 + "\n");
                    continue;
                }
                for (int i = 1; i <= destination.length; i++) {
                    if (arr[i] == 0) count++;
                    else {
                        ans = Math.max(count, ans);
                        count = 0;
                    }
                    if (i == destination.length) {
                        ans = Math.max(count, ans);
                    }
                }
                writer.write(ans + 1 + "\n");
            }
            writer.flush();
        }
    }
}
