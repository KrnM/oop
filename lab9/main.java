package ua.lpnuai.oop.boksho09;


public final class Main {

	/**
	 * Private constructor.
	 */
	private Main() {
	}

	/**
	 * @param args cmd line arguments
	 * Oi?ea aoiao. Aaiiino?ao?y ?ic?iaeaiiai eiioaeia?o oa ?oa?aoi?o.
	 */
	public static void main(final String[] args) {
		String[] array = new String[3];
		array[0] = "This is test.";
		array[1] = "Java container.";
		array[2] = "Another one sentence.";
		
		Container container = new Container(array);
		container.add("One more test");
		if (container.contains("This is test.")) {
			System.out.println("checked");
		}

		@SuppressWarnings("rawtypes")
		Container.Iterator it = container.iterator();
		
		for (String item : container) {
			System.out.println(item);
		}

		while (it.hasNext()) {
			String curr = (String) it.next();
			System.out.println(curr);
		}
	}
}