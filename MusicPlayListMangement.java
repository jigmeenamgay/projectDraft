import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayListMangement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> playlist = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Song");
            System.out.println("2. View Playlist");
            System.out.println("3. Search Song");
            System.out.println("4. Remove Song");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Song name: ");
                    playlist.add(input.nextLine());
                    break;

                case 2:
                    if (playlist.isEmpty()) System.out.println("Playlist empty.");
                    else playlist.forEach(song -> System.out.println((playlist.indexOf(song) + 1) + ". " + song));
                    break;

                case 3:
                    System.out.print("Search: ");
                    String s = input.nextLine();
                    if (playlist.contains(s))
                        System.out.println("Found at position " + (playlist.indexOf(s) + 1));
                    else
                        System.out.println("Not found.");
                    break;

                case 4:
                    System.out.print("Remove: ");
                    if (playlist.remove(input.nextLine()))
                        System.out.println("Removed.");
                    else
                        System.out.println("Song not found.");
                    break;

                case 5:
                    running = false;
                    break;
            }
        }
        input.close();
    }
}
