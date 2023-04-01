package bizsol.view;

public class arrayCombo {
	
	
	static String[] day = new String[31];
	static String[] year = new String[121];
	String month[] = {"January","February","March","April","May","June",
				"July","August","September","October","November","December"};
	
	arrayCombo(){
		for (int x=1;x<=31;x++) {
			day[x-1]=String.valueOf(x);
		}
		int y=0;
		for (int x=1950;x<=2070;x++) {
			year[y]=String.valueOf(x);
			y++;
		}
	
	}
	
	String[] getArrayDay(){
		
		return day;
	}
	
	String[] getArrayYear(){
		
		return year;
	}
	String[] getArrayMonth(){
		return month;
	}
}
