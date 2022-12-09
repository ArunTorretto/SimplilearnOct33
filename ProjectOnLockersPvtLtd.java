package mypackage; 

import java.io.*;
import java.util.*;


public class ProjectOnLockersPvtLtd {
	
	public static void main(String args[])throws IOException
	//Displaying the Welcome page with Developer and company name
	{
		System.out.println("     ***********WELCOME*************");
		System.out.println("   *********Lockers Pvt.Ltd***********");
		System.out.println("Application Developer : Arun Kumar Myakala");
		System.out.println(" ****************************************\n");
		
		//Creating a sample default Directory to be used for this Project.
		String path="C:\\SimplyLearn-Project1\\";
		File fDir = new File(path);
		if(fDir.isDirectory()) {
			System.out.println("\nRequired directory already existing for this Project1");
		}
		else {
			if(fDir.mkdir())  {
				System.out.println("\nCreated a required directory for the Project1");
			}
			else
				System.out.println("Falied to create the required direcotry for the Project1");
		}
		//Using scanner to capture the input from console
		Scanner sc=new Scanner(System.in);
		//Declaring the String and integer variables to use in further logics
		String Line;String filename; 
		int option, suboption=0;
		//Using do while loop to display the main menu and perform the tasks repeatedly until we exit for the main menu
		do
		{
			System.out.println("\n\n*********MAIN MENU*********");
			System.out.println("Select the option");
			System.out.println("1 - Display the list of files and folders");
			System.out.println("2 - Display the user interface");
			System.out.println("3 - Exit");
			Line=sc.nextLine();
			
			//Using try catch block to handle the exceptions that occur during the execution of tasks
			try {
				//Using parseInt to consider only the integers taken from the input which will ignore other primitive data types
				//in input and will throws the exception that will be captured by the catch block accordingly
				option=Integer.parseInt(Line);
				// Using switch case to take an option from Main menu to perform the task accordingly
				switch(option)
				{
				
				//Option 1 in Main menu is to display the files available in directory in ascending order. 
				case 1:
					//Using file class for case 1 to search for the directory where we have perform the tasks on file. 
					File fileDir = new File(path);
					//if and else conditions to check find the directory from the given input 
					if(fileDir.isDirectory()) { //Using isDirectory method that tests whether a file is a directory.
						//creating an array list for all the files in a directory
						List<String> listFile = Arrays.asList(fileDir.list()); 
						//Using sort method to archive all the files in a directory to ascending order and collection (framework) to make it as single unit
						Collections.sort(listFile); 
						//System.out.println("Below are the list of files and directories in the given path:");
						System.out.println("Below are the list of files and directories:");
						for(String s:listFile) {
							System.out.println(s);
						}
						
					}
					else {
						System.out.println("Please provide a valid path in the system.");
					}
					
					break;
					
					//Option 2 in Main menu to display the User Interface to perform the file handling operations
				case 2: 
					//again using the same do while loop to perform the sub options until we opt for the main menu. 
					do {
						//User interface to perform various operations of file
						System.out.println("\n-------User Interface-------");
						System.out.println("Choose the task to perform");
						System.out.println("1 - Add File");
						System.out.println("2 - Delete File");
						System.out.println("3 - Search File");
						System.out.println("4 - Back to Main Menu");
						//Using nextLine to take an String(Line) as input exactly as the way the user provides including spaces 
						Line=sc.nextLine();
						
						try { 
							suboption=Integer.parseInt(Line);
							switch(suboption)
							{
							//Option 1 in sub menu to add files in directory using File class and its methods. 
							case 1:
								System.out.println("Enter the file name for creating a new file");
								filename = sc.nextLine();
								File file = new File(path+filename);
								
								try {
									if (file.createNewFile()) {
										System.out.println("File Created Successfully \n");
									} 
									else if (file.exists())
										System.out.println("File Already Exists");
								}
								catch(Exception e) {System.out.println(e.getMessage());}
								break;
								
								
							//Option 2 in sub menu to perform the delete task using file class along with arrays, sorting, equals and iterations methods. 
							case 2:
								System.out.println("Enter the file name which you want to delete");
								String filename1 = sc.nextLine();
								File directory = new File(path);
								//creating an array list for the available files in directory 
								String[] flist = directory.list();
								int flag_d = 0; 
								if (flist == null) {
									System.out.println("There is no files exists in the directory");
								} 
								else {
			
									// Linear search in the array
									//for method to iterate all the files within a directory
									for (int i = 0; i < flist.length; i++) { 
										
										if (flist[i].equals(filename1))
										{
											File file1 = new File(path + flist[i]);
											if (file1.delete()) {
												System.out.println("File deleted successfully");
											} else {
												System.out.println("Failed to delete the file");
											}
											flag_d = 1;
										}
									}
								}
			
								if (flag_d == 0) {
									System.out.println("No file found in the directory with the given name");
								}
								break;
								
							//Option 3 in sub menu to perform the search task using file class methods along with arrays,
							//sorting, equals and iterations methods. 
								
							case 3: 
								System.out.println("Enter the file name to search");
								filename = sc.nextLine();
								
								File directory_search = new File(path);
			
								String[] flist_search = directory_search.list();
								//Using flag method as boolean value to check if there is a file exists in directory to perform the task(Search)
								boolean flag_s = false; 
								if (flist_search == null) {
									System.out.println("There is no file present in the directory");
								} else {
									// Linear search in the array
									for (int i = 0; i < flist_search.length; i++) {
										//Using equals method as boolean value to find the file names equal to its case sensitive letters. 
										if (flist_search[i].equals(filename)) {
											System.out.println(flist_search[i] + " file found");
											flag_s = true;
										}
									}
								}
			
								if (flag_s == false) {
									System.out.println("No file found in the directory with the given name");
								}
								break;
							default: //default keyword to print the given statement in case if the input wont matches within the given switch cases in suboption's.
								System.out.println("Enter a valid input, 1 or 2 or 3 or 4");
								break; //break statement to get terminated from the current loop and to proceed for the next statement following the loop. 
							
							// Option 4 in sub menu is to return to the main menu using break to terminate from the sub menu loop.
							case 4:
								break;
						}
					}
						//Using catch to catch the exceptions thrown from the try block in order to avoid errors and abnormal exiting of program.
					catch(NumberFormatException e) { System.out.println("Please enter only the valid Numerical input");}
				}while (suboption!=4);
				break;
				
				//Option 3 in Main menu is to exit from the application.
				case 3: 
					System.out.println("Exiting the program...\nThank you!");
					sc.close(); //closes the scanner here
					return;
				default: 
					System.out.println("Invalid Choice, please opt from available options(1 or 2 or 3)");
				
				}
			}
			catch(NumberFormatException e) { System.out.println("Please enter only the valid Numerical input");}
			catch(Exception e) { e.getMessage(); }
			
		}while(true);
	}
	}