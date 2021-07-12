pipeline {
    agent none
    stages {
        stage('Build services') {
            steps {
               dir (/customer-service) {
                sh 'mvn -B -DskipTests clean package'
               }
               dir (/product-service) {
                sh 'mvn -B -DskipTests clean package'
               }
            }
        }
    }
}