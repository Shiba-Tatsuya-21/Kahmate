import java.awt.Point;

public class MovingArea {

    public MovingArea() {
        showTabTerm(createMovingArea(new Point(1, 3), 3));
        showTabTerm(pass(new Point(1, 3), 0));
        showTabTerm(shoot(new Point(1, 3), 0));

        showTabTerm(pass(new Point(1, 3), 1));
        showTabTerm(shoot(new Point(1, 3), 1));

        showTabTerm(force(new Point(3, 3)));

        showTabTerm(firstPlace(1));
    }

    /**
     * Create tab to know where we can move
     * 
     * @param co  : Position of player
     * @param mov : Rest of movement for player
     * @return : Return boolean tab for enable movement
     */
    public static boolean[][] createMovingArea(Point co, int mov) {
        int indice = mov;
        boolean[][] tab = new boolean[13][8];

        int x, y, posx, posy;
        posx = co.x;
        posy = co.y;
        for (int f = 0; f < tab.length; f++) {
            for (int i = 0; i < tab[0].length; i++) {
                x = f - posx;
                if (x < 0)
                    x = -x;
                y = i - posy;
                if (y < 0)
                    y = -y;
                if (x + y <= indice) {
                    tab[f][i] = true;
                } else {
                    tab[f][i] = false;
                }
            }
        }
        return tab;
    }

    /**
     * Create tab to know where we can pass
     * 
     * @param co   : Position of player
     * @param team : Team 0 or 1 to know where he can do a pass
     * @return : Return boolean tab for enable pass
     */
    public static boolean[][] pass(Point co, int team) {
        boolean[][] tab = new boolean[13][8];
        if (team == 1) {

            for (int i = co.x + 1; i < co.x + 3; i++) {
                for (int f = co.y - 2; f < co.y + 3; f++) {
                    if (i < tab.length && i >= 0 && f < tab[0].length && f >= 0) {
                        tab[i][f] = true;
                    }

                }
            }

        } else if (team == 0) {

            for (int i = co.x - 1; i > co.x - 3; i--) {
                for (int f = co.y - 2; f < co.y + 3; f++) {
                    if (i < tab.length && i >= 0 && f < tab[0].length && f >= 0) {
                        tab[i][f] = true;
                    }

                }
            }

        } else {

            System.out.println("Error team to pass");

        }

        return tab;
    }

    /**
     * Create tab to know where we can shoot
     * 
     * @param co   : Position of player
     * @param team : Team 0 or 1 to know where he can do a shoot
     * @return : Return boolean tab for enable shoot
     */
    public static boolean[][] shoot(Point co, int team) {
        boolean[][] tab = new boolean[13][8];
        if (team == 1) {

            for (int i = co.x - 3; i < co.x; i++) {
                for (int f = co.y - 3; f < co.y + 4; f++) {
                    if (i < tab.length && i >= 0 && f < tab[0].length && f >= 0) {
                        tab[i][f] = true;
                    }

                }
            }

        } else if (team == 0) {

            for (int i = co.x + 3; i > co.x; i--) {
                for (int f = co.y - 3; f < co.y + 4; f++) {
                    if (i < tab.length && i >= 0 && f < tab[0].length && f >= 0) {
                        tab[i][f] = true;
                    }

                }
            }

        } else {

            System.out.println("Error team to shoot");

        }

        return tab;
    }

    public static boolean[][] force(Point co) {
        boolean[][] tab = new boolean[13][8];
        for (int i = co.x - 2; i < co.x; i++) {
            for (int f = co.y - 1; f < co.y + 2; f++) {
                if (i < tab.length && i >= 0 && f < tab[0].length && f >= 0) {
                    tab[i][f] = true;
                }

            }
        }
        if (co.x - 3 >= 0) {
            tab[co.x - 3][co.y] = true;
        }
        return tab;
    }

    public static boolean[][] firstPlace(int team) {
        boolean[][] tab = new boolean[13][8];
        int v = 1;
        if (team == 1) {
            v = tab.length - 3;
        }
        for (int i = 0; i < 2; i++) {
            for (int g = 0; g < tab[0].length; g++) {
                tab[v + i][g] = true;
            }

        }

        return tab;
    }
  /*  public static void tackle(Point co,int team){
        if(team == 0){

            if(co.x - 1 == 0){
                int top;
                *Il faut créer cette fonction qui attend la réponse du joueur pour savoir sur quelle case le joueur va déposé le ballon
                *top = chooseTopOrBot(co);
                showTabTerm(chooseTopOrBot(co);
                if(top == 0){
                    this.ball.setPosY = co.Y - 1;
                }else{
                    this.ball.setPosY = co.Y + 1;
                }
            }else{
                this.ball.setPosX = co.x - 1;
            }

        }else if(team == 1){

            if(co.x + 1 == 0){
                int top;
                showTabTerm(chooseTopOrBot(co);
                //top = Récup de la valeur;
                if(top == 0){
                    this.ball.setPosY = co.Y - 1;
                }else{
                    this.ball.setPosY = co.Y + 1;
                }
            }else{
                this.ball.setPosX = co.x + 1;
            }

        }
    }

    public static boolean[][] chooseTopOrBot(Point co){
        boolean[][] tab = new boolean[13][8];
        if(co.y == 0){

            tab[co.y + 1][co.x]=true;

        }else if (co.y == 7){

            tab[co.y - 1][co.x]=true;

        }else{

            tab[co.y - 1][co.x]=true;
            tab[co.y + 1][co.x]=true;
        
        }
        return tab;
    }*/

    public static void showTabTerm(boolean[][] tab) {
        for (int y = 0; y < tab[0].length; y++) {
            for (int x = 0; x < tab.length; x++) {
                if (tab[x][y]) {
                    System.out.print(" 1");

                } else {
                    System.out.print(" 0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new MovingArea();
    }
}