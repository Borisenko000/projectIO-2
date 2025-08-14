package edu.polina;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        Path path1 = Paths.get("C:\\Users\\Professional\\Documents\\task\\copytask.txt");
        Path path2 = Paths.get("C:\\Users\\Professional\\Documents\\task\\result.txt");
        System.out.println(Files.exists(path1));
        try (BufferedReader reader = Files.newBufferedReader(path1);
             BufferedWriter writer = Files.newBufferedWriter(path2, StandardCharsets.UTF_8)) {
            if (!(Files.exists(path1))) {
                System.out.println("файл не существует!");
                throw new FileNotFoundException();
            }
            else {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!(line.isEmpty())) {
                        sum++;
                    }
                }
            }
            writer.write(String.valueOf(sum));
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println(sum);
    }
}