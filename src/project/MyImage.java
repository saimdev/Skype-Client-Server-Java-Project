package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class MyImage{
	
	SignupSecondScreen sss = new SignupSecondScreen("use");
	Signup s = new Signup("use");
	
	MyImage(){

	    int width = 100;    
	    int height = 100; 
	    BufferedImage image = null;
	    File f = null;

	    //read image
	    try{
	      f = new File(sss.path); //image file path
	      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	      image = ImageIO.read(f);
	      System.out.println("Reading complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }

	    //write image
	    try{
	      f = new File(s.user+".jpg");  //output file path
	      ImageIO.write(image, "jpg", f);
	      image = ImageIO.read(f);
	      Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	      System.out.println("Writing complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
	}
	
	MyImage(String second){

	    int width = 100;    
	    int height = 100; 
	    BufferedImage image = null;
	    File f = null;

	    //read image
	    try{
	      f = new File(sss.path); //image file path
	      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	      image = ImageIO.read(f);
	      System.out.println("Reading complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }

	    //write image
	    try{
	      f = new File(s.user+"1.jpg");  //output file path
	      ImageIO.write(image, "jpg", f);
	      image = ImageIO.read(f);
	      Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	      System.out.println("Writing complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
	}
}
