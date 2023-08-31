package xslt.xsltRuntime.stress;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2005-02-13 04:56:23 EST
// -----( ON-HOST: localhost

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.ServiceThread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;
// --- <<IS-END-IMPORTS>> ---

public final class threadsRunSameTask

{
	// ---( internal utility methods )---

	final static threadsRunSameTask _instance = new threadsRunSameTask();

	static threadsRunSameTask _newInstance() { return new threadsRunSameTask(); }

	static threadsRunSameTask _cast(Object o) { return (threadsRunSameTask)o; }

	// ---( server methods )---




	public static final void threadsRunFoo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(threadsRunFoo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required threadNum
		int threadNum = 1;
		String outXmlData = null;
		String baseXmlData = null;
		String expect = null;
		String expectPart1 = null;
		String expectPart2 = null;
		String status = "Success";
		Values errors = null;
		
		String timestamp = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
		
		IDataCursor idc = pipeline.getCursor();
		System.out.println("---------- Starting threadsRunFoo... (time:" + timestamp + ") ----------");
		
		try {
		  threadNum = Integer.parseInt((String) IDataUtil.get(idc, "threadNum"));
		  baseXmlData = (String) IDataUtil.get(idc, "baseXmlData");
		  int index = baseXmlData.lastIndexOf("1");
		  expectPart1 = baseXmlData.substring(0, index); 
		  expectPart2 = baseXmlData.substring(index+1);
		
		  //System.out.println("baseXmlData=" + baseXmlData);
		  //System.out.println("index=" + index);  
		  //System.out.println("expectPart1=" + expectPart1); 
		  //System.out.println("expectPart2=" + expectPart2);     
		
		
		} 
		catch (Exception e) {
		  System.err.println("Error parsing input: " +e + "!!!");
		}
		
		//SPAWN EACH TEST THREAD
		ServiceThread[] threads = new ServiceThread[threadNum];
		for (int i=0; i < threadNum; i++) {
		    IData pushDataInput = IDataFactory.create();
		    IDataCursor pDICursor = pushDataInput.getCursor();
		    IDataUtil.put(pDICursor, "threadID", i+"");
		    //Have to give the full path: xslt.xsltRuntime.stress.threadsRunSameTask
		    threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunSameTask", "runFoo", pushDataInput);
		}
		
		// wait for each thread to complete
		try{
		  for (int i=0; i < threadNum; i++) { 
		    // join
		    threads[i].getData();
		    IData idata= threads[i].getIData();
		    IDataCursor idataCursor = idata.getCursor();
		    outXmlData = (String) IDataUtil.get(idataCursor, "outXmlData");
		    String threadID = (new Integer(i)).toString();
		    //check result
		    //at runtime replaceAll method did not work
		    //expect = baseXmlData.replaceAll("1", threadID); 
		    expect = expectPart1 + i + expectPart2;
		    if (!expect.equals(outXmlData)){
		      status = "Fail";
		    if (errors == null)
		      errors = new Values();
		    errors.put(i+"", outXmlData);  
		      //System.out.println("##### Test fail!!!");   
		    }
		    //else {
		    //  System.out.println("##### Test success!!!");  
		    //}
		    //System.out.println("Thread number=" + i + ",   " + "outXmlData=" + outXmlData);
		    //System.out.println("expect=" + expect);
		  }//for
		} 
		catch (Exception e) {
		  System.out.println("Exception occured:" + e);
		}
		if (status.equals("Success"))
		  System.out.println("##### Test success!!! #####"); 
		else
		  System.out.println("##### Test fail!!! #####"); 
		
		idc.insertAfter("status", status);
		idc.insertAfter("errors", errors); 
		idc.destroy();
		timestamp = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
		System.out.println("---------- Finished!!! (time:" + timestamp + ") ----------");
		// --- <<IS-END>> ---

                
	}
}

