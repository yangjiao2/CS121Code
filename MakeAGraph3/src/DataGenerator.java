import java.util.Scanner;


public class DataGenerator {
	DataSet dataset = new DataSet();

	public DataGenerator(int type){
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().replace(" ", "");
		while (input != ""){
			System.out.println(input);
			switch (type) {
			case 1: 
				dataset = new DataSet<Integer, Integer>();
				while (input != ""){
					String[] str_tuple = input.substring(1, input.length()-1).replace(" ", "").split(",");
					dataset.add(new Pair(String.valueOf(str_tuple[0]), String.valueOf(str_tuple[1])));
					input = sc.nextLine().replace(" ", "");
				}
				break;
			case 2:
				dataset = new DataSet<String, Integer>();
				while (input != ""){
					String[] str_tuple = input.substring(1, input.length()-1).replace(" ", "").split(",");
					dataset.add(new Pair(str_tuple[0], String.valueOf(str_tuple[1])));
					input = sc.nextLine().replace(" ", "");
				}
				break;
			}
		}
	}

}
