import groovy.json.JsonSlurper

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



def xml = new XmlSlurper().parse('/Users/dshue1/Downloads/DiaroExport.xml')
xml.table.r.c.each {
    if (it.@n == 'date') {
        def s = it.text() as long
        println new Date(s)
    }
    if (it.@n == 'location') {
        println it.text()
    }
    if (it.@n == 'title' || it.@n == 'text') {
        println it.text()
    }
    println ''
}

//http://maps.googleapis.com/maps/api/geocode/json?latlng=37.757411,-122.4354&sensor=false
String getAddress(coordinate) {
    String[] pos = coordinate.split(',')
    String longitude = pos[1]
    String latitude = pos[0]
    String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=${latitude},${longitude}&sensor=false"
    Reader reader = new URL(url).newReader()
    def json = new JsonSlurper().parse(reader)

    return json.results.formatted_address[0]
}
