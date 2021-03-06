/*
 * Copyright (c) 1997-2004 Alexandros Eleftheriadis, Danny Hong and 
 * Yuntai Kyong.
 *
 * This file is part of Flavor, developed at Columbia University
 * (http://flavor.sourceforge.net).
 *
 * Flavor is free software; you can redistribute it and/or modify
 * it under the terms of the Flavor Artistic License as described in
 * the file COPYING.txt. 
 *
 */

/*
 * Authors:
 * Danny Hong <danny@ee.columbia.edu>
 *
 */


package maptest;
import flavor.*;
import java.io.*;


public class Main
{
	public static void main(String args[]) throws IOException 
    {
		if (args.length != 3) {
			System.out.println("Usage:");
            System.out.println("    java maptest.Main -ofile=<out file> -schema=[y|n] <bitstream file>");
            System.out.println("    ");
            System.out.println("    -ofile   Specify the output file to write the XML data.");
            System.out.println("    -schema  Assume corresponding schema is available.");
            System.out.println("    -?       Show this help.");
			System.exit(-1);
		}

		try {
			// Create an input bitstream
			Bitstream bs = new Bitstream(args[2], Bitstream.BS_INPUT);

			// Create our MapTest object
			MapTest mt = new MapTest();

            if (args[1].charAt(8) == 'y' || args[1].charAt(8) == 'Y') {
                // Create the root element <MapTest> and include the XML schema - maptest.xsd
                XML.CreateXmlHeader(args[0].substring(7), "MapTest", "maptest.xsd");
    
                // If schema is used, then, the data type attributes may not be needed
                mt.putxml(bs, false);
            }
            else {
                // Create the root element <MapTest>
                XML.CreateXmlHeader(args[0].substring(7), "MapTest");

                // Create the XML document and explicitly generate the data type attributes
                mt.putxml(bs, true);
            }
            // Make sure the end tag matches the root element tag
            XML.EndXml("MapTest");
        }
        catch(IOException e) {
			System.out.println(e.toString());
		}
    }
}
