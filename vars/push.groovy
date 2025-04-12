def call(String credId, String IMAGE_NAME) {
    withCredentials([usernamePassword(
        credentialsId: credId,
        usernameVariable: 'DockerHubUser',
        passwordVariable: 'DockerHubPass'
    )]) {

        echo "Pushing Image to Docker Hub"
        sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"
        sh "docker image tag ${IMAGE_NAME} ${DockerHubUser}/${IMAGE_NAME}:latest"
        sh "docker push ${DockerHubUser}/${IMAGE_NAME}:latest"
        echo "Image Pushed to Docker Hub Successfully"
    }
}
