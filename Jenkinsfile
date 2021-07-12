pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
               echo "-=- compiling project -=-"

               dir ('customer-service') {
                sh 'mvn clean compile'
               }

               dir ('product-service') {
                sh 'mvn clean compile'
               }

            }
        }
        stage('Unit tests') {
            steps {
               echo "-=- cexecute unit tests -=-"

               dir ('customer-service') {
                sh 'mvn mvn test org.jacoco:jacoco-maven-plugin:report'
                junit 'target/surefire-reports/*.xml'
                jacoco execPattern: 'target/jacoco.exec'
               }

               dir ('product-service') {
                sh 'mvn mvn test org.jacoco:jacoco-maven-plugin:report'
                junit 'target/surefire-reports/*.xml'
                jacoco execPattern: 'target/jacoco.exec'
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