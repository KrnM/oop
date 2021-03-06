package ua.lpnuai.oop.boksho10;

import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author nick
 *
 *         Êëàñ-ïðåäñòàâëåííÿ ïðèêëàäíî¿ îáëàñò³.
 */
public class AudioLibrary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1953977639393957131L;
	protected String name;
	protected String genre;
	protected String author;
	protected String text;
	protected String dateOfCreation; // ñïåö³àë³çîâàí³ òèïè
	protected String duration; // ñïåö³àë³çóâàòè òèï (ôëîàò)
	protected String dataFormat;
	protected Map<String, Integer> rating = new HashMap<String, Integer>();

	/**
	 * @param name
	 *            íàçâà
	 * @param genre
	 *            æàíð
	 * @param author
	 *            âèêîíàâåöü
	 * @param text
	 *            òåêñò
	 * @param date
	 *            äàòà ñòâîðåííÿ
	 * @param duration
	 *            òðèâàë³ñòü
	 * @param dataFormat
	 *            ôîðìàò äàíèõ
	 *
	 *            Êîíñòðóêòîð ³ç àðãóìåíòàìè.
	 */
	public AudioLibrary(String name, String genre, String author, String text, String date, String duration,
			String dataFormat) {
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.text = text;
		this.dateOfCreation = date;
		this.duration = duration;
		this.dataFormat = dataFormat;
	}

	/**
	 * Êîíñòðóêòîð çà çàìîâ÷åâàííÿì.
	 */
	public AudioLibrary() {
		this.name = "none";
		this.genre = "none";
		this.author = "none";
		this.text = "none";
		this.dateOfCreation = "none";
		this.duration = "none";
		this.dataFormat = "none";
	}

	/**
	 * @return íàçâà êîíïîçèö³¿
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            íàçâà êîíïîçèö³¿
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return æàíð êîíïîçèö³¿
	 */
	public String getGenre() {
		return this.genre;
	}

	/**
	 * @param genre
	 *            æàíð êîíïîçèö³¿
	 */
	public void setGenre(final String genre) {
		this.genre = genre;
	}

	/**
	 * @return ³ì'ÿ âèêîíàâöÿ
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * @param author
	 *            ³ì'ÿ âèêîíàâöÿ
	 */
	public void setAuthor(final String author) {
		this.author = author;
	}

	/**
	 * @return òåêñò êîìïîçèö³¿
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * @param text
	 *            òåêñò êîìïîçèö³¿
	 */
	public void setText(final String text) {
		this.text = text;
	}

	/**
	 * @return äàòà ñòâîðåííÿ
	 */
	public String getDateOfCreation() {
		return this.dateOfCreation;
	}

	/**
	 * @param dateOfCreation
	 *            äàòà ñòâîðåííÿ
	 */
	public void setDateOfCreation(final String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	/**
	 * @return òðèâàë³ñòü êîìïîçèö³¿
	 */
	public String getDuration() {
		return this.duration;
	}

	/**
	 * @param duration
	 *            òðèâàë³ñòü êîìïîçèö³¿
	 */
	public void setDuration(final String duration) {
		this.duration = duration;
	}

	/**
	 * @return ôîðìàò äàíèõ
	 */
	public String getDataFormat() {
		return this.dataFormat;
	}

	/**
	 * @param dataFormat
	 *            ôîðìàò äàíèõ
	 */
	public void setDataFormat(final String dataFormat) {
		this.dataFormat = dataFormat;
	}

	/**
	 * @return ðåéòèíã êîìïîçèö³¿
	 */
	public Map<String, Integer> getRating() {
		return this.rating;
	}

	/**
	 * @param key
	 *            ðÿäîê-êëþ÷
	 * @param value
	 *            ÷èñëîâå çíà÷åííÿ ðåéòèíãó
	 */
	public void setRating(final String key, final int value) {
		this.rating.put(key, value);
	}

	
	public String toString() {
		StringBuilder buff = new StringBuilder();
		buff.append(this.getAuthor() + " - " + this.getName() + "\nÆàíð: " + this.getGenre() + "\nÒåêñò ïåñíè: "
				+ this.getText() + "\nÄàòà ñîçäàíèÿ: " + this.getDateOfCreation() + "\nÏðîäîëæèòåëüíîñòü: "
				+ this.getDuration() + "\nÔîðìàò äàííûõ: " + this.getDataFormat() + "\n");
		buff.append("Ðåéòèíã: " + this.getRating() + "\n");
		return buff.toString();
	}

	public AudioLibrary init(AudioLibrary object) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String temp = null;

		System.out.print("Àâòîð: ");
		temp = input.readLine();
		object.setAuthor(temp);

		System.out.print("Íàçâà : ");
		temp = input.readLine();
		object.setName(temp);

		System.out.print("Ôîðìàò äàíèõ: ");
		temp = input.readLine();
		object.setDataFormat(temp);

		System.out.print("Ðåéòèíã: ");
		Scanner in = new Scanner(System.in);
		int value = in.nextInt();
		object.setRating("Rolling Stone", value);

		return object;
	}

}