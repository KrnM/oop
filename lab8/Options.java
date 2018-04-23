package ua.lpnuai.oop.boksho08;

public final class Options {

	public static boolean debugParam = false;

	private Options() {

	}

	public static final void forHelperParam(String[] args) {
		for (String param : args) {
			if (param.equals("-h") || param.equals("helper")) {
				System.out.format("\t\t�����: ����� �����, ��-108\n");
				System.out.println("\t������������ ��������: ");
				System.out.println("������� �� ����� �������� �� ���������� ����� ������� ������� ���������� ������.");
				System.out.format("\t 1. input.\n");
				System.out.println("������� ������� �������� ������������ �������� ������. ");
				System.out.format("\t 2. data.\n");
				System.out.println("������� ������� ��������� �� ����� �������� ������.");
				System.out.format("\t 3. calculate.\n");
				System.out.println("������� ������� ������� ������ ���������� �� ���������� ��� � ������� ������.");
				System.out.format("\t 4. result.\n");
				System.out.println("������� ������� ��������� �� ����� ���������� ������.");
				System.out.format("\t 5. exit.\n");
				System.out.println("������� ������� ������ ��������.");
			}
		}
	}

	public static final void forDebugParam(String[] args) {
		for (String param : args) {
			if (param.equals("-d") || param.equalsIgnoreCase("-debug"))
				debugParam = true;
		}
	}
}