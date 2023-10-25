package droidgame.battles;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import droidgame.Droid;
import droidgame.droids.BattleDroid;

public class OneOnOneBattle implements Battle {
  private Random random = new Random();
  private FileWriter battleLogFile;

  public OneOnOneBattle() {
    try {
      battleLogFile = new FileWriter("OneOnOnebattle_log.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void startBattle(Droid droid1, Droid droid2) {
    int round = 1;
    Droid copyDroid1 = createCopyOfDroid(droid1);
    Droid copyDroid2 = createCopyOfDroid(droid2);

    while (copyDroid1.isAlive() && copyDroid2.isAlive()) {
      String roundLog = "\n  Round " + round + ":\n";
      System.out.println(roundLog);
      appendToLog(roundLog);

      performRound(copyDroid1, copyDroid2, round);

      round++;
    }

    String battleResultLog = copyDroid1.isAlive() ? copyDroid1.getName() + " wins!" : copyDroid2.getName() + " wins!";
    System.out.println(battleResultLog);
    appendToLog(battleResultLog);

    closeLogFile();
  }

  private void performRound(Droid droid1, Droid droid2, int round) {
    int damage1 = random.nextInt(droid1.getDamage() + 1);
    int damage2 = random.nextInt(droid2.getDamage() + 1);

    droid1.takeDamage(damage2);
    droid2.takeDamage(damage1);

    if (droid1.getPoisonDamage() > 0) {
      droid2.takeDamage(droid1.getPoisonDamage() + droid2.getCurrentPoisonLevel());
      droid2.incrementCurrentPoisonLevel(droid1.getPoisonDamage());
    }

    if (droid2.getPoisonDamage() > 0) {
      droid1.takeDamage(droid2.getPoisonDamage() + droid1.getCurrentPoisonLevel());
      droid1.incrementCurrentPoisonLevel(droid2.getPoisonDamage());
    }

    String damageLog1 = droid1.getName() + " hits " + droid2.getName() + " for " + damage1 + " damage.";
    String damageLog2 = droid2.getName() + " hits " + droid1.getName() + " for " + damage2 + " damage.";
    String poisonLog1 = droid1.getName() + " Current Poison Level: " + droid1.getCurrentPoisonLevel();
    String poisonLog2 = droid2.getName() + " Current Poison Level: " + droid2.getCurrentPoisonLevel();
    String healthLog1 = droid1.getName() + " Current Health: " + droid1.getHealth();
    String healthLog2 = droid2.getName() + " Current Health: " + droid2.getHealth();

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

    droid1.regenerate();
    droid2.regenerate();

    String regenLog1 = droid1.getName() + " regenerated for " + droid1.getRegenerationRate() + " health.";
    String regenLog2 = droid2.getName() + " regenerated for " + droid2.getRegenerationRate() + " health.";
    String healthLogAfterRegen1 = droid1.getName() + " Health: " + droid1.getHealth();
    String healthLogAfterRegen2 = droid2.getName() + " Health: " + droid2.getHealth();

    System.out.println(regenLog1);
    System.out.println(regenLog2);
    System.out.println(healthLogAfterRegen1);
    System.out.println(healthLogAfterRegen2);

    appendToLog(regenLog1);
    appendToLog(regenLog2);
    appendToLog(healthLogAfterRegen1);
    appendToLog(healthLogAfterRegen2);

    if (!droid1.isAlive()) {
      String deathLog1 = droid1.getName() + " is dead.";
      System.out.println(deathLog1);
      appendToLog(deathLog1);
    }

    if (!droid2.isAlive()) {
      String deathLog2 = droid2.getName() + " is dead.";
      System.out.println(deathLog2);
      appendToLog(deathLog2);
    }
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

  private Droid createCopyOfDroid(Droid original) {
    return new BattleDroid(original.getName(), original.getHealth(), original.getDamage(), original.getRegenerationRate(), original.getPoisonDamage(), original.getCurrentPoisonLevel());
  }

  @Override
  public void startBattle(List<Droid> team1, List<Droid> team2) {
    throw new UnsupportedOperationException("Unimplemented method 'startBattle'");
  }
}