/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.mentat.rest.model

import org.junit.Test

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper



/**
 * TODO Document RestResponseTest
 */
class RestResponseTest {
    @Test
    void test() {
        RestResponse result = new RestResponse()

        //        JAXBContext jaxbContext = JAXBContext.newInstance(RestResponse.class)
        //        Marshaller jaxbMarshaller = jaxbContext.createMarshaller()
        //        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        //        jaxbMarshaller.marshal(result, System.out)

        JacksonXmlModule module = new JacksonXmlModule()
        module.setDefaultUseWrapper(false)
        XmlMapper xmlMapper = new XmlMapper(module)

        xmlMapper.writeValue(System.out, result)

        String xml = xmlMapper.writeValueAsString(result)
        println xml

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter()
        print ow.writeValueAsString(result)
    }
}
