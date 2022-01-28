# processhttpgetrequest
A Java Utility to call API in batch

Java main mehod is in ProcessApiRequest.java. To run this program we need to pass 1 argument as the complete pah of the file to read id.
Main method will use the services of ExecutorService to call api in batches of 5.

To call API one helper thread is defined: utilityThread.java

Utility will call the API only once for all the ids and print the result into console.
