/**
 * ProductRelease.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aspose;

@SuppressWarnings("serial")
public class ProductRelease  implements java.io.Serializable {
    private java.lang.String fileName;

    private java.lang.String versionNumber;

    private java.lang.String changeLog;

    private java.lang.String downloadLink;

    public ProductRelease() {
    }

    public ProductRelease(
           java.lang.String fileName,
           java.lang.String versionNumber,
           java.lang.String changeLog,
           java.lang.String downloadLink) {
           this.fileName = fileName;
           this.versionNumber = versionNumber;
           this.changeLog = changeLog;
           this.downloadLink = downloadLink;
    }


    /**
     * Gets the fileName value for this ProductRelease.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this ProductRelease.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the versionNumber value for this ProductRelease.
     * 
     * @return versionNumber
     */
    public java.lang.String getVersionNumber() {
        return versionNumber;
    }


    /**
     * Sets the versionNumber value for this ProductRelease.
     * 
     * @param versionNumber
     */
    public void setVersionNumber(java.lang.String versionNumber) {
        this.versionNumber = versionNumber;
    }


    /**
     * Gets the changeLog value for this ProductRelease.
     * 
     * @return changeLog
     */
    public java.lang.String getChangeLog() {
        return changeLog;
    }


    /**
     * Sets the changeLog value for this ProductRelease.
     * 
     * @param changeLog
     */
    public void setChangeLog(java.lang.String changeLog) {
        this.changeLog = changeLog;
    }


    /**
     * Gets the downloadLink value for this ProductRelease.
     * 
     * @return downloadLink
     */
    public java.lang.String getDownloadLink() {
        return downloadLink;
    }


    /**
     * Sets the downloadLink value for this ProductRelease.
     * 
     * @param downloadLink
     */
    public void setDownloadLink(java.lang.String downloadLink) {
        this.downloadLink = downloadLink;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductRelease)) return false;
        ProductRelease other = (ProductRelease) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.versionNumber==null && other.getVersionNumber()==null) || 
             (this.versionNumber!=null &&
              this.versionNumber.equals(other.getVersionNumber()))) &&
            ((this.changeLog==null && other.getChangeLog()==null) || 
             (this.changeLog!=null &&
              this.changeLog.equals(other.getChangeLog()))) &&
            ((this.downloadLink==null && other.getDownloadLink()==null) || 
             (this.downloadLink!=null &&
              this.downloadLink.equals(other.getDownloadLink())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getVersionNumber() != null) {
            _hashCode += getVersionNumber().hashCode();
        }
        if (getChangeLog() != null) {
            _hashCode += getChangeLog().hashCode();
        }
        if (getDownloadLink() != null) {
            _hashCode += getDownloadLink().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductRelease.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://aspose.com/", "ProductRelease"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://aspose.com/", "FileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://aspose.com/", "VersionNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeLog");
        elemField.setXmlName(new javax.xml.namespace.QName("http://aspose.com/", "ChangeLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("downloadLink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://aspose.com/", "DownloadLink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
