package org.flysim.Launcher;

import org.flysim.AI.AI;
import org.flysim.Simulator.Simulator;
import org.flysim.UI.Visualizator;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulator simulator = new Simulator();
		AI ai = new AI(simulator, simulator);
		Visualizator ui = new Visualizator(simulator);
		
		Thread simThread = new Thread(simulator);
		simThread.start();
		Thread aiThread = new Thread(ai);
		aiThread.start();
		Thread uiThread = new Thread(ui);
		ui.init();
		uiThread.start();
		

	}

}
