package finalfuntasy.monster;

import java.util.Random;

import finalfuntasy.character.CharacterGame;

public class MonsterFactory {
	public static Monster createMonster(CharacterGame chars1,CharacterGame chars2,CharacterGame chars3) {
		Monster monster = null;
		Random rand = new Random();
		int token = rand.nextInt(6);
		if ((token == 0) || (token == 1) || (token == 2)) {
			monster = new Goblin(chars1,chars2,chars3);
		} else if ((token == 3) || (token == 4)) {
			monster = new Behemoth(chars1,chars2,chars3);
		} else {
			monster = new Marlboro(chars1,chars2,chars3);
		}
		return monster;
	}
}
