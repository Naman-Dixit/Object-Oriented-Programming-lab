import java.util.Scanner;

interface Playable {
    void play();
    void pause();
    void stop();
}

class MusicPlayer implements Playable {
    public void play() {
        System.out.println("Music is playing.");
    }

    public void pause() {
        System.out.println("Music is paused.");
    }

    public void stop() {
        System.out.println("Music is stopped.");
    }
}

public class TestPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicPlayer mp = new MusicPlayer();

        System.out.println("Enter 1 for play, 2 for pause, 3 for stop:");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: mp.play(); break;
            case 2: mp.pause(); break;
            case 3: mp.stop(); break;
            default: System.out.println("Invalid input");
        }
    }
}
