import java.awt.Color;


public class Piece_Spy extends Piece{

	public Piece_Spy(int x, int y, Color color, int rank) {
		super(x, y, color, rank);
	}
	
	@Override
	public boolean attack(Piece other){
		if (this.rank > other.rank || other.rank == 9 || other.rank == 23){
			if (other.rank != 0){
			System.out.println("This piece has Won the deul! HAZZAH!");
			}
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
