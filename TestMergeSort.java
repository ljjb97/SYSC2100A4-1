
public class TestMergeSort {

	public static void main(String[] args) {
		String[] names = {"Lisa", "Adam", "John", "Vicky",
				"George", "Beth", "Kate", "Aaron", "Jinny"};
		Sorter test = new Sorter(names);
		test.printArray();
		test.sort();
		test.printArray();
	}

}
