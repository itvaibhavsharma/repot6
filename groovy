job("job1") {
description("Launch the pods and deploy files")
  scm {
  	github('https://github.com/itvaibhavsharma/repot6.git','master')
  }
 triggers {  
 	scm("* * * * *")
 }
  steps {
  shell('''
  rm -rf /proj6
  mkdir /proj6
  cp -rvf * /task6
  ''')
  	}
  }
  
job("job2") {
description("deploy the code")
 triggers {  
 	upstram('job1','SUCCESS')
 }
  steps {
  shell('''
  if sudo ls /proj6 | grep html
  	then
  if kubectl get pvc | grep html
  then
  echo "PVC already present"
  else
  kubectl create -f /proj6/pvc.yml
  fi
  if kubectl get deploy | grep webserver
  then
    echo "already present"
  else
  	kubectl create -f /proj6/html.yml
  fi
  else
  echo "no html found"
  fi
  html=$(kubectl get pod -l aap=webserver -o jsonpath="{.item[0].metadata.name}")
  kubectl cp /proj6/*.html $html:/usr/local/apache2/htdocs ''')
  }
  }
  
job("job3") {
description("checking the code")
 triggers {  
 	upstram('job2','SUCCESS')
 }
  steps {
  shell('''
  status=$(curl -o /dev/null -sw "%{http_code}" http://192.168.99.100:31000/)
  if [[ $status == 200 ]]
  then
  	echo "Its working all fine"
  	exit 0
  	else
  	exit 1
  fi ''')
  }
  publishers {
        extendedEmail {
            recipientList('itvaibhavsharma@gmail.com')
            defaultSubject('Oops')
            defaultContent('Something broken')
            contentType('text/html')
            triggers {
                beforeBuild()
                stillUnstable {
                    subject('Subject')
                    content('Body')
                    sendTo {
                        developers()
                        requester()
                        culprits()
                    }
                }
            }
        }
    }
  }


