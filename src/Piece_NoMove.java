import java.awt.Color;


public class Piece_NoMove extends Piece{

	public Piece_NoMove(int x, int y, Color color, int rank) {
		super(x, y, color, rank);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean move(int startx,int starty, int endx, int endy){
		return false;
		
	}

}
