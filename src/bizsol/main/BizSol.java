package bizsol.main;

import java.sql.SQLException;
import java.text.ParseException;

import bizsol.controller.LogInControler;
import bizsol.model.LogInModel;
import bizsol.view.LogInView;
import bizsol.view.showGui;

public class BizSol {

	public static void main(String[] args) throws SQLException, InterruptedException, ParseException {
		// TODO Auto-generated method stub
//	new LogInView();
	//new showGui();
	
	
		LogInView view = new LogInView();
		LogInModel model = new LogInModel();
		LogInControler controller = new LogInControler(model, view);

	}}

