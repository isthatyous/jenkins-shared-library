def call(String IMAGE_NAME){
    sh "trivy image --severity HIGH,CRITICAL ${IMAGE_NAME} -o docker-image-trivy-report.txt"
}