<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PATCH Update booking with Authorization</name>
   <tag></tag>
   <elementGuidId>f5802d9c-edba-48eb-b8a5-ec7de20ca348</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;firstname\&quot; : \&quot;${firstName}\&quot;,\n    \&quot;lastname\&quot; : \&quot;${lastName}\&quot;,\n    \&quot;totalprice\&quot; : $totalPrice,\n    \&quot;depositpaid\&quot; : $depositPaid,\n    \&quot;bookingdates\&quot; : {\n        \&quot;checkin\&quot; : \&quot;${checkIn}\&quot;,\n        \&quot;checkout\&quot; : \&quot;${checkOut}\&quot;\n    },\n    \&quot;additionalneeds\&quot; : \&quot;Breakfast\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>99f6816c-3e60-4683-97fc-517f45e4924e</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>f91e6e0a-08aa-4acc-b12c-4a064efb9b43</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic YWRtaW46cGFzc3dvcmQxMjM=</value>
      <webElementGuid>6f271ff7-ede3-4292-a992-381e70db585d</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.1.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>${GlobalVariable.baseUrl}/booking/${id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Huong01'</defaultValue>
      <description></description>
      <id>545bde50-ab7c-4424-86de-1c882d425d48</id>
      <masked>false</masked>
      <name>firstName</name>
   </variables>
   <variables>
      <defaultValue>'Phan01'</defaultValue>
      <description></description>
      <id>fa742f6c-db7d-4218-84bf-712d10d75c79</id>
      <masked>false</masked>
      <name>lastName</name>
   </variables>
   <variables>
      <defaultValue>200</defaultValue>
      <description></description>
      <id>005de13a-f0c0-4d51-9a18-14a12c4402b7</id>
      <masked>false</masked>
      <name>totalPrice</name>
   </variables>
   <variables>
      <defaultValue>false</defaultValue>
      <description></description>
      <id>55273b3e-6436-4442-945f-b54288e731c6</id>
      <masked>false</masked>
      <name>depositPaid</name>
   </variables>
   <variables>
      <defaultValue>'2023-01-01'</defaultValue>
      <description></description>
      <id>59379760-16de-4ee0-9055-c483a2de99b0</id>
      <masked>false</masked>
      <name>checkIn</name>
   </variables>
   <variables>
      <defaultValue>'2023-12-12'</defaultValue>
      <description></description>
      <id>b2a7917c-f279-4001-9e79-b4fed5545239</id>
      <masked>false</masked>
      <name>checkOut</name>
   </variables>
   <variables>
      <defaultValue>'4367'</defaultValue>
      <description></description>
      <id>a1d8e95f-6fc8-40d4-88e5-0b159fe8c17f</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
