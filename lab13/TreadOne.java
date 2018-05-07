package ua.khpi.oop.bashkatov13;
import ua.khpi.oop.shiyka09.LinkedList;
import ua.khpi.oop.shiykaka11.Composition;
import ua.khpi.oop.shiyka12.RegexSearch;

public class ThreadOne extends Thread {

	private LinkedList<Composition> list;
	private long finish;

	public ThreadOne(LinkedList<Composition> list) {
		this.list = list;
	}

	public void run() {

		while (!this.isInterrupted()) {
			try {
				;
				RegexSearch.search(this.list);
				sleep(1000);
				setFinish();
				throw new InterruptedException();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted!");
				break;
			}
		}
	}

	private void setFinish() {
		this.finish = System.nanoTime();
	}

	public long getFinish() {
		return this.finish;
}