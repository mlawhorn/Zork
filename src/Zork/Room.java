/**
 * ---------------------------------------------------------------------------
 * File name: Room.java
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
 * Room class tells things about a room/cell such as if there is a weapon
 * or monster and can tell where the player is
 *
 * <hr>
 * Date created: Jul 27, 2017
 * <hr>
 * @author Miranda Lawhorn
 */
public class Room
{
		
		public boolean playerFound = false;		//determines if the player is in a certain cell
		public boolean monsterFound = false;	//determines if a monster is in a cell
		public boolean weaponFound = false;		//determines if a weapon is in a cell
		public boolean cellVisited = false;		//determines if a cell has been visited or not
					   
		
		public Monster[] monsters = new Monster[5]; //creates an array of Monsters containing 5 blank indexes
		public Weapon[] weapon = new Weapon[1];		//holds weapon type object for cell
		Random rnd = new Random();
		int randomMonster = rnd.nextInt(2) + 1;	//random number for 50% chance of room containing monster
		int	randomMonType = rnd.nextInt(3) + 1;	//random number for monster type
		int	randomMonNum = rnd.nextInt(3) + 1;	//random number for number of monster type in cell
		int	randomWeapon = rnd.nextInt (4) + 1;	//random number for 25% chance of weapon
		int	randomWepType = rnd.nextInt(2) + 1; //random number for weapon type
		
		/**
		 * default constructor        
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 * 
		 */
		public Room()
		{
			monFound();
			wepFound();
			monsters[0] = monFound();
		}//end Room()
		
		/**
		 * parameterized constructor       
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 * @param monsterFound
		 * @param weaponFound
		 */
		public Room(boolean monsterFound, boolean weaponFound)
		{
			this.monsterFound = monsterFound;
			this.weaponFound = weaponFound;
		}//end Room(boolean, boolean)
		
		/**
		 * parameterized constructor        
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 * @param monsterFound
		 * @param weaponFound
		 * @param cellVisited
		 */
		public Room(boolean monsterFound, boolean weaponFound, boolean cellVisited)
		{
			this.monsterFound = monsterFound;
			this.weaponFound = weaponFound;
			this.cellVisited = cellVisited;
		}//end Room(boolean, boolean, boolean)
		
		/**
		 * sets cellVisited       
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 * @param cellVisited
		 */
		public void setVisited(boolean cellVisited)
		{
			this.cellVisited = cellVisited;
		}//end setVisited(boolean)
		
		/**
		 * Creates monster if one is found in the cell     
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 * @return
		 */
		public Monster monFound()
		{
			Monster tempMon = new Monster();
			
			if(randomMonster == 2)
			{
				monsterFound = true;
				
				if(randomMonType == 1)
				{
					randomMonNum = 1;
					Monster[] monsters = new Monster[1];
					tempMon = new Cyclops();
				}
				else if(randomMonType == 2)
				{
					Monster[] monsters = new Monster[randomMonNum];
					for(int i=0; i<=randomMonNum-1; i++)
					{
						tempMon = new KingKong();
					}
				}
				else
				{
					Monster[] monsters = new Monster[randomMonNum];
					for(int i=0; i<=randomMonNum-1; i++)
					{
						tempMon = new Frankenstein();
					}
				}
			}
			return tempMon;
		}//end monFound()
		
		/**
		 * creates weapon if found in cell       
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 */
		public void wepFound()
		{
			if(randomWeapon == 3)
			{
				weaponFound = true;
				Weapon[] weapon = new Weapon[1];
				
				if(randomWepType == 1)
				{
					weapon[0] = new Stick();
				}
				else if(randomWepType == 2)
				{
					weapon[0] = new Sword();
				}
			}
		}//end wepFound()
		
		/**
		 * sets playerFound        
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 * @param playerFound
		 */
		public void playerFound(boolean playerFound)
		{
			this.playerFound = playerFound;
		}//end playerFound(boolean)
		
		/**
		 * returns number of monsters in a cell       
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 * @return randomMonNum
		 */
		public int getMonsterNum()
		{
			return randomMonNum;
		}//end getMonsterNum()
		
		/**
		 * toString       
		 *
		 * <hr>
		 * Date created: Jul 27, 2017
		 *
		 * <hr>
		 * @return
		 * @see java.lang.Object#toString()
		 */
		public String toString()
		{
			String cellPrint = "";
			
			if(!cellVisited)
			{
				cellPrint += "|?????|";
			}
			else if(playerFound && monsterFound && weaponFound)
			{
				cellPrint += "|_PWM_|";
			}
			else if(playerFound && monsterFound)
			{
				cellPrint += "|_P_M_|";
			}
			else if(playerFound && weaponFound)
			{
				cellPrint += "|_P_W_|";
			}
			else if(monsterFound && weaponFound)
			{
				cellPrint += "|_M_W_|";
			}
			else if(monsterFound)
			{
				cellPrint += "|__M__|";
			}
			else if(weaponFound)
			{
				cellPrint += "|__W__|";
			}
			else if(playerFound)
			{
				cellPrint += "|__P__|";
			}
			else if(playerFound)
			{
				cellPrint += "|*_P_*|";
			}
			else
			{
				cellPrint += "|_____|";
			}
			
			return cellPrint;
		}//end of toString
}//end Room()