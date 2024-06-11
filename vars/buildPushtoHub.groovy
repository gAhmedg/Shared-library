def call(Map config = [:]) {
    // Build the Docker image
    def dockerfileFlag = config.dockerfile ? "-f ${config.dockerfile}" : ""
    sh "docker build ${dockerfileFlag} --tag ${config.image} ${config.context}"
    
    // Login to Dockerhub using provided credentials
    withCredentials([usernamePassword(credentialsId: config.DockerCredentials, passwordVariable: 'password', usernameVariable: 'user')]) {
        sh "docker login -u ${user} -p ${password}"
    }
    
    // Push the built image to Dockerhub
    sh "docker push ${config.image}"
}
