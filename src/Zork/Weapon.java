/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Miranda Lawhorn, lawhornm@etsu.edu
 * Course:  CSCI 1260-090
 * Creation Date: Jul 27, 2017
 * ---------------------------------------------------------------------------
 */

package Zork;


/**
 * Weapon class creates weapons and returns attack values
 *
 * <hr>
 * Date created: Jul 27, 2017
 * <hr>
 * @author Miranda Lawhorn
 */
public class Weapon
{
	public String name = "";	//holds weapon name
	public int weaponType = 0;	//holds weapon type
	public int attack = 1;		//holds weapon attack value
	
	
	/**
	 * default constructor        
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 */
	public Weapon()
	{
		
	}//end Weapon()
	
	
	/**
	 * parameterized constructor      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param name
	 * @param weaponType
	 * @param attack
	 */
	public Weapon(String name, int weaponType, int attack)
	{
		this.name = name;
		this.weaponType = weaponType;
		this.attack = attack;
	}//end Weapon(String, int, int)
	
	/**
	 * returns attack      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return attack
	 */
	public int getAttack()
	{
		return attack;
	}//end getAttack()
}//end Weapon()