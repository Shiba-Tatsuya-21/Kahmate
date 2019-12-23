import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
	private GridBagConstraints GridBagConstraints;
	private JButton onePlayer;
	private JButton twoPlayers;
	private JButton rules;
	private JButton leave;
	private JLabel title;

	public Menu() {
		super();

		this.setSize(700, 700);
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.title = new JLabel("Kahmate");
		this.title.setFont(new Font("Comics sans Ms",Font.BOLD,40));
		this.title.setForeground(new Color(128, 202, 42));
		this.add(title);
		this.onePlayer = new JButton("1 joueur");
		this.add(onePlayer);
		this.twoPlayers = new JButton("2 joueurs");
		this.add(twoPlayers);
		this.rules = new JButton("Règles");
		this.add(rules);
		this.leave = new JButton("Quitter");


		this.GridBagConstraints = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.GridBagConstraints.insets = new Insets(40,0,0,0);


		this.GridBagConstraints.gridx=0;
		this.GridBagConstraints.gridy=1;
		this.GridBagConstraints.ipadx = 85;
		this.GridBagConstraints.ipady = 35; 
		this.GridBagConstraints.fill=GridBagConstraints.BOTH;
		this.add(this.onePlayer,this.GridBagConstraints);


		this.GridBagConstraints.gridx=0;
		this.GridBagConstraints.gridy=2;
		this.GridBagConstraints.ipadx = 85;
		this.GridBagConstraints.ipady = 35; 
		this.GridBagConstraints.fill=GridBagConstraints.BOTH;
		this.add(this.twoPlayers,this.GridBagConstraints);

		this.GridBagConstraints.gridx=0;
		this.GridBagConstraints.gridy=3;
		this.GridBagConstraints.ipadx = 85;
		this.GridBagConstraints.ipady = 35; 
		this.GridBagConstraints.fill=GridBagConstraints.BOTH;
		this.add(this.rules,this.GridBagConstraints);

		this.GridBagConstraints.gridx=0;
		this.GridBagConstraints.gridy=4;
		this.GridBagConstraints.ipadx = 85;
		this.GridBagConstraints.ipady = 35; 
		this.GridBagConstraints.fill=GridBagConstraints.BOTH;
		this.add(this.leave,this.GridBagConstraints);

		MenuController MenuController = new MenuController (this);
		this.onePlayer.addActionListener(MenuController);
		this.twoPlayers.addActionListener(MenuController);
		this.rules.addActionListener(MenuController);
		this.leave.addActionListener(MenuController);

		//PaintMenu paintMenu = new PaintMenu();
		//this.add(paintMenu,BorderLayout.CENTER);

	}

	
}