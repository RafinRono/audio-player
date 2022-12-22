import javax.sound.sampled.*; //this is needed for using audio

import javax.swing.JOptionPane; // for JOptionPane gui texts

import java.io.File; // for using file class
import java.io.IOException; //for the exception throwing

import java.util.Scanner;// for scanner input class

public class audio 
{

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	// the throw exceptions are needed, so these were auto generated
	{
		Scanner input = new Scanner(System.in);
		
		File audioFile = new File("AoT.wav");
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); 
		// for getting audio input
		
		Clip audioClip = AudioSystem.getClip(); //declaring the Clip file
		
		audioClip.open(audioStream); // for opening the clip
		
		//audioClip.start(); //this will start the audio clip
		
		// now the problem is the audio will run in a background thread
		// but the program terminates automatically as soon as it runs all codes
		// so we need a way to stop the program from closing
		//for example using an input dialogue or a gui like JOptionPane
		
		//JOptionPane.showMessageDialog(null, "Music is playing");
		//we can use this to halt the program from terminating
		
		String response = ""; //for getting an input as response
		
		//making a while loop to act as a music player
		while ( !response.equals("Q") ) //while response is not equal to "Q", the loop will run
		{
			System.out.println("P = Play , S = Stop , R = Reset , Q = Quit");
			System.out.print("Enter choice: ");
			
			response = input.next();
			response = response.toUpperCase(); //converts everything to upper case
			
			switch (response)
			{
			case "P" :
				System.out.println("Audio is playing \n");
				audioClip.start();
				break;
			
			case "S" :
				System.out.println("Audio is stopped \n");
				audioClip.stop();
				break;
				
			case "R" :
				System.out.println("Audio has been reset \n");
				audioClip.setMicrosecondPosition(0); 
				//this will turn the clip back to the 0 micro second point
				break;
				
			case "Q" :
				System.out.println("You have quit the audio player \n");
				audioClip.close(); //closing the clip
				break;
				
			default:
				System.out.println("invalid input \n");
			}
		}
		
		System.out.println("Byee bitch");

	}

}
