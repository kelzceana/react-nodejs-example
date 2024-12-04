def execute() {
    echo 'Building docker image'
    withCredentials([usernamePassword(credentialsId: 'dockerhub',
                                      passwordVariable: 'PASS',
                                      usernameVariable: 'USER')]) {
        sh '''
                docker build --platform linux/amd64 -t kelzceana/react-app_amd:1.1 .
                echo $PASS | docker login -u $USER --password-stdin
                docker push kelzceana/react-app_amd:1.1
                '''
                                                  }
}
return this
