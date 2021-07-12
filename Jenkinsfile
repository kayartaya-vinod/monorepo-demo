pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
               echo "-=- compiling project -=-"
               compile('customer-service')
               compile('product-service')
            }
        }
        stage('Unit tests') {
            steps {
               echo "-=- cexecute unit tests -=-"

               dir ('customer-service') {
                sh 'mvn test'
                junit 'target/surefire-reports/*.xml'
               }

               dir ('product-service') {
                sh 'mvn test'
                junit 'target/surefire-reports/*.xml'
               }
               
            }
        }

        stage('Package') {
            steps {
                echo "-=- packaging project -=-"
                dir ('customer-service') {
                    sh "mvn package -DskipTests"
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
                dir ('product-service') {
                    sh "mvn package -DskipTests"
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }
}

def compile(dirName){
    dir (dirName) {
        sh 'mvn clean compile'
    }
}