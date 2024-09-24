
import java.util.ArrayList;


public class Test {

    public static void main(String[] args) {
        // Create a User object using the default constructor
        User defaultUser = new User();
        User user1 = new User("John Doe", 55);
        User user2 = new User("Jane Doe", 70, 1.75f, 175f);

        // Add users to array
        ArrayList<User> users = new ArrayList<>();
        users.add(defaultUser);
        users.add(user1);
        users.add(user2);
        
        // Print user details
        System.out.println("\nUser Details:\n------------------------------------------------------------------------------------------");
        for (User user : users) {
            System.out.println(user.toString());
        }

        // Print user's name, BMI and obesisty level
        System.out.println("\nName, BMI and obesisty level of users:\n------------------------------------------------------------------------------------------");
        for (User user : users) {
            
            System.out.println("[Name: " + user.getName() + "] [BMI: " + user.calculateBMI() + "] [ObesityLevel: " + user.determineObesityLevel() + "]"); 
        }

        // Print name and obesity level of users that don't have Healthy classification
        System.out.println("\nName and obesity level of users that don't have Healthy classification:\n------------------------------------------------------------------------------------------");
        for (User user : users) {
            if (!user.isHealthy()) {
                System.out.println("[Name: " + user.getName() + "]  [ObesityLevel: " + user.determineObesityLevel() + "]");
            }
        }

        // Check if user1 is younger than user2
        System.out.println("\nCheck younger user:\n------------------------------------------------------------------------------------------");
        int youngerUser = user1.checkYounger(user2);
        switch (youngerUser) {
            case 1 -> System.out.println(user1.getName() + " is younger than " + user2.getName());
            case 0 -> System.out.println(user2.getName() + " is younger than " + user1.getName());
            default -> System.out.println(user1.getName() + " is the same age as " + user2.getName());
        }


        // Search user
        String userName = "Jane Doe";
        int k = 0;
        while (k < users.size() && !users.get(k).getName().equalsIgnoreCase(userName)) {
            k++;
        }

        System.out.println("\nSearch user by name:\n------------------------------------------------------------------------------------------");
        if(k >= users.size()) {
            System.out.println("User not found!");
        } else {
            System.out.println(users.get(k).toString());
        }
       
    }
}