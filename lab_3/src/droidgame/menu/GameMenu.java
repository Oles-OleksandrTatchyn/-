package droidgame.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import droidgame.Droid;
import droidgame.battles.Battle;
import droidgame.battles.OneOnOneBattle;
import droidgame.battles.TeamBattle;
import droidgame.droids.BattleDroid;

public class GameMenu {
  private List<Droid> droids = new ArrayList<>();
  private Battle battle;
  private Scanner scanner = new Scanner(System.in);

  public void run() {
    while (true) {
      System.out.println("\n\t\tMenu:\n");
      System.out.println("1. Create a droid");
      System.out.println("2. Show the list of created droids");
      System.out.println("3. Start a 1-on-1 battle");
      System.out.println("4. Start a team battle");
      System.out.println("5. Load a battle from a file");
      System.out.println("6. Exit the program\n");

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
            createDroid();
            break;
          case 2:
            showDroidList();
            break;
          case 3:
            startOneOnOneBattle();
            break;
          case 4:
            startTeamBattle();
            break;
          case 5:
            loadBattleFromFile();
            break;
          case 6:
            scanner.close();
            System.exit(0);
            break;
          default:
            System.out.println("Invalid choice. Please select a valid option.");
            break;
        }
      } else {
        System.out.println("Invalid input. Please enter a valid integer.");
        scanner.nextLine();
      }
    }
  }

  private void createDroid() {
    System.out.println("Enter the droid's name:");
    String name = scanner.nextLine();

    System.out.println("Enter the droid's health:");
    int health = getIntInput();

    System.out.println("Enter the droid's damage:");
    int damage = getIntInput();

    System.out.println("Enter the droid's regeneration rate:");
    int regenerationRate = getIntInput();

    System.out.println("Enter the droid's poison damage:");
    int poisonDamage = getIntInput();

    int currentPoisonLevel = 0;

    BattleDroid droid = new BattleDroid(name, health, damage, regenerationRate, poisonDamage, currentPoisonLevel);
    droids.add(droid);

    System.out.println("Droid " + name + " created and added to the list.");
  }

  private int getIntInput() {
    while (true) {
      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      } else {
        System.out.println("Invalid input. Please enter a valid integer.");
        scanner.nextLine();
      }
    }
  }

  private void showDroidList() {
    if (droids.isEmpty()) {
      System.out.println("The list of droids is empty.");
    } else {
      System.out.println("List of droids:");
      for (int i = 0; i < droids.size(); i++) {
        System.out.println((i + 1) + ". " + droids.get(i).getName());
      }
    }
  }

  private void startOneOnOneBattle() {
    showDroidList();
    if (droids.size() < 2) {
      System.out.println("To start a battle, you need at least two droids.");
      return;
    }

    System.out.println("Select the first droid (enter the number from the list):");
    int index1 = scanner.nextInt() - 1;
    scanner.nextLine();

    System.out.println("Select the second droid (enter the number from the list):");
    int index2 = scanner.nextInt() - 1;
    scanner.nextLine();

    if (index1 < 0 || index1 >= droids.size() || index2 < 0 || index2 >= droids.size()) {
      System.out.println("Invalid droid selection.");
      return;
    }

    Droid droid1 = droids.get(index1);
    Droid droid2 = droids.get(index2);

    battle = new OneOnOneBattle();
    battle.startBattle(droid1, droid2);
  }

  private void startTeamBattle() {
    showDroidList();
    if (droids.size() < 4) {
        System.out.println("To start a team battle, you need at least four droids.");
        return;
    }

    List<Droid> team1 = new ArrayList<>();
    List<Droid> team2 = new ArrayList<>();

    System.out.println("Select droids for Team 1 (enter numbers from the list, separated by spaces):");
    String[] team1Indexes = scanner.nextLine().split(" ");
    for (String indexStr : team1Indexes) {
        int index = Integer.parseInt(indexStr) - 1;
        if (index >= 0 && index < droids.size()) {
            team1.add(droids.get(index));
        }
    }

    System.out.println("Select droids for Team 2 (enter numbers from the list, separated by spaces):");
    String[] team2Indexes = scanner.nextLine().split(" ");
    for (String indexStr : team2Indexes) {
        int index = Integer.parseInt(indexStr) - 1;
        if (index >= 0 && index < droids.size()) {
            team2.add(droids.get(index));
        }
    }

    if (team1.size() < 2 || team2.size() < 2) {
        System.out.println("Both teams must have at least two droids.");
        return;
    }

    battle = new TeamBattle();
    battle.startBattle(team1, team2);
  }


  public void loadBattleFromFile() {
    System.out.println("Enter the path to the battle log file:");
    String filePath = scanner.nextLine();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Error reading the log file: " + e.getMessage());
    }
  }
  
}