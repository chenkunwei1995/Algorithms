package JavaCoreTech.com.java.stream.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StreamDemo01 {
    /**
     * Stream 创建流
     * filter转换流
     * count结束六，执行队形惰性操作，得到最后结果
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String contents
                =new String(Files.readAllBytes(
                Paths.get("alice.txt")
        ), StandardCharsets.UTF_8);
        List<String> words= Arrays.asList(contents.split("\\PL+"));
        long count=0;
        for(String w:words){
            if(w.length()>12)
                count++;
        }
        //or
        long count2 =words.stream().filter(w->w.length()>12).count();

        //or double thread
        long count3=words.parallelStream()
                .filter((w->w.length()>12)).count();
    }
}
