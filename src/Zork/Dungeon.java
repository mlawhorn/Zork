/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Miranda Lawhorn, lawhornm@etsu.edu
 * Course:  CSCI 1260-090
 * Creation Date: Jul 27, 2017
 * ---------------------------------------------------------------------------
 */

package Zork;

import java.util.Random;

/**
 * Dungeon class creates the dungeon and everything inside it
 *
 * <hr>
 * Date created: Jul 27, 2017
 * <hr>
 * @author Miranda Lawhorn
 */
public class Dungeon
{
	static Random rnd = new Random();			//new instance of the random class
	static int randomCell = rnd.nextInt(10);	//creates the length of the dungeon and randomizes it
	public static Room[] dungeon = new Room[randomCell + 3];	//creates new room 
	Player player1 = new Player();				//creates new player
	
	
	/**
	 * default constructor      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 */
	public Dungeon()
	{
		dungeon[0] = new StarterRoom();
		dungeon[dungeon.length - 1] = new EndRoom();
		for(int i = 1; i < dungeon.length-1; i++)
		{
			dungeon[i] = new Room();	//create new dungeon with specific number of rooms
		}
	}//end Dungeon()
	
	/**
	 *String for information of a battle      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param position
	 * @return battleInfo
	 */
	public String battle(int position)
	{
		String battleInfo = "";
		int monsterHealth;		//holds monsters health
		int playerHealth;		//holds players health
		int monsterAttack;		//attack strength
		
		int monsterCount;		//number of monsters in cell
		int ranPlayerHit;		//probability of player hitting monster
		int ranMonsterHit;		//probability of monster hitting player
		int playerAttack;		//player attack points
		boolean playerDead = false;
		boolean monsterDead = false;

		if(dungeon[position].monsterFound)
		{
			battleInfo += "\nBattle begins!";
			monsterCount = dungeon[position].getMonsterNum();
			
			for(int i = 0; i < monsterCount; i++)
			{
				if(playerDead)
				{
					break;
				}
				//get health for player and monster involved in battle
				monsterHealth = dungeon[position].monsters[0].getHealth();
				playerHealth = player1.getHealth();
				playerAttack = player1.getAttack();
				monsterAttack = dungeon[position].monsters[0].getAttack();
				
				while(!playerDead || !monsterDead)
				{
					//pick random value to determine outcome, specific values result in a miss instead of a hit
					ranPlayerHit = rnd.nextInt(10);	
					ranMonsterHit = rnd.nextInt(5);	
					battleInfo += "\nPlayer makes a move...";
					
					if(ranPlayerHit == 8)
					{
						battleInfo += " Miss!";
					}
					else
					{
						//calculate health after damage, display, and check if the monster has died
						monsterHealth -= playerAttack;
						battleInfo += " Hit! Monster lost " + playerAttack + " health. Monster Health: " + monsterHealth;
						
						if(monsterHealth <= 0)
						{
							monsterDead = true;
							break;
						}
					}
					
					battleInfo += " Monster attacks...";
					
					if(ranMonsterHit == 3)
					{
						battleInfo += " Miss!";
					}
					else
					{
						//calculate health after damage, display, and check if the player has died
						playerHealth -= monsterAttack;
						battleInfo += " Hit! Player lost "  + monsterAttack + " health. Player Health: " + playerHealth;

						if(playerHealth <= 0)
						{
							playerDead = true;
							break;
						}
					}
				}
				monsterDead = false; 
				player1.setHealth (playerHealth); 
			}
		}
		dungeon[position].monsterFound = false;
		return battleInfo;
	}//end battle(int)
	
	/**
	 *Create string for dungeon map      
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return dungeonMap
	 */
	public String dungeonMap()
	{
		String dungeonMap = "";
		
		dungeonMap += "Dungeon Map\n\n";

		for(int i = 0; i < dungeon.length; i++)
		{
			dungeonMap += dungeon[i];
		}
		
		return dungeonMap;
	}//end dungeonMap()
	
	/**
	 * toString method, creates map of the dungeon and creates prompts for if a room contains a weapon or monster    
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @param position
	 * @return dungeonPrint
	 */
	public String toString(int position)
	{
		String dungeonPrint = "";
		
		if(dungeon[position].weaponFound)
		{
			dungeonPrint += "\n\n";
			if(dungeon[position].randomWepType == 1)
			{
				dungeonPrint += "There is a stick on the ground.\n";
				
				if(player1.weaponType == 2)
				{
					dungeonPrint += "You already have a better weapon, you leave the stick.";
				}
				else if(player1.weaponType == 1)
				{
					dungeonPrint += "You already have a stick, you leave this one here.";
				}
				else if(player1.weaponType == 0)
				{
					dungeonPrint += "You do not have a weapon, you pick up the stick.";
					player1.setWeapon(1);
					player1.weaponType = 1;
					dungeon[position].weaponFound = false;
				}
				
			}
			else if(dungeon[position].randomWepType == 2)
			{
				dungeonPrint += "\n";
				
				if(player1.weaponType == 1)
				{
					dungeonPrint += "This sword will do more damage than your stick.\n"+
									"You decide to keep the sword and discard the stick.";
					player1.setWeapon(2);
					player1.weaponType = 2;
					dungeon[position].weapon[0] = new Stick();
					dungeon[position].randomWepType = 1;
				}
				else if(player1.weaponType == 2)
				{
					dungeonPrint += "You already have a sword, you leave this one here.";
				}
				else if(player1.weaponType == 0)
				{
					dungeonPrint += "You do not have a weapon, you pick up the sword.";
					player1.setWeapon(2);
					player1.weaponType = 2;
					dungeon[position].weaponFound = false;
				}
				
			}
			
		}
		
		if(dungeon[position].monsterFound)
		{
			dungeonPrint += "\n\nLook out! This room contains " +
					dungeon[position].randomMonNum + " ";
					if(dungeon[position].randomMonType == 1)
						{
							dungeonPrint += "Cyclops";
						}
					else if(dungeon[position].randomMonType == 2)
					{
						dungeonPrint += "King Kong";
					}
					else if(dungeon[position].randomMonType == 3)
					{
						dungeonPrint += "Frankenstein";
					}
					
					dungeonPrint += "!";
		}

		dungeonPrint += battle(position);
	
		return dungeonPrint;
	}//end toString(int)
	
	/**
	 *Returns length of dungeon       
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 * @return
	 */
	public int getLength()
	{
		return dungeon.length;
	}//end getLength()
	
	/**
	 * Print out GAME OVER       
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 * 
	 */
	public void gameOver()
	{
		GameDriver.clearScreen();
		System.out.println(" ######      ###    ##     ## ########     #######  ##     ## ######## ########");
		System.out.println("##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ##");
		System.out.println("##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ##");
		System.out.println("##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ########");
		System.out.println("##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##");
		System.out.println("##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ##");
		System.out.println(" ######   ##     ## ##     ## ########     #######     ###    ######## ##     ##");
		System.exit(0);
	}//end gameOver()
}//end Dungeon()
