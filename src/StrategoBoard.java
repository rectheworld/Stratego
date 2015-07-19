import javax.swing.JFrame;


public class StrategoBoard extends JFrame {

	// Variabls 
	
	StrategoPanel S_panel; 
	
	public  StrategoBoard(){
		//inside the constructor : Size,Panel,Default Close operation, Visibility 
		S_panel = new StrategoPanel();
		this.setSize(840,840);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("  Startego  ");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(S_panel);
		
		
}
}
