package engine.model;

public class Entity{
    /*
    **Entity position X and Y
    */
    private int posx;
    private int posy;

    public Entity(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
    }

    /*
    *Return an integer for X-Position
    * @return : return X-Position
    */
    public int getX(){
        return this.posx;
    }

    /*
    *Return an integer for Y-Position
    * @return : return Y-Position
    */
    public int getY(){
        return this.posy;
    }

    /*
    *Set X-Position for this entity
    * @param x : X-position
    */
    public void setX(int x){
        this.posx = x;
    }

    /*
    *Set Y-Position for this entity
    * @param x : X-position
    */
    public void setY(int y){
        this.posy = y;
    }
}