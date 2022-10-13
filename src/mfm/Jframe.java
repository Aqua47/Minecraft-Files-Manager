package mfm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Jframe {

	public static void main(String min) {
		
		JFrame frame = new JFrame("Minecraft Files Manager");
		
		final JTextField tf=new JTextField();  
	    tf.setBounds(75,50, 150,20);  
	    tf.setText("Type here!");
	    
	    JTextArea console = new JTextArea();
	    console.setBounds(15, 180, 270, 70);
	    console.setText("use the cmd windows!");
	        
	    JButton enter = new JButton("enter");
	    enter.setBounds(250,70,30,20); 
	    
	    
	    
	    JButton b1=new JButton("Indexes");  
	    b1.setBounds(1,100,80,30);  
	    b1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	            try { Indexes.main(min, "all"); } catch (IOException e1) { e1.printStackTrace(); }
	        }  
	    }); 
	    JButton c1=new JButton("...");  
	    c1.setBounds(81,100,20,30);  
	    c1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    		String[] av = ClassMFM.available(min+"\\assets\\indexes",true,true);
	    		console.setText("Available versions:");
	    		console.append("\n"+Arrays.toString(av));
	    		console.append("\nType the version without: .json  ex: 1.19 for 1.19!");			
	    		console.append("\nOr  all  to do all version available");
	            String text = tf.getText();
	            try { 
	            	if (!Indexes.main(min, text)) {
	            		frame.add(enter);
	            	}
	            } catch (IOException e1) { e1.printStackTrace(); }
	        }  
	    });
	    
	    
	    JButton b2=new JButton("Objects");  
	    b2.setBounds(102,100,80,30);  
	    b2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	            try { Objects.main(min, "all"); } catch (IOException e1) { e1.printStackTrace(); }
	        }  
	    });
	    JButton c2=new JButton("...");  
	    c2.setBounds(182,100,20,30);  
	    c2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		console.setText("Available versions:");
	    		console.append("\n"+Arrays.toString(ClassMFM.available(min+"\\assets\\indexes",true,true)));
	    		console.append("\nType the version without: .json  ex: 1.19 for 1.19!");			
	    		console.append("\nOr  all  to do all version available");
	            String text = tf.getText();
	            try { 
	            	if (Indexes.main(min, text)) {
	            		
	            	}
	            } catch (IOException e1) { e1.printStackTrace(); }
	        }  
	    });
	    
	    
	    JButton b3=new JButton("Old");  
	    b3.setBounds(203,100,100,30);  
	    b3.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    		//String text = tf.getText();
	            try { Old.main(min); } catch (IOException e1) { e1.printStackTrace(); }
	        }  
	    });
	    
	    
	    JButton b4=new JButton("Logs");  
	    b4.setBounds(1,131,100,30);  
	    b4.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	            try { 
	            	console.setText(String.valueOf(Logs.main(min))+" seconds"); 
	            } catch (IOException | InterruptedException e1) { e1.printStackTrace(); }
	        }  
	    });
	    
	    
	    JButton b5=new JButton("Delete");  
	    b5.setBounds(102,131,80,30);  
	    b5.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	            try { Delete.main(min, "all"); } catch (IOException e1) { e1.printStackTrace(); }
	        }  
	    });
	    JButton c5=new JButton("...");  
	    c5.setBounds(182,131,20,30);  
	    c5.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		console.setText("choose files to remove");		
	    		console.append("\n\n| 1 | Indexes | 2 | Objects | 4 | Logs\n| all | for all files in output");
	            String text = tf.getText();
	            try { 
	            	if (Delete.main(min, text)) {
	            		
	            	}
	            } catch (IOException e1) { e1.printStackTrace(); }
	        }  
	    });
	    
	    
	    JButton b0=new JButton("EXIT");  
	    b0.setBounds(203,131,100,30);  
	    b0.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    		frame.dispose();
	        }  
	    });
	    
	       
	    frame.add(b1);frame.add(b2);frame.add(b3);frame.add(b4);frame.add(b5);frame.add(b0);
	    frame.add(c1);frame.add(c2);frame.add(c5);
	    frame.add(tf);frame.add(console);
	    
	    
	    
	    frame.setSize(320,300);  
	    frame.setLayout(null);  
	    
	    
	    //
	    frame.setVisible(true);

	}

}
