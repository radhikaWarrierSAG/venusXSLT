package xslt.wmXSLT.inputs;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-03-12 14:04:10 EDT
// -----( ON-HOST: MCDGAYHART02.eur.ad.sag

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class nullxslparaminput

{
	// ---( internal utility methods )---

	final static nullxslparaminput _instance = new nullxslparaminput();

	static nullxslparaminput _newInstance() { return new nullxslparaminput(); }

	static nullxslparaminput _cast(Object o) { return (nullxslparaminput)o; }

	// ---( server methods )---




	public static final void setnull (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(setnull)>> ---
		// @sigtype java 3.5
		// [o] record:0:required indoc1 hints[{field_largerEditor,false},{field_password,false}]
		IDataUtil.put(pipeline.getCursor(), "indoc1", null);
		// --- <<IS-END>> ---

                
	}
}

