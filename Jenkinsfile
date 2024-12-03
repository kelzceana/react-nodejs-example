pipeline {
    agent {
        docker {
            image 'node:18-alpine'
            reuseNode true
        }
    }
    stages {
        stage('Init') {
            steps {
                script {
                    buildimage = load 'script/buildimage.groovy'
                }
            }
        }
        stage('Build Package') {
            steps {
                script {
                    sh 'npm install'
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                    buildimage.execute()
                }
            }
        }
    }
}
