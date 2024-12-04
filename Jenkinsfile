pipeline {
    agent any
    tools {
        nodejs 'node'
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
        stage ('deploy to EC2') {
            steps {
                script {
                    def dockerCmd = 'docker run -d -p 3000:3080 kelzceana/react-app:latest'
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@54.165.47.234 ${dockerCmd}"
                    }
                }
            }
        }
    }
}
