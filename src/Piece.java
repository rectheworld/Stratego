import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/*This is the Generic Piece Class

it contains methods to validdate proposed moves 
and to attack other pieces */
public class Piece {
	int x;
	int y;
	Color color;
	int rank;
	String name;
	
/*	The constructor takes four arguments, the y location of the peice in the board array 
	and the x location of the piece in the board array, the color of the oiece, and the peices rank */
	public Piece(int y, int x, Color color, int rank){
		this.y = y;
		this.x = x;
		this.color = color;
		this.rank = rank; 
		
		
		/// this next bit of the constructor determines the name that is displayed in the GUI 
		if (this.rank == 21){
			name = "Bomb";
		}else if(this.rank == 25){
			name = "Spy";
		}else if(this.rank == 23){
			name = "Flag";
		}else if(this.rank == 24){
			name = "Lake";
		}else{
			name = String.valueOf(this.rank);
		}
		
		
				
	}
	
	
/*	This next method displays the peice on the board.
	Parameters: Graphics g 
	Returns: Void 
	
	It is called in stratego panel */
	public void drawPiece(Graphics g){
		g.setColor(this.color);
		g.fillRoundRect((this.x * 80) + 20, (this.y * 80) + 20, 60, 60, 15, 15);
		
		g.setColor(Color.black);
		
		g.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		g.drawString(this.name, (this.x * 80) + 30, (this.y * 80) + 50);
		
	}
	
/*	This next function determines if a proposed move is valid 
	
	Parameters: y and x inital position in the board array, proposed y and x position in the board array 
	Returns true or false 
	
	This function is called in the Game class under the check_valid method 
	*/
	public boolean move(int starty, int startx, int endy,int endx){
		/// These next two if staments return false if it is not the players turn 
		if(this.color == Color.RED && Game.user_turn == false){
			return false;
		}
		if(this.color == Color.BLUE && Game.user_turn == true){
			return false;
		/// This next if stament returns false if you try to move into a space occupied by your own color 
		}else if(Game.board[endy][endx].color == Game.board[starty][startx].color){
			System.out.println("That location is occupied by a piece of your own color " + this.color);
			return false;
		/// This next if stament prevents player from moving into a lake 
		}else if(Game.board[endy][endx].rank == 24){ // 24 is the rank of a lake
			return false;
		/// Piece cannot move more than one space away 
		}else if((Math.abs(endy - starty) > 1) || (Math.abs(endx - startx)) > 1 ){ /// MAkes sure the peice is not moving more than on in each direction 
			return false;
		/// Piece cannot move diagnal 
		}else if(Math.abs(endy - starty) + Math.abs(endx - startx) > 1){
			return false;
		}else{
			return true;
		}
		
	}
	
/*	This next function detemines which peice survives when there is a battle
	
	Parameters Other object of type piece 
	Returns: Boolean true or false 
	*/
	public boolean attack(Piece other){
		if (this.rank >= other.rank || other.rank == 23){ /// Rank 23 is the rank of the Flag 
			if (other.rank != 0){
			System.out.println("This piece has Won the deul! HAZZAH!");
			}
			/// Check for a Win 
			if (other.rank == 23){
				Game.win = true;
			}
			
			return true;
		}else{
			System.out.println("This piece has lost, he will be remembered by all");
			return false;
		}
		
	}
}
