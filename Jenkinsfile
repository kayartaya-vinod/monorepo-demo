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
               runTests('customer-service')
               runTests('product-service')
            }
        }

        stage('Build') {
            steps {
                echo "-=- packaging project -=-"
                createBuild('customer-service')
                createBuild('product-service')
            }
        }
    }
}

def compile(dirName){
    when {
        changeset dirName+"/*.*"
        beforeAgent true
        dir (dirName) {
            sh 'mvn clean compile'
        }
    }
}

def runTests(dirName){
    dir(dirName){
        sh 'mvn test'
        junit 'target/surefire-reports/*.xml'
    }
}

def createBuild(dirName){
    dir (dirName) {
        sh "mvn package -DskipTests"
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
}