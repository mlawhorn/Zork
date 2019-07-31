/**
 * ---------------------------------------------------------------------------
 * File name: StarterRoom.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Miranda Lawhorn, lawhornm@etsu.edu
 * Course:  CSCI 1260-090
 * Creation Date: Jul 27, 2017
 * ---------------------------------------------------------------------------
 */

package Zork;


/**
 *creates starting room in a dungeon 
 *
 * <hr>
 * Date created: Jul 27, 2017
 * <hr>
 * @author Miranda Lawhorn
 */
public class StarterRoom extends Room
{
	public boolean playerFound = true; //sets player in first room for start
	
	/**
	 * default constructor       
	 *
	 * <hr>
	 * Date created: Jul 27, 2017
	 *
	 * <hr>
	 */
	public StarterRoom ( )
	{
		super(false, false, true);
	}//end StarterRoom()
}//end StarterRoom()