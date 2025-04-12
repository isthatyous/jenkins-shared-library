def call(String credId , String IMAGE_NAME){
     withCredentials([usernamePassword(
                    credentialsId: credId,
                    usernameVariable: 'DockerHubUser',
                    passwordVariable: 'DockerHubPass'
                    )]) {
                    
                    echo "Pushing Image to Docker Hub"
                    sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}"
                    sh "docker image tag ${IMAGE_NAME} ${env.DockerHubUser}/${IMAGE_NAME}"
                    sh "docker push ${env.DockerHubUser}/${IMAGE_NAME}:latest"
                    echo "Image Pushed to Docker Hub Successfully"

                    }
}
        
