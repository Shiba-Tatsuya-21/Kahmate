
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JPanel {
    
 private JButton Retour;
    private JLabel Regles;
    private JLabel regle1;
    private JLabel regle2;
    private JLabel regle3;
    private JLabel regle4;
    private JLabel regle5;
    private JLabel regle6;
    private JLabel regle7;

    public Rules() {
       /* 
        JFrame fenetre = new JFrame();
        fenetre.setSize(750, 700);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
        */
        initComponents();// appel a la methode qui va initialiser tout les composants
      /*  
		fenetre.add(this);
        fenetre.setVisible(true);
        */
    }

    
      private void initComponents() {// methode qui initialise, place et définit tous les composants
       	GridBagConstraints gridBagConstraints;

        Regles = new JLabel();
        Retour = new JButton();
        regle1 = new JLabel();
        regle2 = new JLabel();
        regle3 = new JLabel();
        regle4 = new JLabel();
        regle5 = new JLabel();
        regle6 = new JLabel();
        regle7 = new JLabel();

        setMinimumSize(new Dimension(750, 500));
        setPreferredSize(new Dimension(750, 500));
        setLayout(new GridBagLayout());

        Regles.setFont(new Font("Tahoma", 1, 36)); 
        Regles.setForeground(new Color(255, 51, 51));
        Regles.setText("Regles du jeu : ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(36, 56, 0, 0);
        add(Regles, gridBagConstraints);

        Retour.setText("RETOUR");

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(56, 32, 64, 0);
        add(Retour, gridBagConstraints);

        regle1.setFont(new Font("Tahoma", 0, 20));
        regle1.setText("Le jeu de Kahmate est un jeu de plateau ou 2 equipes de 6 joueurs ");
        gridBagConstraints = new  GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(51, 32, 0, 0);
        add(regle1, gridBagConstraints);

        regle2.setFont(new Font("Tahoma", 0, 20)); 
        regle2.setText("de differentes couleurs s'affrontent. L'objecif du jeu est de marquer ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 32, 0, 0);
        add(regle2, gridBagConstraints);

        regle3.setFont(new Font("Tahoma", 0, 20)); 
        regle3.setText("un essai c'est-a-dire déplacer le ballon avec un joueur dans le camp ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 32, 0, 0);
        add(regle3, gridBagConstraints);

        regle4.setFont(new Font("Tahoma", 0, 20)); 
        regle4.setText("adversaire. Le jeu se joue en tour par tour. Le capitaine chaque tour");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 32, 0, 0);
        add(regle4, gridBagConstraints);

        regle5.setFont(new Font("Tahoma", 0, 20));
        regle5.setText("peut deplacer 1 ou 2 joueurs, faire des passes en arriere, faire un ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 32, 0, 0);
        add(regle5, gridBagConstraints);

        regle6.setFont(new Font("Tahoma", 0, 20));
        regle6.setText("plaquage, un coup de pied ou marquer un essai. L'action de marquer ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 32, 0, 49);
        add(regle6, gridBagConstraints);

        regle7.setFont(new Font("Tahoma", 0, 20)); 
        regle7.setText("un essai termine le jeu et l'equipe qui l'a realiser gagne.");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor =GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 32, 0, 0);
        add(regle7, gridBagConstraints);
    }        

	// private void RetourActionPerformed(ActionEvent evt ){

    // }
    
   

   

  
   
  
}
