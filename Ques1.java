package lab1;

import java.util.Scanner;

public class construction {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int totalNoOfBuildings = sc.nextInt();
		int[] floorSize = new int[totalNoOfBuildings+1];
		for(int i=1;i<=totalNoOfBuildings;i++) {
			System.out.println("enter the floor size given on day : "+i);
			floorSize[i] = sc.nextInt();
		}
		buildSkyScraper(totalNoOfBuildings,floorSize);
	}

	private static void buildSkyScraper(int totalNoOfBuildings, int[] floorSize) {
		int max = totalNoOfBuildings;
		int start = 1;
		
		//max should be greater than 0 and start should not exceed total no of buildings
		
		while(max>0 && start<=totalNoOfBuildings) {
			if(floorSize[start]==max) {
				max = printAndReturnMax(floorSize,start,max,totalNoOfBuildings);
			}else {
				System.out.println("\nDay: "+start+"\n");
			}
			start++;
		}
	}

	private static int printAndReturnMax(int[] floorSize, int start,int max,int totalNoOfBuildings) {
		System.out.println("Day: "+start+" ");
		
		//if start has reached the end print all the values from max in descending order
			if(start==totalNoOfBuildings) {
				for(int i=max;i>=1;i--) {
					System.out.print(i+" ");	
				}
			}else {
				
				//we can print until floorSize[i] = max , till condition fails else return max
				for(int i=start;i>=1;i--) {
				if(floorSize[i]==max) {
					System.out.print(max+" ");
					max--;
				}else {
					System.out.println();
					return max;
				}
			}
		}
		return max;
	}
}
