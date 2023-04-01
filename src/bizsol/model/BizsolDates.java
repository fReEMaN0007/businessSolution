package bizsol.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class BizsolDates {

	 Date Cutoff;
	// Date period;
	 String period;
	 Date dateparse = new Date();
	 SimpleDateFormat dfoutput = new SimpleDateFormat("MM-dd-yyy");
	 SimpleDateFormat dfoutput2 = new SimpleDateFormat("MMM-dd-yyy");
	 SimpleDateFormat dfinput = new SimpleDateFormat("yyyy-MM-dd");
	 SimpleDateFormat dfinput2 = new SimpleDateFormat("MM-dd-yyyy");
	 LocalDate date = LocalDate.now();
	 LocalTime time = LocalTime.now();	 
	 public Date setCutoff(){
		
			try {
				dateparse = dfinput.parse(date.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Integer.valueOf(date.toString().substring(8))>20) {
				try {
					Cutoff = dfinput.parse(date.toString().substring(0, 5)+(date.getMonthValue()+1)+"-20");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dfoutput.format(Cutoff);
			}
			
			else {
				try {
					Cutoff = dfinput.parse(date.toString().substring(0, 5)+(date.getMonthValue())+"-20");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return Cutoff;
	 }
	 
	 public String payrollPeriod() {
		 setCutoff();
//		 newCutoff.toString().substring(0, 2);
		 int mon;
		 String oldmon;
		 Date newOld = null;
		 mon=Integer.valueOf(dfoutput.format(Cutoff).substring(0, 2)); 
		 mon = mon-1;
		 oldmon = mon + dfoutput.format(Cutoff).substring(2);
		 try {
			newOld=dfinput2.parse("0"+oldmon);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 period =  dfoutput2.format(newOld) + " - "+dfoutput2.format(Cutoff);
		 System.out.println(period);
		 
		// System.out.println(time + "Fdsa");
		 return period;
	 }

}
