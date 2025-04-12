def call(String credId , String IMAGE_NAME){
     withCredentials([usernamePassword(
                    credentialsId: 'credId',
                    usernameVariable: 'DockerHubUser',
                    passwordVariable: 'DockerHubPass'
                    )]) {
                    
                    echo "Pushing Image to Docker Hub"
                    sh "docker image tag ${IMAGE_NAME} ${DockerHubUser}/${IMAGE_NAME}"
                    sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"
                    sh "docker push ${DockerHubUser}/${IMAGE_NAME}"
                    echo "Image Pushed to Docker Hub Successfully"

                    }
        