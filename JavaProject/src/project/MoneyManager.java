package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

	public class MoneyManager {
		private ArrayList<Transaction> transactions = new ArrayList<>();

		public void addTransaction(Transaction transaction) {
			transactions.add(transaction);
		}
		public ArrayList<Transaction> getTransactions(){
			return transactions;
		}
		public double calculateTotalBalance() {
			double total = 0;
			for (Transaction transaction : transactions) {
				if (transaction.getType().equalsIgnoreCase("Income")) {
					total += transaction.getAmount();
				} else if (transaction.getType().equalsIgnoreCase("Expense")) {
					total -= transaction.getAmount();
				}
			}
			return total;
		}

		public void displayIncomeTransactions() {
			System.out.println("Income Transactions:");
			for (Transaction transaction : transactions) {
				if (transaction.getType().equalsIgnoreCase("Income")) {
					transaction.display();
				}
			}
		}

		public void displayExpenseTransactions() {
			System.out.println("Expense Transactions:");
			for (Transaction transaction : transactions) {
				if (transaction.getType().equalsIgnoreCase("Expense")) {
					transaction.display();
				}
			}
		}
		//Use to test is the program read file correctly
		public void display(){
			for (Transaction transaction : transactions) {
				transaction.display();
			}
		}
		// Method to write transactions to a file
		public void writeToFile(String filename) {
			try {
				BufferedWriter writeFile = new BufferedWriter(new FileWriter(filename,true));
				for (Transaction e : transactions) {
					writeFile.write(e.getType() + " " + e.getAmount() + "\n");
				}
				writeFile.close();
			} catch (Exception e) {
				System.out.println("SomethingWrongHappen");
			}
		}

		// Method to read transactions from a file
		public void readFromFile(String filename) {
			String line;
			try {
				BufferedReader readFile = new BufferedReader(new FileReader(filename));

				while ((line = readFile.readLine()) != null) {
					String[] fromFile = line.split("\\s+");
					if (fromFile.length > 1) {
						String type = fromFile[0];
						double amount = Double.parseDouble(fromFile[1]);
						Transaction newTransaction = new Transaction(type, amount);
						transactions.add(newTransaction);
					}
				}
				readFile.close();
			} catch (Exception e) {
				System.out.println("Something WrongHappen");
			}
		}
	}