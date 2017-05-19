
public class Pair<E, T> {
	private E value_one;
	private T value_two;
	
	public Pair(E value_one, T value_two) {
		this.value_one = value_one;
		this.value_two = value_two;
	}
	public static <E, T> Pair<E,T> createPair(E value_one, T value_two) {
		return new Pair <E, T> (value_one, value_two);
	}
	
    public E getFirstValue() {
        return value_one;
    }

    public T getSecondValue() {
        return value_two;
    }
    
    public E setFirstValue(Pair<E, T> thispair, E value_one) {
        return thispair.value_one = value_one;
    }

    public T setSecondValue(Pair<E, T> thispair, T value_two) {
        return thispair.value_two = value_two;
    }
    
    public String toString() {
        return "(" + value_one.toString() + ", " + value_two.toString() + ")";
    } 
	
	public int getFirstInt(){
		return (Integer) getFirstValue();
	}
	
	public int getSecondInt(){
		return (Integer) getSecondValue();
	}
}
