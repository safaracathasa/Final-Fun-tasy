package dev.huntul.finalfuntasy.monster;

import java.util.Random;

import dev.huntul.finalfuntasy.character.CharacterGame;

public class MonsterFactory {
	public static Monster createMonster(CharacterGame chars1,CharacterGame chars2,CharacterGame chars3) {
		Monster monster = null;
		Random rand = new Random();
		int token = rand.nextInt(5);
		if ((token == 0) || (token == 1) || (token == 2)) {
			monster = new Kingsman(chars1,chars2,chars3);
		} else if ((token == 3) || (token == 4)) {
			monster = new Behemoth(chars1,chars2,chars3);
		} else {
			monster = new Marlboro(chars1,chars2,chars3);
		}
		return monster;
	}
}
