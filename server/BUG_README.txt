There is a known bug with glassfish 4.1.1 when working with web services. (https://java.net/jira/browse/GLASSFISH-21440)

When attempting to return JSON an error is thrown, to fix this issue the MANIFEST.MF in the org.eclipse.persistence.moxy.jar file needs to be manually updated to include missing import packages. 

File location: glassfish/modules/org.eclipse.persistence.moxy.jar

Solution: http://stackoverflow.com/questions/33722764/glassfish-error-when-producing-json

It would seem this bug has been around for a long time now... 