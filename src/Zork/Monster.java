/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Miranda Lawhorn, lawhornm@etsu.edu
 * Course:  CSCI 1260-090
 * Creation Date: Jul 27, 2017
 * ---------------------------------------------------------------------------
 */

package Zork;


/**
 * Monster class creates monsters and sets up stats
 *
 * <hr>
 * Date created: Jul 27, 2017
 * <hr>
 * @author Miranda Lawhorn
 */
public class Monster
{
	public int health = 20; 	//health counter
	public int attack; 			//attack points
	public String name; 		//monster type
	
	/**
	 * default constructor        
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 */
	public Monster()
	{
		
	}//end Monster()
	
	/**
	 * parameterized constructor        
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param health
	 * @param attack
	 * @param name
	 */
	public Monster(int health, int attack, String name)
	{
		this.health = health;
		this.attack = attack;
		this.name = name;
	}//end Monster(int, int, String)
	
	/**
	 * returns attack strength        
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
	
	/**
	 * returns monsters health level   
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return health
	 */
	public int getHealth()
	{
		return health;
	}//end getHealth()
	
	/**
	 * sets health      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param health
	 */
	public void setHealth(int health)
	{
		this.health += health;
	}//end setHealth(int)
	
	/**
	 * toString method      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return strInfo
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String strInfo = "name";
		
		return strInfo;
	}//end toString()
}//end Monster()
