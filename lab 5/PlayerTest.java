import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Player {
    String name;
    int age;

    Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void play(String sport) {
        System.out.println(name + " is playing " + sport + ".");
    }

    void train(int hours) {
        System.out.println(name + " is training for " + hours + " hours.");
    }
}

class Cricket_Player extends Player {
    String position;

    Cricket_Player(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }
}

class Football_Player extends Player {
    String position;

    Football_Player(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }
}

class Hockey_Player extends Player {
    String position;

    Hockey_Player(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }
}

public class PlayerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Input Player Details
        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Choose a sport
        System.out.print("Enter Sport (Cricket/Football/Hockey): ");
        String sport = sc.nextLine();

        // Enter Position
        System.out.print("Enter Position: ");
        String position = sc.nextLine();

        // Creating the appropriate player object
        Player player;
        if (sport.equalsIgnoreCase("Cricket")) {
            player = new Cricket_Player(name, age, position);
        } else if (sport.equalsIgnoreCase("Football")) {
            player = new Football_Player(name, age, position);
        } else if (sport.equalsIgnoreCase("Hockey")) {
            player = new Hockey_Player(name, age, position);
        } else {
            System.out.println("Invalid sport. Exiting program.");
            sc.close();
            return;
        }

        // Play the chosen sport
        player.play(sport);

        // Training details
        System.out.print("Enter number of training hours: ");
        int hours = sc.nextInt();
        player.train(hours);

        // Display all input data with timestamp
        System.out.println("\n--- Player Details ---");
        System.out.println("Date & Time: " + formattedDateTime);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Sport: " + sport);
        System.out.println("Position: " + position);
        System.out.println("Training Hours: " + hours);

        sc.close();
    }
}
