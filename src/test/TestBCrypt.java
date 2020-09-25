package test;

import java.util.Scanner;
import security.BCrypt;

public class TestBCrypt {

    public static void main(String[] args) {
//        String currentPassword = "dangquoclai";
//
//        currentPassword = BCrypt.hashpw(currentPassword, BCrypt.gensalt(12));
//        System.out.println("BCrypt hash: " + currentPassword);
//
//        Scanner in = new Scanner(System.in);
//        System.out.print("Nhập mật khẩu mới: ");
//        String newPassword = in.nextLine();
//
//        if (BCrypt.checkpw(newPassword, currentPassword)) {
//            System.out.println("Mật khẩu đúng");
//        } else {
//            System.out.println("Mật khẩu sai");
//        }
//        
//        
        String databasePassword = "$2a$12$YSd770NiAqwgIQ6ENIahXeEFNOaBmSgkjmo5BBBH5Yo5TNTyc9lsK"; // dangquoclai
        Scanner in = new Scanner(System.in);
        String thisPassword= "";
        while(true){
            System.out.print("Nhập mật khẩu: ");
            thisPassword = in.nextLine();
            
            if (BCrypt.checkpw(thisPassword, databasePassword))
            {
                System.out.println("Mật khẩu đúng");
                return;
            }
            System.out.println("Mật khẩu sai");
        }
//        String password = "abc";
//        while(true){
//            System.out.print("Nhập mật khẩu: ");
//            password = in.nextLine();
//            if(password.equals("exit"))
//                return;
//            
//            System.out.println("password hash: "+BCrypt.hashpw(password, BCrypt.gensalt(12)));
//            
//        }
//        String str2 = "$2a$12$udR3LVfK70yk30mmrYFjs.BHCKfQOZZSVV4pJWyj/E1DjanVQocYm";
//        System.out.println("Length: "+(str2.length()));
        
    }
}
