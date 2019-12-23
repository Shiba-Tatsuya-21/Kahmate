import engine.api.*;
import engine.*;
import gui.api.*;
import gui.*;

public class Launcher{
    public static void main(String[] args){
        IEngine engine = new Engine();
        IGUI gui = new GUI(engine);
    }
}