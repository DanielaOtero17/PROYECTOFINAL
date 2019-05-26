package Interfaz;

import java.awt.*;
import javax.swing.*;


public class MainWindow extends JFrame{

	
	public MainWindow() {

		setTitle("STP :: Software de Transporte Publico");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	//	setIconImage(new ImageIcon(ICON_PATH).getImage());
		setLayout(new BorderLayout());
		setResizable(false);
		setPreferredSize(new Dimension(690, 680));

//		main = new MainClass();
//
//		pMap = new PanelMap(this);
//		pOptions = new PanelOptions(this);
//		pResult = new PanelResultPath(this);
//		pSearch = new PanelSearch(this);
//		pSearch.initComboBox(main.getStations_List());
		
		//JScrollPane sp = new JScrollPane(pResult);
//		sp.setPreferredSize(new Dimension(240,475));
		JPanel aux = new JPanel(new FlowLayout());
		aux.setBackground(Color.WHITE);

		aux.setPreferredSize(new Dimension(250,650));
//		aux.add(pSearch);
//		aux.add(sp);
//		add(pMap, BorderLayout.CENTER);
		add(aux, BorderLayout.WEST);
//		add(pOptions, BorderLayout.SOUTH);
		pack();
//		center();
	}
	
	public static void main(String[] args) {
//		ls = new LoadingScreen();
//		ls.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		ls.setVisible(false);
//		ls.dispose();
		MainWindow m = new MainWindow();
		m.setVisible(true);
	}


	
}
