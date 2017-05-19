// Vu Nguyen
// ID: 42182872



public final class Frequency {
	public String poemName;
	public int frequency;
	
	public Frequency(String word) {
		this.poemName = word;
		this.frequency = 0;
	}
	
	public Frequency(String word, int frequency) {
		this.poemName = word;
		this.frequency = frequency;
	}
	
	public void incrementFrequency() {
		frequency++;
	}
	
	@Override
	public String toString() {
		return poemName + ":" + frequency;
	}
}
