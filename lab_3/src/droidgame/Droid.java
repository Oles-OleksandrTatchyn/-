package droidgame;

public abstract class Droid {
  protected String name;
  protected int health;
  protected int damage;
  protected int regenerationRate;
  protected int poisonDamage;
  protected int currentPoisonLevel;

  public Droid(String name, int health, int damage, int regenerationRate, int poisonDamage, int currentPoisonLevel) {
    this.name = name;
    this.health = health;
    this.damage = damage;
    this.regenerationRate = regenerationRate;
    this.poisonDamage = poisonDamage;
    this.currentPoisonLevel = 0;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public int getDamage() {
    return damage;
  }

  public int getRegenerationRate() {
    return regenerationRate;
  }

  public int getCurrentPoisonLevel() {
    return currentPoisonLevel;
  }

  public void incrementCurrentPoisonLevel(int poisonDamage) {
    currentPoisonLevel += poisonDamage;
  }

  public int getPoisonDamage() {
    return poisonDamage;
  }

  public void takeDamage(int damage) {
    health -= damage;
  }

  public void regenerate() {
    health += regenerationRate;
  }

  public void applyPoison() {
    health -= poisonDamage;
  }

  public boolean isAlive() {
    return health > 0;
  }

  public abstract void specialAbility(Droid enemy);

  public void attack(Droid enemy) {
    int damageDealt = damage;
    specialAbility(enemy);
    enemy.takeDamage(damageDealt);
  }
}