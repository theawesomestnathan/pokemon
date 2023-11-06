import java.util.Scanner;
import java.util.ArrayList;

class Pokemon {
  // Declaring the instance variables
  private String name, type;
  private float health; // Float because the health of a Pokemon is in decimal form
  private int level;

  public Pokemon(String name, String type, float health, int level) {
    setName(name);
    setType(type);
    setHealth(health);
    setLevel(level);
  }

  public Pokemon() {}

  // Getters and Setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public float getHealth() {
    return this.health;
  }

  public void setHealth(float health) {
    this.health = health;
  }

  public int getLevel() {
    return this.level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void attack(Pokemon enemy) {
    System.out.println("Go " + getName() + "!");
    enemy.setHealth(enemy.getHealth() - 5);
  }
}

// Types of Pokemon

class Fire extends Pokemon {
  Fire(String name, float health, int level) {
    super(name, "Fire", health, level);
  }

  // The override isn't needed, but it helps
  @Override
  public void attack(Pokemon enemy) {
    System.out.println("Go, " + enemy.getName() + " ");

    // Taking damage depending of the type in the enemy
    if (enemy.getType() == "Fire") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
    else if (enemy.getType() == "Water") {
      System.out.println("That was not that effective...");
      enemy.setHealth(enemy.getHealth() - 1);
    }
    else if (enemy.getType() == "Grass") {
      System.out.println("That was very effective!");
      enemy.setHealth(enemy.getHealth() - 10);
    }
    else if (enemy.getType() == "Electric") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
  }
}

// We repeat the same thing for the other types

class Water extends Pokemon {
  Water(String name, float health, int level) {
    super(name, "Water", health, level);
  }

  @Override
  public void attack(Pokemon enemy) {
    System.out.println("Go, " + enemy.getName() + " ");

    if (enemy.getType() == "Fire") {
      System.out.println("That was very effective!");
      enemy.setHealth(enemy.getHealth() - 10);
    }
    else if (enemy.getType() == "Water") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
    else if (enemy.getType() == "Grass") {
      System.out.println("That was not that effective...");
      enemy.setHealth(enemy.getHealth() - 1);
    }
    else if (enemy.getType() == "Electric") {
      System.out.println("That was not that effective...");
      enemy.setHealth(enemy.getHealth() - 1);
    }
  }
}

class Grass extends Pokemon {
  Grass(String name, float health, int level) {
    super(name, "Grass", health, level);
  }

  @Override
  public void attack(Pokemon enemy) {
    System.out.println("Go, " + enemy.getName() + " ");

    if (enemy.getType() == "Fire") {
      System.out.println("That was not that effective...");
      enemy.setHealth(enemy.getHealth() - 1);
    }
    else if (enemy.getType() == "Water") {
      System.out.println("That was very effective!");
      enemy.setHealth(enemy.getHealth() - 10);
    }
    else if (enemy.getType() == "Grass") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
    else if (enemy.getType() == "Electric") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
  }
}

class Electric extends Pokemon {
  Electric(String name, float health, int level) {
    super(name, "Electric", health, level);
  }

  @Override
  public void attack(Pokemon enemy) {
    System.out.println("Go, " + enemy.getName() + " ");

    if (enemy.getType() == "Fire") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
    else if (enemy.getType() == "Water") {
      System.out.println("That was very effective!");
      enemy.setHealth(enemy.getHealth() - 10);
    }
    else if (enemy.getType() == "Grass") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
    else if (enemy.getType() == "Electric") {
      System.out.println("That was effective!");
      enemy.setHealth(enemy.getHealth() - 5);
    }
  }
}

class Trainer {
  private String name;
  private ArrayList<Pokemon> team = new ArrayList<Pokemon>();

  Trainer(String name) {
    setName(name);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Pokemon> getTeam() {
    return this.team;
  }

  public void setTeam(ArrayList<Pokemon> team) {
    this.team = team;
  }
}

public class Main {
	public static void main(String[] args) {
		Trainer player1 = new Trainer("Nathan");
		Trainer player2 = new Trainer("Emman");
		
		Fire charmander = new Fire("Charmander", 100, 1);
		Grass moomoograsseater = new Grass("Moo Moo Grass Eater", 100, 1);
		Fire blaziken = new Fire("Blaziken", 100, 1);
		Fire spicyhotchickenwing = new Fire("Spicy Hot Chicken Wing", 100, 1);
		
		player1.getTeam().add(charmander);
		player1.getTeam().add(moomoograsseater);
		player2.getTeam().add(blaziken);
		player2.getTeam().add(spicyhotchickenwing);
		
		start(player1, player2);
	}
	
	public static void start(Trainer player1, Trainer player2) {
		Scanner sc = new Scanner(System.in);
		
		//Check if game is over
		boolean isGameOver = false;
		
		//Check if player 1 is ready
		boolean isPlayer1Ready = false;
		
		//Check if player 2 is ready
		boolean isPlayer2Ready = false;
		
		//Placeholder for player 1's pokemon
		Pokemon p1Choosed = new Pokemon("", "", 100, 1);
		
		//Placeholder for player 2's pokemon
		Pokemon p2Choosed = new Pokemon("", "", 100, 1);
		
		//Placeholder for the game message
		String msg = " ";
		
		//Switch player turns
		int playerTurn = 1;
		
		while(!isGameOver) {
			if (playerTurn % 2 == 0) {
				//Player 2's turn
				if (!isPlayer2Ready) { // If player 2 is not ready
					int choice = 0;
					//Choose a pokemon
					
						System.out.println("Choose a pokemon:");
						for (Pokemon p : player2.getTeam()) {
							//Print healthy pokemons
							if (p.getHealth() > 0) {
								System.out.println(p.getName());
							}
						}
						choice = sc.nextInt();
						//Checks if user chose a healthy pokemon
						if (player2.getTeam().get(choice).getHealth() == 0) {
							System.out.println(player2.getTeam().get(choice).getName() + " has fainted.");
						}
						else {
							p2Choosed = player2.getTeam().get(choice);
							isPlayer2Ready = true;
						}
					
				
				}
				else if (isPlayer2Ready && p2Choosed.getHealth() == 0) { //If player 2 is ready and his chosen pokemon has fainted
					int choice = 0;
					//Pokemon faints so choose another pokemon
					while(p2Choosed.getHealth() == 0) { //Loops the user input if user chose a dead pokemon
						System.out.println(p2Choosed.getName() + " has fainted. Choose another pokemon.");
						for (Pokemon p : player2.getTeam()) {
							//Prints healthy pokemons
							if (p.getHealth() > 0) {
								System.out.println(p.getName());
							}
						}
						choice = sc.nextInt();
						//Checks if the chosen pokemon is healthy
						if (player2.getTeam().get(choice).getHealth() == 0) {
							System.out.println(player2.getTeam().get(choice).getName() + " has fainted.");
						}
						else {
							p2Choosed = player2.getTeam().get(choice);
						}
					}
					
					
				}
				else {//Player 2 is ready to battle
					
					if (isPlayer1Ready) { //If player 1 is ready to battle as well
						p2Choosed.attack(p1Choosed); //attack
					}
					else { //Wait a sec
						System.out.println("Player 1 is not ready");
					}
				}
				
				
			}
			else {
				//Player 1's turn
			
				if (!isPlayer1Ready) {
					int choice = 0;
					//Choose a pokemon
					
						System.out.println("Choose a pokemon:");
						for (Pokemon p : player1.getTeam()) {
							if (p.getHealth() > 0) {
								System.out.println(p.getName());
							}
						}
						choice = sc.nextInt();
						if (player1.getTeam().get(choice).getHealth() == 0) {
							System.out.println(player1.getTeam().get(choice).getName() + " has fainted.");
						}
						else {
							p1Choosed = player1.getTeam().get(choice);
							isPlayer1Ready = true;
						}
					
				
				}
				else if (isPlayer1Ready && p1Choosed.getHealth() == 0) {
					int choice = 0;
					//Pokemon faints so choose another pokemon
					while(p1Choosed.getHealth() == 0) {
						System.out.println(p1Choosed.getName() + " has fainted. Choose another pokemon.");
						for (Pokemon p : player1.getTeam()) {
							if (p.getHealth() > 0) {
								System.out.println(p.getName());
							}
						}
						choice = sc.nextInt();
						
						if (player1.getTeam().get(choice).getHealth() > 0) {
							p1Choosed = player1.getTeam().get(choice);
						}
						
					}
					
					
				}
				else {
					if (isPlayer2Ready) {
						p1Choosed.attack(p2Choosed);
					}
					else {
						System.out.println("Player 2 is not ready");
					}
				}
				
			}
			
			//Check if player 1 ran out of pokemon
			for (Pokemon p : player1.getTeam()) {
				if (p.getHealth() == 0) {
					isGameOver = true;
					msg = player2.getName() + " wins!"; //player 2 wins
				}
				else {
					isGameOver = false;
					break;
				}
			}
			
			//Check if player 2 ran out of pokemon
			for (Pokemon p : player2.getTeam()) {
				if (p.getHealth() == 0) {
					isGameOver = true;
					msg = player1.getName() + " wins!"; //Player 1 wins
				}
				else {
					isGameOver = false;
					break;
				}
			}
			
			if (isGameOver) { //If the game is really over
				System.out.println(msg); //Print message
			}
			
			playerTurn -= 3; //Switch between 1 and 2
			System.out.println(); // Prints new line
		}
	}
}