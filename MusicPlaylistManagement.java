import java.util.Scanner;

public class MusicPlaylistManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] playlist = new String[100]; 
        int songCount = 0;
        boolean running = true;

        System.out.println("🎶 Welcome to Your Music Playlist Manager 🎶");

        while (running) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Song");
            System.out.println("2. View Playlist");
            System.out.println("3. Search Song");
            System.out.println("4. Remove Song");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            
            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    if (songCount < playlist.length) {
                        System.out.print("Enter song name: ");
                        String songName = input.nextLine();
                        playlist[songCount] = songName;
                        songCount++;
                        System.out.println("✅ '" + songName + "' added to your playlist!");
                    } else {
                        System.out.println("⚠️ Playlist is full! Cannot add more songs.");
                    }
                    break;

                case 2:
                    System.out.println("\n🎧 Your Playlist:");
                    if (songCount == 0) {
                        System.out.println("No songs in the playlist yet.");
                    } else {
                        for (int i = 0; i < songCount; i++) {
                            System.out.println((i + 1) + ". " + playlist[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter song name to search: ");
                    String search = input.nextLine();
                    boolean found = false;

                    for (int i = 0; i < songCount; i++) {
                        if (playlist[i].equalsIgnoreCase(search)) {
                            System.out.println("🎵 Song found at position " + (i + 1));
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ Song not found in playlist.");
                    }
                    break;

                case 4:
                    System.out.print("Enter song name to remove: ");
                    String removeSong = input.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < songCount; i++) {
                        if (playlist[i].equalsIgnoreCase(removeSong)) {
                            for (int j = i; j < songCount - 1; j++) {
                                playlist[j] = playlist[j + 1];
                            }
                            playlist[songCount - 1] = null; // Clear last element
                            songCount--;
                            removed = true;
                            System.out.println("🗑️ '" + removeSong + "' removed from playlist.");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("❌ Song not found.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("👋 Exiting Music Playlist Manager. Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Please select between 1-5.");
            }
        }

        input.close();
    }
}

