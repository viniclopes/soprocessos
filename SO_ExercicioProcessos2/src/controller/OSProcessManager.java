package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class OSProcessManager {
	public String getOS() {
		return System.getProperty("os.name");
	}
	
	public void showTaskList(String os) {
		Process p=null;
		if(os.contains("Windows")) {
			try {
				p = Runtime.getRuntime().exec("tasklist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		    
		}else {
			try {
				p = Runtime.getRuntime().exec("ps -few");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		InputStream inputstream = p.getInputStream();

		InputStreamReader inputstreamreader = new InputStreamReader(inputstream);

		BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

		String line,result="";

		try {
			while ((line = bufferedreader.readLine()) != null) {
						result+=line;
						result+="\n";
					}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, result);   
	}
	
	
	public void killProcess(String os , int pid) {
		if(os.contains("Windows")) {
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("taskkill /F /IM "+pid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("kill -9 "+pid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void killProcess(String os ,String processName) {
		if(os.contains("Windows")) {
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("taskkill /F /IM "+processName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("kill -9 "+processName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
