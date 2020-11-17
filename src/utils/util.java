package utils;

public class util {

	public static int daysInMonth(int month) {

		switch (month) {
		case 1: //jan
			return 31;
		case 2: //feb
			return 28;
		case 3: //mar
			return 31;
		case 4: //apr
			return 30;
		case 5: //may
			return 31;
		case 6: //jun
			return 30;
		case 7: //jul
			return 31;
		case 8: //aug
			return 31;
		case 9: //sep
			return 30;
		case 10: //oct
			return 31;
		case 11: //nov
			return 30;
		case 12: //dec
			return 31;
		default:
			return 30;
		}
		
	}
	
	public static int castStringToInt(String str) {
		int num;
		try {
			num = Integer.parseInt(str);
			return num;
		}
		catch (NumberFormatException e){
			return -999;
			
		}
	}
	
}
