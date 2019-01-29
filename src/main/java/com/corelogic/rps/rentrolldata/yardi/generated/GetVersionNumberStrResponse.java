
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
 *         &lt;element name="GetVersionNumber_StrResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getVersionNumberStrResult"
})
@XmlRootElement(name = "GetVersionNumber_StrResponse")
public class GetVersionNumberStrResponse {

    @XmlElement(name = "GetVersionNumber_StrResult")
    protected String getVersionNumberStrResult;

    /**
     * Gets the value of the getVersionNumberStrResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetVersionNumberStrResult() {
        return getVersionNumberStrResult;
    }

    /**
     * Sets the value of the getVersionNumberStrResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetVersionNumberStrResult(String value) {
        this.getVersionNumberStrResult = value;
    }

}
