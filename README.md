# SOAP MASTERY

First The Internet Had Static COntents, hich Get Outdated Over Time..

In other to provide dynamic content to web users, 2-tier web applications were realized with the introduction of 
*Common Gateway Interface* (CGI). 

WHich retrieves content from external data resources eg DB.

CGI acts as aclient, in client server architecture. 
CGI process the request and return to web server. 
The server then format the content in HTML and returns to the browser for
display...

### WebService

WS is a software application identified by a URI whose interfaces and binding
are capable og being defined and discovered by XML artifacts
And they support direct interaction with other software applications using
XML based messages via Internet-based protocols...

WS must involve web-based protocol such as HTTP 
or SImple Mail Transfer Protocol (SMTP). Other transport protocols may 
be used, but HTTP is the most common one being used. HTTPS
uses Secure Socket Layer (SSL) or Transport Secure Layer (TLS) 
for secured transport of data. In regard
to software development concerns, the difference between HTTP 
and HTTPS is trivial. HTTP, thus, is
used throughout this text.

A Web Service is a software application that requires interaction 
with another application. WS is a software integration technique for 
a B2B type of integration.

Here, one application acts as a service
provider (server) and the others act as service consumers (clients).
This is a many-to-one relationship...

‘Interface’ is defined as “[The] point of interaction or communication
between a computer and any other
entity”

An interface can also be described as an “abstraction of a
service that only defines the operations supported by the service 
(publicly accessible variable, procedures,
or methods), but not their implementation” (Szyperski, 2002).
For example, in Java, an interface can be
defined and then implemented by a concrete class. 

Web Service Description Language (WSDL) specifies the service 
interface and the rules for binding the
service consumer and the provider.

WSDL is defined as an XML format for describing network services as a set
of endpoint operating on messages containing either document-oriented or
procedure-oriented information...
WSDL defineds how a consumer can interact with service via a 
concrete protocol and message format using extended markup language

XML is a profile (subset) of Standard Generalized Markup Language (SGML).
SGML is a metalanguage,  i.e., a language that describes other languages.
Unlike HyperText Markup Language (HTML), which is
used to serve static webpages, XML allows the author to create his or
her own tags. Thus, XML facilitates
the data and document processing function

Universal Discovery, Description and
Integration (UDDI), and Metadata Registry (MDR). UDDI is usually a 
good idea; however, it is not
widely used except in a private network of service

Web Service relies on Simple Object Application Protocol (SOAP) as its 
transport. 
As its name implies,
SOAP is a lightweight protocol that can be used to 
exchange structured messages (i.e., XML).

- Service requester – the client that consumes or requests the service
- Service provider – the entity that implements the service and fulfill the service requests
- Service registry – a listing like a phonebook where available services are 
listed and described in full


The top-down approach may increase the level of interoperability 
and allow more control of the WS, wehereas the bottom-up approach 
starts at the low level of the Java bean or enterprise Java bean
(EJB) and is faster and easier.


*SOAP Message Request*
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:emp="http://employees.ws.bemach.com/">
<soapenv:Header />
<soapenv:Body>
 <emp:getEmployee>
 <emplNo>100011</emplNo>
 </emp:getEmployee>
</soapenv:Body>
</soapenv:Envelope>
```

*SOAP response message*
When the SOAP server successfully processes a request, a response is then marshaled into an XML
document and returned as a part of HTTP response to the client.
The client SOAP engine then unmarshals 
the message to further process the result of the call.

* A SOAP header is not used.
* The SOAP body has a single element, ns2:getEmployeeResponse.
Note that namespace, ns2, is used and referenced.
* Within the SOAP body, an employee record is returned.

```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
<S:Body>
 <ns2:getEmployeeResponse xmlns:ns2="http://employees.ws.bemach.com/"
 xmlns:ns3="http://bemach.com">
 <return>
 <emplNo>100011</emplNo>
 <firstName>Shmuel</firstName>
 <lastName>Birge</lastName>
 <birthDate>1956-07-20T00:00:00-04:00</birthDate>
 <gender>M</gender>
 <hireDate>1989-11-23T00:00:00-05:00</hireDate>
 </return>
 </ns2:getEmployeeResponse>
</S:Body>
</S:Envelope>
```

*SOAP fault message*
If a request contains an invalid employee number, then a SOAP fault 
message can be optionally returned.
A SOAP fault may contain messages that help the client to 
resolve an error or unexpected condition. It
must include a fault code, fault string, and a detailed error message.

```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
<S:Body>
 <S:Fault xmlns:ns4="http://www.w3.org/2003/05/soap-envelope">
 <faultcode>S:Server</faultcode>
 <faultstring>No such employee!</faultstring>
 <detail>
 <ns2:SOAPException xmlns:ns2="http://employees.ws.bemach.com/"
 xmlns:ns3="http://bemach.com">
 <message>No such employee!</message>
 </ns2:SOAPException>
 </detail>
 </S:Fault>
</S:Body>
</S:Envelope>
```

http://localhost:9999/java-ws/hello?xsd=1


- Open a command prompt or a Unix terminal.
- Go to the java-ws-client project directory.
- Create a ‘generated’ directory.
- Create a ‘lib’ directory.
- Go to the ‘generated’ directory.
- Run the following command:
`wsimport -d . http://localhost:9999/java-ws/hello?wsdl`
- Package the generated client code:
`jar cvf ../java-ws-generated.jar *`
- Move the java-ws-generated.jar file to the ‘lib’ directory