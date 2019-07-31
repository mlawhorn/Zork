/**
 * ---------------------------------------------------------------------------
 * File name: GameDriver.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Miranda Lawhorn, lawhornm@etsu.edu
 * Course:  CSCI 1260-090
 * Creation Date: Jul 27, 2017
 * ---------------------------------------------------------------------------
 */

package Zork;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Main driver for Zork game
 *
 * <hr>
 * Date created: Jul 27, 2017
 * <hr>
 * @author Miranda Lawhorn
 */
public class GameDriver
{
	/**
	 * Main method
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 * 
	 */
	public static void main (String [ ] args)
	{
		int question;	//holds value for direction prompt
		int	position;	//holds and passes player position
		int	length;		//holds length of dungeon
		
				
		try
		{
			JOptionPane.showMessageDialog(null, "WELCOME TO THE ZORK GAME: \n\n" +
				"In this game, you are exploring a dungeon of with between 5 and 10 cells " +
				"\nThe player begins in the west-most cell and tries to get to " +
				"\nthe east-most cell which contains the dungeon exit." +
				"\nA successful exit from the final cell wins the game." +
				"\nAlong the way, each cell may have a monster that must be defeated." +
				"\nOne cell contains a weapon which may be used on the monster, if any, in that cell." +
				"\n\nThe game continues until the player is defeated by a monster" +
				"\nor until the player successfully exits the east-most cell."+
				"\nIn each cell, a player may move one cell to the east or one cell"+
				"\nto the west, if there is an exit in that direction.");
		
			clearScreen ( );
		
			Dungeon dungeon = new Dungeon();
			
			//create dungeon
			Dungeon.dungeon[0].playerFound(true);
			position = dungeon.player1.getPosition ( );
			length = dungeon.getLength ( );
			
			while(position != (length-1))
			{
				clearScreen();

				//get current position and print out dungeon map
				JOptionPane.showMessageDialog(null, Dungeon.dungeon[position]);

				System.out.println(dungeon.dungeonMap());

				//display an appropriate dialog if a monster or weapon is found in the current cell
				if(Dungeon.dungeon[position].monsterFound || Dungeon.dungeon[position].weaponFound)
				{
					JOptionPane.showMessageDialog(null, dungeon.toString(position));
				}
		
				if(dungeon.player1.getHealth() <= 0)
				{
					JOptionPane.showMessageDialog (null, "Oh no! You died...");
					dungeon.gameOver ( );
				}
					//if in first room, provide option to move forward
					if(position == 0)
					{
						UIManager.put ("OptionPane.yesButtonText", "Yes");
						UIManager.put ("OptionPane.noButtonText", "No");
						question = JOptionPane.showConfirmDialog (null, "Continue to next room?", "", JOptionPane.YES_NO_OPTION);
						if(question == JOptionPane.YES_OPTION)
						{	
							dungeon.player1.movePlayer (1);
						}
						else
						{
							JOptionPane.showMessageDialog (null, "Game Over.");
							dungeon.gameOver ( );
						}	
					}
					//otherwise, give option to move forwards or backwards
					else
					{
						UIManager.put ("OptionPane.yesButtonText", "West");
						UIManager.put ("OptionPane.noButtonText", "East");
						UIManager.put ("OptionPane.cancelButtonText", "Quit");
						question = JOptionPane.showConfirmDialog (null, "Which direction would you like to move?");
						
						if(question == JOptionPane.YES_OPTION)
						{
							dungeon.player1.movePlayer(-1);
						}	
						else if(question == JOptionPane.NO_OPTION)
						{
							dungeon.player1.movePlayer(1);
						}
						else if(question == JOptionPane.CANCEL_OPTION)
						{
							JOptionPane.showMessageDialog (null, "Game Over.");
							dungeon.gameOver ( );
						}
						else if(question == JOptionPane.CLOSED_OPTION)
						{
							JOptionPane.showMessageDialog (null, "Game Over.");
							dungeon.gameOver ( );
						}
					
					}
				
					position = dungeon.player1.getPosition ();
				}
	
			clearScreen();

			JOptionPane.showMessageDialog(null, Dungeon.dungeon[dungeon.getLength()-1]);
			System.out.println(dungeon.dungeonMap());
			System.out.println("######## ##     ## ########    ######## ##    ## ########");
			System.out.println("   ##    ##     ## ##          ##       ###   ## ##     ##");
			System.out.println("   ##    ##     ## ##          ##       ####  ## ##     ##");
			System.out.println("   ##    ######### ######      ######   ## ## ## ##     ##");
			System.out.println("   ##    ##     ## ##          ##       ##  #### ##     ##");
			System.out.println("   ##    ##     ## ##          ##       ##   ### ##     ##");
			System.out.println("   ##    ##     ## ########    ######## ##    ## ########");	
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog (null, "Oops! There seems to be an error \n\n\n " +
					"Error: " + e);
		}

	}//end main(String [])
	
	/**
	 * clears the screen
	 * 
	 * <hr>
	 * Date created: Jul 27, 2017
	 * 
	 */
	public static void clearScreen()
	{
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}//end clearScreen()
}//end GameDriver() 