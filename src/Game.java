import java.awt.Color;
import java.util.Scanner;
import java.awt.Graphics;

public class Game {
	
	/// Variable Zoo 
	
	/// This is the size of the 2d Array 
    static int SIZE = 10;
    
    /// Here we initlizize the 2d array as a 10x10 array of type Piece
	static Piece[][] board = new Piece[SIZE][SIZE];
	
	/// This is a boolean used to Identify if a flag has been captured 
	static boolean win = false; 
	
	/// This is a boolean used to keep track of whose turn it is
	static boolean user_turn = true; 
	
	/// This is a Boolean used to identify is the mouse is currently being clicked 
	static boolean click = false;
	
	/// These variables store the x and y pixal locations of the mouse click 
	static int mouse_x;
	static int mouse_y;
	
	/// These Varibales store the pixal locations of where the mouse was released 
	static int mouse_released_x;
	static int mouse_released_y; 
	
	/// These variables store the grid locations of the mouse click. they are computed by dividing the mouse_x and mouse_y
	/// by 80 ( ie the size of each grid in pixals)
	static int intial_x;
	static int intial_y;
	
	///These vaiables store the grid location of the mouse release. They are computed by dividing the Mouse_released_x
	/// and mouse_released_y by 80 (ie the size of the grids in pixals) 
	static int new_x;
	static int new_y;
	
	/// This is an instance of StrategoBoard. it serves of the visablle board of the game. 
	/// this board also holds the mouse liseners for the game. 
	static StrategoBoard GUIboard = new StrategoBoard();
	
	/// This vaiable stores the Piece that the player has clicked on  
	static Piece active_piece;
	
	
	
/*	 This function checks to see if the proposed move is valid; 
	 it is called in StrategoPanel under MouseReleased
	 Parameters: 2d game board
	 inital y and x coordnates of the active peice 
	 the proposed y and x location of the active piece.
	 
	 returns: void 
	
	The function first tests wheather a move is valid, and then rewrites the board array depending on
	wheather the move was valid. */
	
	public static void check_valid(Piece[][] board, int intial_y, int intial_x, int new_y, int new_x){
		
		/// This statment is true if a pieces move function returns true and false otherwise. 

		if (board[intial_y][intial_x].move(intial_y, intial_x, new_y,new_x)){
			/// if attack was successful, we switch out the pieces. 
				
			if (board[intial_y][intial_x].attack(board[new_y][new_x])){
				/// empty new space 
				board[new_y][new_x] = null;
				/// fill new space with active piece 
				active_piece.x = new_x;
				active_piece.y = new_y;
				board[new_y][new_x] = active_piece;
				/// empty the old space and place an empty piece there 
				board[intial_y][intial_x] = null;
				board[intial_y][intial_x] = new Piece(intial_y, intial_x , Color.GREEN, 0);
				
				
			}else{ // If the atack was unsuccesful, remove the active piece.
				board[intial_y][intial_x] = null;
				board[intial_y][intial_x] = new Piece(intial_y, intial_x , Color.GREEN, 0);
				
				if(board[new_y][new_x].rank == 21){/// if the attacked piece was a bomb, remove it 
				board[new_y][new_x] = null;
				board[new_y][new_x] = new Piece(new_y, new_x , Color.GREEN, 0);	
				
				}	
			}/// End of If attack was unsuccessful 


			}else{ /// if the move is not valid, reset the piece 
				active_piece.x = intial_x;
				active_piece.y = intial_y;
				board[intial_y][intial_x] = active_piece;
				System.out.println("Not a valid Move");
			} /// End of Else of the 
			GUIboard.repaint();
			/// Reset the active Piece to null 
			active_piece = null;
			
			/// If the move was valid, the current turn is over and it is the other players turn 
			if (board[intial_y][intial_x].move(intial_y, intial_x, new_y,new_x)){
				if(user_turn){
					user_turn = false;
				}else{
						user_turn = true;
					}
			}

		}// end of Check Valid Method
			
	
	
/*	This is the main mathod of the game 
	
	It starts by creating the 80 Pieces that will be used in the game. 
	It then populated the 2d array with those pieces 
	
	Empty pieces are filled with a Piece with rank zero 
	
	The game then runs in  a while loop until the flag is captured*/
	
	public static void main(String[] args){
		
		/// BLUE PIECE 
		Piece marshal_b = new Piece(0,0,Color.BLUE, 9);
		Piece general_b = new Piece(0,1, Color.BLUE, 8);
		Piece colonel_1b = new Piece(0,2, Color.BLUE, 7);
		Piece colonel_2b = new Piece(0,3, Color.BLUE, 7);
		Piece major_1b = new Piece(0,4, Color.BLUE, 6);
		Piece major_2b = new Piece(0,5, Color.BLUE, 6);
		Piece major_3b = new Piece(0,6, Color.BLUE, 6);
		Piece captain_1b = new Piece(0,7, Color.BLUE, 5);
		Piece captain_2b = new Piece(0,8, Color.BLUE, 5);
		Piece captain_3b = new Piece(0,9, Color.BLUE, 5);
		Piece captain_4b = new Piece(1,0, Color.BLUE, 5);
		Piece lieutenant_1b = new Piece(1,1,Color.BLUE, 4);
		Piece lieutenant_2b = new Piece(1,2,Color.BLUE, 4);
		Piece lieutenant_3b = new Piece(1,3,Color.BLUE, 4);
		Piece lieutenant_4b = new Piece(1,4,Color.BLUE, 4);
		Piece sargent_1b = new Piece(1,5, Color.BLUE, 3);
		Piece sargent_2b = new Piece(1,6, Color.BLUE, 3);
		Piece sargent_3b = new Piece(1,7, Color.BLUE, 3);
		Piece sargent_4b = new Piece(1,8, Color.BLUE, 3);
		Piece miner_1b = new Piece_Miner(1,9, Color.BLUE, 2);
		Piece miner_2b = new Piece_Miner(2,0, Color.BLUE, 2);
		Piece miner_3b = new Piece_Miner(2,1, Color.BLUE, 2);
		Piece miner_4b = new Piece_Miner(2,2, Color.BLUE, 2);
		Piece miner_5b = new Piece_Miner(2,3, Color.BLUE, 2);
		Piece scout_1b = new Piece_Scout(2,4, Color.BLUE, 1);
		Piece scout_2b = new Piece_Scout(2,5, Color.BLUE, 1);
		Piece scout_3b = new Piece_Scout(2,6, Color.BLUE, 1);
		Piece scout_4b = new Piece_Scout(2,7, Color.BLUE, 1);
		Piece scout_5b = new Piece_Scout(2,8, Color.BLUE, 1);
		Piece scout_6b = new Piece_Scout(2,9, Color.BLUE, 1);
		Piece scout_7b = new Piece_Scout(3,0, Color.BLUE, 1);
		Piece scout_8b = new Piece_Scout(3,1, Color.BLUE, 1);
		Piece spy_b = new Piece(3,2, Color.BLUE, 25);
		Piece_NoMove bomb_1b = new Piece_NoMove(3,3, Color.BLUE, 21);
		Piece_NoMove bomb_2b = new Piece_NoMove(3,4, Color.BLUE, 21);
		Piece_NoMove bomb_3b = new Piece_NoMove(3,5, Color.BLUE, 21);
		Piece bomb_4b = new Piece_NoMove(3,6, Color.BLUE, 21);
		Piece bomb_5b = new Piece_NoMove(3,7, Color.BLUE, 21);
		Piece bomb_6b = new Piece_NoMove(3,8, Color.BLUE, 21);
		Piece flagb = new Piece_NoMove(3,9, Color.BLUE, 23);
		
		/// Red Pieces 
		Piece marshal = new Piece(6,0,Color.RED, 9);
		Piece general = new Piece(6,1, Color.RED, 8);
		Piece colonel_1 = new Piece(6,2, Color.RED, 7);
		Piece colonel_2 = new Piece(6,3, Color.RED, 7);
		Piece major_1 = new Piece(6,4, Color.RED, 6);
		Piece major_2 = new Piece(6,5, Color.RED, 6);
		Piece major_3 = new Piece(6,6, Color.RED, 6);
		Piece captain_1 = new Piece(6,7, Color.RED, 5);
		Piece captain_2 = new Piece(6,8, Color.RED, 5);
		Piece captain_3 = new Piece(6,9, Color.RED, 5);
		Piece captain_4 = new Piece(7,0, Color.RED, 5);
		Piece lieutenant_1 = new Piece(7,1,Color.RED, 4);
		Piece lieutenant_2 = new Piece(7,2,Color.RED, 4);
		Piece lieutenant_3 = new Piece(7,3,Color.RED, 4);
		Piece lieutenant_4 = new Piece(7,4,Color.RED, 4);
		Piece sargent_1 = new Piece(7,5, Color.RED, 3);
		Piece sargent_2 = new Piece(7,6, Color.RED, 3);
		Piece sargent_3 = new Piece(7,7, Color.RED, 3);
		Piece sargent_4 = new Piece(7,8, Color.RED, 3);
		Piece miner_1 = new Piece_Miner(7,9, Color.RED, 2);
		Piece miner_2 = new Piece_Miner(8,0, Color.RED, 2);
		Piece miner_3 = new Piece_Miner(8,1, Color.RED, 2);
		Piece miner_4 = new Piece_Miner(8,2, Color.RED, 2);
		Piece miner_5 = new Piece_Miner(8,3, Color.RED, 2);
		Piece scout_1 = new Piece_Scout(8,4, Color.RED, 1);
		Piece scout_2 = new Piece_Scout(8,5, Color.RED, 1);
		Piece scout_3 = new Piece_Scout(8,6, Color.RED, 1);
		Piece scout_4 = new Piece_Scout(8,7, Color.RED, 1);
		Piece scout_5 = new Piece_Scout(8,8, Color.RED, 1);
		Piece scout_6 = new Piece_Scout(8,9, Color.RED, 1);
		Piece scout_7 = new Piece_Scout(9,0, Color.RED, 1);
		Piece scout_8 = new Piece_Scout(9,1, Color.RED, 1);
		Piece spy = new Piece(9,2, Color.RED, 25);
		Piece bomb_1 = new Piece_NoMove(9,3, Color.RED, 21);
		Piece bomb_2 = new Piece_NoMove(9,4, Color.RED, 21);
		Piece bomb_3 = new Piece_NoMove(9,5, Color.RED, 21);
		Piece bomb_4 = new Piece_NoMove(9,6, Color.RED, 21);
		Piece bomb_5 = new Piece_NoMove(9,7, Color.RED, 21);
		Piece bomb_6 = new Piece_NoMove(9,8, Color.RED, 21);
		Piece flag = new Piece_NoMove(9,9, Color.RED, 23);
		

		
		/// Lakes 
		Piece lake_1 = new Piece_NoMove(4,2, Color.CYAN, 24);
		Piece lake_2 = new Piece_NoMove(5,2, Color.CYAN, 24);
		Piece lake_3 = new Piece_NoMove(4,3, Color.CYAN, 24);
		Piece lake_4 = new Piece_NoMove(5,3, Color.CYAN, 24);
		
		Piece lake_5 = new Piece_NoMove(4,6, Color.CYAN, 24);
		Piece lake_6 = new Piece_NoMove(5,6, Color.CYAN, 24);
		Piece lake_7 = new Piece_NoMove(4,7, Color.CYAN, 24);
		Piece lake_8 = new Piece_NoMove(5,7, Color.CYAN, 24);
		
		
		/// Add all the peices to the board
		
		///Ren Peice 
		board[marshal.y][marshal.x]= marshal;
		board[general.y][general.x] = general;
		board[colonel_1.y][colonel_1.x] = colonel_1;
		board[colonel_2.y][colonel_2.x] = colonel_2;
		board[major_1.y][major_1.x] = major_1;
		board[major_2.y][major_2.x] = major_2;
		board[major_3.y][major_3.x] = major_3;
		board[captain_1.y][captain_1.x] = captain_1;
		board[captain_2.y][captain_2.x] = captain_2;
		board[captain_3.y][captain_3.x] = captain_3;
		board[captain_4.y][captain_4.x] = captain_4;
		board[lieutenant_1.y][lieutenant_1.x] = lieutenant_1;
		board[lieutenant_2.y][lieutenant_2.x] = lieutenant_2;
		board[lieutenant_3.y][lieutenant_3.x] = lieutenant_3;
		board[lieutenant_4.y][lieutenant_4.x] = lieutenant_4;
		board[sargent_1.y][sargent_1.x] = sargent_1;
		board[sargent_2.y][sargent_2.x] = sargent_2;
		board[sargent_3.y][sargent_3.x] = sargent_3;
		board[sargent_4.y][sargent_4.x] = sargent_4;
		board[miner_1.y][miner_1.x] = miner_1;
		board[miner_2.y][miner_2.x] = miner_2;
		board[miner_3.y][miner_3.x] = miner_3;
		board[miner_4.y][miner_4.x] = miner_4;
		board[miner_5.y][miner_5.x] = miner_5;
		board[scout_1.y][scout_1.x] = scout_1;
		board[scout_2.y][scout_2.x] = scout_2;
		board[scout_3.y][scout_3.x] = scout_3;
		board[scout_4.y][scout_4.x] = scout_4;
		board[scout_5.y][scout_5.x] = scout_5;
		board[scout_6.y][scout_6.x] = scout_6;
		board[scout_7.y][scout_7.x] = scout_7;
		board[scout_8.y][scout_8.x] = scout_8;
		board[spy.y][spy.x] = spy;
		board[bomb_1.y][bomb_1.x] = bomb_1;
		board[bomb_2.y][bomb_2.x] = bomb_2;
		board[bomb_3.y][bomb_3.x] = bomb_3;
		board[bomb_4.y][bomb_4.x] = bomb_4;
		board[bomb_5.y][bomb_5.x] = bomb_5;
		board[bomb_6.y][bomb_6.x] = bomb_6;
		board[flag.y][flag.x] = flag;
		
		board[marshal_b.y][marshal_b.x]= marshal_b;
		board[general_b.y][general_b.x] = general_b;
		board[colonel_1b.y][colonel_1b.x] = colonel_1b;
		board[colonel_2b.y][colonel_2b.x] = colonel_2b;
		board[major_1b.y][major_1b.x] = major_1b;
		board[major_2b.y][major_2b.x] = major_2b;
		board[major_3b.y][major_3b.x] = major_3b;
		board[captain_1b.y][captain_1b.x] = captain_1b;
		board[captain_2b.y][captain_2b.x] = captain_2b;
		board[captain_3b.y][captain_3b.x] = captain_3b;
		board[captain_4b.y][captain_4b.x] = captain_4b;
		board[lieutenant_1b.y][lieutenant_1b.x] = lieutenant_1b;
		board[lieutenant_2b.y][lieutenant_2b.x] = lieutenant_2b;
		board[lieutenant_3b.y][lieutenant_3b.x] = lieutenant_3b;
		board[lieutenant_4b.y][lieutenant_4b.x] = lieutenant_4b;
		board[sargent_1b.y][sargent_1b.x] = sargent_1b;
		board[sargent_2b.y][sargent_2b.x] = sargent_2b;
		board[sargent_3b.y][sargent_3b.x] = sargent_3b;
		board[sargent_4b.y][sargent_4b.x] = sargent_4b;
		board[miner_1b.y][miner_1b.x] = miner_1b;
		board[miner_2b.y][miner_2b.x] = miner_2b;
		board[miner_3b.y][miner_3b.x] = miner_3b;
		board[miner_4b.y][miner_4b.x] = miner_4b;
		board[miner_5b.y][miner_5b.x] = miner_5b;
		board[scout_1b.y][scout_1b.x] = scout_1b;
		board[scout_2b.y][scout_2b.x] = scout_2b;
		board[scout_3b.y][scout_3b.x] = scout_3b;
		board[scout_4b.y][scout_4b.x] = scout_4b;
		board[scout_5b.y][scout_5b.x] = scout_5b;
		board[scout_6b.y][scout_6b.x] = scout_6b;
		board[scout_7b.y][scout_7b.x] = scout_7b;
		board[scout_8b.y][scout_8b.x] = scout_8b;
		board[spy_b.y][spy_b.x] = spy_b;
		board[bomb_1b.y][bomb_1b.x] = bomb_1b;
		board[bomb_2b.y][bomb_2b.x] = bomb_2b;
		board[bomb_3b.y][bomb_3b.x] = bomb_3b;
		board[bomb_4b.y][bomb_4b.x] = bomb_4b;
		board[bomb_5b.y][bomb_5b.x] = bomb_5b;
		board[bomb_6b.y][bomb_6b.x] = bomb_6b;
		board[flagb.y][flagb.x] = flagb;
		
		/// Add lakes to borad 
		board[lake_1.y][lake_1.x] = lake_1;
		board[lake_2.y][lake_2.x] = lake_2;
		board[lake_3.y][lake_3.x] = lake_3;
		board[lake_4.y][lake_4.x] = lake_4;
		board[lake_5.y][lake_5.x] = lake_5;
		board[lake_6.y][lake_6.x] = lake_6;
		board[lake_7.y][lake_7.x] = lake_7;
		board[lake_8.y][lake_8.x] = lake_8;
		
		
		
		/// fill in extra spaces 
		for (int i = 0; i <= 9; i ++){
			for (int j = 0; j <= 9; j ++){
				if (board[i][j] == null){
					board[i][j] = new Piece(i, j , Color.GREEN, 0);
				}
			}
		}
		
		/// repaint the board 
		GUIboard.repaint();
		
		while (win == false){
			
			if (user_turn == true){
				
				System.out.println("USER");
				
			}else{
				
				System.out.println("COMPUTER");
				
				
			}
			
		}/// While loop 
		
		System.out.print("THE WAR IS WON");
	} /// Main 
	
}/// Class 

