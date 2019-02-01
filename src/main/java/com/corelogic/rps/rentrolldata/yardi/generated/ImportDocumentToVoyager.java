
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
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Database" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Platform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YardiPropertyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InterfaceEntity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InterfaceLicense" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObjId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObjType" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fileExt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttachmentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bytes" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bWebLink" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "userName",
    "password",
    "serverName",
    "database",
    "platform",
    "yardiPropertyId",
    "interfaceEntity",
    "interfaceLicense",
    "objId",
    "objType",
    "fileExt",
    "attachmentType",
    "bytes",
    "suffix",
    "bWebLink"
})
@XmlRootElement(name = "ImportDocumentToVoyager")
public class ImportDocumentToVoyager {

    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "ServerName")
    protected String serverName;
    @XmlElement(name = "Database")
    protected String database;
    @XmlElement(name = "Platform")
    protected String platform;
    @XmlElement(name = "YardiPropertyId")
    protected String yardiPropertyId;
    @XmlElement(name = "InterfaceEntity")
    protected String interfaceEntity;
    @XmlElement(name = "InterfaceLicense")
    protected String interfaceLicense;
    @XmlElement(name = "ObjId")
    protected String objId;
    @XmlElement(name = "ObjType")
    protected long objType;
    protected String fileExt;
    @XmlElement(name = "AttachmentType")
    protected String attachmentType;
    @XmlElement(name = "Bytes")
    protected byte[] bytes;
    protected String suffix;
    protected boolean bWebLink;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the serverName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * Sets the value of the serverName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerName(String value) {
        this.serverName = value;
    }

    /**
     * Gets the value of the database property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Sets the value of the database property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabase(String value) {
        this.database = value;
    }

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatform(String value) {
        this.platform = value;
    }

    /**
     * Gets the value of the yardiPropertyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYardiPropertyId() {
        return yardiPropertyId;
    }

    /**
     * Sets the value of the yardiPropertyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYardiPropertyId(String value) {
        this.yardiPropertyId = value;
    }

    /**
     * Gets the value of the interfaceEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceEntity() {
        return interfaceEntity;
    }

    /**
     * Sets the value of the interfaceEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceEntity(String value) {
        this.interfaceEntity = value;
    }

    /**
     * Gets the value of the interfaceLicense property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceLicense() {
        return interfaceLicense;
    }

    /**
     * Sets the value of the interfaceLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceLicense(String value) {
        this.interfaceLicense = value;
    }

    /**
     * Gets the value of the objId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjId() {
        return objId;
    }

    /**
     * Sets the value of the objId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjId(String value) {
        this.objId = value;
    }

    /**
     * Gets the value of the objType property.
     * 
     */
    public long getObjType() {
        return objType;
    }

    /**
     * Sets the value of the objType property.
     * 
     */
    public void setObjType(long value) {
        this.objType = value;
    }

    /**
     * Gets the value of the fileExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * Sets the value of the fileExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileExt(String value) {
        this.fileExt = value;
    }

    /**
     * Gets the value of the attachmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentType() {
        return attachmentType;
    }

    /**
     * Sets the value of the attachmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentType(String value) {
        this.attachmentType = value;
    }

    /**
     * Gets the value of the bytes property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * Sets the value of the bytes property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBytes(byte[] value) {
        this.bytes = ((byte[]) value);
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the bWebLink property.
     * 
     */
    public boolean isBWebLink() {
        return bWebLink;
    }

    /**
     * Sets the value of the bWebLink property.
     * 
     */
    public void setBWebLink(boolean value) {
        this.bWebLink = value;
    }

}
