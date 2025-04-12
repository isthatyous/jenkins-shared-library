
def call(){
    sh 'trivy fs --severity HIGH,CRITICAL . -o file-system-trivy-report.txt'
}