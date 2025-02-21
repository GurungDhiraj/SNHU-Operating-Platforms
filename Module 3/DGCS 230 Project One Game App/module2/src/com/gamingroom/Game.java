package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{

	private List<Team> teams = new ArrayList<>();

	// Constructor with an identifier and name
	public Game(long id, String name) {
		super(id, name);
	}

	public Team addTeam(String name)
	{
		// Local instance of Team
		Team team = null;

		// create an iterator for the existing list called teams
		Iterator<Team> iterator = teams.iterator();

		// Iterate over list, and if same team is found return the existing instance
		while (iterator.hasNext())
		{
			// Create a temp Team variable
			Team tempTeam = iterator.next();
			
			// Check to see if name exists
			if (tempTeam.getName() == name)
			{
				return tempTeam;
			}
		}

		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			team = new Team(GameService.getInstance().getNextPlayerId(), name);
			teams.add(team);
		}

		// return the new/existing team instance to the caller
		return team;
	}

	@Override
	public String toString() 
	{
		return "Player [id=" + getId() + ", name=" + getName() + "]";	
	}

}
