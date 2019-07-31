/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Miranda Lawhorn, lawhornm@etsu.edu
 * Course:  CSCI 1260-090
 * Creation Date: Jul 27, 2017
 * ---------------------------------------------------------------------------
 */

package Zork;


/**
 * Player class creates player and sets up stats
 *
 * <hr>
 * Date created: Jul 27, 2017
 * <hr>
 * @author Miranda Lawhorn
 */
public class Player
{
	public int health = 100; 	//health counter
	public int position = 0;	//position of player
	public Weapon weapon;		//holds player weapon
	public int weaponType = 0;	//holds type of player weapon
	
	/**
	 * default constructor        
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 */
	public Player ( )
	{
		weapon = new Weapon();
	}//end Player()
	
	/**
	 * return attack points      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return
	 * @see Monster#getAttack()
	 */
	public int getAttack()
	{
		return weapon.getAttack();
	}//end getAttack()
	
	/**
	 * set player weapon       
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param weapon
	 */
	public void setWeapon(int weapon)
	{
		if(weapon == 1)
		{
			this.weapon = new Stick();
		}
		else if(weapon == 2)
		{
			this.weapon = new Sword();
		}
	}//end setWeapon(int)
	
	/**
	 * return player weapon      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return weapon
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}//end getWeapon()
	
	/**
	 * return player health <br>        
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return health
	 * @see Monster#getHealth()
	 */
	public int getHealth()
	{
		return health;
	}//end getHealth()
	
	/**
	 * set player health        
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param health
	 * @see Monster#setHealth(int)
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}//end setHealth(int)
	
	/**
	 * move player from one cell to another       
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param move
	 */
	public void movePlayer (int move)
	{
		Dungeon.dungeon[position].playerFound(false);
		position += move;
		Dungeon.dungeon[position].playerFound(true);
		Dungeon.dungeon[position].setVisited(true);
	}//end movePlayer(int)
	
	/**
	 * return position      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return position
	 */
	public int getPosition()
	{
		return position;
	}//end getPosition()
}//end Player()