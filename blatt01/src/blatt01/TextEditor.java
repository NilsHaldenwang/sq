package blatt01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 * simple text editor
 * 
 * @author Christian Flothmann <cflothma@uni-osnabrueck.de>
 * @author Nils Haldenwang <nhaldenw@uni-osnabrueck.de>
 */
public class TextEditor extends JFrame {

    /**
     * the menubar
     */
    private JMenuBar menuBar;

    /**
     * the text field
     */
    private JTextArea editor;

    /**
     * the statusbar
     */
    private JLabel statusBar;

    public TextEditor() {
        super("Text Editor");

        setLayout(new BorderLayout());

        // create menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // and add menus
        addFileMenu();
        addTextMenu();

        // create the input field
        editor = new JTextArea(20, 100);
        add(editor, BorderLayout.CENTER);

        // add the statusbar
        addStatusBar();
    }

    private void addFileMenu() {
        JMenu fileMenu = new JMenu("Datei");
        menuBar.add(fileMenu);

        JMenuItem load = new JMenuItem("Öffnen");
        fileMenu.add(load);
        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File inputFile = fileChooser.getSelectedFile();
                    try {
                        StringBuilder newText = new StringBuilder();
                        BufferedReader reader = new BufferedReader(
                                new FileReader(inputFile));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            newText.append(line);
                            newText.append(System.getProperty("line.separator"));
                        }
                        reader.close();
                        editor.setText(newText.toString());
                    } catch (IOException e) {
                        statusBar.setText(e.getMessage());
                    }
                }
            }
        });

        JMenuItem store = new JMenuItem("Speichern");
        fileMenu.add(store);
        store.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File outputFile = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(outputFile);
                        writer.write(editor.getText());
                        writer.close();
                    } catch (IOException e) {
                        statusBar.setText(e.getMessage());
                    }
                }
            }
        });
    }

    private void addTextMenu() {
        JMenu fileMenu = new JMenu("Text");
        menuBar.add(fileMenu);

        JMenuItem sort = new JMenuItem("Zeilen sortieren");
        fileMenu.add(sort);
        sort.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                // count the number of occurences of all lines
                TreeMap<String, Integer> lines = new TreeMap<String, Integer>();
                Scanner lineScanner = new Scanner(editor.getText());
                lineScanner.useDelimiter(System.getProperty("line.separator"));
                while (lineScanner.hasNext()) {
                    String line = lineScanner.next();
                    if (lines.containsKey(line)) {
                        lines.put(line, lines.get(line) + 1);
                    } else {
                        lines.put(line, 1);
                    }
                }

                // create the new text containing all lines in sorted order
                StringBuilder newText = new StringBuilder();
                for (String line : lines.keySet()) {
                    int count = lines.get(line);
                    for (int i = 0; i < count; i++) {
                        newText.append(line);
                        newText.append(System.getProperty("line.separator"));
                    }
                }
                editor.setText(newText.toString());
            }
        });

        JMenuItem countWords = new JMenuItem("Wörter zählen");
        fileMenu.add(countWords);
        countWords.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                int wordsCount = 0;
                Scanner countScanner = new Scanner(editor.getText());
                while (countScanner.hasNext()) {
                    countScanner.next();
                    wordsCount++;
                }
                statusBar.setText("Anzahl der Wörter: " + wordsCount);
            }
        });

        JMenuItem countLetters = new JMenuItem("Buchstaben zählen");
        fileMenu.add(countLetters);
        countLetters.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                statusBar.setText("Anzahl der Buchstaben: "
                        + editor.getText().length());
            }
        });
    }

    /**
     * add the statusbar
     */
    private void addStatusBar() {
        statusBar = new JLabel();
        add(statusBar, BorderLayout.SOUTH);
    }

    /**
     * TODO: Dokumentation
     * 
     * @param args
     */
    public static void main(String[] args) {
        JFrame window = new TextEditor();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

}
