import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

/// This is the brown 

public class StrategoPanel extends JPanel implements MouseMotionListener, MouseListener{
	
	//Variables
	private static final long serialVersionUID = 1L;
	///public StrategoPieces piece ;
	//public Colision col;
		
//-----------------------------------------------------------------------------------------------------------------	
	//Blue tiles of the fist line 
/*	public int X11 = 20,     Y11 = 20,  X12 = 100,     Y12 = 20;
*/
	
	public  static final int WIDTH  = 1000;
	public  static final int HEIGHT = 840;
	
	public StrategoPanel (){ // constructor beginning
				
		addMouseMotionListener (this); // adding the functionality of the mouse 
		addMouseListener(this);   	// adding the functiionality of the mouse 
		
		
	}//end of the constructor 
	
	// Paint method begins
	
	public void paint (Graphics g){

		
		super.paint(g);
		//this.setBackground(Color.Blue);
		
		g.setColor(new Color(102,51,0));
		g.fillRect(0,0, 1000, 1000);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(830, 0, 600, 1100);
		
		//TILED BOEARD 
		//first line
		g.setColor(Color.white);
		g.drawRect(10, 10, 80, 80);
		g.drawRect(90,10, 80, 80);
		g.drawRect(170, 10, 80, 80);
		g.drawRect(250, 10, 80, 80);
		g.drawRect(330, 10, 80, 80);
		g.drawRect(410, 10, 80, 80);
		g.drawRect(490, 10, 80, 80);
		g.drawRect(570, 10, 80, 80);
		g.drawRect(650, 10, 80, 80);
		g.drawRect(730, 10, 80, 80);
	
		//second line
		g.setColor(Color.white);
		g.drawRect(10, 90, 80, 80);
		g.drawRect(90,90, 80, 80);
		g.drawRect(170, 90, 80, 80);
		g.drawRect(250, 90, 80, 80);
		g.drawRect(330, 90, 80, 80);
		g.drawRect(410, 90, 80, 80);
		g.drawRect(490, 90, 80, 80);
		g.drawRect(570, 90, 80, 80);
		g.drawRect(650, 90, 80, 80);
		g.drawRect(730, 90, 80, 80);
	
		//third line
		g.setColor(Color.white);
		g.drawRect(10, 170, 80, 80);
		g.drawRect(90, 170, 80, 80);
		g.drawRect(170,170, 80, 80);
		g.drawRect(250,170, 80, 80);
		g.drawRect(330,170, 80, 80);
		g.drawRect(410,170, 80, 80);
		g.drawRect(490, 170, 80, 80);
		g.drawRect(570, 170, 80, 80);
		g.drawRect(650, 170, 80, 80);
		g.drawRect(730, 170, 80, 80);
	
		//Fourth line
		g.setColor(Color.white);
		g.drawRect(10, 250, 80, 80);
		g.drawRect(90, 250, 80, 80);
		g.drawRect(170,250, 80, 80);
		g.drawRect(250,250, 80, 80);
		g.drawRect(330,250, 80, 80);
		g.drawRect(410,250, 80, 80);
		g.drawRect(490,250, 80, 80);
		g.drawRect(570,250, 80, 80);
		g.drawRect(650,250, 80, 80);
		g.drawRect(730,250, 80, 80);
		
		//fourth line
		g.setColor(Color.white);
		g.drawRect(10, 330, 80, 80);
		g.drawRect(90, 330, 80, 80);
		g.drawRect(170,330, 80, 80);
		g.drawRect(250,330, 80, 80);
		g.drawRect(330,330, 80, 80);
		g.drawRect(410,330, 80, 80);
		g.drawRect(490, 330, 80, 80);
		g.drawRect(570, 330, 80, 80);
		g.drawRect(650, 330, 80, 80);
		g.drawRect(730, 330, 80, 80);
		
		//fifth line
		g.setColor(Color.white);
		g.drawRect(10, 410, 80, 80);
		g.drawRect(90, 410, 80, 80);
		g.drawRect(170,410, 80, 80);
		g.drawRect(250,410, 80, 80);
		g.drawRect(330,410, 80, 80);
		g.drawRect(410,410, 80, 80);
		g.drawRect(490,410, 80, 80);
		g.drawRect(570,410, 80, 80);
		g.drawRect(650,410, 80, 80);
		g.drawRect(730,410, 80, 80);
	
		//Sixth line
		g.setColor(Color.white);
		g.drawRect(10,490, 80, 80);
		g.drawRect(90,490, 80, 80);
		g.drawRect(170,490, 80, 80);
		g.drawRect(250,490, 80, 80);
		g.drawRect(330,490, 80, 80);
		g.drawRect(410,490, 80, 80);
		g.drawRect(490,490, 80, 80);
		g.drawRect(570,490, 80, 80);
		g.drawRect(650,490, 80, 80);
		g.drawRect(730,490, 80, 80);
		
		
		//Sevenline
		g.setColor(Color.white);
		g.drawRect(10, 570, 80, 80);
		g.drawRect(90, 570, 80, 80);
		g.drawRect(170,570, 80, 80);
		g.drawRect(250,570, 80, 80);
		g.drawRect(330,570, 80, 80);
		g.drawRect(410,570, 80, 80);
		g.drawRect(490, 570, 80, 80);
		g.drawRect(570, 570, 80, 80);
		g.drawRect(650, 570, 80, 80);
		g.drawRect(730, 570, 80, 80);
	
		//Eight line
		g.setColor(Color.white);
		g.drawRect(10, 650, 80, 80);
		g.drawRect(90, 650, 80, 80);
		g.drawRect(170,650, 80, 80);
		g.drawRect(250,650, 80, 80);
		g.drawRect(330,650, 80, 80);
		g.drawRect(410,650, 80, 80);
		g.drawRect(490,650, 80, 80);
		g.drawRect(570,650, 80, 80);
		g.drawRect(650,650, 80, 80);
		g.drawRect(730,650, 80, 80);
	
		//Nine line
		g.setColor(Color.white);
		g.drawRect(10, 730, 80, 80);
		g.drawRect(90, 730, 80, 80);
		g.drawRect(170,730, 80, 80);
		g.drawRect(250,730, 80, 80);
		g.drawRect(330,730, 80, 80);
		g.drawRect(410,730, 80, 80);
		g.drawRect(490,730, 80, 80);
		g.drawRect(570,730, 80, 80);
		g.drawRect(650,730, 80, 80);
		g.drawRect(730,730, 80, 80);
		
		

		
	
		//Blue tiles 
		///g.setColor(Color.blue);
		///piece.Blue11_piece(g); /// Draws peice 
/*		piece.Blue12_piece(g);
*/	
		for (int i = 0; i <= 9; i ++){
			for (int j = 0; j <= 9; j ++){
				if (Game.board[i][j].rank > 0){
				g.setColor(Game.board[i][j].color);
				Game.board[i][j].drawPiece(g);
				}
			}
		}
		///keep image tearing 
		repaint();
		
		g.dispose();
		this.setSize(WIDTH,HEIGHT);
	}/// end of paint function 
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub  
/*		if(e.getX() > col.BallX11 && e.getX() < col.BallX11 + col.Ball11.width && 
		   e.getY() > col.BallY11 && e.getY() < col.BallY11 + col.Ball11.height){
			///sqaure11    =   true;
			///heightlight11 = true;
		}*/
		Game.click = true;
		
		int mouse_x = e.getX();
		int mouse_y = e.getY();
		Game.mouse_x = e.getX();
		Game.mouse_y = e.getY();
		
		Game.intial_x = mouse_x / 80;
		Game.intial_y = mouse_y / 80;

		Game.active_piece = Game.board[Game.intial_y][Game.intial_x];
		
		Game.GUIboard.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Game.mouse_released_x = e.getX() -34;
		Game.mouse_released_y = e.getY() - 34;
		// TODO Auto-generated method stub
		//// Move pieces here is they can move
		// board[endx[oldy]=board[startx[starty]
		//board[atartx[starty]=null
		
		Game.new_x = Game.mouse_released_x / 80;
		Game.new_y = Game.mouse_released_y / 80;
		Game.check_valid(Game.board, Game.intial_y, Game.intial_x, Game.new_y, Game.new_x);
		Game.click = false;
		Game.GUIboard.repaint();
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
		// TODO Auto-generated method stub
		Game.active_piece.x = e.getX() - 34;
		Game.active_piece.y = e.getY() - 34;
		//Piece piece = Game.active_piece;
		//col.BallX11 = X11;
		//col.BallY11 = Y11;
		
		//Game.active_piece.x = e.getX();
		//Game.active_piece.y = e.getY();
		///Game.active_piece.drawPiece(g);
		Game.GUIboard.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// inside the panel : 
}
