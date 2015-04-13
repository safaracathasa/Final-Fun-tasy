public interface Skillable
{
	public void Attack();
	/*
	 * Merupakan Skill yang akan diakses dengan berbeda pada setiap Level
	 * Skill akan diimplementasikan dengan nama yang berbeda pada setiap kelas
	 * Contoh 	: Jika Class Mage mengimplementasikan Attack(); maka yang dilakukan adalah sebuah Black Magic.
	 *			: Skill Magic nya pun, based on "Elemen" yang dimiliki oleh si Class Magenya.
	 *	 		: Jika api, maka nama Skill Attack(); akan ditampilkan menjadi
	 *				- Jika Level 01-10 : "Fire"
	 *				- Jika Level 11-20 : "Fira"
	 *				- Jika Level > 21  : "Firaga"
	 */

	public void Defend();
	/*
	 * Merupakan Skill yang dapat melakukan Buff untuk mengurangi damage yang didapat.
	 * Kemampuan Buff Skill nya pun berbeda sesuai dengan tingkat level dan class (Teserah Implementasiin aja ntar Wqwqwq)
	 */	

	public void Heal();
	/*
	 * Simple as its Name, menambah Darah. Jeng jeng. :D
	 */	
}
