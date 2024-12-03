pipeline {
    agent {
        docker {
            image 'node:18-alpine'
            reuseNode true
        }
    }
    stages {
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
                    withCredentials([usernamePassword(credentialsId: 'dockerhub',
                                                      usernameVariable: 'USER',
                                                      passwordVariable: 'PASS')]) {
                        sh '''
                       docker build -t kelzceana/my-webapp:latest .
                       echo $PASS | docker login -u $USER --password-stdin
                       docker push kelzceana/my-webapp:latest
                    '''
                                                      }
                }
            }
        }
    }
}