package ua.lpnuai.oop.boksho14;
import java.util.Comparator;
import ua.khpi.oop.shiyka11.Composition;

public class AuthorComparator implements Comparator<Composition> {

	@Override
	public int compare(Composition o1, Composition o2) {
		return o1.getAuthor().compareTo(o2.getAuthor());
	}

}