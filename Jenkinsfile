pipeline {
    agent any

    stages {
        stage('Unit Test Stage') {
            steps {
               bat "mvn -pl Jenkins -Dtest=Unit* test"
            }
        }
        stage('Integration Test Stage') {
            steps {
               bat "mvn -pl Jenkins -Dtest=Integration* test"
            }
        }
        stage('System Test Stage') {
            steps {
               bat "mvn -pl Jenkins -Dtest=System* test"
            }
        }
    }
}