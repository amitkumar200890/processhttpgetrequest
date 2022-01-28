# processhttpgetrequest
A Java Utility to call API in batch

Java main mehod is in ProcessApiRequest.java. To run this program we need to pass 1 argument as the complete path of the file to read id.
Main method will use the services of ExecutorService to call api in batches of 5.

To call API one helper thread is defined: utilityThread.java

Utility thread will be called only once for all the ids, and the utility thread will call the API ids and print the result into console.
