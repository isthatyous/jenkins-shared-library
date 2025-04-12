def call(String IMAGE_NAME){
    sh "docekr build -t ${IMAGE_NAME}"
}