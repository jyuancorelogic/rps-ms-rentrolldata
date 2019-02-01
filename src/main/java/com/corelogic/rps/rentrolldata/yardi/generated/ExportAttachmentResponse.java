
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
 *         &lt;element name="ExportAttachmentResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "exportAttachmentResult"
})
@XmlRootElement(name = "ExportAttachmentResponse")
public class ExportAttachmentResponse {

    @XmlElement(name = "ExportAttachmentResult")
    protected byte[] exportAttachmentResult;

    /**
     * Gets the value of the exportAttachmentResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getExportAttachmentResult() {
        return exportAttachmentResult;
    }

    /**
     * Sets the value of the exportAttachmentResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setExportAttachmentResult(byte[] value) {
        this.exportAttachmentResult = ((byte[]) value);
    }

}
