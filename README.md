# processhttpgetrequest
A Java Utility to call API in batch

Java main mehod is in ProcessApiRequest.java. To run this program we need to pass 1 argument as the complete path of the file to read id.
Main method will use the services of ExecutorService to call api in batches of 5.

To call API one helper thread is defined: utilityThread.java

Utility thread will be called only once for all the ids, and the utility thread will call the API ids and print the result into console.

Steps to Run the program in Eclipse
1. create a java project named as: process-http-request
2. Go to src folder and create a package named as: com.apiprocess.utility
3. Download the java files (ProcessApiRequest.java, utilityThread.java) from location https://github.com/amitkumar200890/processhttpgetrequest
and paste these two files under the package (com.apiprocess.utility) created in step 2
4. Create a text file which will include the id. (1 id per line) as in TestData.text ()
5. We need to send the above text file as an argument. Follow the steps to configure it in eclipse.
   5.1. Right click on the newly created Project
   5.2. click on the Properties
   5.3. Click on Run/Debug settings
   5.4. Click on New and select the Java Application and click Ok
   5.5. Click on Main and add Project: as process-http-request and Main class: as com.apiprocess.utility.ProcessApiRequest and click on Apply
   5.5. Now Click on (x)= Arguments
   5.6. Add the complete path of the text file. ex: C:\Users\Amit\Desktop\TestData.txt
        under Program arguments and click on Apply and then click on Ok.
   5.7  click on Apply and Close
6. Right click on Project (process-http-request) -> click on Run AS -> Java Application

In console we will see the input as well as output.
