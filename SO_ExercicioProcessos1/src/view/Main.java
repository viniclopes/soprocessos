package view;



import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redeController = new RedesController();
		
		int opc=Integer.parseInt(JOptionPane.showInputDialog("Digite A Opcao \n 1-Ver Adaptadores/IPs \n 2-Ver media de ping  \n 9 - Sair  "));
		do {
			switch (opc) {
			case 1:
				redeController.ip();;
				break;
			case 2:
				redeController.ping();
				break;
			default:
				break;
			}
			
			opc=Integer.parseInt(JOptionPane.showInputDialog("Digite A Opcao \\n 1-Ver Adaptadores/IPs \\n 2-Ver media de ping  \\n 9 - Sair  "));
		} while (opc != 9);
		
	}
}
