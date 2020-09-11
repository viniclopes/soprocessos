package view;

import javax.swing.JOptionPane;

import controller.OSProcessManager;

public class Main {

	public static void main(String[] args) {
		OSProcessManager ospm = new OSProcessManager();
		String os = ospm.getOS();
		int opc=Integer.parseInt(JOptionPane.showInputDialog("Digite A Opcao \n 1-Mostrar Processos \n 2-Matar Processos por PID \n 3- Matar Processo por Nome \n 9 - Sair  "));
		do {
			switch (opc) {
			case 1:
				ospm.showTaskList(os);
				break;
			case 2:
				int o = Integer.parseInt(JOptionPane.showInputDialog("Digite O PID"));
				ospm.killProcess(os, o);
				break;
			case 3:
				String s = JOptionPane.showInputDialog("Digite O Nome do Processo");
				ospm.killProcess(os, s);
				break;
			default:
				break;
			}
			
			opc=Integer.parseInt(JOptionPane.showInputDialog("Digite A Opcao \n 1-Mostrar Processos \n 2-Matar Processos por PID \n 3- Matar Processo por Nome \n 9 - Sair  "));
		} while (opc != 9);
	}

}
