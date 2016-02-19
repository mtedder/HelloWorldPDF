/**
 * 
 */
package com.grandcircus.examples;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/*
* Create PDFs using PDFBox library (based on code from http://pdfbox.apache.org/1.8/cookbook/documentcreation.html): HelloWorldPDF.java
*
* To compile this program from the command line type: javac -cp .;libs/pdfbox-1.8.8.jar;libs/fontbox-1.8.8.jar HelloWorldPDF.java
* Mac OS javac -cp ".:libs/pdfbox-1.8.8.jar:libs/fontbox-1.8.8.jar" HelloWorldPDF.java
*
* To run this program from the command line type: java -cp .;libs/pdfbox-1.8.8.jar;libs/fontbox-1.8.8.jar;libs/commons-logging-1.2.jar HelloWorldPDF
*
* Reference: http://pdfbox.apache.org/1.8/cookbook/documentcreation.html
*
* Requires jars (download from http://pdfbox.apache.org/download.cgi#recent): pdfbox-1.8.8.jar and fontbox-1.8.8.jar
* and commons-logging-1.2.jar (download from: http://commons.apache.org/proper/commons-logging/download_logging.cgi)
*/
public class HelloWorldPDF {

	 /**
	* Main is the entry point for starting your application.
	* @param args the command line arguments
	*/
	public static void main(String[] args) {
		try{
			// Create a document and add a page to it
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage( page );

			// Create a new font object selecting one of the PDF base fonts
			PDFont font = PDType1Font.HELVETICA_BOLD;

			// Start a new content stream which will "hold" the to be created content
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
			contentStream.beginText();
			contentStream.setFont( font, 12 );
			contentStream.moveTextPositionByAmount( 100, 700 );
			contentStream.drawString( "Hello World" );
			contentStream.endText();

			// Make sure that the content stream is closed:
			contentStream.close();

			// Save the results and ensure that the document is properly closed:
			document.save( "Hello World.pdf");
			document.close();
		}catch(IOException e){
			//
		} catch (COSVisitorException e) {
			//
		}
	}

}
