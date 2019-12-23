
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuController implements ActionListener{
	
	private Menu menu;
	

	public MenuController(Menu m){
		this.menu = m;
		
	}
	
	public void actionPerformed(ActionEvent e){
		String nomButton=e.getActionCommand();


		if(nomButton.equals("1 joueur")){
			menu.dispose();
			

		}
		else if(nomButton.equals("2 joueurs")){
			menu.dispose();
		}
		else if(nomButton.equals("Règles")){
			menu.dispose();
			Rules rules = new Rules();
			rules.setVisible(true);
		}
		else if(nomButton.equals("Quitter")){
			menu.dispose();
			menu.setVisible(false);
			End end = new End();
			end.setVisible(true);

		}

	}
}