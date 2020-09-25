package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestTime {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        
        System.out.println("2020/09/25 12:19:09".length());
    }
}
