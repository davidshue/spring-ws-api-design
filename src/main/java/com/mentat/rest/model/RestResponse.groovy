package com.mentat.rest.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement


@XmlAccessorType( XmlAccessType.NONE )
@XmlRootElement(name='response')
class RestResponse {
    @XmlElement
    Map<String, String> data = [a:'1', b:'2', c:'3']
}
