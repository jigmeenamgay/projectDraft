import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class music extends JFrame {
    private ArrayList<String> playlist;
    private DefaultListModel<String> listModel;
    private JList<String> playlistView;
    private JTextField songInput;
    private JButton addButton, removeButton, searchButton, clearButton;

    public music() {
        // Initialize data structures
        playlist = new ArrayList<>();
        listModel = new DefaultListModel<>();

        // Window setup
        setTitle(" Music Playlist Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ======= TOP PANEL (input + buttons) =======
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        songInput = new JTextField(20);
        addButton = new JButton("Add Song");
        removeButton = new JButton("Remove Song");
        searchButton = new JButton("Search Song");
        clearButton = new JButton("Clear Playlist");

        topPanel.add(new JLabel("Enter Song:"));
        topPanel.add(songInput);
        topPanel.add(addButton);
        topPanel.add(removeButton);
        topPanel.add(searchButton);
        topPanel.add(clearButton);

        add(topPanel, BorderLayout.NORTH);

        // ======= CENTER PANEL (playlist display) =======
        playlistView = new JList<>(listModel);
        playlistView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playlistView.setVisibleRowCount(10);
        JScrollPane scrollPane = new JScrollPane(playlistView);

        add(scrollPane, BorderLayout.CENTER);

        // ======= BUTTON ACTIONS =======
        addButton.addActionListener(e -> addSong());
        removeButton.addActionListener(e -> removeSong());
        searchButton.addActionListener(e -> searchSong());
        clearButton.addActionListener(e -> clearPlaylist());

        // Show the GUI
        setVisible(true);
    }

    private void addSong() {
        String song = songInput.getText().trim();
        if (!song.isEmpty()) {
            playlist.add(song);
            listModel.addElement(song);
            songInput.setText("");
            JOptionPane.showMessageDialog(this, "✅ '" + song + "' added to your playlist!");
        } else {
            JOptionPane.showMessageDialog(this, "⚠️ Please enter a song name.");
        }
    }

    private void removeSong() {
        int selectedIndex = playlistView.getSelectedIndex();
        if (selectedIndex != -1) {
            String song = playlist.remove(selectedIndex);
            listModel.remove(selectedIndex);
            JOptionPane.showMessageDialog(this, "🗑️ '" + song + "' removed from playlist.");
        } else {
            JOptionPane.showMessageDialog(this, "❌ Please select a song to remove.");
        }
    }

    private void searchSong() {
        String search = JOptionPane.showInputDialog(this, "Enter song name to search:");
        if (search != null && !search.trim().isEmpty()) {
            boolean found = false;
            for (int i = 0; i < playlist.size(); i++) {
                if (playlist.get(i).equalsIgnoreCase(search.trim())) {
                    playlistView.setSelectedIndex(i);
                    playlistView.ensureIndexIsVisible(i);
                    JOptionPane.showMessageDialog(this, "🎵 Song found at position " + (i + 1));
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "❌ Song not found in playlist.");
            }
        }
    }

    private void clearPlaylist() {
        if (!playlist.isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(this, "Clear entire playlist?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                playlist.clear();
                listModel.clear();
                JOptionPane.showMessageDialog(this,"🧹 Playlist cleared!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "⚠️ Playlist is already empty.");
        }
    }

    // ======= MAIN METHOD 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(music::new);
    }
}
    

