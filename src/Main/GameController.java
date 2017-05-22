package Main;
import importing.ImportManager;


import java.util.*;

import Entities.*;

import javax.swing.JFrame;
import javax.swing.Timer;

import Manager.*;
//import 
import Thread.GUIPane;
import Levels.*
;
public class GameController {
	GUIManager gui;// = new GUIManager();
	boolean menuOpen;
	List<Level> levels;
	List<Entity> ents;
	int currentLevel;
	public GameController (){
		/*gui = new GUIManager();
		Timer t = gui.initTimer();
		t.start();
		ents = ImportManager.initLevel();
		//int x, int y, int h, int w, double angel, String img
		gui.initReftoGUIPane(this, ents);
		JFrame realGui = gui.getThis();
		
		realGui.setVisible(true);*/
		currentLevel = 0;
		gui = new GUIManager();
		Timer t = gui.initTimer();
		t.start();
		levels = ImportManager.initLevels();
		ents = levels.get(currentLevel).getEnts();
		//int x, int y, int h, int w, double angel, String img
		gui.initReftoGUIPane(this, ents);
		JFrame realGui = gui.getThis();
		
		realGui.setVisible(true);
		
	}
	
	public void run() {
		gui.initTimer();
	}
	
	
	
	public void play() {
		/*GUIPane g = gui.getThis();
		g.changeTestString(g.getClickedX()+" "+g.getClickedY());
		g.repaint();
		*/
		GUIPane g = gui.getThis();
		g.changeTestString(g.getClickedX()+" "+g.getClickedY());
		g.repaint();
		if(levels.get(currentLevel).objectiveMet()){
			try{
			currentLevel++;
			g.initReftoGUIPane(levels.get(currentLevel).getEnts());
			}
			catch(IndexOutOfBoundsException e){
				g.dispose();
			}
		}
	}
}
