package evolution.entity;

public class Course {
	private int id;
	private int score;
	@Override
	public String toString() {
		return "Course [id=" + id + ", score=" + score + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
