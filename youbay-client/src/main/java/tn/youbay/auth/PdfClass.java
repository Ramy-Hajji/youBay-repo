package tn.youbay.auth;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.text.Document;

import org.dom4j.DocumentException;

import tn.youbay.entities.PaymentWay;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class PdfClass {
	 public static void PdfProduct( int a ,String n, String b,PaymentWay pay, double pr, String s, int qt) {

  		  com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
  		 
  		  
  		   
			try {
				PdfWriter.getInstance(doc, new FileOutputStream("listeProduit.pdf"));
			} catch (FileNotFoundException
					| com.itextpdf.text.DocumentException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		 
  		   doc.open();
  		   doc.addAuthor("2B4G");
  		   doc.addCreationDate();
  		   doc.addProducer();
  		   doc.addCreator("Product");
  		   doc.addTitle("List of Product");
  		   doc.setPageSize(PageSize.LETTER);
  		 
  		   
			try {
				doc.add( new Paragraph(n));
			} catch (com.itextpdf.text.DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
  		      

  		 
  		  Paragraph p1= new Paragraph(b);
  		  Paragraph p2= new Paragraph(pay.toString());
  		  Paragraph p3= new Paragraph(pr+"");
  		  Paragraph p4= new Paragraph(qt+"");
  		  Paragraph p5= new Paragraph(s);

  		  Paragraph p6=new Paragraph("-------------------");
  		 
  		    try {
				doc.add(p1);
				 doc.add(p2);
		  		    doc.add(p3);
		  		    doc.add(p4);
		  		    doc.add(p5);
		  		    doc.add( Chunk.NEWLINE );
		  		    doc.add(p6);
	  		    	doc.close();

			} catch (com.itextpdf.text.DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		   
  		   
  		    
  		     
  		
  		   }
	 
  		        
  		 

}
