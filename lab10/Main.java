package ua.lpnuai.oop.boksho10;

public class Main {

	/**
	 * @param args Ïàðàìåòðè êîìàíäíîãî ðÿäêó
	 * 
	 * Òî÷êà âõîäó êîíñîëüíî¿ ïðîãðàìè
	 */
	public static void main(String[] args) {
		
		final int SIZE = 3;
	
		AudioLibrary[] storage = new AudioLibrary[SIZE];
		for (int i = 0; i < SIZE; i++) {
			storage[i] = new AudioLibrary();
		}
		
		storage[0].setAuthor("ïàñîø");
		storage[0].setName("íèêîãäà");
		storage[0].setGenre("Alternative rock");
		storage[0].setDateOfCreation("2015");
		storage[0].setDuration("3:14");
		storage[0].setDataFormat(".mp3");
		
		storage[1].setAuthor("Áóåðàê");
		storage[1].setName("Òâîÿ ôèãóðà");
		storage[1].setDateOfCreation("2017");
		
		for (AudioLibrary elem : storage) {
			System.out.println(elem);
		}
	}

}
