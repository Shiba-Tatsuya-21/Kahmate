

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class End extends javax.swing.JPanel {

    private javax.swing.JButton Retour;
    private javax.swing.JButton Quitter;
    private javax.swing.JLabel Titre;
    private javax.swing.JLabel Felicitation;
    private javax.swing.JLabel Win;

    public End() {
		/*   
		JFrame fenetre = new JFrame();
        fenetre.setSize(750, 700);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
        */
		initComponents();// appel a la methode qui initialse les composants
	/*	 
		fenetre.add(this);
        fenetre.setVisible(true);
        */
    }

	
    private void initComponents() {// methode qui initialise, place et définit tous les composant 
        java.awt.GridBagConstraints gridBagConstraints;

        Titre = new javax.swing.JLabel();
        Felicitation = new javax.swing.JLabel();
        Win = new javax.swing.JLabel();
        Retour = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();

		setMinimumSize(new Dimension(750, 500));
        setPreferredSize(new Dimension(750, 500));
        setLayout(new java.awt.GridBagLayout());

        Titre.setFont(new java.awt.Font("Tahoma", 1, 48));
        Titre.setText("Kahmate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(63, 251, 0, 0);
        add(Titre, gridBagConstraints);

        Felicitation.setFont(new java.awt.Font("Tahoma", 2, 40));
        Felicitation.setText("Félicitation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(96, 251, 0, 0);
        add(Felicitation, gridBagConstraints);

        Win.setFont(new java.awt.Font("Tahoma", 0, 35)); 
        Win.setText("Vous avez gagné la partie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 157, 0, 0);
        add(Win, gridBagConstraints);

        Retour.setFont(new java.awt.Font("Tahoma", 0, 25));
        Retour.setText("Retour Menu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(120, 157, 68, 0);
        add(Retour, gridBagConstraints);

        Quitter.setFont(new java.awt.Font("Tahoma", 0, 25)); 
        Quitter.setText("Quitter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(120, 106, 68, 188);
        add(Quitter, gridBagConstraints);
    }

  /*public static void main(String args[]) {
	  
        new End();// appel au constructeur 
   
   }
*/
   
   
   
}
