package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; // import the Iterator to use iterator functionality

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	// A list of the active games
	private static List<Game> games = new ArrayList<>();

	// Holds the next game identifier
	private static long nextGameId = 1;

	// Holds the next game identifier
	private static long nextTeamId = 1;

	// Holds the next game identifier
	private static long nextPlayerId = 1;

	// Create an object of GameSerivce
	private static GameService instance = new GameService();

	// private default constructor so that this class cannot be instantiated
	private GameService(){}

	// Public accessor to get the instance
	public static GameService getInstance()
	{
		return instance;
	}

	/**
	 * Construct a new game instance
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// create an iterator for the existing list called games
		Iterator<Game> iterator = games.iterator();
		
		// Iterate over list, and if same name is found return the existing instance
		while (iterator.hasNext())
		{
			// Create a temp game variable
			Game existingGame = iterator.next();
			
			// Check to see if name exists
			if (existingGame.getName() == name)
			{
				return existingGame;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// create an iterator for games
		Iterator<Game> iterator = games.iterator();

		// Iterate over list and if same name is found, return the existing instance
		while (iterator.hasNext())
		{
			// Create a temp game variable
			Game existingGame = iterator.next();
			
			// Check to see if the game id already exists
			if (existingGame.getId() == id)
			{
				return existingGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// create an iterator for games
		Iterator<Game> iterator = games.iterator();

		// Iterate over list and if same name is found, assign the existing instance to local variable
		while (iterator.hasNext())
		{
			// Create a temp game variable
			Game existingGame = iterator.next();
			
			// Check to see if the game id already exists
			if (existingGame.getName() == name)
			{
				// assign existing instance to the game variable
				game = existingGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	// Getter for nextTeamId
	public long getNextTeamId(){return nextTeamId++;}

	// Getter for nextPlayerId
	public long getNextPlayerId(){return nextPlayerId++;}
}
