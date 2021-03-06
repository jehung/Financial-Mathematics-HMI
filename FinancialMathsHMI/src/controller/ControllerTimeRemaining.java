package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import abstraction.Arguments;

public class ControllerTimeRemaining implements ActionListener,Observer{
	private Arguments arg;
	private JTextField timeRemaining;

	public ControllerTimeRemaining(Arguments arg, JTextField timeRemaining) {
		super();
		this.arg = arg;
		this.timeRemaining = timeRemaining;
		arg.addObserver(this);
		timeRemaining.addActionListener(this);
	}


	@Override
	public void update(Observable o, Object argu) {
		timeRemaining.setText(arg.getTimeRemaining()+"");
		if(timeRemaining.getText()!=null){
			ControllerSubmit.timeRemainingCompleted=true;
			ControllerSubmit.change();
		}
		else{
			ControllerSubmit.timeRemainingCompleted=true;
			ControllerSubmit.change();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			arg.setTimeRemaining(Double.parseDouble(this.timeRemaining.getText()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Entrez une valeur r�elle!", "Mauvais argument d'entr�e", JOptionPane.ERROR_MESSAGE);
			timeRemaining.setText("");
			ControllerSubmit.timeRemainingCompleted=false;
			ControllerSubmit.change();
		}
	}
}