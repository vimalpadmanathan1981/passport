pipeline{
   agent {
    docker {
      image 'maven:3.6.3-jdk-11'
      args '-v /root/.m2:/root/.m2'
    }
  }
  stages {
      stage("Maven Build"){
          steps{
              sh 'mvn -B -DskipTests clean package'
          }
      }
      
     stage("Build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('SonarPassport') {
                sh 'java -version'
                sh 'mvn clean package sonar:sonar'
              }
            }
          }
     stage('Deploy to artifactory'){
        steps{
        rtUpload(
         serverId : 'ARTIFACTORY_SERVER',
         spec :'''{
           "files" :[
           {
           "pattern":"target/*.jar",
           "target":"art-doc-devo-loc"
           }
           ]
         }''',
         
      )
      }
     
     post{
                success{
                    echo "========Deploying executed successfully========"
                   mail bcc: '', body: 'deploying is sucesfull', cc: '', from: '', replyTo: '', subject: 'deployed', to: 'mukeshkousalya2k17@gmail.com '

                }
                
                failure{
                    echo "========Deploying stage execution failed========"
                }
            }
        
     }
    }
  }

           
