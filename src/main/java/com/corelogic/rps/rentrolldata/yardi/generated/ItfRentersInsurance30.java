package com.corelogic.rps.rentrolldata.yardi.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * Yardi Renter's Insurance v3.0 Web Service. Utilizes XML in Renter's Insurance Yardi Standard Utilizing MITS Core Data 3.0. All web methods contained in this web service that read/write data from Voyager will require login credentials.
 *
 * This class was generated by Apache CXF 2.5.1
 * 2019-02-05T15:44:01.131+05:30
 * Generated source version: 2.5.1
 * 
 */
@WebServiceClient(name = "ItfRentersInsurance3_0", 
                  wsdlLocation = "file:/D:/MS/rps-ms-rentrolldata/src/main/resources/wsdl/ItfRentersinsurance.wsdl",
                  targetNamespace = "http://tempuri.org/YSI.Interfaces.WebServices/ItfRentersInsurance30") 
public class ItfRentersInsurance30 extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://tempuri.org/YSI.Interfaces.WebServices/ItfRentersInsurance30", "ItfRentersInsurance3_0");
    public final static QName ItfRentersInsurance30Soap = new QName("http://tempuri.org/YSI.Interfaces.WebServices/ItfRentersInsurance30", "ItfRentersInsurance3_0Soap");
    public final static QName ItfRentersInsurance30Soap12 = new QName("http://tempuri.org/YSI.Interfaces.WebServices/ItfRentersInsurance30", "ItfRentersInsurance3_0Soap12");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/MS/rps-ms-rentrolldata/src/main/resources/wsdl/ItfRentersinsurance.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ItfRentersInsurance30.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/MS/rps-ms-rentrolldata/src/main/resources/wsdl/ItfRentersinsurance.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ItfRentersInsurance30(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ItfRentersInsurance30(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ItfRentersInsurance30() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ItfRentersInsurance30(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ItfRentersInsurance30(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ItfRentersInsurance30(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ItfRentersInsurance30Soap
     */
    @WebEndpoint(name = "ItfRentersInsurance3_0Soap")
    public ItfRentersInsurance30Soap getItfRentersInsurance30Soap() {
        return super.getPort(ItfRentersInsurance30Soap, ItfRentersInsurance30Soap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ItfRentersInsurance30Soap
     */
    @WebEndpoint(name = "ItfRentersInsurance3_0Soap")
    public ItfRentersInsurance30Soap getItfRentersInsurance30Soap(WebServiceFeature... features) {
        return super.getPort(ItfRentersInsurance30Soap, ItfRentersInsurance30Soap.class, features);
    }
    /**
     *
     * @return
     *     returns ItfRentersInsurance30Soap
     */
    @WebEndpoint(name = "ItfRentersInsurance3_0Soap12")
    public ItfRentersInsurance30Soap getItfRentersInsurance30Soap12() {
        return super.getPort(ItfRentersInsurance30Soap12, ItfRentersInsurance30Soap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ItfRentersInsurance30Soap
     */
    @WebEndpoint(name = "ItfRentersInsurance3_0Soap12")
    public ItfRentersInsurance30Soap getItfRentersInsurance30Soap12(WebServiceFeature... features) {
        return super.getPort(ItfRentersInsurance30Soap12, ItfRentersInsurance30Soap.class, features);
    }

}
