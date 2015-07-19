import java.awt.Color;


public class Piece_Scout extends Piece{

	public Piece_Scout(int x, int y, Color color, int rank) {
		super(x, y, color, rank);
		// TODO Auto-generated constructor stub
	}
	public boolean move(int starty, int startx, int endy,int endx){
		if(this.color == Color.RED && Game.user_turn == false){
			return false;
		}
		if(this.color == Color.BLUE && Game.user_turn == true){
			return false;
		}
		else if(Game.board[endy][endx].color == Game.board[starty][startx].color){
			System.out.println("That location is occupied by a piece of your own color " + this.color);
			return false;
		}else if(Game.board[endy][endx].rank == 24){ // 24 is the rank of a lake
			return false;
		
		}else if((Math.abs(endy - starty) > 8) || (Math.abs(endx - startx)) > 8 ){ /// MAkes sure the peice is not moving more than on in each direction 
			return false;
		}else if(Math.abs(endy - starty) > 0 && Math.abs(endx - startx) != 0){
			return false;
		}else if(Math.abs(endx - startx) > 0 && Math.abs(endy - starty) != 0){
			return false;
		}else{
			return true;
		}
		
	}
}
