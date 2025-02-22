package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	// Create a list to hold the name of players
	private static List<Player> players = new ArrayList<>();

	// Constructor with an identifier and name
	public Team(long id, String name) {
		super(id,name);
	}

	public Player addPlayer(String name)
	{
		// Local instance of Player
		Player player = null;

		// create an iterator for the existing list called players
		Iterator<Player> iterator = players.iterator();

		// Iterate over list, and if same player is found return the existing instance
		while (iterator.hasNext())
		{
			// Create a temp Player variable
			Player tempPlayer = iterator.next();
			
			// Check to see if name exists
			if (tempPlayer.getName() == name)
			{
				return tempPlayer;
			}
		}

		// if not found, make a new player instance and add to list of players
		if (player == null) {
			player = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(player);
		}

		// return the new/existing player instance to the caller
		return player;
	}

	@Override
	public String toString() 
	{
		return "Player [id=" + getId() + ", name=" + getName() + "]";	
	}
}
