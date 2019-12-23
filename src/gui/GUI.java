package gui;

import gui.api.*;
import gui.controllers.*;
import gui.layers.*;
import gui.models.*;
import engine.api.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GUI implements IGUI, IActor{

    private IEngine engine;

    private ArrayList<VisualPlayer> players;
    private ArrayList<VisualArea> areas;
    private VisualBall ball;
    private VisualCard[] cards;

    private TerrainLayer terrainLayer;
    private PlayersLayer playersLayer;
    private AreaLayer areaLayer;
    private BallLayer ballLayer;
    private CardLayer cardLayer;

    public GUI(IEngine engine){
        this.engine = engine;

        //Load images
        Images.load();

        //Initialize
        this.players = new ArrayList<>();
        this.areas = new ArrayList<>();
        this.ball = new VisualBall(new Point(0, 0), null);
        this.cards = new VisualCard[]{
            new VisualCard(Images.get(Images.CARD_FORM_1)),
            new VisualCard(Images.get(Images.CARD_FORM_2)),
            new VisualCard(Images.get(Images.CARD_FORM_3)),
            new VisualCard(Images.get(Images.CARD_FORM_4)),
            new VisualCard(Images.get(Images.CARD_FORM_5)),
            new VisualCard(Images.get(Images.CARD_FORM_1)),
            new VisualCard(Images.get(Images.CARD_FORM_2)),
            new VisualCard(Images.get(Images.CARD_FORM_3)),
            new VisualCard(Images.get(Images.CARD_FORM_4)),
            new VisualCard(Images.get(Images.CARD_FORM_5))
        };
        this.cards[7].setActive(false);
        this.cards[1].setActive(false);

        this.terrainLayer = new TerrainLayer();
        this.playersLayer = new PlayersLayer(this.players);
        this.areaLayer = new AreaLayer();
        this.ballLayer = new BallLayer(this.ball);
        this.cardLayer = new CardLayer(this.cards);

        //Create frames
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new OverlayLayout(panel));

        MouseController mouseController = new MouseController(this, this.areaLayer, this.cardLayer);
        KeyboardController keyboardController = new KeyboardController(this, this.areaLayer, this.cardLayer);

        panel.add(this.cardLayer);
        panel.add(this.ballLayer);
        panel.add(this.playersLayer);
        panel.add(this.areaLayer);
        panel.add(this.terrainLayer);
        
        frame.add(panel);
        frame.setSize(1024, 576);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Select the scene to work on
     * @param type scene to choose
     */
    @Override
    public void setScene(SceneType type){

    }

    /**
     * Create new player entity associated to
     * a graphical resource
     * @param position : initial player position
     * @param image : main image
     * @param tackled : tackled image
     * @return : player handler
     */
    @Override
    public int createPlayer(Point position, String image, String tackled){
        VisualPlayer player = new VisualPlayer(Images.get(image), Images.get(tackled), position, false);
        this.players.add(player);

        return this.players.size() - 1;
    }
    /**
     * Control if the player is turned or not
     * @param id : player entity id
     * @param toggle : turned or not
     */
    @Override
    public void setTacklPlayer(int id, boolean toggle){
        this.players.get(id).setTackled(toggle);
    }
    /**
     * Move graphical player
     * @param id : player id
     * @param position : new player position
     */
    @Override
    public void movePlayer(int id, Point position){
        VisualPlayer player = this.players.get(id);

        //Run animation
        if(!player.getPosition().equals(position)){
            player.setNextPosition(position);
            Thread thread;
            if(this.ball.isAttached()){
                thread = new Thread(new AnimationRunnable(new Layer[]{this.playersLayer, this.ballLayer}, 0.5));
            } else{
                thread = new Thread(new AnimationRunnable(new Layer[]{this.playersLayer}, 0.5));
            }
            thread.start();
            try{
                thread.join();
            } catch(InterruptedException exception){
                System.out.println("Failed to join");
            }
            player.setPosition(position);
        }
    }

    /**
     * Move ball graphical entity
     * @param position : new ball position
     */
    @Override
    public void moveBall(Point position){
        if(!this.ball.isAttached()){
            //Run animation
            if(!this.ball.getPosition().equals(position)){
                this.ball.setNextPosition(position);
                Thread thread = new Thread(new AnimationRunnable(new Layer[]{this.ballLayer}, 0.5));
                thread.start();
                try{
                    thread.join();
                } catch(InterruptedException exception){
                    System.out.println("Failed to join");
                }
                this.ball.setPosition(position);
            }
        }
    }
    /**
     * Attach ball to a player. When the player move,
     * the ball move also.
     * @param player : player entity id
     */
    @Override
    public void attachBall(int player){
        this.ball.attachTo(this.players.get(player));
    }
    /**
     * Detach ball from player
     */
    @Override
    public void detachBall(){
        this.ball.attachTo(null);
    }

    /**
     * Change selection area
     * @param areas : areas list
     */
    @Override
    public void setArea(VisualArea[] areas){
        this.areaLayer.setAreas(areas);
        this.areaLayer.repaint();
    }

    /**
     * Control if the card has already been use
     * @param card : card number
     * @param toggle : use or not
     */
    @Override
    public void toggleCard(int card, boolean toggle){
        this.cards[card].setActive(toggle);
        this.cardLayer.repaint();
    }
    /**
     * Display card deck or not
     * @param toggle : control
     */
    @Override
    public void toggleCardDeck(boolean toggle){

        Thread thread = new Thread(new AnimationRunnable(new Layer[]{this.cardLayer}, 1.0));
        thread.start();
        try{
            thread.join();
        } catch(InterruptedException exception){
            System.out.println("Failed to join");
        }
        this.cardLayer.showCard(!this.cardLayer.isShowed());

    }

    /**
     * Show black screen or not
     * @param toggle : control
     * @param message : message to display (eg: "player 1")
     */
    @Override
    public void toggleBlackScreen(boolean toggle, String message){

    }


    /**
     * Classical turn play by an actor, actions should be thrown to the
     * engine
     */
    public void performActions(){

    }
    
    /**
     * Card duel is triggered by the other player
     * 
     * @return : card number returned
     */
    public int performDuel(){
        return 0;
    }
}