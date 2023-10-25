package droidgame.battles;

import java.util.List;

import droidgame.Droid;

public interface Battle {
  void startBattle(Droid droid1, Droid droid2);
  void startBattle(List<Droid> team1, List<Droid> team2);
}