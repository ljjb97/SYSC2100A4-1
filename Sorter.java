import java.util.Arrays;

/**
 * 
 */

/**
 * @author Liam Ballantyne
 *
 */
public class Sorter {
	private String[] words;
	
	Sorter(String[] words) {
		this.words = words;
	}
	
	public String[] mergeSort(String[] array) {
		if(array == null || array.length == 0) {
			return null;
		} else if(array.length > 1) {
			String[][] merged = splitter(array);
			merged[0] = mergeSort(merged[0]);
			merged[1] = mergeSort(merged[1]);
			array = merger(merged);
			return array;
		} else return array;
	}
	
	public String[][] splitter(String[] array) {
		int div = (int) Math.ceil((double) array.length/2);
		String[] fhalf = Arrays.copyOfRange(array, 0, div);
		String[] shalf = Arrays.copyOfRange(array, div, array.length);
		String[][] split = {fhalf, shalf};
		return split;
		}
	
	public String[] merger(String[][] array) {
		int length = array[0].length + array[1].length;
		String[] merged = new String[length];
		for(int i=0, j=0, k=0; k < length; k++) {
			if(i == array[0].length) {
				merged[k] = array[1][j];
				j++;
			} else if(j == array[1].length) {
				merged[k] = array[0][i];
				i++;
			} else if( valueOfFirstLetter(array[0][i]) <= valueOfFirstLetter(array[1][j])) {
				merged[k] = array[0][i];
				i++;
			}else {
				merged[k] = array[1][j];
				j++;
			}
		}
		return merged;
	}
	
	public int valueOfFirstLetter(String word) {
		char fletter = word.charAt(0);
		return Character.getNumericValue(fletter);
	}
	
	public void printArray() {
		for(String i: words) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	public void sort() {
		words = mergeSort(words);
	}
}
