package org.hitech;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleRoulette {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		try {
			List<String> playerNames = readFile();
			Random generator = new Random();
			int number;
			int rouletteNum;
			int result = 0;
			char response = 'Y';
			List<Player> finalList = new ArrayList<>(); 
			while (response == 'Y' || response == 'y') {
				List<Player> players = new ArrayList<>();
				while (keyboard.hasNextLine()) {
					String[] input = keyboard.nextLine().split(" ");
					if (input != null && input.length == 3) {
						Player player = new Player();
						if (!playerNames.contains(input[0])) {
							throw new Exception("Player not registerd. Please check the uploaded file.!");
						}
						player.setName(input[0]);
						player.setBetNumber(input[1].trim());
						player.setBetAmount(Double.parseDouble(input[2]));
						players.add(player);
					} else {
						break;
					}

				}
				rouletteNum = generator.nextInt(37);
				System.out.println("Number " + rouletteNum);
				for (Player player : players) {
					if (player.getBetNumber().equalsIgnoreCase("EVEN")) {
						if (rouletteNum == 0 || rouletteNum % 2 != 0) {
							result = 0;
						} else {
							player.setWinAmount(2 * player.getBetAmount());
							result = 1;
						}
					} else if ("ODD".equalsIgnoreCase(player.getBetNumber())) {
						if (rouletteNum == 0 || rouletteNum % 2 == 0) {
							result = 0;
						} else {
							result = 1;
							player.setWinAmount(2 * player.getBetAmount());
						}

					} else {
						number = Integer.parseInt(player.getBetNumber());
						if (number > 36 || number < 1) {
							System.out.println("Please provide correct number for bet.!");
						} else {
							if (rouletteNum == number) {
								result = 35;
								player.setWinAmount(36 * player.getBetAmount());
							} else
								result = 0;
						}
					}

					// game result, win/lose
					if (result > 0) {
						player.setResult("WIN");
					} else {
						player.setResult("LOSE");
					}
				
				}

				System.out.println("Player\t\tBet\tOutcome\t\tWinnings");
				System.out.println("---------------");
				finalList.addAll(players);
				for (Player player : players) {
					System.out.println(player.getName() + "\t\t" + player.getBetNumber() + "\t" + player.getResult()
							+ "\t\t" + player.getWinAmount());
				}
				System.out.println("Would you like to play one more round?(Y/N) : ");
				response = keyboard.nextLine().charAt(0);
			}
		} catch (Exception e) {
			keyboard.close();
			System.out.println(e.getMessage());
		}

	}

	public static List<String> readFile() {
		List<String> players = new ArrayList<>();
		Scanner readFile;
		try {
			readFile = new Scanner(new File("C:\\Users\\SaiKrishna\\Downloads\\players.txt"));
			while (readFile.hasNext()) {
				players.add(readFile.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Please check file exists?");
		}
		return players;
	}
}
