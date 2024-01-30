import java.util.Scanner;

public class LoginValidation {

    public static boolean validationCheck(String username, String password, int count){
        boolean validation = false;

        if (!username.equals("Admin") && !password.equals("KoolAid")) {
            validation = false;
            System.out.println("The username and password are both incorrect!! You have: " +
                    count + " amounts of tries left.");
        } else if (!username.equals("Admin")) {
            System.out.println("The username is incorrect! You have: " +
                    count + " amounts of tries left.");
            validation = false;
        } else if (!password.equals("KoolAid")) {
            System.out.println("The password is incorrect! You have: " +
                    count + " amounts of tries left.");
            validation = false;
        } else if (username.equals("Admin") && password.equals("KoolAid")) {
            validation = true;
            System.out.println("Successful login attempt!");
        }

        return validation;
    }

    public static void main(String[] args) {
        String username = "Admin";
        String password = "KoolAid";
        boolean validation = false;
        String answer = "yes";
        int count = 9;

        Scanner scanner = new Scanner(System.in);

        while(answer.equalsIgnoreCase("yes") && validation == false && count >= 0){
            try {
                System.out.println("Enter username");
                username = scanner.next();
                System.out.println("Enter password");
                password = scanner.next();

                validation = validationCheck(username, password, count);

                if(!validation) {
                    if(count > 0) {
                        System.out.println("Would you like to try again, yes/no?");
                        answer = scanner.next();
                    }
                    count -= 1;
                }
            }
            catch(Exception e){
                System.out.println("Keyboard malfunctioned!!!");
            }
        }
        if(count <= 0)
            System.out.println("You have reached the maximum amount of tries!!!");
    }
}
