package codewars;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Warrior {
	private int level = 1; // 1-100; rises one with each 100 experience
	private int experience = 100;// 100 - 10000
	private String rank = "Pushover"; // "Pushover" - "Greatest"; one up every
										// 10 level
	private List<String> achievements;
	private List<String> ranks;

	public Warrior() {
		this.achievements = new ArrayList<String>();
		this.ranks = Arrays.asList("Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage", "Elite", "Conqueror",
				"Champion", "Master", "Greatest");
	}

	public int level() {
		return this.level;
	}

	public int experience() {
		return this.experience;
	}

	public String rank() {
		return this.rank;
	}

	public List<String> achievements() {
		return this.achievements;
	}

	public String training(String description, int experience, int minLevel) {
		if (this.level < minLevel)
			return "Not strong enough";
		this.experience += experience;
		setParameters();
		this.achievements.add(description);
		return description;
	}

	private void setParameters() {
		if (this.experience >= 10000)
			this.experience = 10000;
		this.level = this.experience / 100;
		this.rank = ranks.get(this.level / 10);
	}

	public String battle(int level) {
		if (level < 1 || level > 100)
			return "Invalid level";
		if (this.level == level) {
			this.experience += 10;
			setParameters();
			return "A good fight";
		} else if (this.level == level + 1) {
			this.experience += 5;
			setParameters();
			return "A good fight";
		} else if (this.level > level + 1) {
			return "Easy fight"; // zero exp point
		} else if (((this.level / 10) + 1 <= level / 10) && (this.level + 5 <= level)) {
			return "You've been defeated";
		} else {
			this.experience = this.experience + (20 * (level - this.level) * (level - this.level));
			setParameters();
			return "An intense fight";
		}

	}
}