package com.company;

import com.company.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

public class FrameMain extends JFrame{
    private JPanel panelMain;
    private JTable tableInput;
    private JTable tableOutput;
    private JButton buttonStandardQueue;
    private JButton buttonLinkedListQueue;
    private JButton buttonLoadInputFromFile;
    private JButton buttonRandom;

    private JFileChooser fileChooserSave;
    private JFileChooser fileChooserOpen;

    public FrameMain() {
        this.setTitle("Task_3");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(320, 10, 100, 100);
        this.setResizable(true);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 30, false, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 30, false, true, false, true);

        tableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        buttonLinkedListQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {

                    int[] array = JTableUtils.readIntArrayFromJTable(tableInput);
                    assert array != null;
                    LinkedListQueue<Integer> queue = LinkedListQueueUtils.intArrayToQueue(array);

                    BubbleSort bubbleSort = new BubbleSort();
                    bubbleSort.sort(queue);

                    int[] resultArray = LinkedListQueueUtils.intQueueToArray(queue);
                    JTableUtils.writeArrayToJTable(tableOutput, resultArray);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonStandardQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {

                    int[] array = JTableUtils.readIntArrayFromJTable(tableInput);
                    assert array != null;
                    LinkedBlockingQueue<Integer> queue = LinkedBlockedQueueUtils.intArrayToQueue(array);

                    BubbleSort bubbleSort = new BubbleSort();
                    bubbleSort.sort(queue);

                    int[] resultArray = LinkedBlockedQueueUtils.intQueueToArray(queue);
                    JTableUtils.writeArrayToJTable(tableOutput, resultArray);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] inputArr1 = ArrayUtils.createRandomIntArray(tableInput.getColumnCount(), 0, 99);
                    JTableUtils.writeArrayToJTable(tableInput, inputArr1);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
