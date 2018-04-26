pipeline {
    agent any

    stages {
        stage('Unit Test Stage') {
            steps {
               bat "mvn -Dtest=Unit* test"
            }
        }
        stage('Integration Test Stage') {
            steps {
               bat "mvn -Dtest=Integration* test"
            }
        }
        stage('System Test Stage') {
            steps {
               bat "mvn -Dtest=System* test"
            }
        }
    }
}