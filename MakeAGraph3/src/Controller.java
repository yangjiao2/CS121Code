import java.util.Scanner;


public class Controller {
	int type;
	Plot plot;
	DataSet dataset;
	GraphGenerator graph;
	DataGenerator data;
	
	public void main(String[] args) {
		String command = "";
		Scanner sc = new Scanner(System.in);
		while (command.equalsIgnoreCase("quit")){
			System.out.println("Welcome to MakeAGraph!");
			System.out.println("Please input the integer corresponding to graph mode:");
			System.out.println("1. Scatter Plot");
			System.out.println("2. Bar Graph");
			//		System.out.println("3. Line Graph");
			//		System.out.println("4. Pie Chart");

			type = sc.nextInt();
			graph = new GraphGenerator(type);
			plot = graph.plot;
			
			System.out.println("Please input data pairs in the format of (*, *):");
			System.out.println("Use <Enter> to quit inputting data");
			
			data = new DataGenerator(type);
			dataset.getDataSet();
			
			System.out.println("Type \"quit\" to quit MakeAGraph, else to generate another graph.");
			command = sc.nextLine();
		}
	}
}
