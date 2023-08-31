package xslt.xsltRuntime.stress;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2005-02-13 05:15:49 EST
// -----( ON-HOST: localhost

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.ServiceThread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
// --- <<IS-END-IMPORTS>> ---

public final class threadsRunTasks

{
	// ---( internal utility methods )---

	final static threadsRunTasks _instance = new threadsRunTasks();

	static threadsRunTasks _newInstance() { return new threadsRunTasks(); }

	static threadsRunTasks _cast(Object o) { return (threadsRunTasks)o; }

	// ---( server methods )---




	public static final void threadsRunTasks (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(threadsRunTasks)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required threadNum
		// [i] field:1:required expectList
		int threadNum = 1;
		String emp = "packages/venusXSLT/pub/emp.xml";
		String[] expectResultList = null;
		String status = "Success";
		Values errors = null;
		
		String timeString = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
		
		IDataCursor idc = pipeline.getCursor();
		
		try {
		  threadNum = Integer.parseInt((String) IDataUtil.get(idc, "threadNum"));
		  expectResultList = IDataUtil.getStringArray( idc, "expectList" );
		} 
		catch (Exception e) {
		    System.err.println("Error parsing input: " +e);
		}
		
		System.out.println("---------- Starting threadsRunTasks... (time:" + timeString + ") ----------");
		
		// SPAWN EACH TEST THREAD
		ServiceThread[] threads = new ServiceThread[threadNum];
		for (int i=0; i < threadNum; i++) {
		
		    IData pushDataInput = IDataFactory.create();
		    IDataCursor pDICursor = pushDataInput.getCursor();
		    IDataUtil.put(pDICursor, "threadID", i+"");
		//Have to give the full path: xslt.xsltRuntime.stress.threadsRunTasks
		    int count = i%10;
		    switch (count){
		      case 0:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeOver20", pushDataInput);
		        break;
		      case 1:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeOver30", pushDataInput);
		        break;
		      case 2:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeOver40", pushDataInput);
		        break;
		      case 3:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeOver50", pushDataInput);
		        break;
		      case 4:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeOver60", pushDataInput);
		        break;
		      case 5:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeUnder30", pushDataInput);
		        break;
		      case 6:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeUnder40", pushDataInput);
		        break;
		      case 7:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeUnder45", pushDataInput);
		        break;
		      case 8:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeUnder50", pushDataInput);
		        break;
		      case 9:
		        IDataUtil.put(pDICursor, "fileName", emp);
		        threads[i] = Service.doThreadInvoke("xslt.xsltRuntime.stress.threadsRunTasks", "runEmpAgeUnder60", pushDataInput);
		        break;
		      
		      default:
		    }
		}
		String result = null;
		
		int index = -1;
		// wait for each thread to complete
		try {
		  for (int i=0; i < threadNum; i++) {
		    // join
		    threads[i].getData();
		    IData idata= threads[i].getIData();
		    IDataCursor idataCursor = idata.getCursor();
		    result = (String) IDataUtil.get(idataCursor, "results");
		    //System.out.println("Thread number=" + i + ",  result=" + result);
		    index = i%10;
		    if (!expectResultList[i%10].equals(result)){
		      System.out.println("*****  Thread number=" + i + " Fail!!! *****");
		      status = "Fail";
		      if (errors == null)
		        errors = new Values();
		      errors.put(i+"", result);  
		    }  
		    //else{
		    //  System.out.println("*****  Thread number=" + i + " success!!! *****");
		    //}
		
		  }//for
		} 
		catch (Exception e) {
		  System.err.println("Error when joing thread: " + e);
		}
		
		if (status.equals("Success"))
		  System.out.println("##### Test success!!! #####"); 
		else
		  System.out.println("##### Test fail!!! #####"); 
		
		idc.insertAfter("status", status);
		idc.insertAfter("errors", errors);
		idc.destroy();
		
		timeString = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
		System.out.println("---------- Finished!!! (time:" + timeString + ") ----------" );
		// --- <<IS-END>> ---

                
	}
}

