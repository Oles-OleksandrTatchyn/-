package droidgame.battles;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import droidgame.Droid;

public class TeamBattle implements Battle {
  private Random random = new Random();
  private FileWriter battleLogFile;

  public TeamBattle() {
    try {
      battleLogFile = new FileWriter("Teambattle_log.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void startBattle(List<Droid> team1, List<Droid> team2) {
    int round = 1;

    while (!team1.isEmpty() && !team2.isEmpty()) {
      String roundLog = "\n  Round " + round + ":\n";
      System.out.println(roundLog);
      appendToLog(roundLog);

      performRound(team1, team2);

      round++;
    }

    String battleResultLog = !team1.isEmpty() ? "Team 1 wins!" : "Team 2 wins!";
    System.out.println(battleResultLog);
    appendToLog(battleResultLog);

    closeLogFile();
  }

  private void performRound(List<Droid> team1, List<Droid> team2) {
    Collections.shuffle(team1);
    Collections.shuffle(team2);

    Iterator<Droid> iterator1 = team1.iterator();
    Iterator<Droid> iterator2 = team2.iterator();

    while (iterator1.hasNext() && iterator2.hasNext()) {
      Droid attacker1 = iterator1.next();
      Droid attacker2 = iterator2.next();

      Droid target1 = getRandomDroid(team2);
      Droid target2 = getRandomDroid(team1);

      int damage1 = random.nextInt(attacker1.getDamage() + 1);
      int damage2 = random.nextInt(attacker2.getDamage() + 1);

      target1.takeDamage(damage1);
      target2.takeDamage(damage2);

      if (attacker1.getPoisonDamage() > 0) {
        target1.incrementCurrentPoisonLevel(attacker1.getPoisonDamage());
      }

      if (attacker2.getPoisonDamage() > 0) {
        target2.incrementCurrentPoisonLevel(attacker2.getPoisonDamage());
      }

      String damageLog1 = attacker1.getName() + " hits " + target1.getName() + " for " + damage1 + " damage.";
      String damageLog2 = attacker2.getName() + " hits " + target2.getName() + " for " + damage2 + " damage.";
      String poisonLog1 = target1.getName() + " Current Poison Level: " + target1.getCurrentPoisonLevel();
      String poisonLog2 = target2.getName() + " Current Poison Level: " + target2.getCurrentPoisonLevel();
      String healthLog1 = target1.getName() + " Current Health: " + target1.getHealth();
      String healthLog2 = target2.getName() + " Current Health: " + target2.getHealth();

      System.out.println(damageLog1);
      System.out.println(damageLog2);
      System.out.println(poisonLog1);
      System.out.println(poisonLog2);
      System.out.println(healthLog1);
      System.out.println(healthLog2);

      appendToLog(damageLog1);
      appendToLog(damageLog2);
      appendToLog(poisonLog1);
      appendToLog(poisonLog2);
      appendToLog(healthLog1);
      appendToLog(healthLog2);

      if (!target1.isAlive()) {
        String deathLog1 = target1.getName() + " is dead.";
        System.out.println(deathLog1);
        iterator1.remove();
        appendToLog(deathLog1);
      }

      if (!target2.isAlive()) {
        String deathLog2 = target2.getName() + " is dead.";
        System.out.println(deathLog2);
        iterator2.remove();
        appendToLog(deathLog2);
      }
    }

    String endOfRound = "\n  *End of round*\n";
    System.out.println(endOfRound);
    appendToLog(endOfRound);

    for (Droid droid : team1) {
      droid.takeDamage(droid.getCurrentPoisonLevel());
      String poisonDamageLog1 = droid.getName() + " was damaged by poison for " + droid.getCurrentPoisonLevel() + " health.";
      System.out.println(poisonDamageLog1);
      appendToLog(poisonDamageLog1);
    }

    for (Droid droid : team2) {
      droid.takeDamage(droid.getCurrentPoisonLevel());
      String poisonDamageLog2 = droid.getName() + " was damaged by poison for " + droid.getCurrentPoisonLevel() + " health.";
      System.out.println(poisonDamageLog2);
      appendToLog(poisonDamageLog2);
    }

    for (Droid droid : team1) {
      droid.regenerate();
      String regenLog1 = droid.getName() + " regenerated for " + droid.getRegenerationRate() + " health.";
      System.out.println(regenLog1);
      appendToLog(regenLog1);
    }

    for (Droid droid : team2) {
      droid.regenerate();
      String regenLog2 = droid.getName() + " regenerated for " + droid.getRegenerationRate() + " health.";
      System.out.println(regenLog2);
      appendToLog(regenLog2);
    }
  }

  private Droid getRandomDroid(List<Droid> droids) {
    int randomIndex = random.nextInt(droids.size());
    return droids.get(randomIndex);
  }

  private void appendToLog(String logEntry) {
    try {
      battleLogFile.write(logEntry + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void closeLogFile() {
    try {
      battleLogFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void startBattle(Droid droid1, Droid droid2) {
    throw new UnsupportedOperationException("Unimplemented method 'startBattle'");
  }
}