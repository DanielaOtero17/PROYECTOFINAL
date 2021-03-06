package Interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOptions extends JPanel implements ActionListener{
	
//	public static final String ADD = "a";
	public static final String NEW_SEARCH = "ns";
	public static final String CHANGE_GRAPH = "cg";
	public static final String BFS = "bfs";
	
//	private JButton add;
	private JButton newSearch;
	private JButton changeGraph;
	private JButton bfs;
	
	private MainWindow mw;
	
	public PanelOptions(MainWindow main) {
		
		mw = main;
		
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);

//		add = new JButton("Agregar estacion");
//		add.addActionListener(this);
//		add.setActionCommand(ADD);
//		add.setBackground(Color.WHITE);

		newSearch = new JButton("Nueva busqueda");
		newSearch.addActionListener(this);
		newSearch.setActionCommand(NEW_SEARCH);
		newSearch.setBackground(Color.WHITE);

		changeGraph = new JButton("Cambiar tipo de grafo");
		changeGraph.addActionListener(this);
		changeGraph.setActionCommand(CHANGE_GRAPH);
		changeGraph.setBackground(Color.WHITE);
		
		bfs = new JButton("BFS");
		bfs.addActionListener(this);
		bfs.setActionCommand(BFS);
		bfs.setBackground(Color.WHITE);

		
		add(newSearch);
		add(bfs);
		add(changeGraph);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String ac = a.getActionCommand();
		if(ac.equals(CHANGE_GRAPH)) {
			mw.initChangeGraphDialog();
		}
		else if(ac.equals(BFS)) {
			mw.initSelectBFSDialog();
		}
		else if(ac.equals(NEW_SEARCH)) {
			mw.clearResultsPanel();
		}
	}
}

