/**
 * Review.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.wsd.soap.client;

public class Review  implements java.io.Serializable {
    private int authorId;

    private java.util.Calendar date;

    private java.lang.String description;

    private java.lang.String headline;

    private int hotelId;

    private int id;

    private int rating;

    public Review() {
    }

    public Review(
           int authorId,
           java.util.Calendar date,
           java.lang.String description,
           java.lang.String headline,
           int hotelId,
           int id,
           int rating) {
           this.authorId = authorId;
           this.date = date;
           this.description = description;
           this.headline = headline;
           this.hotelId = hotelId;
           this.id = id;
           this.rating = rating;
    }


    /**
     * Gets the authorId value for this Review.
     * 
     * @return authorId
     */
    public int getAuthorId() {
        return authorId;
    }


    /**
     * Sets the authorId value for this Review.
     * 
     * @param authorId
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }


    /**
     * Gets the date value for this Review.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this Review.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the description value for this Review.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Review.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the headline value for this Review.
     * 
     * @return headline
     */
    public java.lang.String getHeadline() {
        return headline;
    }


    /**
     * Sets the headline value for this Review.
     * 
     * @param headline
     */
    public void setHeadline(java.lang.String headline) {
        this.headline = headline;
    }


    /**
     * Gets the hotelId value for this Review.
     * 
     * @return hotelId
     */
    public int getHotelId() {
        return hotelId;
    }


    /**
     * Sets the hotelId value for this Review.
     * 
     * @param hotelId
     */
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }


    /**
     * Gets the id value for this Review.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Review.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the rating value for this Review.
     * 
     * @return rating
     */
    public int getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this Review.
     * 
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Review)) return false;
        Review other = (Review) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.authorId == other.getAuthorId() &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.headline==null && other.getHeadline()==null) || 
             (this.headline!=null &&
              this.headline.equals(other.getHeadline()))) &&
            this.hotelId == other.getHotelId() &&
            this.id == other.getId() &&
            this.rating == other.getRating();
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
        _hashCode += getAuthorId();
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getHeadline() != null) {
            _hashCode += getHeadline().hashCode();
        }
        _hashCode += getHotelId();
        _hashCode += getId();
        _hashCode += getRating();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Review.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.wsd.uts/", "review"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("headline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "headline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hotelId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hotelId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rating");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
