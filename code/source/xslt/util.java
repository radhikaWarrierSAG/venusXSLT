package xslt;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2005-02-15 11:50:12 EST
// -----( ON-HOST: 10.3.19.124

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.lang.SecurityException;
import java.util.Properties;
import wcard.WCardDirFilter;
import com.wm.app.b2b.server.*;
import com.wm.util.ByteOutputBuffer;
import java.util.Hashtable;
import com.wm.data.*;
import com.wm.util.coder.*;
import com.wm.util.xform.*;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void closeFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(closeFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required fileWriter
		// [o] field:0:required successFlag
		//define input variables  
		BufferedWriter fileWriter = null;
		IDataCursor idcPipeline = pipeline.getCursor();
					
		//Output Variables 
		String successFlag = "false";
		
		// Check to see if the fileWriter object is in the pipeline
		if (idcPipeline.first("fileWriter"))
		{	
			//get the BufferedWriter stream out of the pipeline					
			fileWriter = (BufferedWriter) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			System.out.println("Error executing closeFileWriter: Required parameter 'fileWriter' missing.");
			successFlag = "false";	
		
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);
		
			//Always destroy cursurs that you created
			idcPipeline.destroy();	
		
			return;
		}
		
		// Try to flush the fileWriter object.  Handle the exception if it fails.
		try			
		{
			fileWriter.close();
			successFlag = "true";						
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
		
			//Print the exception out to standard output
			System.out.println("Error executing closeFileWriter:" + e.toString());	
		}
		
			//remove any other successFlags from pipline
		if(idcPipeline.first("successFlag"))
		{
				idcPipeline.delete();
		}
		
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);
		
		//Always destroy cursors that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}



	public static final void flushFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(flushFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required fileWriter
		// [o] field:0:required successFlag
		//define input variables    
		BufferedWriter fileWriter = null;
		IDataCursor idcPipeline = pipeline.getCursor();
					
		//Output Variables 
		String successFlag = "false";
		
		// Check to see if the fileWriter object is in the pipeline
		if (idcPipeline.first("fileWriter"))
		{	
			//get the BufferedWriter stream out of the pipeline					
			fileWriter = (BufferedWriter) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			System.out.println("Error executing flushFileWriter: Required parameter 'fileWriter' missing.");
			successFlag = "false";	
		
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);
		
			//Always destroy cursurs that you created
			idcPipeline.destroy();	
		
			return;
		}
		
		// Try to flush the fileWriter object.  Handle the exception if it fails.
		try			
		{
			fileWriter.flush();
			successFlag = "true";						
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
		
			//Print the exception out to standard output
			System.out.println("Error executing flushFileWriter:" + e.toString());	
		}
		
		//remove any other successFlags from pipline
		if(idcPipeline.first("successFlag"))
		{
				idcPipeline.delete();
		}
		
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);
		
		//Always destroy cursors that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}



	public static final void getServerPort (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServerPort)>> ---
		// @sigtype java 3.5
		// [o] field:0:required port
		IDataCursor idc = pipeline.getCursor();
		idc.insertAfter("port", String.valueOf(ServerAPI.getCurrentPort()));
		idc.destroy();  
		// --- <<IS-END>> ---

                
	}


    public static final Values normalizeLineBreaks (Values in)
    {
        Values out = in;
		// --- <<IS-START(normalizeLineBreaks)>> ---
		// @sigtype java 3.0
		// [i] field:0:required inString
		// [o] field:0:required value
		    String inString = (String) in.get("inString");
		try {
		    String value = StringDT.replace(inString, "\r\n", "\n", false);
		//    value = StringDT.replace(value, "\n", "\r", false);
		    out.put("value", value);
		} catch (Exception e) {};
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void openFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(openFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required filename
		// [i] field:0:required overwriteFlag {"overwrite","append"}
		// [o] object:0:required fileWriter
		// [o] field:0:required successFlag
		//define input variables    
		IDataCursor idcPipeline = pipeline.getCursor();
		String strFilename = null;
		String strOverwriteFlag = null;
		 
		//Output Variables 
		String successFlag = "false";
		BufferedWriter fileWriter = null;
		
		// Check to see if the filename object is in the pipeline
		if (idcPipeline.first("filename"))
		{
				//get the filename out of the pipeline						
				strFilename = (String)idcPipeline.getValue();	
		
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			System.out.println("Error executing openFileWriter: required parameter 'filename' missing.");
			successFlag="false";
				
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);	
		
			//Always destroy cursors that you created
			idcPipeline.destroy();	
		
			return;
		}
		
		
		// Check to see if the overwriteFlag object is in the pipeline
		if (idcPipeline.first("overwriteFlag"))	
		{
				//get the overwriteFlag out of the pipeline						
				strOverwriteFlag = (String)idcPipeline.getValue();	 
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			System.out.println("Error executing openFileWriter: required parameter 'overwriteFlag' missing.");
			successFlag="false";
				
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);	
		
			//Always destroy cursors that you created
			idcPipeline.destroy();	
		
			return;
		}
		
		// Try to create a BufferedWriter object.  Handle the exception if it fails.
		try
		{
				// Check to see if the overwriteFlag was set to overwrite
				if (strOverwriteFlag.equals("overwrite")) 			
				{
					//Create a new BufferedWriter object that will overwrite the old file
					fileWriter = new BufferedWriter(new FileWriter(strFilename, false));
				}
				// Check to see if the overwriteFlag was set to append
				else
				{
				//Create a new BufferedWriter object that will append to the old file
				fileWriter = new BufferedWriter(new FileWriter(strFilename, true));
				}
			//Set the success flag because the service was successful
				successFlag = "true";
		
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
		 
			//Print the exception out to standard output
			System.out.println("Error executing openFileWriter:" + e.toString());	
		}
		
		//insert the fileWriter into the pipeline
		idcPipeline.insertAfter("fileWriter", fileWriter);	
		
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);	
		
		//Always destroy cursors that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}



	public static final void writeFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required fileWriter
		// [i] field:0:required fileContent
		// [o] object:0:required fileWriter
		// [o] field:0:required successFlag
		//define input variables   
		IDataCursor idcPipeline = pipeline.getCursor();
		String 	strFileContent = null;
		  
		//Output Variables 
		String successFlag = "false";
		BufferedWriter fileWriter = null;
		
		// Check to see if the fileWriter object is in the pipeline
		if (idcPipeline.first("fileWriter"))
		{	
			//get the BufferedWriter stream out of the pipeline					
			fileWriter = (BufferedWriter) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			System.out.println("Error:  fileWriter object is not in the pipeline!!");
			return;
		}
		
		
		// Check to see if the fileContent object is in the pipeline
		if (idcPipeline.first("fileContent"))	
		{
				//get the fileContent out of the pipeline						
				strFileContent = (String) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			System.out.println("Error:  fileContent object is not in the pipeline!!");
			return;
		}
		
		// Try to write to the BufferedWriter object.  Handle the exception if it fails.
		try
		{
			fileWriter.write(strFileContent);
		
			//Set the success flag because the service was successful
			successFlag = "true";
		
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
		
		}
		
		//remove any other successFlags from pipline
		if(idcPipeline.first("successFlag"))
		{
				idcPipeline.delete();
		}
		
		
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);	
		
		//Always destroy cursurs that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}
}

