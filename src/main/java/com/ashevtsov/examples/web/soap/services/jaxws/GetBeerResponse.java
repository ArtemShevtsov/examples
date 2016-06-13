
package com.ashevtsov.examples.web.soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getBeerResponse", namespace = "http://services.soap.web.examples.ashevtsov.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBeerResponse", namespace = "http://services.soap.web.examples.ashevtsov.com/")
public class GetBeerResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ashevtsov.examples.web.soap.beans.Beer _return;

    /**
     * 
     * @return
     *     returns Beer
     */
    public com.ashevtsov.examples.web.soap.beans.Beer getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ashevtsov.examples.web.soap.beans.Beer _return) {
        this._return = _return;
    }

}
