package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Sorting extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sorting frame = new Sorting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sorting() {
		setTitle("Sort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Array");
		lblNewLabel.setBounds(6, 6, 104, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Origional Array");
		lblNewLabel_1.setBounds(6, 51, 209, 16);
		contentPane.add(lblNewLabel_1);

		JTextArea origArraytxt = new JTextArea();
		JScrollPane scol = new JScrollPane(origArraytxt);
		scol.setBounds(6, 82, 438, 45);
		contentPane.add(scol);

		JLabel lblSortedArray = new JLabel("Sorted Array");
		lblSortedArray.setBounds(6, 146, 209, 16);
		contentPane.add(lblSortedArray);

		//Text Area for sorted 
		JTextArea sortedArraytxt = new JTextArea();
		JScrollPane scroll = new JScrollPane(sortedArraytxt);
		scroll.setBounds(6, 174, 438, 45);
		contentPane.add(scroll);

		// exit button
		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitbtn.setBounds(327, 246, 117, 26);
		contentPane.add(exitbtn);

		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(247, 256, 1, 16);
//		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(227, 222, 217, 18);
		contentPane.add(textField);
		textField.setColumns(10);

		// combo box
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) comboBox.getSelectedItem();
				sortArray(s.trim());
			}

			//Sort Array
			private void sortArray(String s) {
				Map<String, int[]> map = new HashMap<>();
				int[] originalArr;
				if (map.containsKey(s)) {
					originalArr = map.get(s);
				} else {
					Random rand = new Random();
					int randomNumber = rand.nextInt(1000) + 1001;
					System.out.println("Size of the array is: " +randomNumber);
					originalArr = generateArray(randomNumber, rand);
					map.put(s, originalArr);
				}
				origArraytxt.setText(Arrays.toString(originalArr));
				long startTime = System.nanoTime();
				int[] sorted = calculate(originalArr);
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				
				System.out.println("Time spent nanoTime: " +totalTime);
				sortedArraytxt.setText(Arrays.toString(sorted));
				textField.setText(String.valueOf(totalTime));
			}

			//created method to call mergeSort 
			public int[] calculate(int[] arr) {
				int[] sortedArray = arr.clone();
				int l = 0, r = sortedArray.length - 1;
				mergeSort(l, r, sortedArray);
				return sortedArray;
			}

			//find mid and devide the array
			private void mergeSort(int first, int right, int[] arr) {
				if (first < right) {
					int mid = (first + right) / 2;
					mergeSort(first, mid, arr);
					mergeSort(mid + 1, right, arr);
					merge(arr, first, mid, right);
				}
			}

			//merge the array
			private void merge(int[] arr, int left, int mid, int right) {
				int n1Length = mid - left + 1;
				int n2Length = right - mid;
				int arrLeft[] = new int[n1Length];
				int arrRight[] = new int[n2Length];

				for (int i = 0; i < n1Length; i++) {
					arrLeft[i] = arr[left + i];
				}
				for (int i = 0; i < n2Length; i++) {
					arrRight[i] = arr[mid + i + 1];
				}

				int i = 0, j = 0, index = left;

				while (i < n1Length && j < n2Length) {
					if (arrLeft[i] < arrRight[j]) {
						arr[index] = arrLeft[i];
						i++;
					} else {
						arr[index] = arrRight[j];
						j++;
					}
					index++;
				}

				while (i < n1Length) {
					arr[index] = arrLeft[i];
					i++;
					index++;
				}
				while (j < n2Length) {
					arr[index] = arrRight[j];
					j++;
					index++;
				}
			}

			//generate array with random number
			private int[] generateArray(int size, Random rand) {
				int[] arr = new int[size];
				for (int i = 0; i < size; i++) {
					arr[i] = rand.nextInt();
				}
				return arr;
			}
		});
		addValuesToComboBox(comboBox);
		comboBox.setToolTipText("");
		comboBox.setBounds(267, 2, 135, 27);
		contentPane.add(comboBox);
		
		JLabel lblTotalTimeSpent = new JLabel("Total Time Spent in nanoTime: ");
		lblTotalTimeSpent.setBounds(6, 222, 196, 18);
		contentPane.add(lblTotalTimeSpent);
		
		

	}

	//Add sets to combobox
	private void addValuesToComboBox(JComboBox comboBox) {
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
	}
}
