# repot6

**Job1 :**  clone the repo and copy on folder and creating Jenkins docker image

*This is Already done in Jenkins Task 3*

**Job2 :**  
By looking at the code or program file, Jenkins should automatically start the respective language interpreter installed image container to deploy code on top of Kubernetes ( eg. If code is of PHP, then Jenkins should start the container that has PHP already installed )
    Expose your pod so that testing team could perform the testing on the pod
    Make the data to remain persistent using PVC ( If server collects some data like logs, other user information )
***Job3 :*** Test your app if it  is working or not.

***Job4 :*** if app is not working , then send email to developer with error
 messages and redeploy the application after code is being edited by the
 developer

# Confinguring
***Configuring the groovy files***
![Pic1](/images/1.png)

***Configuring the Jenkins seed job files***
![Pic2](/images/4.png)

***YAML Files***
Server Deployment yml file
![Pic3](/images/2.png)

Pvc yml
![Pic4](/images/3.png)
**Uploading to git**
![Pic8](/images/10.png)

**Job1 Configured**
![Pic5](/images/5.png)

**Job2 Configured**
![Pic6](/images/6.png)

**Job3 Configured**

![Pic7](/images/7.png)

**Mail configured in same job**
![Pic8](/images/8.png)

**Web server Check**

![Pic8](/images/9.png)



