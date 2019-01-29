
package com.corelogic.rps.rentrolldata.yardi.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImportDocumentToVoyagerResult" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importDocumentToVoyagerResult"
})
@XmlRootElement(name = "ImportDocumentToVoyagerResponse")
public class ImportDocumentToVoyagerResponse {

    @XmlElement(name = "ImportDocumentToVoyagerResult")
    protected long importDocumentToVoyagerResult;

    /**
     * Gets the value of the importDocumentToVoyagerResult property.
     * 
     */
    public long getImportDocumentToVoyagerResult() {
        return importDocumentToVoyagerResult;
    }

    /**
     * Sets the value of the importDocumentToVoyagerResult property.
     * 
     */
    public void setImportDocumentToVoyagerResult(long value) {
        this.importDocumentToVoyagerResult = value;
    }

}
