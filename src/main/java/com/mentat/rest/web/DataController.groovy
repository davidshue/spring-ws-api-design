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


package com.mentat.rest.web

import static org.springframework.http.MediaType.*

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

import com.mentat.rest.model.Person


/**
 * TODO Document DataController
 */
@Controller
class DataController {
    @RequestMapping(value='/person', produces = [
        APPLICATION_JSON_VALUE,
        TEXT_XML_VALUE
    ])
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody Object data() {
        return new Person(name:'Brad Pitt', age:50)
    }
}
