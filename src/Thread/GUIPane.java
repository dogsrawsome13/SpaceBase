package Thread;

import Entities.*;
import Main.GameController;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;

public class GUIPane extends JFrame implements 
ActionListener, KeyListener, MouseListener, MouseMotionListener{
	
	private List<Entity> ents;
	private char key;
	private int clickedX, clickedY;
	private boolean clicked;
	private GameController gaco;
	int time;
	private final int winWidth = 900, winHeight = 506;
	String testing;
	Menu openMenu;
	
	public GUIPane(){
		super("SpaceBase");
		addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		this.setSize(winWidth, winHeight);
		time =0;
		testing = "";
		openMenu = null;
		
	}
	
	public void changeTestString(String r){
		testing = r;
	}
	
	public void initReftoGUIPane(GameController gc, List<Entity> entities){
		gaco = gc;
		ents = entities;
	}
	
	public void paint(Graphics g)
    {
        // gra = g;
        Image offImage = createImage(winWidth, winHeight);
        // if (offImage == null) offImage = createImage(748,748);
        // Creates an off-screen drawable image to be used for
        // double buffering; XSIZE, YSIZE are each of type ‘int’
        Graphics buffer = offImage.getGraphics();
        // Creates a graphics context for drawing to an
        // off-screen image
        paintOffScreen(buffer); // your own method
        g.drawImage(offImage, 0, 0, null);

        // draws the image with upper left corner at 0,0

        // Calls GameController's play() method
        //gameController.play();
    }

    public void paintOffScreen(Graphics g)
    {
    	for(Entity e : ents){
    		Integer[] is = {clickedX, clickedY};
    		e.tickAction(is);
    		e.draw(g);
    		g.drawPolygon(e.returnBounds());
    		
    	}
    	g.setColor(Color.BLUE);
    	g.drawString(testing, clickedX, clickedY);
    	
    }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		clickedX = e.getX();
		clickedY = e.getY();
		clickActions();
		
		//System.out.println(e.getButton());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

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
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gaco.play();
		//System.out.println("Hello Tim");
	}
	
	private void clickActions(){
		boolean menuOpen = false;
		if(openMenu == null)
			for(Entity x : ents){
				x.checkBounds(clickedX, clickedY);
				if(x instanceof MenuSpawnable){
					openMenu = ((MenuSpawnable)x).spawnMenu();
					menuOpen = true;
				}
			}
		else{
			if(!openMenu.checkBounds(clickedX, clickedY)){
				ents.remove(openMenu);
				openMenu = null;
			}
		}
		if(menuOpen)
			ents.add(openMenu);
		
	}
	
	public boolean isClicked() {
		if(clicked) {
			clicked = false;
			return true;
		}
		else return false;
	}
	
	public int getClickedX() {
		return clickedX;
	}
	
	public int getClickedY() {
		return clickedY;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		clickedX = arg0.getX();
		clickedY = arg0.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void removeFromEnts(Entity e) {
		for(int i=0; i<ents.size(); i++)
			if(e == ents.get(i)){
				ents.remove(i);
				i--;
			}				
	}
}
