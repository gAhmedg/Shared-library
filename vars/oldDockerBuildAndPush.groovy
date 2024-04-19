def call(Map config = [:]) {
  sh "docker build --tag ${config.imageName} ."
  withCredentials([usernamePassword(credentialsId: 'DOCKERHUB', passwordVariable: 'password', usernameVariable: 'user')]) {
    sh "docker login -u ${user} -p ${password}"
}
  sh "docker push ${config.imageName}"
}