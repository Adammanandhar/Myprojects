/* Author: Trishala Manandhar
   Email: TMANAN21@g.holycross.edu
   Written:09/22/21
   Updated:09/24/21// compiled and fixed errors
   prints the distance between two points in earth
   Example: java Flight.java 42.2381 N 71.8109 W 37.362517 N 122.034760 W */
public class Flight {
	public static void main (String[] args) {
		final double R = 3963.1676;// in miles
		double homeLatitude = Double.parseDouble(args[0]);//non signed decimal fromat
		char direction1 = args[1].charAt(0);// N/S direction	
		double homeLongitude = Double.parseDouble(args[2]);
		char direction2 = args[3].charAt(0);//E/W direction
		double destinationLatitude = Double.parseDouble(args[4]);
		char direction3 = args[5].charAt(0);// N/S direction
		double destinationLongitude = Double.parseDouble(args[6]);
		char direction4 = args[7].charAt(0);//E/W direction
		String answer;
		String maps = 
		System.out.println("Home latitude is " + homeLatitude + " " + direction1);
		System.out.println("Home longitude is " + homeLongitude + " " + direction2);
		System.out.println("Destination latitude is " + destinationLatitude + " " + direction3);
		System.out.println("Destination longitude is " + destinationLongitude + " " + direction4);

		if (direction1 == 'S') {
			homeLatitude = homeLatitude*(-1.0);
		} if (direction2 == 'W') {
			homeLongitude=homeLongitude*(-1.0);
		} if (direction3 == 'S') {
			destinationLatitude=destinationLatitude*(-1.0);
		} if (direction4 == 'W') {
			destinationLongitude=destinationLongitude*(-1.0);
		} 

		double latA = homeLatitude*Math.PI/180;// latitude & longitude in radians
		double latB = destinationLatitude*Math.PI/180;
		double lonA = homeLongitude*Math.PI/180;
		double lonB = destinationLongitude*Math.PI/180;
		
		double latitudeDiff = latB-latA;//change in latitude
		double longitudeDiff = lonB-lonA;// change in longitude
		double sinLat = (Math.sin(latitudeDiff/2)) * (Math.sin(latitudeDiff/2));// the first part of the formula for v.
		double sinLon = (Math.sin(longitudeDiff/2)) * (Math.sin(longitudeDiff/2));// the calculation of sin longitutude for v.
		double  secondPartOfV = sinLon * Math.cos(latA) * Math.cos(latB);//this calculates the section after the plus section in the equation for v.
		final double v = sinLat + secondPartOfV;//the square of half the chord length between the points.
		final double d = 2 * R * (Math.atan2(Math.sqrt(v),Math.sqrt(1-v)));//distance
		
		
		if (homeLatitude< 0.0 || homeLatitude>= 90.0) {
            System.out.println("Sorry, the destination coordinates you entered are not valid.");
			System.out.println("Sorry, the destination N/S hemisphere you entered is not valid.");
              } if (destinationLatitude< 0 || destinationlatitude>= 90) {
			System.out.println("Sorry, the destination coordinates you entered are not valid.");
			System.out.println("Sorry, the destination N/S hemisphere you entered is not valid.");
             } if (homeLongitude< 0 || homeLongitude>= 180) {
			System.out.println("Sorry, the destination coordinates you entered are not valid.");
			System.out.println("Sorry, the destination E/W hemisphere you entered is not valid.");
             } if (destinationLongitude< 0 || destinationLongitude>= 180) {
			System.out.println("Sorry, the destination coordinates you entered are not valid.");
			System.out.println("Sorry, the destination E/W hemisphere you entered is not valid.");
			System.out.println("Because of invalid coordinates, the program with terminate");
             } else {
			System.out.println("The distance from home to destination is " +  d + " miles.");
			System.out.println("Would you like to see a map of your trip?");
			String answer = StdIn.readString();
             } if (answer.equals("yes")) {
			System.out.println("You said yes!");
			System.out.println("Right-click this link or copy it to your browser:");
			System.out.println("https://www.mapquestapi.com/staticmap/v4/getmap?key=t8xhSEnIxadDAwSL0fSuJer5JAWqGPZ5&size=400,400&type=map&bestfit="+homeLatitude+","+homeLongitude+","+destinationLatitude+","+destinationLongitude+"&pois=A,"+homeLatitude+","+homeLongitude+"%7CB,"++destinationLatitude+","+destinationLongitude+"&polyline=color:0xff0000%7Cwidth:3%7C"+homeLatitude+","+homeLongitude+","+destinationLatitude+","+destinationLongitude);
	    } else {
            System.out.println("Goodbye!");
		
			} 
		
	}
}
